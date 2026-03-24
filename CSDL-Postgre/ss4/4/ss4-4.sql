--
-- PostgreSQL database dump
--

\restrict rJyNCB2w4NO1rB1ip533WkdcrlaAVmZ6n0asmMyYsda9Gw2j6IqakG9vcc27ehc

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
-- Name: productsch; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA productsch;


ALTER SCHEMA productsch OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: products; Type: TABLE; Schema: productsch; Owner: postgres
--

CREATE TABLE productsch.products (
    id integer NOT NULL,
    name character varying(255),
    category character varying(100),
    price numeric(18,2),
    stock integer,
    manufacturer character varying(100)
);


ALTER TABLE productsch.products OWNER TO postgres;

--
-- Data for Name: products; Type: TABLE DATA; Schema: productsch; Owner: postgres
--

COPY productsch.products (id, name, category, price, stock, manufacturer) FROM stdin;
1	Laptop Dell XPS 13	Laptop	25000000.00	12	Dell
2	Chuột Logitech M90	Phụ kiện	150000.00	50	Logitech
6	Laptop Dell XPS 13	Laptop	25000000.00	12	Dell
8	Chuột không dây Logitech M170	Phụ kiện	300000.00	20	Logitech
4	Macbook Air M2	Laptop	35200000.00	7	Apple
5	iPhone 14 Pro Max	Điện thoại	38500000.00	15	Apple
7	Tai nghe AirPods 3	Phụ kiện	4950000.00	\N	Apple
\.


--
-- Name: products products_pkey; Type: CONSTRAINT; Schema: productsch; Owner: postgres
--

ALTER TABLE ONLY productsch.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

\unrestrict rJyNCB2w4NO1rB1ip533WkdcrlaAVmZ6n0asmMyYsda9Gw2j6IqakG9vcc27ehc

