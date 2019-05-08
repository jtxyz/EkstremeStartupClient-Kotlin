package io.pivotal.extremestartupkotlindemo.solvers

import org.springframework.stereotype.Component

@Component
class SquareCubesSolver : Solver {
    companion object {
        fun isSquareCube(it: Int): Boolean {
            val sqrt = Math.sqrt(it.toDouble())
            val cbrt = Math.cbrt(it.toDouble())
            return Math.floor(sqrt) == sqrt
                    && Math.floor(cbrt) == cbrt
        }
    }

    override val regex = """which of the following numbers is both a square and a cube: ((?:\d+)(?:, (?:\d+))+)""".toRegex()
    override fun solve(groupsValues: List<String>) = groupsValues
            .first()
            .split(", ")
            .map { it.toInt() }
            .first { isSquareCube(it) }
}