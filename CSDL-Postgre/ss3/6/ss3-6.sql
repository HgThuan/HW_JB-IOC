--
-- PostgreSQL database dump
--

\restrict gBtlu9zo6GL30PU8Vn82jbv6cDNy1sarp3nodM5fvtzyawd9tQzW5UThgFaojHm

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
-- Name: library; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA library;


ALTER SCHEMA library OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: books; Type: TABLE; Schema: library; Owner: postgres
--

CREATE TABLE library.books (
    book_id integer NOT NULL,
    title character varying(255) NOT NULL,
    author character varying(155),
    published_year integer,
    available boolean DEFAULT true,
    CONSTRAINT books_published_year_check CHECK ((published_year > 0))
);


ALTER TABLE library.books OWNER TO postgres;

--
-- Name: books_book_id_seq; Type: SEQUENCE; Schema: library; Owner: postgres
--

CREATE SEQUENCE library.books_book_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE library.books_book_id_seq OWNER TO postgres;

--
-- Name: books_book_id_seq; Type: SEQUENCE OWNED BY; Schema: library; Owner: postgres
--

ALTER SEQUENCE library.books_book_id_seq OWNED BY library.books.book_id;


--
-- Name: members; Type: TABLE; Schema: library; Owner: postgres
--

CREATE TABLE library.members (
    member_id integer NOT NULL,
    name character varying(150) NOT NULL,
    email character varying(100) NOT NULL,
    join_date date DEFAULT CURRENT_DATE
);


ALTER TABLE library.members OWNER TO postgres;

--
-- Name: members_member_id_seq; Type: SEQUENCE; Schema: library; Owner: postgres
--

CREATE SEQUENCE library.members_member_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE library.members_member_id_seq OWNER TO postgres;

--
-- Name: members_member_id_seq; Type: SEQUENCE OWNED BY; Schema: library; Owner: postgres
--

ALTER SEQUENCE library.members_member_id_seq OWNED BY library.members.member_id;


--
-- Name: books book_id; Type: DEFAULT; Schema: library; Owner: postgres
--

ALTER TABLE ONLY library.books ALTER COLUMN book_id SET DEFAULT nextval('library.books_book_id_seq'::regclass);


--
-- Name: members member_id; Type: DEFAULT; Schema: library; Owner: postgres
--

ALTER TABLE ONLY library.members ALTER COLUMN member_id SET DEFAULT nextval('library.members_member_id_seq'::regclass);


--
-- Data for Name: books; Type: TABLE DATA; Schema: library; Owner: postgres
--

COPY library.books (book_id, title, author, published_year, available) FROM stdin;
\.


--
-- Data for Name: members; Type: TABLE DATA; Schema: library; Owner: postgres
--

COPY library.members (member_id, name, email, join_date) FROM stdin;
\.


--
-- Name: books_book_id_seq; Type: SEQUENCE SET; Schema: library; Owner: postgres
--

SELECT pg_catalog.setval('library.books_book_id_seq', 1, false);


--
-- Name: members_member_id_seq; Type: SEQUENCE SET; Schema: library; Owner: postgres
--

SELECT pg_catalog.setval('library.members_member_id_seq', 1, false);


--
-- Name: books books_pkey; Type: CONSTRAINT; Schema: library; Owner: postgres
--

ALTER TABLE ONLY library.books
    ADD CONSTRAINT books_pkey PRIMARY KEY (book_id);


--
-- Name: members members_email_key; Type: CONSTRAINT; Schema: library; Owner: postgres
--

ALTER TABLE ONLY library.members
    ADD CONSTRAINT members_email_key UNIQUE (email);


--
-- Name: members members_pkey; Type: CONSTRAINT; Schema: library; Owner: postgres
--

ALTER TABLE ONLY library.members
    ADD CONSTRAINT members_pkey PRIMARY KEY (member_id);


--
-- PostgreSQL database dump complete
--

\unrestrict gBtlu9zo6GL30PU8Vn82jbv6cDNy1sarp3nodM5fvtzyawd9tQzW5UThgFaojHm

