--populating ingredient table with items
BEGIN TRANSACTION;
--vegetables
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Avocado', 1, 'lb', 'vegetable');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Beans', 1, 'cup', 'vegetable');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Beets', 1, 'lb', 'vegetable');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Broccoli', 1, 'lb', 'vegetable');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Carrot', 1, 'lb', 'vegetable');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Celery', 1, 'lb', 'vegetable');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Corn', 1, 'lb', 'vegetable');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Cucumber', 1, 'lb', 'vegetable');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Eggplant', 1, 'lb', 'vegetable');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Garlic', 1, 'lb', 'vegetable');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Mushroom', 1, 'lb', 'vegetable');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Onion', 1, 'lb', 'vegetable');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Potato', 1, 'lb', 'vegetable');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Radish', 1, 'lb', 'vegetable');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Squash', 1, 'lb', 'vegetable');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Tomato', 1, 'lb', 'vegetable');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Zucchini', 1, 'lb', 'vegetable');

--fruits
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Apple', 1, 'lb', 'fruit');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Apricot', 1, 'lb', 'fruit');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Banana', 1, 'lb', 'fruit');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Blackberry', 1, 'lb', 'fruit');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Blueberry', 1, 'lb', 'fruit');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Coconut', 1, 'lb', 'fruit');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Cranberry', 1, 'lb', 'fruit');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Grapes', 1, 'lb', 'fruit');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Lemon', 1, 'lb', 'fruit');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Mango', 1, 'lb', 'fruit');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Orange', 1, 'lb', 'fruit');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Peach', 1, 'lb', 'fruit');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Pear', 1, 'lb', 'fruit');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Pineapple', 1, 'lb', 'fruit');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Plum', 1, 'lb', 'fruit');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Pomegranate', 1, 'lb', 'fruit');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Raspberry', 1, 'lb', 'fruit');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Strawberry', 1, 'lb', 'fruit');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Watermelon', 1, 'lb', 'fruit');

--dairy/animal products
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Butter', 1, 'lb', 'dairy/animal products');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Cheese', 1, 'lb', 'dairy/animal products');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Cream', 1, 'lb', 'dairy/animal products');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Egg', 1, 'lb', 'dairy/animal products');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Mayonnaise', 1, 'lb', 'dairy/animal products');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Milk', 1, 'lb', 'dairy/animal products');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Yogurt', 1, 'lb', 'dairy/animal products');

--Meat
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Bass', 1, 'lb', 'meat');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Beef', 1, 'lb', 'meat');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Catfish', 1, 'lb', 'meat');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Chicken', 1, 'lb', 'meat');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Clam', 1, 'lb', 'meat');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Crab', 1, 'lb', 'meat');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Flounder', 1, 'lb', 'meat');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Lobster', 1, 'lb', 'meat');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Mussel', 1, 'lb', 'meat');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Oyster', 1, 'lb', 'meat');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Pork', 1, 'lb', 'meat');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Salmon', 1, 'lb', 'meat');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Shrimp', 1, 'lb', 'meat');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Tilapia', 1, 'lb', 'meat');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Trout', 1, 'lb', 'meat');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Tuna', 1, 'lb', 'meat');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Turkey', 1, 'lb', 'meat');

--nuts
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Almond', 1, 'lb', 'nut');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Cashew', 1, 'lb', 'nut');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Hazelnut', 1, 'lb', 'nut');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Peanut', 1, 'lb', 'nut');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Pecan', 1, 'lb', 'nut');
INSERT INTO ingredient(name, quantity, unit, category) VALUES ('Walnut', 1, 'lb', 'nut');


--adding data to recipes
INSERT INTO recipe(name, diet_type, instruction) VALUES ('Strawberry Banana Smoothie', 'vegetarian', 'Add ice and blend together!');
INSERT INTO recipe(name, diet_type, instruction) VALUES ('Chicken Salad', 'low-carb', 'Chop chop and mix well.');

-- attaching ingredients to recipe
--Strawberry Banana Smootie
INSERT INTO recipe_ingredient (recipe_id, ingredient_id) VALUES ( 1, 20);
INSERT INTO recipe_ingredient (recipe_id, ingredient_id) VALUES ( 1, 35);
INSERT INTO recipe_ingredient (recipe_id, ingredient_id) VALUES ( 1, 43);

--Chicken Salad
INSERT INTO recipe_ingredient (recipe_id, ingredient_id) VALUES ( 2, 6);
INSERT INTO recipe_ingredient (recipe_id, ingredient_id) VALUES ( 2, 41);
INSERT INTO recipe_ingredient (recipe_id, ingredient_id) VALUES ( 2, 47);


COMMIT TRANSACTION;

--SELECT * FROM ingredient;

--SELECT i.name FROM recipe r
--JOIN recipe_ingredient ri ON ri.recipe_id = r.recipe_id
--JOIN ingredient i ON i.ingredient_id = ri.ingredient_id
--WHERE r.name='Strawberry Banana Smoothie'