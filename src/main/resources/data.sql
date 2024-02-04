INSERT INTO levels (level, exp_next_level)
VALUES (1, 10), (2, 20), (3, 30), (4, 40), (5, 50);

INSERT INTO characters (name, experience, actual_energy, total_energy, actual_life, total_life, level_id)
VALUES
    ('Cristian', 1, 100, 100, 100, 100, 1);

-- CREATE QUESTS:
INSERT INTO quests (name, description, duration, min_experience, max_experience, energy_cost)
VALUES (
	'The farmer needs help!',
    'Help the old village farmer collect the carrots from the garden and eliminate all the weeds.',
	10, 10, 15, 25
);






