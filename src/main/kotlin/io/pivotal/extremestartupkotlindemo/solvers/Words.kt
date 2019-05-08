package io.pivotal.extremestartupkotlindemo.solvers

object Words {
    val pattern = """which of the following is an anagram of (\w+): (\w+(:?, \w+)+)""".toRegex()

    private val sortStuff = { w: String -> w.toCharArray().toList().sorted() }

    fun solve(values: List<String>): String? {
        val (word, allCandidates) = values

        val candidates = allCandidates.split(", ")
        val map = candidates.associateBy(sortStuff)

        return map[sortStuff(word)]
    }
}