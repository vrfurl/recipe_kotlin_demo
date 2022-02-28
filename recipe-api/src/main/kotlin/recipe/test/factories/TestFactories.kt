package recipe.test.factories

import io.github.serpro69.kfaker.faker
import recipe.model.Ingredient
import recipe.model.NutritionalInfo
import recipe.model.Recipe
import recipe.model.RecipeIngredient


// TODO: Move this to a testFixtures directory directory once the 'java-test-fixtures' plugin becomes available in Kotlin (see: https://docs.gradle.org/current/userguide/java_testing.html#sec:java_test_fixtures)


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
