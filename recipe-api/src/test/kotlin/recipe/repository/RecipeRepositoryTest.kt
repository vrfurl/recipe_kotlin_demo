package recipe.repository

import factories.buildRecipe

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest


@DataJpaTest
class RecipeRepositoryTest @Autowired constructor(
    val recipeRepository: RecipeRepository
) {

    @Test
    fun `Save Recipe`() {

        val recipe = buildRecipe()

        val result = recipeRepository.save(recipe)

        assertEquals(recipe, result)
        assertNotNull(recipe.id)
    }

    @Test
    fun `Find Recipe Like`() {

        val recipe = buildRecipe()
        val persistedRecipe = recipeRepository.save(recipe)

        val exactNameResult = recipeRepository.findByNameContaining(recipe.name)
        val partialNameResult = recipeRepository.findByNameContaining(recipe.name.dropLast(recipe.name.length - 1))

        assertTrue(exactNameResult.contains(persistedRecipe))
        assertTrue(partialNameResult.contains(persistedRecipe))
    }
}