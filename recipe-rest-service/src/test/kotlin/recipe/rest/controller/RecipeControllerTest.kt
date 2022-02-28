package recipe.rest.controller

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import recipe.repository.RecipeRepository
import recipe.rest.test.factories.buildCreateRecipeRequestBody
import recipe.rest.util.recipe.buildRecipe

@AutoConfigureMockMvc
@SpringBootTest
//@WebMvcTest
class RecipeControllerTest(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    private lateinit var recipeRepository: RecipeRepository


    @Test
    fun `Create a Recipe`() {

        val requestBody = buildCreateRecipeRequestBody()
        val recipe = buildRecipe(requestBody)
        every { recipeRepository.save(recipe) } returns recipe
        mockMvc.perform(
            post("/api/recipe").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                .content(Json.encodeToString(recipe))
        )
            .andExpect(
                status().isOk
            )


    }


}