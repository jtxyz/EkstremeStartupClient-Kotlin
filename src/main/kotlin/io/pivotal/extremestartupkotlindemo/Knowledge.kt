package io.pivotal.extremestartupkotlindemo

import io.pivotal.extremestartupkotlindemo.solvers.*

val generalKnowledge = mapOf(
        "what is your name" to "Jax2019",
        "which city is the Eiffel tower in" to "Paris",
        "what colour is a pattern" to "yellow",
        "who played James Bond in the film Dr No" to "Sean Connery",
        "which year was Theresa May first elected as the Prime Minister of Great Britain" to "2016"
)

val mathsKnowledge = mapOf(
        Arithmetic.pattern to Arithmetic::solve,
        Comparison.pattern to Comparison::solve,
        SquareCubes.pattern to SquareCubes::solve,
        Primes.pattern to Primes::solve,
        Fibonacci.pattern to Fibonacci::solve
)

val wordsKnowledge = mapOf(
        Words.pattern to Words::solve,
        ScrabbleScore.pattern to ScrabbleScore::solve
)