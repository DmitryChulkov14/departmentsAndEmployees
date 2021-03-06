-- SQL Manager Lite for PostgreSQL 5.9.1.49393
-- ---------------------------------------
-- Хост         : localhost:5433
-- База данных  : office
-- Версия       : PostgreSQL 9.5.6, compiled by Visual C++ build 1800, 64-bit



SET check_function_bodies = false;
--
-- Structure for table departments (OID = 24578) : 
--
SET search_path = public, pg_catalog;
CREATE TABLE public.departments (
    id integer DEFAULT nextval(('public.departments_id_seq'::text)::regclass) NOT NULL,
    name varchar(100)
)
WITH (oids = false);
--
-- Definition for sequence departments_id_seq (OID = 24622) : 
--
CREATE SEQUENCE public.departments_id_seq
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 2147483647
    NO MINVALUE
    CACHE 1;
--
-- Structure for table employees (OID = 24635) : 
--
CREATE TABLE public.employees (
    id integer DEFAULT nextval(('public.employees_id_seq'::text)::regclass) NOT NULL,
    department_id integer,
    name varchar(50),
    email varchar(30),
    salary integer,
    date date
)
WITH (oids = false);
--
-- Definition for sequence employees_id_seq (OID = 24647) : 
--
CREATE SEQUENCE public.employees_id_seq
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 2147483647
    NO MINVALUE
    CACHE 1;
--
-- Data for table public.departments (OID = 24578) (LIMIT 0,2)
--
INSERT INTO departments (id, name)
VALUES (1, 'Департамент №1');

INSERT INTO departments (id, name)
VALUES (2, 'Департамент №2');

--
-- Data for table public.employees (OID = 24635) (LIMIT 0,2)
--
INSERT INTO employees (id, department_id, name, email, salary, date)
VALUES (1, 1, 'Сотрудник Один', 'sort1@dep1.ua', 100, '2017-05-28');

INSERT INTO employees (id, department_id, name, email, salary, date)
VALUES (2, 1, 'Сотрудник Два', 'sotr2@dep1.ua', 200, '2017-05-27');

--
-- Definition for index departments_name_key (OID = 24620) : 
--
ALTER TABLE ONLY departments
    ADD CONSTRAINT departments_name_key
    UNIQUE (name);
--
-- Definition for index departments_pkey (OID = 24624) : 
--
ALTER TABLE ONLY departments
    ADD CONSTRAINT departments_pkey
    PRIMARY KEY (id);
--
-- Definition for index employees_email_key (OID = 24640) : 
--
ALTER TABLE ONLY employees
    ADD CONSTRAINT employees_email_key
    UNIQUE (email);
--
-- Definition for index employees_fk (OID = 24642) : 
--
ALTER TABLE ONLY employees
    ADD CONSTRAINT employees_fk
    FOREIGN KEY (department_id) REFERENCES departments(id) ON DELETE CASCADE;
--
-- Definition for index employees_pkey (OID = 24649) : 
--
ALTER TABLE ONLY employees
    ADD CONSTRAINT employees_pkey
    PRIMARY KEY (id);
--
-- Data for sequence public.departments_id_seq (OID = 24622)
--
SELECT pg_catalog.setval('departments_id_seq', 2, true);
--
-- Data for sequence public.employees_id_seq (OID = 24647)
--
SELECT pg_catalog.setval('employees_id_seq', 2, true);
--
-- Comments
--
COMMENT ON SCHEMA public IS 'standard public schema';
