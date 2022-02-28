package recipe.repository

import org.springframework.data.jpa.repository.JpaRepository
import recipe.model.Recipe

interface RecipeRepository : JpaRepository<Recipe, Long>{
    fun findByNameContainingAllIgnoreCase(name: String):List<Recipe>
}

