--
-- PostgreSQL database dump
--

\restrict rRysuSdfyQZACjmxHz30xYaZaQ2SAKQZXopZWfFpjrhQ5x39BGN7J55lpdmYuJI

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
-- Name: sales; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA sales;


ALTER SCHEMA sales OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: customers; Type: TABLE; Schema: sales; Owner: postgres
--

CREATE TABLE sales.customers (
    customer_id integer NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    email character varying(50) NOT NULL,
    phone text
);


ALTER TABLE sales.customers OWNER TO postgres;

--
-- Name: customers_customer_id_seq; Type: SEQUENCE; Schema: sales; Owner: postgres
--

CREATE SEQUENCE sales.customers_customer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE sales.customers_customer_id_seq OWNER TO postgres;

--
-- Name: customers_customer_id_seq; Type: SEQUENCE OWNED BY; Schema: sales; Owner: postgres
--

ALTER SEQUENCE sales.customers_customer_id_seq OWNED BY sales.customers.customer_id;


--
-- Name: orderitems; Type: TABLE; Schema: sales; Owner: postgres
--

CREATE TABLE sales.orderitems (
    order_item_id integer NOT NULL,
    order_id integer,
    product_id integer,
    quantity integer,
    CONSTRAINT orderitems_quantity_check CHECK ((quantity > 1))
);


ALTER TABLE sales.orderitems OWNER TO postgres;

--
-- Name: orderitems_order_item_id_seq; Type: SEQUENCE; Schema: sales; Owner: postgres
--

CREATE SEQUENCE sales.orderitems_order_item_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE sales.orderitems_order_item_id_seq OWNER TO postgres;

--
-- Name: orderitems_order_item_id_seq; Type: SEQUENCE OWNED BY; Schema: sales; Owner: postgres
--

ALTER SEQUENCE sales.orderitems_order_item_id_seq OWNED BY sales.orderitems.order_item_id;


--
-- Name: orders; Type: TABLE; Schema: sales; Owner: postgres
--

CREATE TABLE sales.orders (
    order_id integer NOT NULL,
    customer_id integer,
    order_date date NOT NULL
);


ALTER TABLE sales.orders OWNER TO postgres;

--
-- Name: orders_order_id_seq; Type: SEQUENCE; Schema: sales; Owner: postgres
--

CREATE SEQUENCE sales.orders_order_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE sales.orders_order_id_seq OWNER TO postgres;

--
-- Name: orders_order_id_seq; Type: SEQUENCE OWNED BY; Schema: sales; Owner: postgres
--

ALTER SEQUENCE sales.orders_order_id_seq OWNED BY sales.orders.order_id;


--
-- Name: products; Type: TABLE; Schema: sales; Owner: postgres
--

CREATE TABLE sales.products (
    product_id integer NOT NULL,
    product_name character varying(100) NOT NULL,
    price numeric(5,2) NOT NULL,
    stock_quantity integer NOT NULL
);


ALTER TABLE sales.products OWNER TO postgres;

--
-- Name: products_product_id_seq; Type: SEQUENCE; Schema: sales; Owner: postgres
--

CREATE SEQUENCE sales.products_product_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE sales.products_product_id_seq OWNER TO postgres;

--
-- Name: products_product_id_seq; Type: SEQUENCE OWNED BY; Schema: sales; Owner: postgres
--

ALTER SEQUENCE sales.products_product_id_seq OWNED BY sales.products.product_id;


--
-- Name: customers customer_id; Type: DEFAULT; Schema: sales; Owner: postgres
--

ALTER TABLE ONLY sales.customers ALTER COLUMN customer_id SET DEFAULT nextval('sales.customers_customer_id_seq'::regclass);


--
-- Name: orderitems order_item_id; Type: DEFAULT; Schema: sales; Owner: postgres
--

ALTER TABLE ONLY sales.orderitems ALTER COLUMN order_item_id SET DEFAULT nextval('sales.orderitems_order_item_id_seq'::regclass);


--
-- Name: orders order_id; Type: DEFAULT; Schema: sales; Owner: postgres
--

ALTER TABLE ONLY sales.orders ALTER COLUMN order_id SET DEFAULT nextval('sales.orders_order_id_seq'::regclass);


