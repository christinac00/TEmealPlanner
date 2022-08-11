package com.techelevator.controller;

import com.techelevator.dao.RecipeDao;
import com.techelevator.dao.UserRecipeDao;
import com.techelevator.exception.RecipeNotFoundException;
import com.techelevator.model.Recipe;
import com.techelevator.model.UserRecipe;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Positive;
import java.util.List;


//@RequestMapping("/users/{id}/recipes")
@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class UserRecipeController {


    private final UserRecipeDao userRecipeDao;
    private final RecipeDao recipeDao;




    public UserRecipeController(UserRecipeDao userRecipeDao, RecipeDao recipeDao) {
        this.userRecipeDao = userRecipeDao;
        this.recipeDao = recipeDao;
    }


    @GetMapping("/users/{id}/recipes")
    public List<Recipe> getMyRecipes(@PathVariable int id) throws RecipeNotFoundException{
        UserRecipe userRecipe= new UserRecipe();
                userRecipe.setUser_id(id);
//        if(id == Integer.parseInt(null)){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No recipes under this user.");
//        }


        if(id == userRecipe.getUser_id()){
            return userRecipeDao.myRecipesList(id);
        } else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No recipes under this user.");
        }


    }


    @PostMapping("/users/{id}/recipes")
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
