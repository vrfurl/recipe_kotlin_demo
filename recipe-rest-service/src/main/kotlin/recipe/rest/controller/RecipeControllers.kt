package recipe.rest.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import recipe.model.Recipe
import recipe.rest.model.CreateRecipeRequestBody
import recipe.rest.util.recipe.buildRecipe
import recipe.service.RecipeService

@RestController
@RequestMapping(
    "/api",
)
class RecipeController(@Autowired val recipeService: RecipeService) {


    @PostMapping(
        "/recipe",
    )
    fun create(@RequestBody createRecipeRequestBody: CreateRecipeRequestBody): Recipe =
        recipeService.createRecipe(buildRecipe(createRecipeRequestBody))


    @GetMapping("/search/recipe")
    fun search(@RequestParam query: String) = recipeService.searchRecipeByName(query)


}