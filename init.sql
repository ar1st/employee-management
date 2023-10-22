drop table if exists employees_attributes;
drop table if exists employees;
drop table if exists attributes;

CREATE TABLE employees (
    id serial4 NOT NULL,
    car bool NOT NULL,
    date_of_birth timestamp NULL,
    "name" varchar(255) NULL,
    x_coordinate varchar(255) NULL,
    y_coordinate varchar(255) NULL,
    CONSTRAINT employees_pkey PRIMARY KEY (id)
);

CREATE TABLE attributes (
    id serial4 NOT NULL,
    "name" varchar(255) NULL,
    value varchar(255) NULL,
    CONSTRAINT attributes_pkey PRIMARY KEY (id)
);

CREATE TABLE employees_attributes (
    user_id int4 NOT NULL,
    attribute_id int4 NOT NULL,
    CONSTRAINT employees_attributes_pkey PRIMARY KEY (user_id, attribute_id),
    CONSTRAINT employees_attributes_user_id_fkey FOREIGN KEY (user_id) REFERENCES employees(id),
    CONSTRAINT employees_attributes_attribute_id_fkey FOREIGN KEY (attribute_id) REFERENCES attributes(id)
);

INSERT INTO attributes (name, "value") VALUES ('Height', 'Tall');
INSERT INTO attributes (name, "value") VALUES ('Height', 'Short');