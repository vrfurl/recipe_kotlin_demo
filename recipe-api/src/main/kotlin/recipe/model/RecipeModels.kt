package recipe.model

import javax.persistence.*

@Entity
@AttributeOverride(name = "id", column = Column(name = "recipe_id"))
class Recipe(
    var name: String,
    @OneToMany(
        cascade = [CascadeType.ALL],
        mappedBy = "ingredient"
    ) var ingredients: MutableList<RecipeIngredient>? = null,
    @OneToMany(
        cascade = [CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH], mappedBy = "recipe"
    ) var nutritionalInfo: MutableList<NutritionalInfo>? = null
) : BaseModel()

@Entity
@AttributeOverride(name = "id", column = Column(name = "recipe_ingredient_id"))
class RecipeIngredient(
    @ManyToOne(cascade = [CascadeType.ALL]) @JoinColumn(name = "recipe_id") var recipe: Recipe? = null,
    @ManyToOne(cascade = [CascadeType.ALL]) @JoinColumn(name = "ingredient_id") var ingredient: Ingredient? = null
) : BaseModel()

@Entity
@AttributeOverride(name = "id", column = Column(name = "ingredient_id"))
class Ingredient(
    var quantity: String,
    var description: String,
    @OneToMany(
        cascade = [CascadeType.ALL],
        mappedBy = "ingredient"
    ) var recipes: MutableList<RecipeIngredient>? = null
) : BaseModel()

@Entity
@AttributeOverride(name = "id", column = Column(name = "nutritional_info_id"))
data class NutritionalInfo(
    val name: String,
    val quantity: String,
    @ManyToOne(cascade = [CascadeType.ALL]) @JoinColumn(name = "recipe_id") val recipe: Recipe
) : BaseModel()


