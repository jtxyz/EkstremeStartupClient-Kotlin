package io.pivotal.extremestartupkotlindemo

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class QuestionController {

    @GetMapping
    fun respond(@RequestParam q: String): ResponseEntity<String> {
        val question = extractQuestion(q)
        val answer = answer(question)

        println("Question: \"$question\"; Answer: \"$answer\"")

        return ResponseEntity.ok(answer)
    }

    private fun answer(question: String): String {
        return when {
            "what is your name" in question -> "MyTeam"
            else -> "I don't know"
        }
    }

    fun extractQuestion(text: String): String {
        return text.trim()
    }
}