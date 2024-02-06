INSERT INTO levels (level, exp_next_level)
VALUES (1, 10), (2, 20), (3, 30), (4, 40), (5, 50);

INSERT INTO inventory (id, max_weight)
VALUES (1, 5);

INSERT INTO characters (name, experience, actual_energy, total_energy, actual_life, total_life, level_id, inventory_id)
VALUES
    ('Cristian', 1, 100, 100, 100, 100, 1, 1);

-- CREATE QUESTS:
INSERT INTO quests (name, description, duration, min_experience, max_experience, energy_cost)
VALUES (
	'The farmer needs help!',
    'Help the old village farmer collect the carrots from the garden and eliminate all the weeds.',
	10, 10, 15, 25
);

-- CREATE ITEMS:
-- Item categories
INSERT INTO item_categories (name)
VALUES ('Weapon'), ('Armor'), ('Food');

-- Item subcategories
INSERT INTO

-- Weapons
INSERT INTO weapons (id, name, score, one_hand, physical_damage, actual_durability, max_durability, inventory_id)
VALUES (1, 'Wooden club', 1, true, 4, 10, 10, 1);

-- Armors
INSERT INTO armors (id, name, score, actual_durability, max_durability, defense, inventory_id)
VALUES
    (1, 'Rag pants', 1, 10, 10, 1, 1),
    (2, 'Old shirt', 1, 10, 10, 1, 1);

-- Foods
INSERT INTO foods (id, name, score, stamina_recovery, inventory_id)
VALUES (1, 'Roasted turkey leg', 4, 20, 1);