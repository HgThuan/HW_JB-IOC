--
-- PostgreSQL database dump
--

\restrict 8zOTAKM8uUtgjQUpWLVLyje2hYYjGyaOefqOO9ln0KR2r1NAfk9zCcrbJfnPvgz

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
-- Name: hotel; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA hotel;


ALTER SCHEMA hotel OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: bookings; Type: TABLE; Schema: hotel; Owner: postgres
--

CREATE TABLE hotel.bookings (
    booking_id integer NOT NULL,
    customer_id integer,
    room_id integer,
    check_in date NOT NULL,
    check_out date NOT NULL,
    status character varying(20),
    CONSTRAINT bookings_status_check CHECK (((status)::text = ANY ((ARRAY['Pending'::character varying, 'Confirmed'::character varying, 'Cancelled'::character varying])::text[])))
);


ALTER TABLE hotel.bookings OWNER TO postgres;

--
-- Name: bookings_booking_id_seq; Type: SEQUENCE; Schema: hotel; Owner: postgres
--

CREATE SEQUENCE hotel.bookings_booking_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE hotel.bookings_booking_id_seq OWNER TO postgres;

--
-- Name: bookings_booking_id_seq; Type: SEQUENCE OWNED BY; Schema: hotel; Owner: postgres
--

ALTER SEQUENCE hotel.bookings_booking_id_seq OWNED BY hotel.bookings.booking_id;


--
-- Name: customers; Type: TABLE; Schema: hotel; Owner: postgres
--

CREATE TABLE hotel.customers (
    customer_id integer NOT NULL,
    full_name character varying(100) NOT NULL,
    email character varying(100) NOT NULL,
    phone character varying(15) NOT NULL
);


ALTER TABLE hotel.customers OWNER TO postgres;

--
-- Name: customers_customer_id_seq; Type: SEQUENCE; Schema: hotel; Owner: postgres
--

CREATE SEQUENCE hotel.customers_customer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE hotel.customers_customer_id_seq OWNER TO postgres;

--
-- Name: customers_customer_id_seq; Type: SEQUENCE OWNED BY; Schema: hotel; Owner: postgres
--

ALTER SEQUENCE hotel.customers_customer_id_seq OWNED BY hotel.customers.customer_id;


--
-- Name: payments; Type: TABLE; Schema: hotel; Owner: postgres
--

CREATE TABLE hotel.payments (
    payment_id integer NOT NULL,
    booking_id integer,
    amount numeric(10,2),
    payment_date date NOT NULL,
    method character varying(20),
    CONSTRAINT payments_amount_check CHECK ((amount >= (0)::numeric)),
    CONSTRAINT payments_method_check CHECK (((method)::text = ANY ((ARRAY['Credit Card'::character varying, 'Cash'::character varying, 'Bank Transfer'::character varying])::text[])))
);


ALTER TABLE hotel.payments OWNER TO postgres;

--
-- Name: payments_payment_id_seq; Type: SEQUENCE; Schema: hotel; Owner: postgres
--

CREATE SEQUENCE hotel.payments_payment_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE hotel.payments_payment_id_seq OWNER TO postgres;

--
-- Name: payments_payment_id_seq; Type: SEQUENCE OWNED BY; Schema: hotel; Owner: postgres
--

ALTER SEQUENCE hotel.payments_payment_id_seq OWNED BY hotel.payments.payment_id;


--
-- Name: rooms; Type: TABLE; Schema: hotel; Owner: postgres
--

CREATE TABLE hotel.rooms (
    room_id integer NOT NULL,
    room_number character varying(10) NOT NULL,
    room_type_id integer,
    status character varying(20),
    CONSTRAINT rooms_status_check CHECK (((status)::text = ANY ((ARRAY['Available'::character varying, 'Occupied'::character varying, 'Maintenance'::character varying])::text[])))
);


ALTER TABLE hotel.rooms OWNER TO postgres;

--
-- Name: rooms_room_id_seq; Type: SEQUENCE; Schema: hotel; Owner: postgres
--

CREATE SEQUENCE hotel.rooms_room_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE hotel.rooms_room_id_seq OWNER TO postgres;

--
-- Name: rooms_room_id_seq; Type: SEQUENCE OWNED BY; Schema: hotel; Owner: postgres
--

