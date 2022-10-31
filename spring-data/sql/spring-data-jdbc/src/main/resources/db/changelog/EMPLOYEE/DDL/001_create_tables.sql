--liquibase formatted sql
--changeset jaisoft:create-tables

CREATE TABLE employee(
   id INT PRIMARY KEY,
   name VARCHAR(40)
);

CREATE TABLE branch(
   id INT PRIMARY KEY,
   name VARCHAR(40),
   emp_id INT,
   FOREIGN KEY(emp_id) REFERENCES employee(id) ON DELETE CASCADE
);
