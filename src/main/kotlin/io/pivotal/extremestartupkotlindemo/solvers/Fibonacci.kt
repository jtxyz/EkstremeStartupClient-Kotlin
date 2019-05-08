package io.pivotal.extremestartupkotlindemo.solvers

object Fibonacci {
    val pattern = """what is the (\d+)(?:st|nd|rd|th) number in the Fibonacci sequence""".toRegex()

    fun fibonacciNumber(number: Int): Long {
        if (number < 3) return 1

        var a = 1L
        var b = 1L

        for (i in 2..(number - 1)) {
            val newB = a + b
            a = b
            b = newB
        }

        return b
    }

    fun solve(values: List<String>) =
            values
                    .first()
                    .toInt()
                    .let { fibonacciNumber(it) }

}