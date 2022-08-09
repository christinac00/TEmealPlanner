BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, plan, recipe_plan, user_recipe, recipe, ingredient CASCADE;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,

	CONSTRAINT PK_user PRIMARY KEY (user_id)
);


CREATE TABLE plan (
    plan_id SERIAL ,
    name varchar(50) NOT NULL,
    day_of_week varchar(20) NOT NULL,

    CONSTRAINT PK_plan PRIMARY KEY (plan_id)
);


CREATE TABLE  ingredient (
	ingredient_id SERIAL,
	name varchar(50) NOT NULL,
	quantity int NOT NULL,
	unit varchar(20) NOT NULL,
	category varchar (50) NOT NULL,

	CONSTRAINT PK_ingredient PRIMARY KEY (ingredient_id)
);


CREATE TABLE recipe (
    recipe_id SERIAL,
    name varchar(50) NOT NULL,
    ingredient_id int NOT NULL,
    diet_type varchar(50) ,
    instruction text,
	CONSTRAINT PK_recipe PRIMARY KEY (recipe_id),
	CONSTRAINT FK_ingredient_recipe FOREIGN KEY (ingredient_id) REFERENCES ingredient(ingredient_id)

);


CREATE TABLE recipe_plan (
    plan_id int NOT NULL,
    recipe_id int NOT NULL,
    time_of_day varchar(20) NOT NULL,

    CONSTRAINT PK_recipe_plan PRIMARY KEY (plan_id, recipe_id),
	CONSTRAINT FK_recipe_plan_plan FOREIGN KEY (plan_id) REFERENCES plan(plan_id),
	CONSTRAINT FK_recipe_plan_recipe FOREIGN KEY (recipe_id) REFERENCES recipe(recipe_id)

);


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
