package recipe.service

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import recipe.repository.RecipeRepository
import recipe.test.factories.buildRecipe

@SpringBootTest
class RecipeServiceTest(
    @Autowired val recipeService: RecipeService
) {


    @MockkBean
    lateinit var recipeRepository: RecipeRepository

    @Test
    fun `Create recipe`() {
        // Given
        val recipe = buildRecipe()
        every { recipeRepository.save(recipe) } returns recipe

        // When
        val result = recipeService.createRecipe(recipe)

        // Then
        verify(exactly = 1) { recipeRepository.save(recipe) }
        assertEquals(recipe, result)
    }


    fun `Search For Recipe By Name`(){

        // Given
        val recipe = buildRecipe()
        every { recipeRepository.findByNameContainingAllIgnoreCase(recipe.name) } returns listOf(recipe)

        //When
        val result = recipeService.searchRecipeByName(recipe.name)

        // Then
        verify(exactly = 1) { recipeRepository.findByNameContainingAllIgnoreCase(recipe.name) }
        assertTrue(result.contains(recipe))

    }

}