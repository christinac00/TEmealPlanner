START TRANSACTION;
--associate ingredients with recipes
--breakfast smoothies
INSERT INTO recipe_ingredient(recipe_id, ingredient_id, quantity, unit) VALUES ((SELECT recipe_id FROM recipe WHERE name ='Breakfast Smoothies'), (SELECT ingredient_id FROM ingredient WHERE name = 'Yogurt'), '1.5','cups');
INSERT INTO recipe_ingredient(recipe_id, ingredient_id, quantity, unit) VALUES ((SELECT recipe_id FROM recipe WHERE name ='Breakfast Smoothies'), (SELECT ingredient_id FROM ingredient WHERE name = 'Banana'), '3', 'whole');
INSERT INTO recipe_ingredient(recipe_id, ingredient_id, quantity, unit) VALUES ((SELECT recipe_id FROM recipe WHERE name ='Breakfast Smoothies'), (SELECT ingredient_id FROM ingredient WHERE name ='Strawberry'), '14','ounces');
INSERT INTO recipe_ingredient(recipe_id, ingredient_id, quantity, unit) VALUES ((SELECT recipe_id FROM recipe WHERE name ='Breakfast Smoothies'), (SELECT ingredient_id FROM ingredient WHERE name ='Milk'), '.25','cups');
INSERT INTO recipe_ingredient(recipe_id, ingredient_id, quantity, unit) VALUES ((SELECT recipe_id FROM recipe WHERE name ='Breakfast Smoothies'), (SELECT ingredient_id FROM ingredient WHERE name ='Honey'), '2','Tbsp');

--black bean tacos
INSERT INTO recipe_ingredient(recipe_id, ingredient_id, quantity, unit) VALUES ((SELECT recipe_id FROM recipe WHERE name ='Black Bean Tacos'), (SELECT ingredient_id FROM ingredient WHERE name='Beans'), '30', 'ounces');
INSERT INTO recipe_ingredient(recipe_id, ingredient_id, quantity, unit) VALUES ((SELECT recipe_id FROM recipe WHERE name ='Black Bean Tacos'), (SELECT ingredient_id FROM ingredient WHERE name='Cumin'), '1','Tspn');
INSERT INTO recipe_ingredient(recipe_id, ingredient_id, quantity, unit) VALUES ((SELECT recipe_id FROM recipe WHERE name ='Black Bean Tacos'), (SELECT ingredient_id FROM ingredient WHERE name='Garlic Powder'), '.5', 'Tspn');
INSERT INTO recipe_ingredient(recipe_id, ingredient_id, quantity, unit) VALUES ((SELECT recipe_id FROM recipe WHERE name ='Black Bean Tacos'), (SELECT ingredient_id FROM ingredient WHERE name='Monterey Jack Cheese'), '.75', 'cup');

--southern sherried shrimp
INSERT INTO recipe_ingredient(recipe_id, ingredient_id, quantity, unit) VALUES ((SELECT recipe_id FROM recipe WHERE name ='Southern Sherried Shrimp'), (SELECT ingredient_id FROM ingredient WHERE name ='Butter'), '.25','lb');
INSERT INTO recipe_ingredient(recipe_id, ingredient_id, quantity, unit) VALUES ((SELECT recipe_id FROM recipe WHERE name ='Southern Sherried Shrimp'), (SELECT ingredient_id FROM ingredient WHERE name ='Shrimp'), '1','lb');
INSERT INTO recipe_ingredient(recipe_id, ingredient_id, quantity, unit) VALUES ((SELECT recipe_id FROM recipe WHERE name ='Southern Sherried Shrimp'), (SELECT ingredient_id FROM ingredient WHERE name ='Sherry Wine'), '.33', 'cups');
INSERT INTO recipe_ingredient(recipe_id, ingredient_id, quantity, unit) VALUES ((SELECT recipe_id FROM recipe WHERE name ='Southern Sherried Shrimp'), (SELECT ingredient_id FROM ingredient WHERE name ='Cayenne Pepper'), '.25','Tspn');
INSERT INTO recipe_ingredient(recipe_id, ingredient_id, quantity, unit) VALUES ((SELECT recipe_id FROM recipe WHERE name ='Southern Sherried Shrimp'), (SELECT ingredient_id FROM ingredient WHERE name ='Salt'), '.5','Tspn');
INSERT INTO recipe_ingredient(recipe_id, ingredient_id, quantity, unit) VALUES ((SELECT recipe_id FROM recipe WHERE name ='Southern Sherried Shrimp'), (SELECT ingredient_id FROM ingredient WHERE name ='Pepper'), '.5','Tspn');

--peanut butter banana pops
INSERT INTO recipe_ingredient(recipe_id, ingredient_id, quantity, unit) VALUES ((SELECT recipe_id FROM recipe WHERE name ='Peanut Butter Banana Pops'), (SELECT ingredient_id FROM ingredient WHERE name ='Banana'), '7', 'whole');
INSERT INTO recipe_ingredient(recipe_id, ingredient_id, quantity, unit) VALUES ((SELECT recipe_id FROM recipe WHERE name ='Peanut Butter Banana Pops'), (SELECT ingredient_id FROM ingredient WHERE name ='Peanut Butter'), '.75', 'cups');
INSERT INTO recipe_ingredient(recipe_id, ingredient_id, quantity, unit) VALUES ((SELECT recipe_id FROM recipe WHERE name ='Peanut Butter Banana Pops'), (SELECT ingredient_id FROM ingredient WHERE name ='Chocolate'), '2.5', 'cups');

COMMIT;