package io.pivotal.extremestartupkotlindemo

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam


fun answer(question: String) =
        generalKnowledge[question]
                ?: (mathsKnowledge + wordsKnowledge)
                        .entries
                        .asSequence()
                        .mapNotNull { (regex, solver) ->
                            regex.matchEntire(question)
                                    ?.groupValues
                                    ?.drop(1)
                                    ?.run(solver)
                                    ?.toString()
                        }
                        .firstOrNull()
                ?: "I don't know"

@Controller
class QuestionController {
    @GetMapping
    fun respond(@RequestParam q: String): ResponseEntity<String> {
        val question = q.trim()
        val answer = answer(question)

        println("Question: \"$question\"; Answer: \"$answer\"")

        return ResponseEntity.ok(answer)
    }
}
