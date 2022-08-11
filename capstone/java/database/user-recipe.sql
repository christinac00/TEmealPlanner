BEGIN TRANSACTION;

INSERT INTO user_recipe(user_id, recipe_id, isCreated, isFavorite) VALUES (3, 1, true, true)

COMMIT TRANSACTION;