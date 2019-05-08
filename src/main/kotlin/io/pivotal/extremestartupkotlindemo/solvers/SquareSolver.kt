package io.pivotal.extremestartupkotlindemo.solvers

import org.springframework.stereotype.Component

@Component
class SquareSolver : Solver {
    override val regex = """what is (\d+) squared""".toRegex()

    override fun solve(groupsValues: List<String>) =
            groupsValues
                    .first()
                    .toInt()
                    .let { it * it }

}