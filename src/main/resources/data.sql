INSERT INTO coin_types (name, description)
VALUES
    ('Gold', 'Gold description'),
    ('Silver', 'Silver description'),
    ('Bronze', 'Bronze description');

INSERT INTO coin_amount (amount, coin_type_id)
VALUES
    (1, 1), (2, 1), (3, 1),
    (1, 2), (2, 2), (3, 2), (4, 2), (5, 2),
    (1, 3), (2, 3), (3, 3), (4, 3), (5, 3), (6, 3), (7, 3);

INSERT INTO levels (level, exp_next_level)
VALUES (1, 100), (2, 200), (3, 300), (4, 400);

INSERT INTO characters (name, experience, actual_stamina, total_stamina, actual_life, total_life, level_id)
VALUES
    ('Cristian', 1, 100, 100, 100, 100, 1),
    ('Tatiana', 5, 85, 100, 95, 100, 1);

INSERT INTO wallets (character_id, coin_amount_id)
VALUES (1, 1), (1, 4);







