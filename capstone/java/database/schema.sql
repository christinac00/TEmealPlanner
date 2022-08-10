BEGIN TRANSACTION;

DROP TABLE IF EXISTS recipe_plan, recipe_ingredient, recipe_tag, user_recipe, tag, recipe, ingredient, plan, users CASCADE;

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
	name varchar(50) NOT NULL UNIQUE,
	category varchar (50) NOT NULL,

	CONSTRAINT PK_ingredient PRIMARY KEY (ingredient_id)
);


CREATE TABLE recipe (
    recipe_id SERIAL,
    name varchar(100) NOT NULL,
    instructions text,
	CONSTRAINT PK_recipe PRIMARY KEY (recipe_id)

);


CREATE TABLE tag (
    tag_id SERIAL,
    keyword varchar(100) NOT NULL,
    CONSTRAINT PK_tag PRIMARY KEY (tag_id)
);


CREATE TABLE recipe_tag(
    recipe_id int NOT NULL,
    tag_id int NOT NULL,
    CONSTRAINT PK_recipe_tag PRIMARY KEY (recipe_id, tag_id),
    CONSTRAINT FK_recipe_tag_recipe FOREIGN KEY (recipe_id) REFERENCES recipe(recipe_id),
    CONSTRAINT FK_recipe_tag_tag FOREIGN KEY (tag_id) REFERENCES tag(tag_id)
);


CREATE TABLE recipe_ingredient (
    recipe_id int NOT NULL,
    ingredient_id int NOT NULL,
    quantity int NOT NULL,
    unit varchar(100) NOT NULL,

    CONSTRAINT PK_recipe_ingredient PRIMARY KEY (recipe_id, ingredient_id),
    CONSTRAINT FK_recipe_ingredient_recipe FOREIGN KEY (recipe_id) REFERENCES recipe(recipe_id),
    CONSTRAINT FK_recipe_ingredient_ingredient FOREIGN KEY (ingredient_id) REFERENCES ingredient(ingredient_id)

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
