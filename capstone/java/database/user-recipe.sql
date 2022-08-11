BEGIN TRANSACTION;

INSERT INTO user_recipe(user_id, recipe_id, isCreated, isFavorite) VALUES (2, 1, true, true);
INSERT INTO user_recipe(user_id, recipe_id, isCreated, isFavorite) VALUES (2, 2, true, true);
INSERT INTO user_recipe(user_id, recipe_id, isCreated, isFavorite) VALUES (2, 3, true, true);
INSERT INTO user_recipe(user_id, recipe_id, isCreated, isFavorite) VALUES (2, 4, true, true);


COMMIT TRANSACTION;