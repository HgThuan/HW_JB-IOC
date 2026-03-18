--
-- PostgreSQL database dump
--

\restrict B3RVYfFmAmdousXcLHjAkdilKVjJBiZfWCz66JnqFRsHleRcoUMlC9HAjrc0DYJ

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
-- Name: shop; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA shop;


ALTER SCHEMA shop OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: categories; Type: TABLE; Schema: shop; Owner: postgres
--

CREATE TABLE shop.categories (
    category_id integer NOT NULL,
    category_name character varying(100) NOT NULL
);


ALTER TABLE shop.categories OWNER TO postgres;

--
-- Name: categories_category_id_seq; Type: SEQUENCE; Schema: shop; Owner: postgres
--

CREATE SEQUENCE shop.categories_category_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE shop.categories_category_id_seq OWNER TO postgres;

--
-- Name: categories_category_id_seq; Type: SEQUENCE OWNED BY; Schema: shop; Owner: postgres
--

ALTER SEQUENCE shop.categories_category_id_seq OWNED BY shop.categories.category_id;


--
-- Name: orderdetails; Type: TABLE; Schema: shop; Owner: postgres
--

CREATE TABLE shop.orderdetails (
    order_detail_id integer NOT NULL,
    order_id integer,
    product_id integer,
    quantity integer,
    price_each numeric(10,2),
    CONSTRAINT orderdetails_price_each_check CHECK ((price_each > (0)::numeric)),
    CONSTRAINT orderdetails_quantity_check CHECK ((quantity > 0))
);


ALTER TABLE shop.orderdetails OWNER TO postgres;

--
-- Name: orderdetails_order_detail_id_seq; Type: SEQUENCE; Schema: shop; Owner: postgres
--

CREATE SEQUENCE shop.orderdetails_order_detail_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE shop.orderdetails_order_detail_id_seq OWNER TO postgres;

--
-- Name: orderdetails_order_detail_id_seq; Type: SEQUENCE OWNED BY; Schema: shop; Owner: postgres
--

ALTER SEQUENCE shop.orderdetails_order_detail_id_seq OWNED BY shop.orderdetails.order_detail_id;


--
-- Name: orders; Type: TABLE; Schema: shop; Owner: postgres
--

CREATE TABLE shop.orders (
    order_id integer NOT NULL,
    user_id integer,
    order_date date NOT NULL,
    status character varying(20),
    CONSTRAINT orders_status_check CHECK (((status)::text = ANY ((ARRAY['Pending'::character varying, 'Shipped'::character varying, 'Delivered'::character varying, 'Cancelled'::character varying])::text[])))
);


ALTER TABLE shop.orders OWNER TO postgres;

--
-- Name: orders_order_id_seq; Type: SEQUENCE; Schema: shop; Owner: postgres
--

CREATE SEQUENCE shop.orders_order_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE shop.orders_order_id_seq OWNER TO postgres;

--
-- Name: orders_order_id_seq; Type: SEQUENCE OWNED BY; Schema: shop; Owner: postgres
--

ALTER SEQUENCE shop.orders_order_id_seq OWNED BY shop.orders.order_id;


--
-- Name: payments; Type: TABLE; Schema: shop; Owner: postgres
--

CREATE TABLE shop.payments (
    payment_id integer NOT NULL,
    order_id integer,
    amount numeric(10,2),
    payment_date date NOT NULL,
    method character varying(30),
    CONSTRAINT payments_amount_check CHECK ((amount >= (0)::numeric)),
    CONSTRAINT payments_method_check CHECK (((method)::text = ANY ((ARRAY['Credit Card'::character varying, 'Momo'::character varying, 'Bank Transfer'::character varying, 'Cash'::character varying])::text[])))
);


ALTER TABLE shop.payments OWNER TO postgres;

--
-- Name: payments_payment_id_seq; Type: SEQUENCE; Schema: shop; Owner: postgres
--

CREATE SEQUENCE shop.payments_payment_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE shop.payments_payment_id_seq OWNER TO postgres;

