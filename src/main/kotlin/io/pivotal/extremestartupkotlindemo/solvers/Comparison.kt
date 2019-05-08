package io.pivotal.extremestartupkotlindemo.solvers

import org.springframework.stereotype.Component

@Component
class ComparisonSolver : Solver {
    override val regex = """which of the following numbers is the (largest|smallest): ((?:\d+)(?:, (?:\d+))+)""".toRegex()
    override fun solve(groupsValues: List<String>): Number {
        val (comparison, allValues) = groupsValues

        return allValues
                .split(", ")
                .map { it.toInt() }
                .run {
                    when (comparison) {
                        "largest" -> max()
                        "smallest" -> min()
                        else -> throw IllegalArgumentException(comparison)
                    }
                }!!

    }
}