insert into users(username, email) values ('username1', 'username1@gmail.com');
insert into users(username, email) values ('username2', 'username2@gmail.com');
insert into users(username, email) values ('username3', 'username3@gmail.com');

/*
INSERT INTO condition(name) values('mint');
INSERT INTO condition(name) values('good');
INSERT INTO condition(name) values('poor');

INSERT INTO genre(name) values('fantasy');
INSERT INTO genre(name) values('sci-fi');
INSERT INTO genre(name) values('horror');
INSERT INTO genre(name) values('thriller');
INSERT INTO genre(name) values('crime novel');
INSERT INTO genre(name) values('novel');
INSERT INTO genre(name) values('drama');
  */

INSERT INTO author(name, born_in, died_in, place_of_birth, place_of_death) values('Jules Verne', str_to_date('2/8/1828', '%m/%d/%Y'), str_to_date('3/24/1905', '%m/%d/%Y'), 'Nantes', 'Amiens');
-- INSERT INTO author(name, born_in, died_in, place_of_birth, place_of_death) values('Agatha Christie', str_to_date('9/15/1890', '%m/%d/%Y'), str_to_date('1/12/1976', '%m/%d/%Y'), 'Ashfield', 'Wallingford');
INSERT INTO author(name, born_in, died_in, place_of_birth, place_of_death) values('Arthur Conan Doyle', str_to_date('5/22/1859', '%m/%d/%Y'), str_to_date('7/7/1930', '%m/%d/%Y'), 'Edinburgh', 'Crowborough');
-- INSERT INTO author(name, born_in, place_of_birth) values('George R. R. Martin', str_to_date('9/20/1948', '%m/%d/%Y'), 'Bayonne');
INSERT INTO author(name, born_in, place_of_birth) values('Stephen King', str_to_date('9/21/1947', '%m/%d/%Y'), 'Portland');
INSERT INTO author(name, born_in, died_in, place_of_birth, place_of_death) values('J. R. R. Tolkien', str_to_date('1/3/1892', '%m/%d/%Y'), str_to_date('2/9/1973', '%m/%d/%Y'), 'Bloemfontein', 'Bournemouth');
INSERT INTO author(name, born_in, died_in, place_of_birth, place_of_death) values('Aldous Huxley', str_to_date('7/26/1894', '%m/%d/%Y'), str_to_date('11/22/1963', '%m/%d/%Y'), 'Godalming', 'Los Angeles');
INSERT INTO author(name, born_in, place_of_birth) values('Joanne Kathleen Rowling', str_to_date('7/31/1965', '%m/%d/%Y'), 'Yate');
INSERT INTO author(name, born_in, died_in, place_of_birth, place_of_death) values('Gerald Durrell', str_to_date('1/7/1925', '%m/%d/%Y'), str_to_date('1/30/1995', '%m/%d/%Y'), 'Dzsamsedpur', 'Jersey');

-- Jules Verne books
INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year)
SELECT 'Around the World in Eighty Days', id, 'Fiction', 304,
       str_to_date('2013', '%Y'), str_to_date('1873', '%Y') FROM author WHERE name = 'Jules Verne';

-- Gerard Durrell books
INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year)
SELECT 'My Family and Other Animals', id, 'Autobiography', 376,
       str_to_date('2016', '%Y'), str_to_date('1956', '%Y') FROM author WHERE name = 'Gerald Durrell';

-- Sherlock Holmes books
INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year)
SELECT 'The Adventures of Sherlock Holmes', id, 'Detective fiction', 318, str_to_date('2013', '%Y'), str_to_date('1892', '%Y') FROM author WHERE name = 'Arthur Conan Doyle';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year)
SELECT 'The Return of Sherlock Holmes', id, 'Detective fiction', 370, str_to_date('2013', '%Y'), str_to_date('1905', '%Y') FROM author WHERE name = 'Arthur Conan Doyle';

-- Huxley books
INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year)
SELECT 'Brave New World', id, 'Science Fiction', 230,
       str_to_date('2007', '%Y'), str_to_date('1932', '%Y') FROM author WHERE name = 'Aldous Huxley';

