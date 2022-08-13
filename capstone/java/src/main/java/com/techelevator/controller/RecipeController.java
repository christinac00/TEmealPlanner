package com.techelevator.controller;

import com.techelevator.dao.RecipeDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.RecipeNotFoundException;
import com.techelevator.model.Recipe;
import org.apache.coyote.Request;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    public List<Recipe> getAllRecipes() {
        return recipeDao.listAll();
    }

    @RequestMapping(path = "/{recipeId}", method = RequestMethod.GET)
    public Recipe getDetails(@PathVariable int recipeId) throws RecipeNotFoundException {
        return recipeDao.getDetails(recipeId);
    }

    @RequestMapping(path = "/tag/keyword", method = RequestMethod.GET)
    public Recipe getTag(@PathVariable String keyword) {
        return recipeDao.getByTagName(keyword);
    }

    @RequestMapping(path = "/ingredient/name", method = RequestMethod.GET)
    public Recipe getIngredient(@PathVariable String name) {
        return recipeDao.getByIngredientName(name);
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
