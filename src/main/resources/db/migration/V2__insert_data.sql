insert into users(username, email) values ('username1', 'username1@gmail.com');
insert into users(username, email) values ('username2', 'username2@gmail.com');
insert into users(username, email) values ('username3', 'username3@gmail.com');
insert into users(username, email) values ('fodipeti', 'fpeti@gmail.com');

INSERT INTO author(name, born_in, died_in, place_of_birth, place_of_death, portrait)
       values('Jules Verne', to_date('2/8/1828', 'MM/DD/YYYY'), to_date('3/24/1905', 'MM/DD/YYYY'), 'Nantes', 'Amiens',
              'https://upload.wikimedia.org/wikipedia/commons/thumb/a/ae/Jules_Verne%2C_1892_%28colored_portrait%29.jpg/250px-Jules_Verne%2C_1892_%28colored_portrait%29.jpg');
-- INSERT INTO author(name, born_in, died_in, place_of_birth, place_of_death, portrait) values('Agatha Christie', to_date('9/15/1890', 'MM/DD/YYYY'), to_date('1/12/1976', 'MM/DD/YYYY'), 'Ashfield', 'Wallingford');
INSERT INTO author(name, born_in, died_in, place_of_birth, place_of_death, portrait)
        values('Arthur Conan Doyle',
               to_date('5/22/1859', 'MM/DD/YYYY'), to_date('7/7/1930', 'MM/DD/YYYY'), 
               'Edinburgh', 'Crowborough',
               'https://upload.wikimedia.org/wikipedia/commons/thumb/b/bd/Arthur_Conan_Doyle_by_Walter_Benington%2C_1914.png/220px-Arthur_Conan_Doyle_by_Walter_Benington%2C_1914.png');
-- INSERT INTO author(name, born_in, place_of_birth, portrait) values('George R. R. Martin', to_date('9/20/1948', 'MM/DD/YYYY'), 'Bayonne');
INSERT INTO author(name, born_in, place_of_birth, portrait)
        values('Stephen King',
               to_date('9/21/1947', 'MM/DD/YYYY'), 'Portland',
               'https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/Stephen_King_at_the_2024_Toronto_International_Film_Festival_2_%28cropped%29.jpg/220px-Stephen_King_at_the_2024_Toronto_International_Film_Festival_2_%28cropped%29.jpg');
INSERT INTO author(name, born_in, died_in, place_of_birth, place_of_death, portrait)
        values('J. R. R. Tolkien',
               to_date('1/3/1892', 'MM/DD/YYYY'), to_date('2/9/1973', 'MM/DD/YYYY'),
               'Bloemfontein', 'Bournemouth',
               'https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/J._R._R._Tolkien%2C_ca._1925.jpg/220px-J._R._R._Tolkien%2C_ca._1925.jpg');
INSERT INTO author(name, born_in, died_in, place_of_birth, place_of_death, portrait)
        values('Aldous Huxley',
               to_date('7/26/1894', 'MM/DD/YYYY'), to_date('11/22/1963', 'MM/DD/YYYY'),
               'Godalming', 'Los Angeles',
               'https://upload.wikimedia.org/wikipedia/commons/thumb/e/e9/Aldous_Huxley_psychical_researcher.png/220px-Aldous_Huxley_psychical_researcher.png');
INSERT INTO author(name, born_in, place_of_birth, portrait)
        values('Joanne Kathleen Rowling',
               to_date('7/31/1965', 'MM/DD/YYYY'), 'Yate',
               'https://upload.wikimedia.org/wikipedia/commons/thumb/5/5d/J._K._Rowling_2010.jpg/220px-J._K._Rowling_2010.jpg');
INSERT INTO author(name, born_in, died_in, place_of_birth, place_of_death, portrait)
        values('Gerald Durrell',
               to_date('1/7/1925', 'MM/DD/YYYY'), to_date('1/30/1995', 'MM/DD/YYYY'), 
               'Dzsamsedpur', 'Jersey',
               'https://upload.wikimedia.org/wikipedia/commons/thumb/9/9d/Gerald_Durrell%2C_Askania_Nova_%28cropped%29.jpg/220px-Gerald_Durrell%2C_Askania_Nova_%28cropped%29.jpg');
INSERT INTO author(name, born_in, place_of_birth, portrait)
        values ('Dummy Author', to_date('1/1/1970', 'MM/DD/YYYY'), 'Somewhere', null);

-- Jules Verne books
INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'Around the World in Eighty Days', id, 'Adventure', 304,
       2013, 1873,
       'https://s01.static.libri.hu/cover/ac/5/819545_4.jpg'
FROM author WHERE name = 'Jules Verne';

--

-- Gerard Durrell books
INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'My Family and Other Animals', id, 'Autobiography', 376,
       2016, 1956,
       'https://s01.static.libri.hu/cover/1b/7/3774131_4.jpg'
