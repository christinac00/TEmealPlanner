package com.techelevator.controller;

import com.techelevator.dao.IngredientDao;
import com.techelevator.exception.IngredientNotFoundException;
import com.techelevator.model.Ingredient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/ingredients")
public class IngredientController {

    private IngredientDao dao;

    //constructor
    public IngredientController(IngredientDao ingredientDao) {
        this.dao = ingredientDao;
    }

    //create an ingredient
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public Ingredient newIngredient(@RequestBody Ingredient ingredient) {
        //should we add validation later?
        return dao.createIngredient(ingredient);
    }

    //delete an ingredient
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path ="/{id}", method = RequestMethod.DELETE)
    public void deleteIngredient(@PathVariable int id) throws IngredientNotFoundException {
        dao.removeIngredient(id);
    }

    /*@RequestMapping(path = "/{ingredient_id}", method = RequestMethod.GET)
    public Ingredient ingredientDetails(@PathVariable int ingredient_Id){
        return dao.getIngredientById(ingredient_Id);
    }*/
}
