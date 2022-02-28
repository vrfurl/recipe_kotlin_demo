package recipe.rest.test.factories

import io.github.serpro69.kfaker.faker
import recipe.rest.model.CreateRecipeRequestBody
import recipe.rest.model.Ingredient
import recipe.rest.model.NutritionalInfo

// TODO: Move this to a testFixtures directory directory once the 'java-test-fixtures' plugin becomes available in Kotlin (see: https://docs.gradle.org/current/userguide/java_testing.html#sec:java_test_fixtures)


val faker = faker { }

fun buildCreateRecipeRequestBody(): CreateRecipeRequestBody {

    val ingredient = Ingredient(faker.random.randomString(), faker.random.randomString())
    val nutritionalInfo = NutritionalInfo(faker.random.randomString(), faker.random.randomString())
    return CreateRecipeRequestBody(
        faker.random.randomString(),
        ingredients = mutableListOf(ingredient),
        nutritionalInfo = mutableListOf(nutritionalInfo)
    )
}