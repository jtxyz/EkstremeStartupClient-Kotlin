package io.pivotal.extremestartupkotlindemo.solvers

interface Solver {
    val regex: Regex
    fun solve(groupsValues: List<String>): Any?
}