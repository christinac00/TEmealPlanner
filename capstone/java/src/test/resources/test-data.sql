BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user1','user1','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user2','user2','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user3','user3','ROLE_USER');

INSERT INTO ingredient (name, category) VALUES ('Chicken', 'Meat');
INSERT INTO ingredient (name, category) VALUES ('Tuna', 'Fish');
INSERT INTO ingredient (name, category) VALUES ('Broccoli', 'Vegetable');
INSERT INTO ingredient (name, category) VALUES ('Strawberry', 'Fruit');
INSERT INTO ingredient (name, category) VALUES ('Milk', 'Dairy/Animal Product');
INSERT INTO ingredient (name, category) VALUES ('Peanut', 'Nut');
INSERT INTO ingredient (name, category) VALUES ('Rice', 'Grain/Carb');
INSERT INTO ingredient (name, category) VALUES ('Salt', 'Spice/Seasoning');
INSERT INTO ingredient (name, category) VALUES ('Soy Sauce', 'Condiment');
INSERT INTO ingredient (name, category) VALUES ('Water', 'Liquid');

INSERT INTO recipe (name, instructions) VALUES ('Chicken and Broccoli with Rice','Cook and serve');
INSERT INTO recipe (name, instructions) VALUES ('Strawberry Smoothie','Blend and serve');
INSERT INTO recipe (name, instructions) VALUES ('Perfect 10 Rice','Boil and serve');
INSERT INTO recipe (name, instructions) VALUES ('Strawberry Peanut Butter Breakfast Smoothie','Blend and serve, top with crushed peanuts');

INSERT INTO recipe_ingredient (recipe_id, ingredient_id, quantity, unit) VALUES ((SELECT recipe_id FROM recipe WHERE name ='Chicken and Broccoli with Rice'),(SELECT ingredient_id FROM ingredient WHERE name='Chicken'), 1,'lb');
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, quantity, unit) VALUES ((SELECT recipe_id FROM recipe WHERE name ='Strawberry Smoothie'),(SELECT ingredient_id FROM ingredient WHERE name='Strawberry'), 1,'lb');
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, quantity, unit) VALUES ((SELECT recipe_id FROM recipe WHERE name ='Perfect 10 Rice'),(SELECT ingredient_id FROM ingredient WHERE name='Rice'), 1, 'cup');
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, quantity, unit) VALUES ((SELECT recipe_id FROM recipe WHERE name ='Strawberry Peanut Butter Breakfast Smoothie'),(SELECT ingredient_id FROM ingredient WHERE name='Peanut'), 1,'tbsp');

INSERT INTO tag (keyword) VALUES ('Vegetarian');
INSERT INTO tag (keyword) VALUES ('Pescatarian');
INSERT INTO tag (keyword) VALUES ('Vegan');
INSERT INTO tag (keyword) VALUES ('Breakfast');

INSERT INTO recipe_tag (recipe_id, tag_id) VALUES ((SELECT recipe_id FROM recipe WHERE name ='Chicken and Broccoli with Rice'),(SELECT tag_id FROM tag WHERE keyword ='Pescatarian'));
INSERT INTO recipe_tag (recipe_id, tag_id) VALUES ((SELECT recipe_id FROM recipe WHERE name ='Strawberry Smoothie'),(SELECT tag_id FROM tag WHERE keyword ='Vegetarian'));
INSERT INTO recipe_tag (recipe_id, tag_id) VALUES ((SELECT recipe_id FROM recipe WHERE name ='Perfect 10 Rice'),(SELECT tag_id FROM tag WHERE keyword ='Vegan'));
INSERT INTO recipe_tag (recipe_id, tag_id) VALUES ((SELECT recipe_id FROM recipe WHERE name ='Strawberry Peanut Butter Breakfast Smoothie'),(SELECT tag_id FROM tag WHERE keyword ='Breakfast'));

COMMIT TRANSACTION;