--
-- Name: products product_id; Type: DEFAULT; Schema: sales; Owner: postgres
--

ALTER TABLE ONLY sales.products ALTER COLUMN product_id SET DEFAULT nextval('sales.products_product_id_seq'::regclass);


--
-- Data for Name: customers; Type: TABLE DATA; Schema: sales; Owner: postgres
--

COPY sales.customers (customer_id, first_name, last_name, email, phone) FROM stdin;
\.


--
-- Data for Name: orderitems; Type: TABLE DATA; Schema: sales; Owner: postgres
--

COPY sales.orderitems (order_item_id, order_id, product_id, quantity) FROM stdin;
\.


--
-- Data for Name: orders; Type: TABLE DATA; Schema: sales; Owner: postgres
--

COPY sales.orders (order_id, customer_id, order_date) FROM stdin;
\.


--
-- Data for Name: products; Type: TABLE DATA; Schema: sales; Owner: postgres
--

COPY sales.products (product_id, product_name, price, stock_quantity) FROM stdin;
\.


--
-- Name: customers_customer_id_seq; Type: SEQUENCE SET; Schema: sales; Owner: postgres
--

SELECT pg_catalog.setval('sales.customers_customer_id_seq', 1, false);


--
-- Name: orderitems_order_item_id_seq; Type: SEQUENCE SET; Schema: sales; Owner: postgres
--

SELECT pg_catalog.setval('sales.orderitems_order_item_id_seq', 1, false);


--
-- Name: orders_order_id_seq; Type: SEQUENCE SET; Schema: sales; Owner: postgres
--

SELECT pg_catalog.setval('sales.orders_order_id_seq', 1, false);


--
-- Name: products_product_id_seq; Type: SEQUENCE SET; Schema: sales; Owner: postgres
--

SELECT pg_catalog.setval('sales.products_product_id_seq', 1, false);


--
-- Name: customers customers_email_key; Type: CONSTRAINT; Schema: sales; Owner: postgres
--

ALTER TABLE ONLY sales.customers
    ADD CONSTRAINT customers_email_key UNIQUE (email);


--
-- Name: customers customers_pkey; Type: CONSTRAINT; Schema: sales; Owner: postgres
--

ALTER TABLE ONLY sales.customers
    ADD CONSTRAINT customers_pkey PRIMARY KEY (customer_id);


--
-- Name: orderitems orderitems_pkey; Type: CONSTRAINT; Schema: sales; Owner: postgres
--

ALTER TABLE ONLY sales.orderitems
    ADD CONSTRAINT orderitems_pkey PRIMARY KEY (order_item_id);


--
-- Name: orders orders_pkey; Type: CONSTRAINT; Schema: sales; Owner: postgres
--

ALTER TABLE ONLY sales.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (order_id);


--
-- Name: products products_pkey; Type: CONSTRAINT; Schema: sales; Owner: postgres
--

ALTER TABLE ONLY sales.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (product_id);


--
-- Name: orderitems orderitems_order_id_fkey; Type: FK CONSTRAINT; Schema: sales; Owner: postgres
--

ALTER TABLE ONLY sales.orderitems
    ADD CONSTRAINT orderitems_order_id_fkey FOREIGN KEY (order_id) REFERENCES sales.orders(order_id);


--
-- Name: orderitems orderitems_product_id_fkey; Type: FK CONSTRAINT; Schema: sales; Owner: postgres
--

ALTER TABLE ONLY sales.orderitems
    ADD CONSTRAINT orderitems_product_id_fkey FOREIGN KEY (product_id) REFERENCES sales.products(product_id);


--
-- Name: orders orders_customer_id_fkey; Type: FK CONSTRAINT; Schema: sales; Owner: postgres
--

ALTER TABLE ONLY sales.orders
    ADD CONSTRAINT orders_customer_id_fkey FOREIGN KEY (customer_id) REFERENCES sales.customers(customer_id);


--
-- PostgreSQL database dump complete
--

\unrestrict rRysuSdfyQZACjmxHz30xYaZaQ2SAKQZXopZWfFpjrhQ5x39BGN7J55lpdmYuJI

