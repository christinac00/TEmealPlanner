package com.techelevator.controller;

import com.techelevator.dao.RecipeDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.RecipeNotFoundException;
import com.techelevator.model.Recipe;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/recipes")
@CrossOrigin(origins = "http://localhost:8080")
public class RecipeController {

    private final UserDao userDao;
    private final RecipeDao recipeDao;


    public RecipeController(UserDao UserDao, RecipeDao RecipeDao) {
        this.userDao = UserDao;
        this.recipeDao = RecipeDao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Recipe> getAllRecipes(@RequestParam Optional<String> tag, @RequestParam Optional<String> ingredient) {
        if(tag.isPresent() && ingredient.isPresent()) {
            List<Recipe> taggedRecipes = recipeDao.searchByTagName(tag.get());
            List<Recipe> ingredientRecipes = recipeDao.searchByIngredientName(ingredient.get());
            taggedRecipes.retainAll(ingredientRecipes);
            return taggedRecipes;
        }
        else if(tag.isPresent()) {
            return recipeDao.searchByTagName(tag.get());
        }
        else if (ingredient.isPresent()) {
            return recipeDao.searchByIngredientName(ingredient.get());
        }

        return recipeDao.listAll();
    }


    @RequestMapping(path = "/{recipeId}", method = RequestMethod.GET)
    public Recipe getDetails(@PathVariable int recipeId) throws RecipeNotFoundException {
        return recipeDao.getDetails(recipeId);
    }

    @RequestMapping(path = "/ingredient/name", method = RequestMethod.GET)
    public Recipe getIngredient(@PathVariable String name) {
        return null;
    }


    @RequestMapping(path = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Recipe create(@RequestBody Recipe recipe) {
        return recipeDao.create(recipe);
    }

    @RequestMapping(path = "/{recipeId}", method = RequestMethod.PUT)
    public Recipe update(@PathVariable int recipeId, @RequestBody Recipe recipe) {
        recipe.setRecipeId(recipeId);
        return recipeDao.updateRecipe(recipe);
    }



}
