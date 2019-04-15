package io.pivotal.extremestartupkotlindemo

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class QuestionController {

    @GetMapping
    fun answer(@RequestParam q: String): ResponseEntity<String> {
        val question = extractQuestion(q)
        val answer = determineAnswer(question)

        println("Question: \"$question\"; Answer: \"$answer\"")

        return ResponseEntity.ok(answer)
    }

    private fun determineAnswer(question: String): String {
        return when {
            "what is your name" in question -> "Neil"
            else -> "I don't know"
        }
    }

    fun extractQuestion(text: String): String {
        return text.substringAfter(':').trim()
    }
}