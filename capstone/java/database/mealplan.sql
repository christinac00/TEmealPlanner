BEGIN TRANSACTION;

INSERT INTO ingredient (name, quantity, unit, category) VALUES ('chicken', 1, 'lb', 'meat');
INSERT INTO ingredient (name, quantity, unit, category) VALUES ('beef', 1, 'lb', 'meat');
INSERT INTO ingredient (name, quantity, unit, category) VALUES ('pork', 1, 'lb', 'meat');
INSERT INTO ingredient (name, quantity, unit, category) VALUES ('shrimp', 1, 'lb', 'seafood');
INSERT INTO ingredient (name, quantity, unit, category) VALUES ('romaine lettuce', 1, 'bowl', 'vegetable');
INSERT INTO ingredient (name, quantity, unit, category) VALUES ('caesar dressing', 1, 'tbsp', 'condiment');




COMMIT TRANSACTION;