ALTER SEQUENCE hotel.rooms_room_id_seq OWNED BY hotel.rooms.room_id;


--
-- Name: roomtypes; Type: TABLE; Schema: hotel; Owner: postgres
--

CREATE TABLE hotel.roomtypes (
    room_type_id integer NOT NULL,
    type_name character varying(50) NOT NULL,
    price_per_night numeric(10,2),
    max_capacity integer,
    CONSTRAINT roomtypes_max_capacity_check CHECK ((max_capacity > 0)),
    CONSTRAINT roomtypes_price_per_night_check CHECK ((price_per_night > (0)::numeric))
);


ALTER TABLE hotel.roomtypes OWNER TO postgres;

--
-- Name: roomtypes_room_type_id_seq; Type: SEQUENCE; Schema: hotel; Owner: postgres
--

CREATE SEQUENCE hotel.roomtypes_room_type_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE hotel.roomtypes_room_type_id_seq OWNER TO postgres;

--
-- Name: roomtypes_room_type_id_seq; Type: SEQUENCE OWNED BY; Schema: hotel; Owner: postgres
--

ALTER SEQUENCE hotel.roomtypes_room_type_id_seq OWNED BY hotel.roomtypes.room_type_id;


--
-- Name: bookings booking_id; Type: DEFAULT; Schema: hotel; Owner: postgres
--

ALTER TABLE ONLY hotel.bookings ALTER COLUMN booking_id SET DEFAULT nextval('hotel.bookings_booking_id_seq'::regclass);


--
-- Name: customers customer_id; Type: DEFAULT; Schema: hotel; Owner: postgres
--

ALTER TABLE ONLY hotel.customers ALTER COLUMN customer_id SET DEFAULT nextval('hotel.customers_customer_id_seq'::regclass);


--
-- Name: payments payment_id; Type: DEFAULT; Schema: hotel; Owner: postgres
--

ALTER TABLE ONLY hotel.payments ALTER COLUMN payment_id SET DEFAULT nextval('hotel.payments_payment_id_seq'::regclass);


--
-- Name: rooms room_id; Type: DEFAULT; Schema: hotel; Owner: postgres
--

ALTER TABLE ONLY hotel.rooms ALTER COLUMN room_id SET DEFAULT nextval('hotel.rooms_room_id_seq'::regclass);


--
-- Name: roomtypes room_type_id; Type: DEFAULT; Schema: hotel; Owner: postgres
--

ALTER TABLE ONLY hotel.roomtypes ALTER COLUMN room_type_id SET DEFAULT nextval('hotel.roomtypes_room_type_id_seq'::regclass);


--
-- Data for Name: bookings; Type: TABLE DATA; Schema: hotel; Owner: postgres
--

COPY hotel.bookings (booking_id, customer_id, room_id, check_in, check_out, status) FROM stdin;
\.


--
-- Data for Name: customers; Type: TABLE DATA; Schema: hotel; Owner: postgres
--

COPY hotel.customers (customer_id, full_name, email, phone) FROM stdin;
\.


--
-- Data for Name: payments; Type: TABLE DATA; Schema: hotel; Owner: postgres
--

COPY hotel.payments (payment_id, booking_id, amount, payment_date, method) FROM stdin;
\.


--
-- Data for Name: rooms; Type: TABLE DATA; Schema: hotel; Owner: postgres
--

COPY hotel.rooms (room_id, room_number, room_type_id, status) FROM stdin;
\.


--
-- Data for Name: roomtypes; Type: TABLE DATA; Schema: hotel; Owner: postgres
--

COPY hotel.roomtypes (room_type_id, type_name, price_per_night, max_capacity) FROM stdin;
\.


--
-- Name: bookings_booking_id_seq; Type: SEQUENCE SET; Schema: hotel; Owner: postgres
--

SELECT pg_catalog.setval('hotel.bookings_booking_id_seq', 1, false);


--
-- Name: customers_customer_id_seq; Type: SEQUENCE SET; Schema: hotel; Owner: postgres
--

SELECT pg_catalog.setval('hotel.customers_customer_id_seq', 1, false);


--
-- Name: payments_payment_id_seq; Type: SEQUENCE SET; Schema: hotel; Owner: postgres
--

