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
    fun `should respond 'MyTeam' to 'what is your name'`() {
        mock.perform(
                get("/").param("q", "what is your name")
        ).andExpect(
                content().string(equalTo("MyTeam")
                )
        )

    }
}
