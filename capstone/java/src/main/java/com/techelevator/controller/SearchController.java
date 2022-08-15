package com.techelevator.controller;

import com.techelevator.dao.RecipeDao;
import com.techelevator.model.Recipe;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search")
@CrossOrigin(origins = "http://localhost:8080")
public class SearchController {

    private final  RecipeDao recipeDao;

    public SearchController(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }


    @RequestMapping(path = "", method = RequestMethod.GET)
    public Recipe getByTagName(@PathVariable String keyword) {

        return recipeDao.getByTagName(keyword);
    }
}
