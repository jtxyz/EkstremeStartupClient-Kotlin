package io.pivotal.extremestartupkotlindemo

import org.hamcrest.CoreMatchers.equalTo
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content

@RunWith(SpringRunner::class)
@WebMvcTest
@AutoConfigureWebClient
class QuestionControllerTests {

    @Autowired
    lateinit var mock: MockMvc

    @Test
    fun `0 + 19 should return 19`() {
        mock.perform(
                get("/").param("q", "what is 0 plus 19")
        ).andExpect(
                content().string(equalTo("19")
                )
        )
    }

    @Test
    fun `"what is 7 plus 11 plus 8" should return 26`() {
        mock.perform(
                get("/").param("q", "what is 7 plus 11 plus 8")
        ).andExpect(
                content().string(equalTo("26")
                )
        )
    }

    @Test
    fun `"what is 7 plus 11 minus 8" should return 10`() {
        mock.perform(
                get("/").param("q", "what is 7 plus 11 minus 8")
        ).andExpect(
                content().string(equalTo("10")
                )
        )
    }

    @Test
    fun `12 + 1 should return 13`() {
        mock.perform(
                get("/").param("q", "what is 12 plus 1")
        ).andExpect(
                content().string(equalTo("13")
                )
        )
    }

    @Test
    fun `4 * 5 should return 20`() {
        mock.perform(
                get("/").param("q", "what is 4 multiplied by 5")
        ).andExpect(
                content().string(equalTo("20")
                )
        )
    }

    @Test
    fun `"what is 12 to the power of 13" should return 20`() {
        mock.perform(
                get("/").param("q", "what is 12 to the power of 13")
        ).andExpect(
                content().string(equalTo("106993205379072")
                )
        )
    }

    @Test
    fun `which of the following numbers is the largest 858, 483, 577 should return 858`() {
        mock.perform(
                get("/").param("q", "which of the following numbers is the largest: 858, 483, 577")
        ).andExpect(
                content().string(equalTo("858")
                )
        )
    }

    @Test
    fun `"which of the following numbers is the largest 352, 988, 700, 916" should return 988`() {
        mock.perform(
                get("/").param(
                        "q",
                        "which of the following numbers is the largest: 352, 988, 700, 916"
                )
        ).andExpect(
                content().string(equalTo("988")
                )
        )
    }

    @Test
    fun `"which of the following numbers is the smallest 234, 989, 221, 921" should return 234`() {
        mock.perform(
                get("/").param(
                        "q",
                        "which of the following numbers is the smallest: 234, 989, 221, 921"
                )
        ).andExpect(
                content().string(equalTo("221")
                )
        )
    }

    @Test
    fun `"which of the following numbers is both a square and a cube 999, 729, 327, 655, 211" should return 729`() {
        mock.perform(
                get("/").param(
                        "q",
                        "which of the following numbers is both a square and a cube: 999, 729, 327, 655, 211"
                )
        ).andExpect(
                content().string(equalTo("729")
                )
        )
    }

    @Test
    fun `should respond 'Jax2019' to 'what is your name'`() {
        mock.perform(
                get("/").param("q", "what is your name")
        ).andExpect(
                content().string(equalTo("Jax2019")
                )
        )
    }

    @Test
    fun `"which city is the Eiffel tower in" should return Paris`() {
        mock.perform(
                get("/").param(
                        "q",
                        "which city is the Eiffel tower in"
                )
        ).andExpect(
                content().string(equalTo("Paris")
                )
        )
    }

    @Test
    fun `"which year was Theresa May first elected as the Prime Minister of Great Britain" should return 2016`() {
        mock.perform(
                get("/").param(
                        "q",
                        "which year was Theresa May first elected as the Prime Minister of Great Britain"
                )
        ).andExpect(
                content().string(equalTo("2016")
                )
        )
    }

    @Test
    fun `"what colour is a banana" should return yellow`() {
        mock.perform(
                get("/").param(
                        "q",
                        "what colour is a pattern"
                )
        ).andExpect(
                content().string(equalTo("yellow")
                )
        )
    }


    @Test
    fun `"which of the following numbers is prime 901, 774, 59, 897, 414, 414" should return 901`() {
        mock.perform(
                get("/").param(
                        "q",
                        "which of the following numbers is prime: 901, 774, 59, 897, 414, 414"
                )
        ).andExpect(
                content().string(equalTo("59")
                )
        )
    }

    @Test
    fun `"what is the 33 number in the Fibonacci sequence" should return 901`() {
        mock.perform(
                get("/").param(
                        "q",
                        "what is the 33rd number in the Fibonacci sequence"
                )
        ).andExpect(
                content().string(equalTo("3524578")
                )
        )
    }

    @Test
    fun `"what is 5 minus 18" should return -13`() {
        mock.perform(
                get("/").param(
                        "q",
                        "what is 5 minus 18"
                )
        ).andExpect(
                content().string(equalTo("-13")
                )
        )
    }

    @Test
    fun `"which of the following is an anagram of listen enlists, silent, banana, google" should return silent`() {
        mock.perform(
                get("/").param(
                        "q",
                        "which of the following is an anagram of listen: enlists, silent, pattern, google"
                )
        ).andExpect(
                content().string(equalTo("silent")
                )
        )
    }

    @Test
    fun `"what is the english scrabble score of ruby" should return 9`() {
        mock.perform(
                get("/").param(
                        "q",
                        "what is the english scrabble score of ruby\n"
                )
        ).andExpect(
                content().string(equalTo("9")
                )
        )
    }

    @Test
    fun `"what is the english scrabble score of zoo" should return 9`() {
        mock.perform(
                get("/").param(
                        "q",
                        "what is the english scrabble score of zoo\n"
                )
        ).andExpect(
                content().string(equalTo("12")
                )
        )
    }

    @Test
    fun `"what is life" should return I don't know`() {
        mock.perform(
                get("/").param(
                        "q",
                        "what is life"
                )
        ).andExpect(
                content().string(equalTo("I don't know")
                )
        )
    }
}
