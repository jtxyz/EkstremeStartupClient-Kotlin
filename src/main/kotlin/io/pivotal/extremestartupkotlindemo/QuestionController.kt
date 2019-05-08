package io.pivotal.extremestartupkotlindemo

import io.pivotal.extremestartupkotlindemo.solvers.Solver
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class QuestionController(val solvers: List<Solver>) {

    @GetMapping
    fun respond(@RequestParam q: String): Any {
        val question = q.trim()

        val answer = solvers
                .mapNotNull { solver ->
                    solver.regex.matchEntire(question)
                            ?.groupValues
                            ?.drop(1)
                            ?.run(solver::solve)
                }
                .firstOrNull()
                ?: "I don't know"

        println("Question: \"$question\"; Answer: \"$answer\"")

        return answer
    }
}
