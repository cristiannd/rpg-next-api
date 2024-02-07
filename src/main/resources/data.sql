INSERT INTO levels (level, exp_next_level)
VALUES (1, 10), (2, 20), (3, 30), (4, 40), (5, 50);

INSERT INTO inventory (id, max_weight)
VALUES (1, 5);

INSERT INTO characters (name, experience, actual_energy, total_energy, actual_life, total_life, level_id, inventory_id)
VALUES
    ('Cristian', 1, 100, 100, 100, 100, 1, 1);

-- CREATE QUESTS:
INSERT INTO rewards (id, experience) VALUES (1, 320);

INSERT INTO quests (id, name, description, duration, energy_cost)
VALUES (
    1, 'The farmer needs help!',
    'Help the old village farmer collect the carrots from the garden and eliminate all the weeds.',
	10, 25
);

-- CREATE ITEMS:
-- Item categories
INSERT INTO item_categories (id, name)
VALUES (1, 'Weapon'), (2, 'Armor'), (3, 'Food');

-- Item subcategories
INSERT INTO item_sub_categories (id, name, item_category_id)
VALUES
    (1, 'Sword', 1), (2, 'Axe', 1), (3, 'Mace', 1),
    (4, 'Helmet', 2), (5, 'Chest', 2), (6, 'Pant', 2), (7, 'Boot', 2),
    (8, 'Meal', 3), (9, 'Vegetable', 3);

-- Weapons
INSERT INTO weapons (id, name, score, one_hand, physical_damage, actual_durability, max_durability, inventory_id, item_sub_category, reward_id)
VALUES
    (1, 'Wooden club', 1, true, 4, 10, 10, 1, 3, null),
    (2, 'Spectral Killer', 55, true, 33, 125, 125, null, 3, 1);

-- Armors
INSERT INTO armors (id, name, score, actual_durability, max_durability, defense, inventory_id, item_sub_category)
VALUES
    (1, 'Rag pants', 1, 10, 10, 1, 1, 6),
    (2, 'Old shirt', 1, 10, 10, 1, 1, 5);

-- Foods
INSERT INTO foods (id, name, score, stamina_recovery, inventory_id, item_sub_category)
VALUES (1, 'Roasted turkey leg', 4, 20, 1, 8);