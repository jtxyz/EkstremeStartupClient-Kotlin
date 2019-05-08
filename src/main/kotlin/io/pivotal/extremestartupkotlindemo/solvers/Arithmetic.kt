package io.pivotal.extremestartupkotlindemo.solvers

import java.util.regex.Pattern

object Arithmetic {
    private val operators = mapOf(
            "plus" to { x: Long, y: Long -> x + y },
            "minus" to { x, y -> x - y },
            "multiplied by" to { x, y -> x * y },
            "to the power of" to { x, y -> Math.pow(x.toDouble(), y.toDouble()).toLong() }
    )

    private val operatorsPattern = """ (?:${operators.keys.joinToString("|")}) """
    val pattern = """what is (\d+)((?:${operatorsPattern}(?:\d+))+)""".toRegex()

    private val operatorRegex = """^$operatorsPattern""".toRegex()
    private val valueRegex = """^\d+""".toRegex()

    private val operatorPattern = operatorRegex.toPattern()
    private val valuePattern = valueRegex.toPattern()

    fun solve(values: List<String>): Number {
        val (firstValue, rest) = values

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