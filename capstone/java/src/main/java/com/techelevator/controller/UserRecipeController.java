package com.techelevator.controller;

import com.techelevator.dao.RecipeDao;
import com.techelevator.dao.UserRecipeDao;
import com.techelevator.exception.RecipeNotFoundException;
import com.techelevator.model.Recipe;
import com.techelevator.model.RecipeDetail;
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
            return userRecipeDao.myRecipesList(id);

    }



    @PostMapping("/users/{id}/recipes")
    @ResponseStatus(HttpStatus.CREATED)
    public Recipe createRecipe (@PathVariable int userId, int recipeId){
        return userRecipeDao.addUserRecipe(userId, recipeId);
    }

    @PutMapping("/{id}")
    public boolean updateRecipe (@PathVariable int id, @RequestBody RecipeDetail recipeDetail){

        return userRecipeDao.modifyRecipe(id, recipeDetail);

    }


    @RequestMapping(path = "/users/{id}/recipes/{recipeId}", method = RequestMethod.DELETE)
    public void deleteRecipe (@PathVariable int userId, int recipeId) throws RecipeNotFoundException{
        userRecipeDao.deleteRecipe(userId, recipeId);
    }

}