SELECT pg_catalog.setval('hotel.payments_payment_id_seq', 1, false);


--
-- Name: rooms_room_id_seq; Type: SEQUENCE SET; Schema: hotel; Owner: postgres
--

SELECT pg_catalog.setval('hotel.rooms_room_id_seq', 1, false);


--
-- Name: roomtypes_room_type_id_seq; Type: SEQUENCE SET; Schema: hotel; Owner: postgres
--

SELECT pg_catalog.setval('hotel.roomtypes_room_type_id_seq', 1, false);


--
-- Name: bookings bookings_pkey; Type: CONSTRAINT; Schema: hotel; Owner: postgres
--

ALTER TABLE ONLY hotel.bookings
    ADD CONSTRAINT bookings_pkey PRIMARY KEY (booking_id);


--
-- Name: customers customers_email_key; Type: CONSTRAINT; Schema: hotel; Owner: postgres
--

ALTER TABLE ONLY hotel.customers
    ADD CONSTRAINT customers_email_key UNIQUE (email);


--
-- Name: customers customers_pkey; Type: CONSTRAINT; Schema: hotel; Owner: postgres
--

ALTER TABLE ONLY hotel.customers
    ADD CONSTRAINT customers_pkey PRIMARY KEY (customer_id);


--
-- Name: payments payments_pkey; Type: CONSTRAINT; Schema: hotel; Owner: postgres
--

ALTER TABLE ONLY hotel.payments
    ADD CONSTRAINT payments_pkey PRIMARY KEY (payment_id);


--
-- Name: rooms rooms_pkey; Type: CONSTRAINT; Schema: hotel; Owner: postgres
--

ALTER TABLE ONLY hotel.rooms
    ADD CONSTRAINT rooms_pkey PRIMARY KEY (room_id);


--
-- Name: rooms rooms_room_number_key; Type: CONSTRAINT; Schema: hotel; Owner: postgres
--

ALTER TABLE ONLY hotel.rooms
    ADD CONSTRAINT rooms_room_number_key UNIQUE (room_number);


--
-- Name: roomtypes roomtypes_pkey; Type: CONSTRAINT; Schema: hotel; Owner: postgres
--

ALTER TABLE ONLY hotel.roomtypes
    ADD CONSTRAINT roomtypes_pkey PRIMARY KEY (room_type_id);


--
-- Name: roomtypes roomtypes_type_name_key; Type: CONSTRAINT; Schema: hotel; Owner: postgres
--

ALTER TABLE ONLY hotel.roomtypes
    ADD CONSTRAINT roomtypes_type_name_key UNIQUE (type_name);


--
-- Name: bookings bookings_customer_id_fkey; Type: FK CONSTRAINT; Schema: hotel; Owner: postgres
--

ALTER TABLE ONLY hotel.bookings
    ADD CONSTRAINT bookings_customer_id_fkey FOREIGN KEY (customer_id) REFERENCES hotel.customers(customer_id);


--
-- Name: bookings bookings_room_id_fkey; Type: FK CONSTRAINT; Schema: hotel; Owner: postgres
--

ALTER TABLE ONLY hotel.bookings
    ADD CONSTRAINT bookings_room_id_fkey FOREIGN KEY (room_id) REFERENCES hotel.rooms(room_id);


--
-- Name: payments payments_booking_id_fkey; Type: FK CONSTRAINT; Schema: hotel; Owner: postgres
--

ALTER TABLE ONLY hotel.payments
    ADD CONSTRAINT payments_booking_id_fkey FOREIGN KEY (booking_id) REFERENCES hotel.bookings(booking_id);


--
-- Name: rooms rooms_room_type_id_fkey; Type: FK CONSTRAINT; Schema: hotel; Owner: postgres
--

ALTER TABLE ONLY hotel.rooms
    ADD CONSTRAINT rooms_room_type_id_fkey FOREIGN KEY (room_type_id) REFERENCES hotel.roomtypes(room_type_id);


--
-- PostgreSQL database dump complete
--

\unrestrict 8zOTAKM8uUtgjQUpWLVLyje2hYYjGyaOefqOO9ln0KR2r1NAfk9zCcrbJfnPvgz

