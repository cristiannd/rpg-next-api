INSERT INTO levels (level, exp_next_level)
VALUES (1, 100), (2, 200), (3, 300), (4, 400), (5, 500);

INSERT INTO characters (name, experience, actual_stamina, total_stamina, actual_life, total_life, level_id)
VALUES
    ('Cristian', 1, 100, 100, 100, 100, 1),
    ('Tatiana', 5, 85, 100, 95, 100, 1);

-- CREATE QUESTS:
INSERT INTO quests (name, description, duration, min_experience, max_experience)
VALUES (
	'The farmer needs help!',
    'Help the old village farmer collect the carrots from the garden and eliminate all the weeds.',
	10,
    10,
    15
);






