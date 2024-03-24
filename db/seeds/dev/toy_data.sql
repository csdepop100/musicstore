INSERT INTO musicstore.album (id, name, artist, release_date)
VALUES (1, 'What\'s happening?', 'Mario Gaye', '1971-01-31');
INSERT INTO musicstore.album (id, name, artist, release_date)
VALUES (2, 'Animal Sounds', 'The Ocean Girls', '1966-05-10');
INSERT INTO musicstore.album (id, name, artist, release_date)
VALUES (3, 'Red', 'Jodi Marshall', '1971-07-31');

INSERT INTO musicstore.album_reviews (pkId, user, rating, comment, album)
VALUES (1, 'MusicMan1', 5, null, 1);
INSERT INTO musicstore.album_reviews (pkId, user, rating, comment, album)
VALUES (2, 'MetalHead30', 5, null, 1);
INSERT INTO musicstore.album_reviews (pkId, user, rating, comment, album)
VALUES (3, 'MGFan71', 5, 'GOAT', 1);
INSERT INTO musicstore.album_reviews (pkId, user, rating, comment, album)
VALUES (4, 'UntilDawn', 4, null, 1);
INSERT INTO musicstore.album_reviews (pkId, user, rating, comment, album)
VALUES (5, 'AnotherUser', 5, null, 1);
INSERT INTO musicstore.album_reviews (pkId, user, rating, comment, album)
VALUES (6, 'YetAnotherUser', 5, null, 1);
INSERT INTO musicstore.album_reviews (pkId, user, rating, comment, album)
VALUES (7, 'BeforeDusk', 4, null, 1);
INSERT INTO musicstore.album_reviews (pkId, user, rating, comment, album)
VALUES (8, 'MotzNase', 2, 'Nicht meins...', 1);
INSERT INTO musicstore.album_reviews (pkId, user, rating, comment, album)
VALUES (9, 'PositivePeter', 5, 'EINFACH GEIL', 1);
INSERT INTO musicstore.album_reviews (pkId, user, rating, comment, album)
VALUES (10, 'LastUser', 4, null, 1);
INSERT INTO musicstore.album_reviews (pkId, user, rating, comment, album)
VALUES (11, 'OneForGoodMeasure', 5, null, 1);
INSERT INTO musicstore.album_reviews (pkId, user, rating, comment, album)
VALUES (12, 'DeleteMePlease', 5, null, 2);