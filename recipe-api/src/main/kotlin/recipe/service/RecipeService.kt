package recipe.service

import org.springframework.stereotype.Service
import recipe.model.Recipe
import recipe.repository.RecipeRepository

@Service
class RecipeService(
    val recipeRepository: RecipeRepository
) {

    fun createRecipe(recipe: Recipe): Recipe {
        return recipeRepository.save(recipe)
    }

    fun searchRecipeByName(name: String): List<Recipe> {
        return recipeRepository.findByNameContainingAllIgnoreCase(name)
    }
}