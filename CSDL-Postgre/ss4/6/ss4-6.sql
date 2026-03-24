--
-- PostgreSQL database dump
--

\restrict oSXAueEYuxgGIfUudOUWbFWe9eHE8GxQgxYwj5K5WR1AmLJ1apoaZuXXNfLU7iZ

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
-- Name: books; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA books;


ALTER SCHEMA books OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: books; Type: TABLE; Schema: books; Owner: postgres
--

CREATE TABLE books.books (
    id integer NOT NULL,
    title character varying(255),
    author character varying(100),
    category character varying(50),
    publish_year integer,
    price numeric(18,2),
    stock integer
);


ALTER TABLE books.books OWNER TO postgres;

--
-- Data for Name: books; Type: TABLE DATA; Schema: books; Owner: postgres
--

COPY books.books (id, title, author, category, publish_year, price, stock) FROM stdin;
1	Lập trình C cơ bản	Nguyễn Văn Nam	CNTT	2018	95000.00	20
2	Học SQL qua ví dụ	Trần Thị Hạnh	CSDL	2020	125000.00	12
3	Lập trình C cơ bản	Nguyễn Văn Nam	CNTT	2018	95000.00	20
6	Học máy cho người mới bắt đầu	Nguyễn Văn Nam	AI	2023	220000.00	8
5	Quản trị cơ sở dữ liệu	Nguyễn Thị Minh	CSDL	2021	165000.00	5
7	Khoa học dữ liệu cơ bản	Nguyễn Văn Nam	AI	2023	220000.00	0
4	Phân tích dữ liệu với Python	Lê Quốc Bảo	CNTT	2022	198000.00	0
\.


--
-- Name: books books_pkey; Type: CONSTRAINT; Schema: books; Owner: postgres
--

ALTER TABLE ONLY books.books
    ADD CONSTRAINT books_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

\unrestrict oSXAueEYuxgGIfUudOUWbFWe9eHE8GxQgxYwj5K5WR1AmLJ1apoaZuXXNfLU7iZ

