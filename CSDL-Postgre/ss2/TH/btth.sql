--
-- PostgreSQL database dump
--

\restrict MaqiiGQ6PJesaXIXfrpyeexkWgk4DPsfnl3qPSfCzlwsYPjliyFDsXkye1FeYp1

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
-- Name: authors; Type: TABLE; Schema: library; Owner: postgres
--

CREATE TABLE library.authors (
    author_id integer NOT NULL,
    author_name character varying(150) NOT NULL,
    bio text
);


ALTER TABLE library.authors OWNER TO postgres;

--
-- Name: authors_author_id_seq; Type: SEQUENCE; Schema: library; Owner: postgres
--

CREATE SEQUENCE library.authors_author_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE library.authors_author_id_seq OWNER TO postgres;

--
-- Name: authors_author_id_seq; Type: SEQUENCE OWNED BY; Schema: library; Owner: postgres
--

ALTER SEQUENCE library.authors_author_id_seq OWNED BY library.authors.author_id;


--
-- Name: book_authors; Type: TABLE; Schema: library; Owner: postgres
--

CREATE TABLE library.book_authors (
    book_id integer NOT NULL,
    author_id integer NOT NULL
);


ALTER TABLE library.book_authors OWNER TO postgres;

--
-- Name: books; Type: TABLE; Schema: library; Owner: postgres
--

