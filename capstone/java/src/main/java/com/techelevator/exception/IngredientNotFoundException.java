package com.techelevator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Ingredient not found!")
public class IngredientNotFoundException extends Exception{
    public IngredientNotFoundException(){super("Ingredient not found!");}
}