FROM author WHERE name = 'Gerald Durrell';

-- Sherlock Holmes books
INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'The Adventures of Sherlock Holmes', id, 'Detective Fiction', 318,
       2013, 1892,
       'https://s01.static.libri.hu/cover/32/f/819562_4.jpg'
FROM author WHERE name = 'Arthur Conan Doyle';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'The Return of Sherlock Holmes', id, 'Detective Fiction', 370,
       2013, 1905,
       'https://s01.static.libri.hu/cover/27/d/5902954_4.jpg'
FROM author WHERE name = 'Arthur Conan Doyle';

-- Huxley books
INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'Brave New World', id, 'Sci-Fi', 230,
       2007, 1932,
       'https://s01.static.libri.hu/cover/ad/a/731642_4.jpg'
FROM author WHERE name = 'Aldous Huxley';

-- J.K Rowling books
INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'Harry Potter and the Philosopher''s Stone', id, 'Fantasy', 331,
       2014, 1997,
       'https://s01.static.libri.hu/cover/81/3/1957267_4.jpg'
FROM author WHERE name = 'Joanne Kathleen Rowling';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'Harry Potter and the Chamber of Secrets', id, 'Fantasy', 360,
       2014, 1998,
       'https://s01.static.libri.hu/cover/d5/b/1957269_4.jpg'
FROM author WHERE name = 'Joanne Kathleen Rowling';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'Harry Potter and the Prisoner of Azkaban', id, 'Fantasy', 462,
       2014, 1999,
       'https://s01.static.libri.hu/cover/27/0/1957268_4.jpg'
FROM author WHERE name = 'Joanne Kathleen Rowling';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'Harry Potter and the Goblet of Fire', id, 'Fantasy', 617,
       2014, 2000,
       'https://s01.static.libri.hu/cover/c0/c/1957271_4.jpg'
FROM author WHERE name = 'Joanne Kathleen Rowling';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'Harry Potter and the Order of the Phoenix', id, 'Fantasy', 799,
       2014, 2003,
       'https://s01.static.libri.hu/cover/99/b/1957272_4.jpg'
FROM author WHERE name = 'Joanne Kathleen Rowling';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'Harry Potter and the Half-Blood Prince', id, 'Fantasy', 542,
       2014, 2005,
       'https://s01.static.libri.hu/cover/d9/0/1957270_4.jpg'
FROM author WHERE name = 'Joanne Kathleen Rowling';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'Harry Potter and the Deathly Hallows', id, 'Fantasy', 620,
       2014, 2007,
       'https://s01.static.libri.hu/cover/5c/b/1957273_4.jpg'
FROM author WHERE name = 'Joanne Kathleen Rowling';

-- Tolkien books
INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'The Lord of the Rings - The Fellowship of the Ring', id, 'Fantasy', 532,
       2012, 1954,
       'https://s01.static.libri.hu/cover/29/e/854765_4.jpg'
FROM author WHERE name = 'J. R. R. Tolkien';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'The Lord of the Rings - The Two Towers', id, 'Fantasy', 971,
       2012, 1954,
       'https://s01.static.libri.hu/cover/46/2/854766_4.jpg'
FROM author WHERE name = 'J. R. R. Tolkien';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'The Lord of the Rings - The Return of the King', id, 'Fantasy', 590,
       2012, 1955,
       'https://s01.static.libri.hu/cover/e8/2/854767_4.jpg'
FROM author WHERE name = 'J. R. R. Tolkien';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'The Hobbit', id, 'Fantasy', 341,
       2011, 1937,
       'https://s01.static.libri.hu/cover/fa/1/849912_4.jpg'
FROM author WHERE name = 'J. R. R. Tolkien';

-- Stephen King books
INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'Mr. Mercedes', id, 'Thriller', 557,
       2023, 2014,
       'https://s01.static.libri.hu/cover/91/1/2494921_4.jpg'
FROM author WHERE name = 'Stephen King';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'Finders Keepers', id, 'Crime', 385,
       2016, 2015,
       'https://s01.static.libri.hu/cover/85/6/3234487_4.jpg'
FROM author WHERE name = 'Stephen King';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'End of Watch', id, 'Crime', 368,
       2017, 2016,
       'https://s01.static.libri.hu/cover/81/e/3825342_4.jpg'
FROM author WHERE name = 'Stephen King';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'Misery', id, 'Thriller', 464,
       2021, 1987,
       'https://s01.static.libri.hu/cover/e8/7/6101829_4.jpg'
FROM author WHERE name = 'Stephen King';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'The Green Mile', id, 'Fantasy', 506,
       2024, 1996,
       'https://s01.static.libri.hu/cover/90/c/2333890_4.jpg'
FROM author WHERE name = 'Stephen King';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year, cover)
SELECT 'Dummy Title', id, 'Fantasy', 168, 2024, 2024,
       null FROM author where name = 'Dummy Author';


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