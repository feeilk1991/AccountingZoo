-- -- INSERT INTO animals (id, name, is_predator, animal_type) VALUES
-- --                                                            (1, 'Обезьяна', false, 'млекопитающее'),
-- --                                                            (2, 'заяц', false, 'млекопитающее'),
-- --                                                            (3, 'орел', true, 'птица'),
-- --                                                            (4, 'тигр', true, 'млекопитающее'),
-- --                                                            (5, 'лошадь', false, 'млекопитающее');
--
-- -- INSERT INTO products (id, name, type, current_quantity, measure_type) VALUES
-- --                                                          (1, 'Морковь', 'овощ', 120, 'шт'),
-- --                                                          (2, 'Мясо', 'мясо', 35, 'кг'),
-- --                                                          (3, 'Капуста', 'овощ', 130, 'шт'),
-- --                                                          (4, 'Банан', 'фрукт', 100, 'шт'),
-- --                                                          (5, 'Яблоко', 'фрукт', 0, 'шт'),
-- --     (6, 'Зерно', 'овощ', 200, 'кг'),
-- --     (7, 'Вода', 'жидкость', 500, 'л');
--
--
-- INSERT INTO animal_consumptions (animal_id, amount, date, measure_type, product_id) VALUES
--                                                                                         (1, 4, now(), 'шт', 4),
--                                                                                         (1, 3, now(), 'шт', 5),
--                                                                                         (1, 4, now(), 'л', 7),
--                                                                                         (4, 15, now(), 'кг', 2),
--                                                                                         (4, 10, now(), 'л', 7),
--                                                                                         (2, 5, now(), 'шт', 1),
--                                                                                         (2, 2, now(), 'шт', 3),
--                                                                                         (2, 2, now(), 'л', 7),
--                                                                                         (3, 1.5, now(), 'кг', 2),
--                                                                                         (3, 2, now(), 'кг', 6),
--                                                                                         (3, 4, now(), 'шт', 5),
--                                                                                         (3, 3, now(), 'л', 7),
--                                                                                         (5, 16, now(), 'кг', 6),
--                                                                                         (5, 8, now(), 'шт', 5),
--                                                                                         (5, 11, now(), 'шт', 1),
--                                                                                         (5, 17, now(), 'л', 7);