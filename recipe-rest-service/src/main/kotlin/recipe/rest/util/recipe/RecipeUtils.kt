package recipe.rest.util.recipe

import recipe.model.Ingredient
import recipe.model.Recipe
import recipe.model.RecipeIngredient
import recipe.rest.model.CreateRecipeRequestBody
import recipe.model.NutritionalInfo as EntityNutritionalInfo

fun buildRecipe(createRecipeRequestBody: CreateRecipeRequestBody): Recipe {

    val recipe = Recipe(createRecipeRequestBody.name, mutableListOf(), mutableListOf())

    val ingredients = createRecipeRequestBody.ingredients
    ingredients?.let {
        for (ingredient in ingredients) {
            recipe.ingredients!!.add(
                RecipeIngredient(
                    recipe,
                    Ingredient(description = ingredient.description, quantity = ingredient.description)
                )
            )
        }
    }

    val nutritionalInfoList = createRecipeRequestBody.nutritionalInfo
    nutritionalInfoList?.let {
        for (nutritionalInfo in nutritionalInfoList) {
            recipe.nutritionalInfo!!.add(EntityNutritionalInfo(nutritionalInfo.name, nutritionalInfo.quantity, recipe))
        }
    }

    return recipe
}