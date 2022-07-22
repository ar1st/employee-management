-- public."attributes" definition

-- Drop table

-- DROP TABLE public."attributes";

CREATE TABLE public."attributes"
(
    id     serial4 NOT NULL,
    "name" varchar(50) NOT NULL,
    value  varchar(50) NOT NULL,
    CONSTRAINT attributes_pkey PRIMARY KEY (id)
);


-- public.employees definition

-- Drop table

-- DROP TABLE public.employees;

CREATE TABLE public.employees
(
    id            serial4 NOT NULL,
    car           bool    NOT NULL,
    date_of_birth timestamp NULL,
    "name"        varchar(50) NULL,
    x_coordinate  varchar(50) NULL,
    y_coordinate  varchar(50) NULL,
    CONSTRAINT employees_pkey PRIMARY KEY (id)
);


-- public.employees_attributes definition

-- Drop table

-- DROP TABLE public.employees_attributes;

CREATE TABLE public.employees_attributes
(
    user_id      int4 NOT NULL,
    attribute_id int4 NOT NULL,
    CONSTRAINT employees_attributes_pkey PRIMARY KEY (user_id, attribute_id),
    CONSTRAINT employees_attributes_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.employees (id),
    CONSTRAINT employees_attributes_attribute_id_fkey FOREIGN KEY (attribute_id) REFERENCES public."attributes" (id)
);