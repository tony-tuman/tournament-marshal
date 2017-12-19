-- TODO: Need to use Flyway for database migrations

CREATE TABLE IF NOT EXISTS users (
  key INTEGER PRIMARY KEY,
  userName VARCHAR(50),
  fullName VARCHAR(255),
  password VARCHAR(50),
  email VARCHAR(50),
  emailVerified BOOLEAN,
  roles VARCHAR(100),
  mailingAddress INTEGER
);

CREATE TABLE IF NOT EXISTS postalAddresses (
  key INTEGER PRIMARY KEY,
  addressLine1 VARCHAR(255),
  addressLine2 VARCHAR(255),
  city VARCHAR(255),
  state VARCHAR(255),
  postalCode VARCHAR(255),
  country VARCHAR(255)
);