CREATE TABLE client (
  id       INTEGER GENERATED BY DEFAULT AS IDENTITY (
  START WITH 0 )        NOT NULL PRIMARY KEY,
  login    VARCHAR(200) NOT NULL,
  password VARCHAR(200) NOT NULL,
  email    VARCHAR(200) NOT NULL,
  role     VARCHAR(200) NOT NULL
);

CREATE TABLE persistent_logins (
  series    VARCHAR(64) PRIMARY KEY,
  username  VARCHAR(64) NOT NULL,
  token     VARCHAR(64) NOT NULL,
  last_used TIMESTAMP   NOT NULL
);

INSERT INTO client (login, password, email, role)
VALUES
  ('1', '$2a$10$BzDWOkEIEhRVBkImKqLb0.OBAz1.Mddhq4yGHZ2sNLgoXLEmJwQrS', 'myemail@test.com', 'ROLE_ADMIN,ROLE_USER');