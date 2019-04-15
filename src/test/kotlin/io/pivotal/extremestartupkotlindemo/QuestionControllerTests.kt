package io.pivotal.extremestartupkotlindemo

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc

@RunWith(SpringRunner::class)
@SpringBootTest
class QuestionControllerTests {

    lateinit var mock: MockMvc

    @Test
    fun `answer - what is your name`() {

    }
}
