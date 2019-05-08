package io.pivotal.extremestartupkotlindemo.solvers

import org.springframework.stereotype.Component

@Component
class SumOfDigitsSolver : Solver {
    override val regex = """what is the sum of the digits in (\d+)""".toRegex()
    override fun solve(groupsValues: List<String>) =
            groupsValues
                    .first()
                    .splitToSequence("")
                    .filterNot { it.isEmpty() }
                    .map { it.toInt() }
                    .sum()
}
