package com.techelevator.dao;

import com.techelevator.model.Tag;
import com.techelevator.model.Recipe;

import java.util.List;

public interface TagDao {

    List<Tag> listAll();

//    Recipe getRecipesByTag(String keyword, String name);
//
////    Recipe getByTag(String Keyword, int recipeId);
//
//
//    Recipe getByTag(String Keyword, int recipeId, Recipe name);
//
//    Tag getByTag(String Keyword, int recipeId, String name);
}
