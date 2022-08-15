package com.techelevator.dao;

import com.techelevator.model.Ingredient;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JdbcIngredientDaoTest extends BaseDaoTests{
    protected static final Ingredient INGREDIENT_1 = new Ingredient(1, "Chicken", "Meat");
    protected static final Ingredient INGREDIENT_2 = new Ingredient(2, "Broccoli", "Vegetable");
    protected static final Ingredient INGREDIENT_3 = new Ingredient(3, "Water", "Liquid");

    private JdbcIngredientDao sut;
    private Ingredient testIngredient;


    @Before
    public void setup() {
        sut = new JdbcIngredientDao(dataSource);
        testIngredient = new Ingredient(4, "Salmon", "Meat");
    }

    @Test
    void createIngredient() {
    }

    @Test
    void updateIngredient() {
    }

    @Test
    void removeIngredient() {
    }

    @Test
    void getIngredientById() {
    }

    @Test
    void list() {
    }
}