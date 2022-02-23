package factories

import io.github.serpro69.kfaker.faker
import recipe.model.Ingredient
import recipe.model.NutritionalInfo
import recipe.model.Recipe
import recipe.model.RecipeIngredient


val faker = faker { }

fun buildRecipe(): Recipe {
    val recipe = Recipe(faker.random.randomString())
    val ingredient = buildIngredient()
    recipe.ingredients = mutableListOf(RecipeIngredient(recipe = recipe, ingredient = ingredient))
    recipe.nutritionalInfo = mutableListOf(buildNutritionalInfo(recipe))
    return recipe
}

fun buildIngredient(): Ingredient = Ingredient(faker.random.randomString(), faker.random.randomString())


fun buildNutritionalInfo(recipe: Recipe): NutritionalInfo =
    NutritionalInfo(faker.random.randomString(), faker.random.randomString(), recipe)
