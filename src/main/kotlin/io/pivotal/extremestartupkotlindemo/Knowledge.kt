package io.pivotal.extremestartupkotlindemo


val generalKnowledge = mapOf(
        "what is your name" to "Jax2019",
        "which city is the Eiffel tower in" to "Paris",
        "what colour is a banana" to "yellow",
        "who played James Bond in the film Dr No" to "Sean Connery",
        "which year was Theresa May first elected as the Prime Minister of Great Britain" to "2016"
)


val mathsKnowledge = mapOf(
        """what is (\d+)((?:$arithmeticPattern(?:\d+))+)""".toRegex() to ::solveArithmetic,
        """which of the following numbers is the largest: ((?:\d+)(?:, (?:\d+))+)""".toRegex() to ::solveGreatest,
        """which of the following numbers is the smallest: ((?:\d+)(?:, (?:\d+))+)""".toRegex() to ::solveLeast,
        """which of the following numbers is both a square and a cube: ((?:\d+)(?:, (?:\d+))+)""".toRegex() to ::solveSquareCube,
        """which of the following numbers is prime: ((?:\d+)(?:, (?:\d+))+)""".toRegex() to ::solvePrime,
        """what is the (\d+)(?:st|nd|rd|th) number in the Fibonacci sequence""".toRegex() to ::solveFibonacci
)
