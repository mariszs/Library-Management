DROP DATABASE IF EXISTS libraryManagerApp;
CREATE DATABASE IF NOT EXISTS libraryManagerApp;

USE libraryManagerApp;

CREATE TABLE IF NOT EXISTS books(
    bookId INT AUTO_INCREMENT NOT NULL,
    bookName VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
    publishingYear INT NOT NULL,
    department VARCHAR(100) NOT NULL,
    PRIMARY KEY(bookId)
);

CREATE TABLE IF NOT EXISTS clients(
    clientId INT AUTO_INCREMENT NOT NULL,
    clientName VARCHAR(100) NOT NULL,
    email VARCHAR(250) NOT NULL,
    phone INT NOT NULL,
    minusPoints INT DEFAULT 0,
    isBlocked SMALLINT DEFAULT 0,
    booksBorrowed INT DEFAULT 0,
    PRIMARY KEY(clientId)
);

CREATE TABLE IF NOT EXISTS booking(
    bookingId INT AUTO_INCREMENT NOT NULL,
    clientId INT,
    bookId INT,
    bookingDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    returnDate DATE NOT NULL,
    PRIMARY KEY(bookingId),

    FOREIGN KEY(clientId) REFERENCES clients(clientId),
    FOREIGN KEY(bookId) REFERENCES books(bookId)
);

INSERT INTO books (bookName, author, publishingYear, department) VALUES
("Mowgly", "R.Kipling", 1895, "children"),
("Head first: Java", "K.Sierra, B.Bates and T.Gee", 2022, "non-fiction"),
("The Da Vinci Code", "D.Brown", 2003, "fiction");

INSERT INTO clients (clientName, email, phone) VALUES
("Mary", "mary@gmail.com", 55123456);

SELECT * FROM clients; 
SELECT * FROM books; 

USE libraryManagerApp;
DELETE FROM clients; 
ALTER TABLE clients DROP COLUMN booksBorrowed;
ALTER TABLE clients DROP COLUMN isBlocked;
ALTER TABLE clients DROP COLUMN minusPoints;
