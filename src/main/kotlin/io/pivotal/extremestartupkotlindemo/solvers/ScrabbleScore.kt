package io.pivotal.extremestartupkotlindemo.solvers

import org.springframework.stereotype.Component
import java.lang.IllegalArgumentException

@Component
class ScrabbleScoreSolver : Solver {
    private val englishScores = mapOf(
            listOf('A', 'E', 'I', 'O', 'U', 'L', 'N', 'S', 'T', 'R') to 1,
            listOf('D', 'G') to 2,
            listOf('B', 'C', 'M', 'P') to 3,
            listOf('F', 'H', 'V', 'W', 'Y') to 4,
            listOf('K') to 5,
            listOf('J', 'X') to 8,
            listOf('Q', 'Z') to 10
    )
            .flatMap { (k, v) -> k.map { it to v } }
            .toMap()

    override val regex = """what is the english scrabble score of (\w+)""".toRegex()

    override fun solve(groupsValues: List<String>) = groupsValues
            .first()
            .toUpperCase()
            .toCharArray()
            .map { englishScores[it] ?: throw IllegalArgumentException(it.toString()) }
            .sum()
}