package io.pivotal.extremestartupkotlindemo.solvers

object Arithmetic {
    private val operators = mapOf(
            "plus" to { x: Long, y: Long -> x + y },
            "minus" to { x, y -> x - y },
            "multiplied by" to { x, y -> x * y },
            "to the power of" to { x, y -> Math.pow(x.toDouble(), y.toDouble()).toLong() }
    )

    private val operatorPattern = """ (?:${operators.keys.joinToString("|")}) """
    val pattern = """what is (\d+)((?:${Arithmetic.operatorPattern}(?:\d+))+)""".toRegex()

    private val operatorRegex = """^$operatorPattern""".toRegex()
    private val valueRegex = """^\d+""".toRegex()

    fun solve(values: List<String>): Number {
        var (firstValue, rest) = values

        var value = firstValue.toLong()

        while (rest.isNotEmpty()) {
            val operatorResult = operatorRegex.find(rest)!!
            rest = rest.substring(operatorResult.value.length)

            val valueResult = valueRegex.find(rest)!!
            rest = rest.substring(valueResult.value.length)

            value = operators[operatorResult.value.trim()]!!(value, valueResult.value.toLong())
        }

        return value
    }
}