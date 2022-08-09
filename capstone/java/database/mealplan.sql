BEGIN TRANSACTION;

INSERT INTO ingredient (name, quantity, unit, category) VALUES ('chicken', 1, 'lb', 'meat');
INSERT INTO ingredient (name, quantity, unit, category) VALUES ('beef', 1, 'lb', 'meat');
INSERT INTO ingredient (name, quantity, unit, category) VALUES ('pork', 1, 'lb', 'meat');
INSERT INTO ingredient (name, quantity, unit, category) VALUES ('shrimp', 1, 'lb', 'seafood');
INSERT INTO ingredient (name, quantity, unit, category) VALUES ('romaine lettuce', 1, 'bowl', 'vegetable');
INSERT INTO ingredient (name, quantity, unit, category) VALUES ('caesar dressing', 1, 'tbsp', 'condiment');

COMMIT TRANSACTION;



BEGIN TRANSACTION;

INSERT INTO recipe (name, ingredient_id, diet_type, instruction) VALUES ('Caesar Salad', (SELECT ingredient_id FROM ingredient WHERE name='romaine lettuce'), 'vegetarian', 'shake it up');
INSERT INTO recipe (name, ingredient_id, diet_type, instruction) VALUES ('Caesar Salad', (SELECT ingredient_id FROM ingredient WHERE name='caesar dressing'), 'vegetarian', 'shake it up');

INSERT INTO plan (name, day_of_week) VALUES ('Monday Lunch', 'Monday');

COMMIT TRANSACTION;


