package io.pivotal.extremestartupkotlindemo.solvers

import org.springframework.stereotype.Component
import java.util.regex.Pattern

@Component
class ArithmeticSolver : Solver {
    private val operators = mapOf(
            "plus" to { x: Long, y: Long -> x + y },
            "minus" to { x, y -> x - y },
            "multiplied by" to { x, y -> x * y },
            "to the power of" to { x, y -> Math.pow(x.toDouble(), y.toDouble()).toLong() }
    )

    private val operatorsPattern = """ (?:${operators.keys.joinToString("|")}) """
    private val operatorPattern = """^$operatorsPattern""".toRegex().toPattern()
    private val valuePattern = """^\d+""".toRegex().toPattern()

    override val regex = """what is (\d+)((?:$operatorsPattern(?:\d+))+)""".toRegex()

    override fun solve(groupsValues: List<String>): Number {
        val (firstValue, rest) = groupsValues

        var total = firstValue.toLong()

        val matcher = operatorPattern.matcher(rest)

        fun read(pattern: Pattern): String {
            matcher.usePattern(pattern)
            matcher.lookingAt() || throw IllegalArgumentException(rest)

            val operatorResult = matcher.toMatchResult()
            matcher.region(operatorResult.end(), matcher.regionEnd())
            return operatorResult.group()
        }

        while (!matcher.hitEnd()) {
            val operator = read(operatorPattern).trim()
            val value = read(valuePattern).toLong()
            total = (operators.getValue(operator))(total, value)
        }

        return total
    }
}