package io.pivotal.extremestartupkotlindemo

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

fun solveFibonacci(values: List<String>) =
        values
                .first()
                .toInt()
                .let { fibonacciNumber(it) }


fun isPrime(it: Int): Boolean {
    if (it < 2) return true

    for (i in 2 until it) {
        if (it % i == 0) return false
    }

    return true
}

fun solvePrime(values: List<String>) =
        values
                .first()
                .split(", ")
                .map { it.toInt() }
                .first { isPrime(it) }

fun isSquareCube(it: Int): Boolean {
    val sqrt = Math.sqrt(it.toDouble())
    val cbrt = Math.cbrt(it.toDouble())
    return Math.floor(sqrt) == sqrt
            && Math.floor(cbrt) == cbrt
}

fun solveSquareCube(values: List<String>) =
        values
                .first()
                .split(", ")
                .map { it.toInt() }
                .first { isSquareCube(it) }


fun solveGreatest(values: List<String>) =
        values
                .first()
                .split(", ")
                .map { it.toInt() }
                .max()!!

fun solveLeast(values: List<String>) =
        values
                .first()
                .split(", ")
                .map { it.toInt() }
                .min()!!



val arithmetic = mapOf(
        "plus" to { x: Long, y: Long -> x + y },
        "minus" to { x, y -> x - y },
        "multiplied by" to { x, y -> x * y },
        "to the power of" to { x, y -> Math.pow(x.toDouble(), y.toDouble()).toLong() }
)
val arithmeticPattern = """ (?:${arithmetic.keys.joinToString("|")}) """
val arithmeticRegex = """^$arithmeticPattern""".toRegex()
val valueRegex = """^\d+""".toRegex()

fun solveArithmetic(values: List<String>): Number {
    var (firstValue, rest) = values

    var value = firstValue.toLong()

    while (rest.isNotEmpty()) {
        val operatorResult = arithmeticRegex.find(rest)!!
        rest = rest.substring(operatorResult.value.length)

        val valueResult = valueRegex.find(rest)!!
        rest = rest.substring(valueResult.value.length)

        value = arithmetic[operatorResult.value.trim()]!!(value, valueResult.value.toLong())
    }

    return value
}