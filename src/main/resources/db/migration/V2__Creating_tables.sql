-- Создание таблицы авторов
CREATE TABLE author (
    id BIGSERIAL PRIMARY KEY,
    biography TEXT
);

-- Создание таблицы жанров
CREATE TABLE genre (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Создание таблицы книг с внешним ключом на жанр
CREATE TABLE book (
    id BIGSERIAL PRIMARY KEY,
    genre_id BIGINT NOT NULL REFERENCES genre(id) ON DELETE RESTRICT,
    year_of_publication SMALLINT NOT NULL,
    description TEXT,
    status BOOLEAN,
    rating SMALLINT NOT NULL
);

-- Создание связующей таблицы для отношения многие-ко-многим между книгами и авторами
CREATE TABLE book_author (
    book_id BIGINT NOT NULL REFERENCES book(id) ON DELETE CASCADE,
    author_id BIGINT NOT NULL REFERENCES author(id) ON DELETE CASCADE,
    PRIMARY KEY (book_id, author_id)
);

-- Создание индексов для оптимизации запросов по внешним ключам
CREATE INDEX idx_book_genre_id ON book(genre_id);
CREATE INDEX idx_book_author_book ON book_author(book_id);
CREATE INDEX idx_book_author_author ON book_author(author_id);