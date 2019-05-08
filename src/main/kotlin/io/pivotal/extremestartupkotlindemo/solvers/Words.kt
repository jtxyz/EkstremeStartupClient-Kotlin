package io.pivotal.extremestartupkotlindemo.solvers

import org.springframework.stereotype.Component

@Component
class WordsSolver : Solver {
    override val regex = """which of the following is an anagram of (\w+): (\w+(:?, \w+)+)""".toRegex()

    private val sortChars = { w: String -> w.toCharArray().toList().sorted() }
    override fun solve(groupsValues: List<String>): String? {
        val (word, allCandidates) = groupsValues
        val candidates = allCandidates.split(", ")
        val map = candidates.associateBy(sortChars)
        return map[sortChars(word)]
    }
}