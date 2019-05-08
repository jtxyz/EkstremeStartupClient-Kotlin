package io.pivotal.extremestartupkotlindemo.solvers

object SquareCubes {
    val pattern = """which of the following numbers is both a square and a cube: ((?:\d+)(?:, (?:\d+))+)""".toRegex()

    private fun isSquareCube(it: Int): Boolean {
        val sqrt = Math.sqrt(it.toDouble())
        val cbrt = Math.cbrt(it.toDouble())
        return Math.floor(sqrt) == sqrt
                && Math.floor(cbrt) == cbrt
    }

    fun solve(values: List<String>) =
            values
                    .first()
                    .split(", ")
                    .map { it.toInt() }
                    .first { isSquareCube(it) }
}