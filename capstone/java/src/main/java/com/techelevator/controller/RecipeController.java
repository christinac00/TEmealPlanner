package com.techelevator.controller;

import com.techelevator.dao.JdbcRecipeDao;
import com.techelevator.dao.JdbcUserDao;
import com.techelevator.dao.RecipeDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Recipe;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/recipes")


public class RecipeController {

    private final UserDao userDao;
    private final RecipeDao recipeDao;


    public RecipeController(UserDao UserDao, RecipeDao RecipeDao) {
        this.userDao = UserDao;
        this.recipeDao = RecipeDao;
    }
    //i'm not sure if this is going to pull for sql or api. if api it nees different end point
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Recipe> getAllRecipes() {
        return recipeDao.listAll();
    }
    //not sure why it doesn't like the recipeId
    @RequestMapping(path = "recipes/v2/{id}", method = RequestMethod.GET)
    public Recipe getById(PathVariable int recipeId) {
       return recipeDao.getById(getById().getRecipeId());
    }
}
