START TRANSACTION;
--INSERT tags into table
--diets
INSERT INTO tag(keyword) VALUES('Keto');
INSERT INTO tag(keyword) VALUES('Low-carb');
INSERT INTO tag(keyword) VALUES('Paleo');
INSERT INTO tag(keyword) VALUES('Pescatarian');
INSERT INTO tag(keyword) VALUES('Vegan');
INSERT INTO tag(keyword) VALUES('Vegetarian');

--phrases
INSERT INTO tag(keyword) VALUES('Air Fryer');
INSERT INTO tag(keyword) VALUES('Easy Dinner');
INSERT INTO tag(keyword) VALUES('Family Dinner');
INSERT INTO tag(keyword) VALUES('Most Popular');
INSERT INTO tag(keyword) VALUES('One-Pot Recipe');
INSERT INTO tag(keyword) VALUES('Slow Cooker Recipe');
INSERT INTO tag(keyword) VALUES('Under 30 Minutes');

--meal type
INSERT INTO tag(keyword) VALUES('Breakfast');
INSERT INTO tag(keyword) VALUES('Lunch');
INSERT INTO tag(keyword) VALUES('Dinner');
INSERT INTO tag(keyword) VALUES('Drink');
INSERT INTO tag(keyword) VALUES('Dessert');
INSERT INTO tag(keyword) VALUES('Snack');

COMMIT;