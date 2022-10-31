--liquibase formatted sql
--changeset jaisoft:create-tables




CREATE TABLE ProfileEntity(
   id INT PRIMARY KEY
);


CREATE TABLE  UserEntity(
   id INT PRIMARY KEY
);

CREATE TABLE AccountAggregate(
   id INT PRIMARY KEY,
   profile_id INT,
   user_id INT,
   FOREIGN KEY(profile_id) REFERENCES ProfileEntity(id) ON DELETE CASCADE,
   FOREIGN KEY(user_id) REFERENCES UserEntity(id) ON DELETE CASCADE
   
);