--
-- Name: payments_payment_id_seq; Type: SEQUENCE OWNED BY; Schema: shop; Owner: postgres
--

ALTER SEQUENCE shop.payments_payment_id_seq OWNED BY shop.payments.payment_id;


--
-- Name: products; Type: TABLE; Schema: shop; Owner: postgres
--

CREATE TABLE shop.products (
    product_id integer NOT NULL,
    product_name character varying(100) NOT NULL,
    price numeric(10,2),
    stock integer,
    category_id integer,
    CONSTRAINT products_price_check CHECK ((price > (0)::numeric)),
    CONSTRAINT products_stock_check CHECK ((stock >= 0))
);


ALTER TABLE shop.products OWNER TO postgres;

--
-- Name: products_product_id_seq; Type: SEQUENCE; Schema: shop; Owner: postgres
--

CREATE SEQUENCE shop.products_product_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE shop.products_product_id_seq OWNER TO postgres;

--
-- Name: products_product_id_seq; Type: SEQUENCE OWNED BY; Schema: shop; Owner: postgres
--

ALTER SEQUENCE shop.products_product_id_seq OWNED BY shop.products.product_id;


--
-- Name: users; Type: TABLE; Schema: shop; Owner: postgres
--

CREATE TABLE shop.users (
    user_id integer NOT NULL,
    username character varying(50) NOT NULL,
    email character varying(100) NOT NULL,
    password character varying(100) NOT NULL,
    role character varying(20),
    CONSTRAINT users_role_check CHECK (((role)::text = ANY ((ARRAY['Customer'::character varying, 'Admin'::character varying])::text[])))
);


ALTER TABLE shop.users OWNER TO postgres;

--
-- Name: users_user_id_seq; Type: SEQUENCE; Schema: shop; Owner: postgres
--

CREATE SEQUENCE shop.users_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE shop.users_user_id_seq OWNER TO postgres;

--
-- Name: users_user_id_seq; Type: SEQUENCE OWNED BY; Schema: shop; Owner: postgres
--

ALTER SEQUENCE shop.users_user_id_seq OWNED BY shop.users.user_id;


--
-- Name: categories category_id; Type: DEFAULT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.categories ALTER COLUMN category_id SET DEFAULT nextval('shop.categories_category_id_seq'::regclass);


--
-- Name: orderdetails order_detail_id; Type: DEFAULT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.orderdetails ALTER COLUMN order_detail_id SET DEFAULT nextval('shop.orderdetails_order_detail_id_seq'::regclass);


--
-- Name: orders order_id; Type: DEFAULT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.orders ALTER COLUMN order_id SET DEFAULT nextval('shop.orders_order_id_seq'::regclass);


--
-- Name: payments payment_id; Type: DEFAULT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.payments ALTER COLUMN payment_id SET DEFAULT nextval('shop.payments_payment_id_seq'::regclass);


--
-- Name: products product_id; Type: DEFAULT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.products ALTER COLUMN product_id SET DEFAULT nextval('shop.products_product_id_seq'::regclass);


--
-- Name: users user_id; Type: DEFAULT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.users ALTER COLUMN user_id SET DEFAULT nextval('shop.users_user_id_seq'::regclass);


--
-- Data for Name: categories; Type: TABLE DATA; Schema: shop; Owner: postgres
--

COPY shop.categories (category_id, category_name) FROM stdin;
\.


--
-- Data for Name: orderdetails; Type: TABLE DATA; Schema: shop; Owner: postgres
--

COPY shop.orderdetails (order_detail_id, order_id, product_id, quantity, price_each) FROM stdin;
\.


--
-- Data for Name: orders; Type: TABLE DATA; Schema: shop; Owner: postgres
--

COPY shop.orders (order_id, user_id, order_date, status) FROM stdin;
\.


--
-- Data for Name: payments; Type: TABLE DATA; Schema: shop; Owner: postgres
--

COPY shop.payments (payment_id, order_id, amount, payment_date, method) FROM stdin;
\.


--
-- Data for Name: products; Type: TABLE DATA; Schema: shop; Owner: postgres
--

