CREATE TABLE users (
  key INTEGER PRIMARY KEY,
  userName VARCHAR(50),
  firstName VARCHAR(50),
  lastName VARCHAR(50),
  password VARCHAR(50),
  email VARCHAR(50),
  emailVerified BOOLEAN,
  roles VARCHAR(100)
);