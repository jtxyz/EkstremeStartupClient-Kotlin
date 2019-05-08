package io.pivotal.extremestartupkotlindemo

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class QuestionTests {

    @Test
    fun `find primes`() {
        assertThat(isPrime(17)).withFailMessage("17").isTrue()
        assertThat(isPrime(2)).withFailMessage("2").isTrue()
        assertThat(isPrime(21)).withFailMessage("21").isFalse()
    }


    @Test
    fun `calculates fibs`() {
        assertThat(fibonacciNumber(1)).isEqualTo(1)
        assertThat(fibonacciNumber(2)).isEqualTo(1)
        assertThat(fibonacciNumber(3)).isEqualTo(2)
        assertThat(fibonacciNumber(4)).isEqualTo(3)
        assertThat(fibonacciNumber(5)).isEqualTo(5)
        assertThat(fibonacciNumber(6)).isEqualTo(8)
    }
}