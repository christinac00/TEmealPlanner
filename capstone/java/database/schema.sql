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
    CONSTRAINT
);

CREATE TABLE recipe (
    recipe_id SERIAL,
    name varchar,
    ingredient int,
    diet_type varchar,
    instruction text
);



COMMIT TRANSACTION;