COPY shop.products (product_id, product_name, price, stock, category_id) FROM stdin;
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: shop; Owner: postgres
--

COPY shop.users (user_id, username, email, password, role) FROM stdin;
\.


--
-- Name: categories_category_id_seq; Type: SEQUENCE SET; Schema: shop; Owner: postgres
--

SELECT pg_catalog.setval('shop.categories_category_id_seq', 1, false);


--
-- Name: orderdetails_order_detail_id_seq; Type: SEQUENCE SET; Schema: shop; Owner: postgres
--

SELECT pg_catalog.setval('shop.orderdetails_order_detail_id_seq', 1, false);


--
-- Name: orders_order_id_seq; Type: SEQUENCE SET; Schema: shop; Owner: postgres
--

SELECT pg_catalog.setval('shop.orders_order_id_seq', 1, false);


--
-- Name: payments_payment_id_seq; Type: SEQUENCE SET; Schema: shop; Owner: postgres
--

SELECT pg_catalog.setval('shop.payments_payment_id_seq', 1, false);


--
-- Name: products_product_id_seq; Type: SEQUENCE SET; Schema: shop; Owner: postgres
--

SELECT pg_catalog.setval('shop.products_product_id_seq', 1, false);


--
-- Name: users_user_id_seq; Type: SEQUENCE SET; Schema: shop; Owner: postgres
--

SELECT pg_catalog.setval('shop.users_user_id_seq', 1, false);


--
-- Name: categories categories_category_name_key; Type: CONSTRAINT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.categories
    ADD CONSTRAINT categories_category_name_key UNIQUE (category_name);


--
-- Name: categories categories_pkey; Type: CONSTRAINT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.categories
    ADD CONSTRAINT categories_pkey PRIMARY KEY (category_id);


--
-- Name: orderdetails orderdetails_pkey; Type: CONSTRAINT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.orderdetails
    ADD CONSTRAINT orderdetails_pkey PRIMARY KEY (order_detail_id);


--
-- Name: orders orders_pkey; Type: CONSTRAINT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (order_id);


--
-- Name: payments payments_pkey; Type: CONSTRAINT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.payments
    ADD CONSTRAINT payments_pkey PRIMARY KEY (payment_id);


--
-- Name: products products_pkey; Type: CONSTRAINT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (product_id);


--
-- Name: users users_email_key; Type: CONSTRAINT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.users
    ADD CONSTRAINT users_email_key UNIQUE (email);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);


--
-- Name: users users_username_key; Type: CONSTRAINT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.users
    ADD CONSTRAINT users_username_key UNIQUE (username);


--
-- Name: orderdetails orderdetails_order_id_fkey; Type: FK CONSTRAINT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.orderdetails
    ADD CONSTRAINT orderdetails_order_id_fkey FOREIGN KEY (order_id) REFERENCES shop.orders(order_id);


--
-- Name: orderdetails orderdetails_product_id_fkey; Type: FK CONSTRAINT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.orderdetails
    ADD CONSTRAINT orderdetails_product_id_fkey FOREIGN KEY (product_id) REFERENCES shop.products(product_id);


--
-- Name: orders orders_user_id_fkey; Type: FK CONSTRAINT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.orders
    ADD CONSTRAINT orders_user_id_fkey FOREIGN KEY (user_id) REFERENCES shop.users(user_id);


--
-- Name: payments payments_order_id_fkey; Type: FK CONSTRAINT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.payments
    ADD CONSTRAINT payments_order_id_fkey FOREIGN KEY (order_id) REFERENCES shop.orders(order_id);


--
-- Name: products products_category_id_fkey; Type: FK CONSTRAINT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.products
    ADD CONSTRAINT products_category_id_fkey FOREIGN KEY (category_id) REFERENCES shop.categories(category_id);


--
-- PostgreSQL database dump complete
--

\unrestrict B3RVYfFmAmdousXcLHjAkdilKVjJBiZfWCz66JnqFRsHleRcoUMlC9HAjrc0DYJ

