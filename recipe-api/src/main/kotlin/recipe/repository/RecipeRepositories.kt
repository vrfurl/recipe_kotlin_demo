package recipe.repository

import org.springframework.data.jpa.repository.JpaRepository
import recipe.model.Recipe
import recipe.model.RecipeIngredient

interface RecipeRepository : JpaRepository<Recipe, Long>{
    fun findByNameContaining(name: String):List<Recipe>
}

