package com.techelevator.dao;

import com.techelevator.model.Tag;
import com.techelevator.model.Recipe;

import java.util.List;

public interface TagDao {

    List<Tag> listAll();

    Recipe getRecipesByTag(String keyword, String name);

    Recipe getByTag(int tagId, int recipeId);


}
