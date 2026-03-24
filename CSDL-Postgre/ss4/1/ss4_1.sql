--
-- PostgreSQL database dump
--

\restrict fTlyjkZIxmXa9MZ4veiLshZ7OHvA9gfV5VlrqGDvmmv9kt9aG2YLOYRWdat5H3X

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
-- Name: students; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA students;


ALTER SCHEMA students OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: student; Type: TABLE; Schema: students; Owner: postgres
--

CREATE TABLE students.student (
    id integer NOT NULL,
    name character varying(50),
    age integer,
    major character varying(50),
    gpa numeric(3,2)
);


ALTER TABLE students.student OWNER TO postgres;

--
-- Name: student_id_seq; Type: SEQUENCE; Schema: students; Owner: postgres
--

CREATE SEQUENCE students.student_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE students.student_id_seq OWNER TO postgres;

--
-- Name: student_id_seq; Type: SEQUENCE OWNED BY; Schema: students; Owner: postgres
--

ALTER SEQUENCE students.student_id_seq OWNED BY students.student.id;


--
-- Name: student id; Type: DEFAULT; Schema: students; Owner: postgres
--

ALTER TABLE ONLY students.student ALTER COLUMN id SET DEFAULT nextval('students.student_id_seq'::regclass);


--
-- Data for Name: student; Type: TABLE DATA; Schema: students; Owner: postgres
--

COPY students.student (id, name, age, major, gpa) FROM stdin;
1	An	20	CNTT	3.50
3	Cuong	22	CNTT	3.80
4	Duong	20	Vat ly	3.00
6	Hung	23	Hoa hoc	3.40
2	Binh	21	Toan	3.60
\.


--
-- Name: student_id_seq; Type: SEQUENCE SET; Schema: students; Owner: postgres
--

SELECT pg_catalog.setval('students.student_id_seq', 1, false);


--
-- Name: student student_pkey; Type: CONSTRAINT; Schema: students; Owner: postgres
--

ALTER TABLE ONLY students.student
    ADD CONSTRAINT student_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

\unrestrict fTlyjkZIxmXa9MZ4veiLshZ7OHvA9gfV5VlrqGDvmmv9kt9aG2YLOYRWdat5H3X

