CREATE TABLE "users" (
                         id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                         username VARCHAR(100),
                         email VARCHAR(100),
                         CONSTRAINT username_unique UNIQUE (username)
);

CREATE TABLE "author" (
    id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name TEXT,
    born_in DATE NOT NULL,
    died_in DATE,
    place_of_birth TEXT NOT NULL,
    place_of_death TEXT,
    portrait TEXT
);

-- Change years from date to number!
CREATE TABLE "book" (
    id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    title TEXT,
    genre VARCHAR(50),
    num_of_pages INTEGER,
--     publication_year DATE,
--     first_publication_year DATE,
    publication_year SMALLINT check ( publication_year between 0 and extract(year from current_date)),
    first_publication_year SMALLINT check ( publication_year between 0 and extract(year from current_date)),
    cover TEXT,
    author_id INTEGER,
    CONSTRAINT fk_author FOREIGN KEY(author_id) REFERENCES author(id)
);

CREATE TABLE "item" (
    id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    book_id INTEGER,
    is_available BOOLEAN,
    condition VARCHAR(50),
    CONSTRAINT fk_book FOREIGN KEY(book_id) REFERENCES book(id)
--     CONSTRAINT fk_condition FOREIGN KEY(condition_id) REFERENCES condition(id)
);

CREATE TABLE "rent_date"
(
    id          INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    start_date  DATE,
    return_date DATE,
    deadline    DATE
);

CREATE TABLE "rent" (
    id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    user_id INTEGER,
    item_id INTEGER,
    rent_date_id INTEGER,
    num_of_extensions INTEGER,
    CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES users(id),
    CONSTRAINT fk_item FOREIGN KEY(item_id) REFERENCES item(id),
    CONSTRAINT fk_rent_date_rent FOREIGN KEY(rent_date_id) REFERENCES rent_date(id),
    CONSTRAINT extension_range CHECK ( num_of_extensions BETWEEN 0 AND 3),
    CONSTRAINT user_item_date_unique UNIQUE (user_id, item_id, rent_date_id)

);
/*
*/
