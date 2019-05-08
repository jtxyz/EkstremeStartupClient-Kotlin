package io.pivotal.extremestartupkotlindemo.solvers

object Comparison {
    val pattern = """which of the following numbers is the (largest|smallest): ((?:\d+)(?:, (?:\d+))+)""".toRegex()

    fun solve(values: List<String>): Number {
        val (comparison, allValues) = values

        return allValues
                .split(", ")
                .map { it.toInt() }
                .run {
                    when (comparison) {
                        "largest" -> max()
                        "smallest" -> min()
                        else -> throw IllegalArgumentException(values[0])
                    }
                }!!

    }
}