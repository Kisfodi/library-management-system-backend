insert into users(username, email) values ('username1', 'username1@gmail.com');
insert into users(username, email) values ('username2', 'username2@gmail.com');
insert into users(username, email) values ('username3', 'username3@gmail.com');
insert into users(username, email) values ('fodipeti', 'fpeti@gmail.com');

INSERT INTO author(name, born_in, died_in, place_of_birth, place_of_death, portrait)
       values('Jules Verne', to_date('2/8/1828', 'MM/DD/YYYY'), to_date('3/24/1905', 'MM/DD/YYYY'), 'Nantes', 'Amiens', 'jules_verne.png');
-- INSERT INTO author(name, born_in, died_in, place_of_birth, place_of_death, portrait) values('Agatha Christie', to_date('9/15/1890', 'MM/DD/YYYY'), to_date('1/12/1976', 'MM/DD/YYYY'), 'Ashfield', 'Wallingford');
INSERT INTO author(name, born_in, died_in, place_of_birth, place_of_death, portrait)
        values('Arthur Conan Doyle',
               to_date('5/22/1859', 'MM/DD/YYYY'), to_date('7/7/1930', 'MM/DD/YYYY'), 
               'Edinburgh', 'Crowborough', 'arthur_conan_doyle.png');
-- INSERT INTO author(name, born_in, place_of_birth, portrait) values('George R. R. Martin', to_date('9/20/1948', 'MM/DD/YYYY'), 'Bayonne');
INSERT INTO author(name, born_in, place_of_birth, portrait)
        values('Stephen King',
               to_date('9/21/1947', 'MM/DD/YYYY'), 'Portland', 'stephen_king.png');
INSERT INTO author(name, born_in, died_in, place_of_birth, place_of_death, portrait)
        values('J. R. R. Tolkien',
               to_date('1/3/1892', 'MM/DD/YYYY'), to_date('2/9/1973', 'MM/DD/YYYY'),
               'Bloemfontein', 'Bournemouth', 'j_r_r_tolkien.png');
INSERT INTO author(name, born_in, died_in, place_of_birth, place_of_death, portrait)
        values('Aldous Huxley',
               to_date('7/26/1894', 'MM/DD/YYYY'), to_date('11/22/1963', 'MM/DD/YYYY'),
               'Godalming', 'Los Angeles', 'aldous_huxley.png');
INSERT INTO author(name, born_in, place_of_birth, portrait)
        values('Joanne Kathleen Rowling',
               to_date('7/31/1965', 'MM/DD/YYYY'), 'Yate', 'j_k_rowling.png');
INSERT INTO author(name, born_in, died_in, place_of_birth, place_of_death, portrait)
        values('Gerald Durrell',
               to_date('1/7/1925', 'MM/DD/YYYY'), to_date('1/30/1995', 'MM/DD/YYYY'), 
               'Dzsamsedpur', 'Jersey', 'gerald_durrell.png');

-- Jules Verne books
INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'Around the World in Eighty Days', id, 'Adventure', 304,
       2013, 1873, 'around_the_world_in_eighty_days.png'  FROM author WHERE name = 'Jules Verne';

-- Gerard Durrell books
INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'My Family and Other Animals', id, 'Autobiography', 376,
       2016, 1956, 'my_family_and_other_animals.png' FROM author WHERE name = 'Gerald Durrell';

-- Sherlock Holmes books
INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'The Adventures of Sherlock Holmes', id, 'Detective Fiction', 318,
       2013, 1892, 'the_adventures_of_sherlock_holmes.png' FROM author WHERE name = 'Arthur Conan Doyle';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'The Return of Sherlock Holmes', id, 'Detective Fiction', 370,
       2013, 1905, 'the_return_of_sherlock_holmes.png' FROM author WHERE name = 'Arthur Conan Doyle';

-- Huxley books
INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'Brave New World', id, 'Sci-Fi', 230,
       2007, 1932, 'brave_new_world.png' FROM author WHERE name = 'Aldous Huxley';

-- J.K Rowling books
INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'Harry Potter and the Philosopher''s Stone', id, 'Fantasy', 331,
       2014, 1997, 'hp_philosophers_stone.png' FROM author WHERE name = 'Joanne Kathleen Rowling';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'Harry Potter and the Chamber of Secrets', id, 'Fantasy', 360,
       2014, 1998, 'hp_chamber_of_secrets.png' FROM author WHERE name = 'Joanne Kathleen Rowling';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'Harry Potter and the Prisoner of Azkaban', id, 'Fantasy', 462,
       2014, 1999, 'hp_prisoner_of_azkaban.png' FROM author WHERE name = 'Joanne Kathleen Rowling';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'Harry Potter and the Goblet of Fire', id, 'Fantasy', 617,
       2014, 2000, 'hp_goblet_of_fire.png' FROM author WHERE name = 'Joanne Kathleen Rowling';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'Harry Potter and the Order of the Phoenix', id, 'Fantasy', 799,
       2014, 2003, 'hp_order_of_the_phoenix.png' FROM author WHERE name = 'Joanne Kathleen Rowling';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'Harry Potter and the Half-Blood Prince', id, 'Fantasy', 542,
       2014, 2005, 'hp_half_blood_prince.png' FROM author WHERE name = 'Joanne Kathleen Rowling';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'Harry Potter and the Deathly Hallows', id, 'Fantasy', 620,
       2014, 2007, 'hp_deathly_hallows.png' FROM author WHERE name = 'Joanne Kathleen Rowling';

-- Tolkien books
INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'The Lord of the Rings - The Fellowship of the Ring', id, 'Fantasy', 532,
       2012, 1954, 'lotr_fellowship_of_the_ring.png'  FROM author WHERE name = 'J. R. R. Tolkien';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'The Lord of the Rings - The Two Towers', id, 'Fantasy', 971,
       2012, 1954, 'lotr_two_towers.png' FROM author WHERE name = 'J. R. R. Tolkien';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'The Lord of the Rings - The Return of the King', id, 'Fantasy', 590,
       2012, 1955, 'lotr_return_of_the_king.png' FROM author WHERE name = 'J. R. R. Tolkien';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'The Hobbit', id, 'Fantasy', 341,
       2011, 1937, 'the_hobbit.png' FROM author WHERE name = 'J. R. R. Tolkien';

-- Stephen King books
INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'Mr. Mercedes', id, 'Thriller', 557,
       2023, 2014, 'mr_mercedes.png' FROM author WHERE name = 'Stephen King';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'Finders Keepers', id, 'Crime', 385,
       2016, 2015, 'finders_keepers.png' FROM author WHERE name = 'Stephen King';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'End of Watch', id, 'Crime', 368,
       2017, 2016, 'end_of_watch.png' FROM author WHERE name = 'Stephen King';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'Misery', id, 'Thriller', 464,
       2021, 1987, 'misery.png' FROM author WHERE name = 'Stephen King';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'The Green Mile', id, 'Fantasy', 506,
       2024, 1996, 'the_green_mile.png' FROM author WHERE name = 'Stephen King';

-- Insert an item of each book, with each condition option
INSERT INTO item(book_id, is_available, condition)
SELECT book.id, a1.is_available, a2.condition
FROM book
CROSS JOIN (VALUES (TRUE)) as a1(is_available)
CROSS JOIN (VALUES ('mint'), ('good'), ('poor')) as a2(condition);

-- Update values at random?
-- UPDATE item
-- SET condition = "good"
-- FROM