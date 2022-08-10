package com.techelevator.controller;

import com.techelevator.dao.RecipeDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Recipe;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recipe")


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
    public Recipe getById(@PathVariable int recipeId) {
        return recipeDao.getById(recipeId);
    }

    @RequestMapping(path = "/name", method = RequestMethod.GET)
    public Recipe getName(@PathVariable String name) {
        return recipeDao.getByName(name);
    }

    @RequestMapping(path = "dietType", method = RequestMethod.GET)
    public Recipe getByDiet(@PathVariable String dietType) {
        return recipeDao.getByDietType(dietType);
    }

//    @RequestMapping(path = "create", method = RequestMethod.POST)
//    public Recipe create(@PathVariable boolean create {
//        Recipe recipe = null;
//        return recipeDao.create(recipe);
//    }




}
