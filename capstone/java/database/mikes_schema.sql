BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, plan, recipe_plan, user_recipe, recipe, ingredient, category, recipe_ingredient, diet_type CASCADE;

--table to keep track of user information
CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,

	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

--categories for ingredients can be its own table
CREATE TABLE category (
	category_id SERIAL,
	category_name varchar(50) NOT NULL,
	
	CONSTRAINT PK_category PRIMARY KEY (category_id)
);

--table for weekly meal plan
CREATE TABLE plan (
    plan_id SERIAL,
    plan_name varchar(50) NOT NULL,
    day_of_week varchar(20) NOT NULL, --is it that the user eats the same meal on the same day every week?

    CONSTRAINT PK_plan PRIMARY KEY (plan_id)
);

--table for ingredients that reference the category id
CREATE TABLE  ingredient (
	ingredient_id SERIAL,
	ingredient_name varchar(50) NOT NULL UNIQUE,
	category_id int NOT NULL,

	CONSTRAINT PK_ingredient PRIMARY KEY (ingredient_id),
	CONSTRAINT FK_ingredient_category FOREIGN KEY (category_id) REFERENCES category(category_id)
);

--diet type can be its own table to create a join table of recipes that align with a certain diet
CREATE TABLE diet_type (
	diet_type_id SERIAL NOT NULL,
	diet_name varchar(100) NOT NULL,
	CONSTRAINT PK_diet_type PRIMARY KEY (diet_type_id)
);

--table for recipes
CREATE TABLE recipe (
    recipe_id SERIAL,
    recipe_name varchar(50) NOT NULL,
	instructions text, --ingredient quantities could be listed here since Tara doesn't need detailed instructions
	CONSTRAINT PK_recipe PRIMARY KEY (recipe_id)
	--meal_type varchar(50) should recipes include whether it is breakfast, lunch or dinner? this could be a separate table, too
);

--join table for recipes and ingredients
CREATE TABLE recipe_ingredient (
    recipe_id int NOT NULL,
    ingredient_id int NOT NULL,

    CONSTRAINT PK_recipe_ingredient PRIMARY KEY (recipe_id, ingredient_id),
    CONSTRAINT FK_recipe_ingredient_recipe FOREIGN KEY (recipe_id) REFERENCES recipe(recipe_id),
    CONSTRAINT FK_recipe_ingredient_ingredient FOREIGN KEY (ingredient_id) REFERENCES ingredient(ingredient_id)

);

--join table for recipes and plans... does this cover the type of meal each recipe is?
CREATE TABLE recipe_plan (
    plan_id int NOT NULL,
    recipe_id int NOT NULL,
    time_of_day varchar(20) NOT NULL,

    CONSTRAINT PK_recipe_plan PRIMARY KEY (plan_id, recipe_id),
	CONSTRAINT FK_recipe_plan_plan FOREIGN KEY (plan_id) REFERENCES plan(plan_id),
	CONSTRAINT FK_recipe_plan_recipe FOREIGN KEY (recipe_id) REFERENCES recipe(recipe_id)
);

--table for recipes saved by the user. still not sure how to implement the booleans. would that be done with java?
CREATE TABLE user_recipe (
	user_id int NOT NULL,
	recipe_id int NOT NULL,
	isCreated boolean NOT NULL,
	isFavorite boolean NOT NULL,

	CONSTRAINT PK_user_recipe PRIMARY KEY (user_id, recipe_id),
	CONSTRAINT FK_recipe_user_recipe FOREIGN KEY (recipe_id) REFERENCES recipe(recipe_id),
	CONSTRAINT FK_recipe_user_users FOREIGN KEY (user_id) REFERENCES users(user_id)
);

COMMIT TRANSACTION;