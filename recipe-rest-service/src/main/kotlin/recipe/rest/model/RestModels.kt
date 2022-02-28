package recipe.rest.model

import kotlinx.serialization.Serializable


@Serializable
data class CreateRecipeRequestBody(
    val name: String,
    val ingredients: MutableList<Ingredient>? = null,
    val nutritionalInfo: MutableList<NutritionalInfo>? = null
)

@Serializable
data class Ingredient(val description: String, val quantity: String)

@Serializable
data class NutritionalInfo(val name: String, val quantity: String)