-- J.K Rowling books
INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year)
SELECT 'Harry Potter and the Philosopher''s Stone', id, 'Fantasy', 331,
       str_to_date('2014', '%Y'), str_to_date('1997', '%Y') FROM author WHERE name = 'Joanne Kathleen Rowling';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year)
SELECT 'Harry Potter and the Chamber of Secrets', id, 'Fantasy', 360,
       str_to_date('2014', '%Y'), str_to_date('1998', '%Y') FROM author WHERE name = 'Joanne Kathleen Rowling';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year)
SELECT 'Harry Potter and the Prisoner of Azkaban', id, 'Fantasy', 462,
       str_to_date('2014', '%Y'), str_to_date('1999', '%Y') FROM author WHERE name = 'Joanne Kathleen Rowling';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year)
SELECT 'Harry Potter and the Goblet of Fire', id, 'Fantasy', 617,
       str_to_date('2014', '%Y'), str_to_date('2000', '%Y') FROM author WHERE name = 'Joanne Kathleen Rowling';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year)
SELECT 'Harry Potter and the Order of the Phoenix', id, 'Fantasy', 799,
       str_to_date('2014', '%Y'), str_to_date('2003', '%Y') FROM author WHERE name = 'Joanne Kathleen Rowling';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year)
SELECT 'Harry Potter and the Half-Blood Prince', id, 'Fantasy', 542,
       str_to_date('2024', '%Y'), str_to_date('2005', '%Y') FROM author WHERE name = 'Joanne Kathleen Rowling';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year)
SELECT 'Harry Potter and the Deathly Hallows', id, 'Fantasy', 620,
       str_to_date('2024', '%Y'), str_to_date('2007', '%Y') FROM author WHERE name = 'Joanne Kathleen Rowling';

-- Tolkien books
INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year)
SELECT 'The Lord of the Rings - The Fellowship of the Ring', id, 'Fantasy', 532,
       str_to_date('2012', '%Y'), str_to_date('1954', '%Y') FROM author WHERE name = 'J. R. R. Tolkien';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year)
SELECT 'The Lord of the Rings - The Two Towers', id, 'Fantasy', 971,
       str_to_date('2012', '%Y'), str_to_date('1954', '%Y') FROM author WHERE name = 'J. R. R. Tolkien';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year)
SELECT 'The Lord of the Rings - The Return of the King', id, 'Fantasy', 590,
       str_to_date('2012', '%Y'), str_to_date('1955', '%Y') FROM author WHERE name = 'J. R. R. Tolkien';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year)
SELECT 'The Hobbit', id, 'Fantasy', 341,
       str_to_date('2011', '%Y'), str_to_date('1937', '%Y') FROM author WHERE name = 'J. R. R. Tolkien';

-- Stephen King books
INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year)
SELECT 'Mr. Mercedes', id, 'Thriller', 557,
       str_to_date('2023', '%Y'), str_to_date('2014', '%Y') FROM author WHERE name = 'Stephen King';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year)
SELECT 'Finders Keepers', id, 'Crime', 385,
       str_to_date('2016', '%Y'), str_to_date('2015', '%Y') FROM author WHERE name = 'Stephen King';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year)
SELECT 'Mr. Mercedes', id, 'Crime', 368,
       str_to_date('2017', '%Y'), str_to_date('2016', '%Y') FROM author WHERE name = 'Stephen King';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year)
SELECT 'Misery', id, 'Thriller', 464,
       str_to_date('2021', '%Y'), str_to_date('1987', '%Y') FROM author WHERE name = 'Stephen King';

INSERT INTO book(title, author_id, genre, num_of_pages, publication_year, first_publication_year)
SELECT 'The Green Mile', id, 'Fantasy', 506,
       str_to_date('2021', '%Y'), str_to_date('1996', '%Y') FROM author WHERE name = 'Stephen King';


INSERT INTO item(book_id, is_available, condition)
SELECT book.id, a1(is_available), a2.condition
FROM book
CROSS JOIN (VALUES (TRUE)) as a1(is_available)
CROSS JOIN (VALUES ("mint"), ("good"), ("poor")) as a1(condition)

-- Update values at random?
-- UPDATE item
-- SET condition = "good"
-- FROM