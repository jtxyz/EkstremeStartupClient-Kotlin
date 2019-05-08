package io.pivotal.extremestartupkotlindemo

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam


fun answer(question: String): String {
    return generalKnowledge[question]
            ?: mathsKnowledge
                    .entries
                    .asSequence()
                    .mapNotNull { (regex, solver) ->
                        regex.matchEntire(question)
                                ?.groupValues
                                ?.run { drop(1) }
                                ?.run(solver)
                                ?.toString()
                    }
                    .firstOrNull()
            ?: anagrams(question)
            ?: "I don't know"
}

val anagramRegex =
        """which of the following is an anagram of (\w+): (\w+(:?, \w+)+)"""
                .toRegex()

fun anagrams(question: String): String? {
    val result = anagramRegex.matchEntire(question) ?: return null
    val (_, word, allCandidates) = result.groupValues
    val candidates = allCandidates.split(", ")

    val key = word.toCharArray().toList().sorted()

    val map = candidates.associateBy { it.toCharArray().toList().sorted() }

    return map[key]
}

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
