package io.pivotal.extremestartupkotlindemo.solvers

object Primes {
    val pattern = """which of the following numbers is prime: ((?:\d+)(?:, (?:\d+))+)""".toRegex()

    fun isPrime(it: Int): Boolean {
        if (it < 2) return true

        for (i in 2 until it) {
            if (it % i == 0) return false
        }

        return true
    }

    fun solve(values: List<String>) =
            values
                    .first()
                    .split(", ")
                    .map { it.toInt() }
                    .first { isPrime(it) }
}