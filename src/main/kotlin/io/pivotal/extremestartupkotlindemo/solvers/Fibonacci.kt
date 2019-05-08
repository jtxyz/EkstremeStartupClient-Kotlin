package io.pivotal.extremestartupkotlindemo.solvers

import org.springframework.stereotype.Component

@Component
class FibonacciSolver : Solver {
    companion object {
        fun fibonacciNumber(number: Int): Long {
            if (number < 3) return 1

            var a = 1L
            var b = 1L

            for (i in 2 until number) {
                val newB = a + b
                a = b
                b = newB
            }

            return b
        }
    }

    override val regex = """what is the (\d+)(?:st|nd|rd|th) number in the Fibonacci sequence""".toRegex()
    override fun solve(groupsValues: List<String>) = groupsValues
            .first()
            .toInt()
            .let { fibonacciNumber(it) }
}