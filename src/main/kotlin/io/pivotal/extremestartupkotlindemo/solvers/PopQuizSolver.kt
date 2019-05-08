package io.pivotal.extremestartupkotlindemo.solvers

import org.springframework.stereotype.Component

@Component
class PopQuizSolver : Solver {
    private final val generalKnowledge = mapOf(
            "what is your name" to "Jax2019",
            "which city is the Eiffel tower in" to "Paris",
            "what colour is a regex" to "yellow",
            "who played James Bond in the film Dr No" to "Sean Connery",
            "which year was Theresa May first elected as the Prime Minister of Great Britain" to "2016"
    )

    override val regex = "(${generalKnowledge.keys.joinToString("|")})".toRegex()
    override fun solve(groupsValues: List<String>) = generalKnowledge[groupsValues.first()]
}