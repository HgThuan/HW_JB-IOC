--
-- PostgreSQL database dump
--

\restrict BfU4fuBkHEs8LnBntJ0f0hiRNAe0XgYCIvHxHjTQswAWmo6xDA3D9saFdyaUFDt

-- Dumped from database version 18.1 (Postgres.app)
-- Dumped by pg_dump version 18.1 (Postgres.app)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: employees; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA employees;


ALTER SCHEMA employees OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: employees; Type: TABLE; Schema: employees; Owner: postgres
--

CREATE TABLE employees.employees (
    id integer NOT NULL,
    full_name character varying(255),
    department character varying(100),
    "position" character varying(100),
    salary numeric(18,2),
    bonus numeric(18,2),
    join_year integer
);


ALTER TABLE employees.employees OWNER TO postgres;

--
-- Data for Name: employees; Type: TABLE DATA; Schema: employees; Owner: postgres
--

COPY employees.employees (id, full_name, department, "position", salary, bonus, join_year) FROM stdin;
1	Nguyễn Văn Huy	IT	Developer	18000000.00	1000000.00	2021
4	Nguyễn Văn Huy	IT	Developer	18000000.00	1000000.00	2021
6	Bùi Thị Lan	HR	HR Manager	20000000.00	3000000.00	2018
3	Lê Quốc Trung	IT	Tester	16500000.00	800000.00	2023
2	Trần Thị Mai	HR	Recruiter	13200000.00	500000.00	2020
5	Phạm Ngọc Hân	Finance	Accountant	15400000.00	500000.00	2019
7	Đặng Hữu Tài	IT	Developer	18700000.00	500000.00	2022
\.


--
-- Name: employees employees_pkey; Type: CONSTRAINT; Schema: employees; Owner: postgres
--

ALTER TABLE ONLY employees.employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

\unrestrict BfU4fuBkHEs8LnBntJ0f0hiRNAe0XgYCIvHxHjTQswAWmo6xDA3D9saFdyaUFDt

