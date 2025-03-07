CREATE TABLE author (
    id BIGSERIAL PRIMARY KEY,
    biography TEXT
);

CREATE TABLE genre (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE book (
    id BIGSERIAL PRIMARY KEY,
    genre_id BIGINT NOT NULL REFERENCES genre(id) ON DELETE RESTRICT,
    year_of_publication SMALLINT NOT NULL,
    description TEXT,
    status BOOLEAN,
    rating SMALLINT NOT NULL
);

CREATE TABLE book_author (
    book_id BIGINT NOT NULL REFERENCES book(id) ON DELETE CASCADE,
    author_id BIGINT NOT NULL REFERENCES author(id) ON DELETE CASCADE,
    PRIMARY KEY (book_id, author_id)
);

CREATE INDEX idx_book_genre_id ON book(genre_id);
CREATE INDEX idx_book_author_book ON book_author(book_id);
CREATE INDEX idx_book_author_author ON book_author(author_id);