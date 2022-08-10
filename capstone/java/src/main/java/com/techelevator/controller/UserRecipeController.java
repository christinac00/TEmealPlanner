package com.techelevator.controller;

import com.techelevator.dao.RecipeDao;
import com.techelevator.dao.UserRecipeDao;
import com.techelevator.exception.RecipeNotFoundException;
import com.techelevator.model.UserRecipe;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/users/{id}/recipes")
public class UserRecipeController {


    private final UserRecipeDao userRecipeDao;
    private final RecipeDao recipeDao;

    private UserRecipe userRecipe;


    public UserRecipeController(UserRecipeDao userRecipeDao, RecipeDao recipeDao) {
        this.userRecipeDao = userRecipeDao;
        this.recipeDao = recipeDao;
    }


    @GetMapping("")
    public List<UserRecipe> getMyRecipes(int userId){
        return userRecipeDao.myRecipesList(userRecipe.getUser_id());

    }


    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public UserRecipe createRecipe (@RequestBody UserRecipe newRecipe){
        return userRecipeDao.addUserRecipe(newRecipe);
    }

    @PutMapping("/{id}")
    public UserRecipe updateRecipe (@PathVariable int id, @RequestBody UserRecipe userRecipe){
        userRecipe.setRecipe_id(id);
        if(userRecipeDao.modifyRecipe(userRecipe)){
            return userRecipe;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe not found.");
        }
    }



}
