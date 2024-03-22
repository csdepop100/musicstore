DROP TABLE IF EXISTS musicstore.album;
DROP TABLE IF EXISTS musicstore.review;

CREATE TABLE musicstore.album (
    id int auto_increment primary key,
    name varchar(255) not null,
    artist varchar(255) not null,
    releaseDate datetime not null
);

CREATE TABLE musicstore.review (
    id int auto_increment primary key,
    user varchar(255) not null,
    rating int not null,
    comment varchar(255),
    album int references musicstore.album(id)
);

# Dev Toy Data

INSERT INTO musicstore.album
VALUES (1, 'What\'s happening?', 'Mario Gaye', 1971-01-31);
INSERT INTO musicstore.album
VALUES (2, 'Animal Sounds', 'The Ocean Girls', 1966-05-10);
INSERT INTO musicstore.album
VALUES (3, 'Red', 'Jodi Marshall', 1971-07-31);

INSERT INTO musicstore.review
VALUES (1, 'MusicMan1', 5, null, 1);
INSERT INTO musicstore.review
VALUES (2, 'MetalHead30', 5, null, 1);
INSERT INTO musicstore.review
VALUES (3, 'MGFan71', 5, 'GOAT', 1);
INSERT INTO musicstore.review
VALUES (4, 'UntilDawn', 4, null, 1);
INSERT INTO musicstore.review
VALUES (5, 'AnotherUser', 5, null, 1);
INSERT INTO musicstore.review
VALUES (6, 'YetAnotherUser', 5, null, 1);
INSERT INTO musicstore.review
VALUES (7, 'BeforeDusk', 4, null, 1);
INSERT INTO musicstore.review
VALUES (8, 'MotzNase', 2, 'Nicht meins...', 1);
INSERT INTO musicstore.review
VALUES (9, 'PositivePeter', 5, 'EINFACH GEIL', 1);
INSERT INTO musicstore.review
VALUES (10, 'LastUser', 4, null, 1);
INSERT INTO musicstore.review
VALUES (11, 'OneForGoodMeasure', 5, null, 1);