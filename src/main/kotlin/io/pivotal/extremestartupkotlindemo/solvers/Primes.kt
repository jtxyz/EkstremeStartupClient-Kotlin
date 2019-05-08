package io.pivotal.extremestartupkotlindemo.solvers

import org.springframework.stereotype.Component

@Component
class PrimesSolver : Solver {
    companion object {

        fun isPrime(it: Int): Boolean {
            if (it < 2) return true

            for (i in 2 until it) {
                if (it % i == 0) return false
            }

            return true
        }
    }

    override val regex = """which of the following numbers is prime: ((?:\d+)(?:, (?:\d+))+)""".toRegex()
    override fun solve(groupsValues: List<String>) = groupsValues
            .first()
            .split(", ")
            .map { it.toInt() }
            .first { isPrime(it) }
}