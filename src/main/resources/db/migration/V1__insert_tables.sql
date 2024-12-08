CREATE TABLE "users" (
                         id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                         username VARCHAR(100),
                         email VARCHAR(100),
                         CONSTRAINT username_unique UNIQUE (username)
);
--
-- CREATE TABLE "condition" (
--                              id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
--                              condition_type VARCHAR(50)
-- );
--
-- CREATE TABLE "genre" (
--                          id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
--                          name VARCHAR(50)
-- );

CREATE TABLE "author" (
    id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name TEXT,
    born_in DATE NOT NULL,
    died_in DATE,
    place_of_birth TEXT NOT NULL,
    place_of_death TEXT
--     CONSTRAINT birth_comes_first constraint here

);

CREATE TABLE "book" (
    id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    title TEXT,
    genre TEXT,
    num_of_pages INTEGER UNSIGNED,
    publication_year DATE,
    first_publication_year DATE,
    cover TEXT,
    author_id INTEGER,
    CONSTRAINT fk_author FOREIGN KEY(author_id) REFERENCES author(id),
--     CONSTRAINT fk_genre FOREIGN KEY(genre_id) REFERENCES genre(id)

);

CREATE TABLE "item" (
    id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    book_id INTEGER,
    is_available BOOLEAN,
--     is_rentable BOOLEAN,
    condition text,
--     condition_id INTEGER, -- will use Enums for this data
    CONSTRAINT fk_book FOREIGN KEY(book_id) REFERENCES book(id),
--     CONSTRAINT fk_condition FOREIGN KEY(condition_id) REFERENCES condition(id)
);

CREATE TABLE "rent" (
    id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    user_id INTEGER,
    item_id INTEGER,
    start_date DATE,
    return_date DATE,
    num_of_extensions INTEGER UNSIGNED,
--     return_date_extended DATE,
    CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES users(id),
    CONSTRAINT fk_item FOREIGN KEY(item_id) REFERENCES item(id),
    CONSTRAINT extension_range CHECK ( num_of_extensions BETWEEN 0 AND 3)
);