CREATE TABLE library.books (
    book_id integer NOT NULL,
    isbn character varying(20) NOT NULL,
    title character varying(250) NOT NULL,
    publish_year integer,
    publisher character varying(150),
    total_copies integer DEFAULT 1,
    available_copies integer DEFAULT 1,
    category_id integer,
    CONSTRAINT books_check CHECK ((available_copies <= total_copies)),
    CONSTRAINT books_publish_year_check CHECK (((publish_year)::numeric <= EXTRACT(year FROM CURRENT_DATE))),
    CONSTRAINT books_total_copies_check CHECK ((total_copies >= 0))
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
-- Name: categories; Type: TABLE; Schema: library; Owner: postgres
--

CREATE TABLE library.categories (
    category_id integer NOT NULL,
    category_name character varying(100) NOT NULL,
    description text
);


ALTER TABLE library.categories OWNER TO postgres;

--
-- Name: categories_category_id_seq; Type: SEQUENCE; Schema: library; Owner: postgres
--

CREATE SEQUENCE library.categories_category_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE library.categories_category_id_seq OWNER TO postgres;

--
-- Name: categories_category_id_seq; Type: SEQUENCE OWNED BY; Schema: library; Owner: postgres
--

ALTER SEQUENCE library.categories_category_id_seq OWNED BY library.categories.category_id;


--
-- Name: loans; Type: TABLE; Schema: library; Owner: postgres
--

CREATE TABLE library.loans (
    loan_id integer NOT NULL,
    member_id integer,
    book_id integer,
    loan_date date DEFAULT CURRENT_DATE,
    due_date date NOT NULL,
    return_date date,
    CONSTRAINT check_dates CHECK (((due_date >= loan_date) AND ((return_date IS NULL) OR (return_date >= loan_date))))
);


ALTER TABLE library.loans OWNER TO postgres;

--
-- Name: loans_loan_id_seq; Type: SEQUENCE; Schema: library; Owner: postgres
--

CREATE SEQUENCE library.loans_loan_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE library.loans_loan_id_seq OWNER TO postgres;

--
-- Name: loans_loan_id_seq; Type: SEQUENCE OWNED BY; Schema: library; Owner: postgres
--

ALTER SEQUENCE library.loans_loan_id_seq OWNED BY library.loans.loan_id;


--
-- Name: members; Type: TABLE; Schema: library; Owner: postgres
--

CREATE TABLE library.members (
    member_id integer NOT NULL,
    full_name character varying(150) NOT NULL,
    email character varying(100) NOT NULL,
    phone character varying(20),
    date_of_birth date,
    address text,
    membership_status character varying(20) DEFAULT 'active'::character varying,
    registration_date date DEFAULT CURRENT_DATE,
    CONSTRAINT members_membership_status_check CHECK (((membership_status)::text = ANY ((ARRAY['active'::character varying, 'inactive'::character varying])::text[])))
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
-- Name: authors author_id; Type: DEFAULT; Schema: library; Owner: postgres
--

ALTER TABLE ONLY library.authors ALTER COLUMN author_id SET DEFAULT nextval('library.authors_author_id_seq'::regclass);


--
-- Name: books book_id; Type: DEFAULT; Schema: library; Owner: postgres
--

ALTER TABLE ONLY library.books ALTER COLUMN book_id SET DEFAULT nextval('library.books_book_id_seq'::regclass);


--
-- Name: categories category_id; Type: DEFAULT; Schema: library; Owner: postgres
--

ALTER TABLE ONLY library.categories ALTER COLUMN category_id SET DEFAULT nextval('library.categories_category_id_seq'::regclass);


--
-- Name: loans loan_id; Type: DEFAULT; Schema: library; Owner: postgres
--

ALTER TABLE ONLY library.loans ALTER COLUMN loan_id SET DEFAULT nextval('library.loans_loan_id_seq'::regclass);


--
-- Name: members member_id; Type: DEFAULT; Schema: library; Owner: postgres
--

ALTER TABLE ONLY library.members ALTER COLUMN member_id SET DEFAULT nextval('library.members_member_id_seq'::regclass);


--
-- Data for Name: authors; Type: TABLE DATA; Schema: library; Owner: postgres
--

COPY library.authors (author_id, author_name, bio) FROM stdin;
1	Robert C. Martin	Tác giả của cuốn Clean Code nổi tiếng
2	Abraham Silberschatz	Chuyên gia về hệ điều hành và cơ sở dữ liệu
3	Dale Carnegie	Tác giả cuốn Đắc Nhân Tâm
\.


--
-- Data for Name: book_authors; Type: TABLE DATA; Schema: library; Owner: postgres
--

COPY library.book_authors (book_id, author_id) FROM stdin;
\.


--
-- Data for Name: books; Type: TABLE DATA; Schema: library; Owner: postgres
--

COPY library.books (book_id, isbn, title, publish_year, publisher, total_copies, available_copies, category_id) FROM stdin;
1	978-0132350884	Clean Code	2008	Prentice Hall	5	5	1
2	978-0073523323	Database System Concepts	2010	McGraw-Hill	3	2	2
3	978-0671027032	How to Win Friends and Influence People	1936	Simon & Schuster	10	10	3
\.


--
-- Data for Name: categories; Type: TABLE DATA; Schema: library; Owner: postgres
--

COPY library.categories (category_id, category_name, description) FROM stdin;
1	Lập trình	Các sách về ngôn ngữ lập trình và phát triển phần mềm
2	Cơ sở dữ liệu	Sách về SQL, NoSQL và thiết kế hệ thống
3	Kỹ năng mềm	Sách về giao tiếp, quản lý thời gian và tư duy
\.


--
-- Data for Name: loans; Type: TABLE DATA; Schema: library; Owner: postgres
--

COPY library.loans (loan_id, member_id, book_id, loan_date, due_date, return_date) FROM stdin;
\.


--
-- Data for Name: members; Type: TABLE DATA; Schema: library; Owner: postgres
--

COPY library.members (member_id, full_name, email, phone, date_of_birth, address, membership_status, registration_date) FROM stdin;
1	Nguyễn Văn A	anguyen@email.com	0901234567	1995-05-20	Hà Nội	active	2026-03-21
2	Trần Thị B	btran@email.com	0912345678	1998-10-15	TP.HCM	active	2026-03-21
3	Lê Văn C	cle@email.com	0988776655	2000-01-01	Đà Nẵng	active	2026-03-21
\.


--
-- Name: authors_author_id_seq; Type: SEQUENCE SET; Schema: library; Owner: postgres
--

SELECT pg_catalog.setval('library.authors_author_id_seq', 3, true);


--
-- Name: books_book_id_seq; Type: SEQUENCE SET; Schema: library; Owner: postgres
--

SELECT pg_catalog.setval('library.books_book_id_seq', 3, true);


--
-- Name: categories_category_id_seq; Type: SEQUENCE SET; Schema: library; Owner: postgres
--

SELECT pg_catalog.setval('library.categories_category_id_seq', 3, true);


--
-- Name: loans_loan_id_seq; Type: SEQUENCE SET; Schema: library; Owner: postgres
--

SELECT pg_catalog.setval('library.loans_loan_id_seq', 1, false);


--
-- Name: members_member_id_seq; Type: SEQUENCE SET; Schema: library; Owner: postgres
--

SELECT pg_catalog.setval('library.members_member_id_seq', 3, true);


--
-- Name: authors authors_pkey; Type: CONSTRAINT; Schema: library; Owner: postgres
--

ALTER TABLE ONLY library.authors
    ADD CONSTRAINT authors_pkey PRIMARY KEY (author_id);


--
-- Name: book_authors book_authors_pkey; Type: CONSTRAINT; Schema: library; Owner: postgres
--

ALTER TABLE ONLY library.book_authors
    ADD CONSTRAINT book_authors_pkey PRIMARY KEY (book_id, author_id);


--
-- Name: books books_isbn_key; Type: CONSTRAINT; Schema: library; Owner: postgres
--

ALTER TABLE ONLY library.books
    ADD CONSTRAINT books_isbn_key UNIQUE (isbn);


--
-- Name: books books_pkey; Type: CONSTRAINT; Schema: library; Owner: postgres
--

ALTER TABLE ONLY library.books
    ADD CONSTRAINT books_pkey PRIMARY KEY (book_id);


--
-- Name: categories categories_category_name_key; Type: CONSTRAINT; Schema: library; Owner: postgres
--

ALTER TABLE ONLY library.categories
    ADD CONSTRAINT categories_category_name_key UNIQUE (category_name);


--
-- Name: categories categories_pkey; Type: CONSTRAINT; Schema: library; Owner: postgres
--

ALTER TABLE ONLY library.categories
    ADD CONSTRAINT categories_pkey PRIMARY KEY (category_id);


--
-- Name: loans loans_pkey; Type: CONSTRAINT; Schema: library; Owner: postgres
--

ALTER TABLE ONLY library.loans
    ADD CONSTRAINT loans_pkey PRIMARY KEY (loan_id);


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
-- Name: book_authors book_authors_author_id_fkey; Type: FK CONSTRAINT; Schema: library; Owner: postgres
--

ALTER TABLE ONLY library.book_authors
    ADD CONSTRAINT book_authors_author_id_fkey FOREIGN KEY (author_id) REFERENCES library.authors(author_id) ON DELETE CASCADE;


--
-- Name: book_authors book_authors_book_id_fkey; Type: FK CONSTRAINT; Schema: library; Owner: postgres
--

ALTER TABLE ONLY library.book_authors
    ADD CONSTRAINT book_authors_book_id_fkey FOREIGN KEY (book_id) REFERENCES library.books(book_id) ON DELETE CASCADE;


--
-- Name: books books_category_id_fkey; Type: FK CONSTRAINT; Schema: library; Owner: postgres
--

ALTER TABLE ONLY library.books
    ADD CONSTRAINT books_category_id_fkey FOREIGN KEY (category_id) REFERENCES library.categories(category_id) ON DELETE SET NULL;


--
-- Name: loans loans_book_id_fkey; Type: FK CONSTRAINT; Schema: library; Owner: postgres
--

ALTER TABLE ONLY library.loans
    ADD CONSTRAINT loans_book_id_fkey FOREIGN KEY (book_id) REFERENCES library.books(book_id) ON DELETE CASCADE;


--
-- Name: loans loans_member_id_fkey; Type: FK CONSTRAINT; Schema: library; Owner: postgres
--

ALTER TABLE ONLY library.loans
    ADD CONSTRAINT loans_member_id_fkey FOREIGN KEY (member_id) REFERENCES library.members(member_id) ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

\unrestrict MaqiiGQ6PJesaXIXfrpyeexkWgk4DPsfnl3qPSfCzlwsYPjliyFDsXkye1FeYp1

