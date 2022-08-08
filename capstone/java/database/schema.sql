BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);


CREATE TABLE plan (
    plan_id SERIAL,
    name varchar (50),
    day_of_week varchar (20),
    CONSTRAINT PK_plan PRIMARY KEY (plan_id)
);

CREATE TABLE recipe_plan (
    plan_id int,
    recipe_id int,
    time_of_day varchar (20),
    CONSTRAINT PK_recipe_plan PRIMARY KEY (plan_id)
);

CREATE TABLE recipe (
    recipe_id SERIAL,
    name varchar,
    ingredient_id int,
    diet_type varchar(50),
    instruction text
	CONSTRAINT PK_recipe PRIMARY KEY (recipe_id)
);

CREATE TABLE user_recipe (
	user_id SERIAL,
	recipe_id int,
	isCreated boolean,
	isFavorite boolean
	CONSTRAINT PK_user_recipe PRIMARY KEY (user_id)
);

CREATE TABLE  ingredient (
	ingredient_id SERIAL,
	name varchar(50),
	quantity int,
	unit varchar(20)
	CONSTRAINT PK_ingredient_id PRIMARY KEY (ingredient_id)
)




COMMIT TRANSACTION;
