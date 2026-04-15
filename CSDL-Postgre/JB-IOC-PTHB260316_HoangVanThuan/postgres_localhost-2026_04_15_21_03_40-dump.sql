--
-- PostgreSQL database dump
--

\restrict gpWf4lzwDZnMpMQX3YP5yNIuqrpU9aX0gmnDDHo1Y3sTbJlFBY8qYtOC9cwc1dk

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
-- Name: elearning; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA elearning;


ALTER SCHEMA elearning OWNER TO postgres;

--
-- Name: add_customer(character varying, character varying, character varying, character varying, character varying); Type: PROCEDURE; Schema: public; Owner: postgres
--

CREATE PROCEDURE public.add_customer(IN p_id character varying, IN p_name character varying, IN p_email character varying, IN p_phone character varying, IN p_address character varying)
    LANGUAGE plpgsql
    AS $$
    begin
        insert into customer(customer_id, customer_full_name, customer_email, customer_phone, customer_address)
        values (p_id,
                p_name,
                p_email,
                p_phone,
                p_address);
    end;
    $$;


ALTER PROCEDURE public.add_customer(IN p_id character varying, IN p_name character varying, IN p_email character varying, IN p_phone character varying, IN p_address character varying) OWNER TO postgres;

--
-- Name: add_payment(integer, character varying, numeric, date); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.add_payment(p_booking_id integer, p_payment_method character varying, p_payment_amount numeric, p_payment_date date) RETURNS void
    LANGUAGE plpgsql
    AS $$
BEGIN
    INSERT INTO payment (
        booking_id,
        payment_method,
        payment_amount,
        payment_date
    )
    VALUES (
               p_booking_id,
               p_payment_method,
               p_payment_amount,
               p_payment_date
           );
END;
$$;


ALTER FUNCTION public.add_payment(p_booking_id integer, p_payment_method character varying, p_payment_amount numeric, p_payment_date date) OWNER TO postgres;

--
-- Name: check_booking_dates_function(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.check_booking_dates_function() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
    IF NEW.check_in_date > NEW.check_out_date THEN
        RAISE EXCEPTION 'Ngày đặt phòng không thể sau ngày trả phòng được !';
    END IF;
    RETURN NEW;
END;
$$;


ALTER FUNCTION public.check_booking_dates_function() OWNER TO postgres;

--
-- Name: update_room_status_function(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.update_room_status_function() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
    UPDATE room
    SET room_status = 'Booked'
    WHERE room_id = NEW.room_id;
    RETURN NULL;
END;
$$;


ALTER FUNCTION public.update_room_status_function() OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: booking; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.booking (
    booking_id integer NOT NULL,
    customer_id character varying(5) NOT NULL,
    room_id character varying(5) NOT NULL,
    check_in_date date NOT NULL,
    check_out_date date NOT NULL,
    total_amount numeric(10,2)
);


ALTER TABLE public.booking OWNER TO postgres;

--
-- Name: customer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customer (
    customer_id character varying(5) NOT NULL,
    customer_full_name character varying(100) NOT NULL,
    customer_email character varying(100) NOT NULL,
    customer_phone character varying(15) NOT NULL,
    customer_address character varying(255)
);


ALTER TABLE public.customer OWNER TO postgres;

--
-- Name: payment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.payment (
    payment_id integer NOT NULL,
    booking_id integer NOT NULL,
    payment_method character varying(50) NOT NULL,
    payment_date date NOT NULL,
    payment_amount numeric(10,2) NOT NULL
);


ALTER TABLE public.payment OWNER TO postgres;

--
-- Name: room; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.room (
    room_id character varying(5) NOT NULL,
    room_type character varying(50) NOT NULL,
    room_price numeric(10,2) NOT NULL,
    room_status character varying(20) NOT NULL,
    room_area integer
);


ALTER TABLE public.room OWNER TO postgres;

--
-- Name: v_booking_details; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.v_booking_details AS
 SELECT r.room_id,
    r.room_type,
    c.customer_id,
    c.customer_full_name,
    b.check_in_date
   FROM ((public.booking b
     JOIN public.room r ON (((b.room_id)::text = (r.room_id)::text)))
     JOIN public.customer c ON (((b.customer_id)::text = (c.customer_id)::text)))
  WHERE (b.check_in_date < '2025-03-10'::date);


ALTER VIEW public.v_booking_details OWNER TO postgres;

--
-- Name: v_large_room_bookings; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.v_large_room_bookings AS
 SELECT c.customer_id,
    c.customer_full_name,
    r.room_id,
    r.room_area
   FROM ((public.booking b
     JOIN public.customer c ON (((b.customer_id)::text = (c.customer_id)::text)))
     JOIN public.room r ON (((b.room_id)::text = (r.room_id)::text)))
  WHERE (r.room_area > 30);


ALTER VIEW public.v_large_room_bookings OWNER TO postgres;

--
-- Data for Name: booking; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.booking (booking_id, customer_id, room_id, check_in_date, check_out_date, total_amount) FROM stdin;
1	C001	R001	2025-03-01	2025-03-05	400.00
3	C003	R003	2025-03-03	2025-03-07	1000.00
5	C005	R005	2025-03-05	2025-03-09	800.00
6	C006	R001	2025-03-06	2025-03-10	400.00
8	C008	R003	2025-03-08	2025-03-12	1000.00
10	C010	R005	2025-03-10	2025-03-14	800.00
2	C002	R002	2025-03-02	2025-03-06	600.00
4	C004	R004	2025-03-04	2025-03-08	480.00
7	C007	R002	2025-03-07	2025-03-11	600.00
9	C009	R004	2025-03-09	2025-03-13	480.00
11	C011	R003	2025-04-01	2025-04-04	750.00
12	C011	R005	2025-04-05	2025-04-09	640.00
\.


--
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.customer (customer_id, customer_full_name, customer_email, customer_phone, customer_address) FROM stdin;
C001	Nguyen Anh Tu	tu.nguyen@example.com	0912345678	Hanoi, Vietnam
C002	Tran Thi Mai	mai.tran@example.com	0923456789	Ho Chi Minh, Vietnam
C003	Le Minh Hoang	hoang.le@example.com	0934567890	Danang, Vietnam
C004	Pham Hoang Nam	nam.pham@example.com	0945678901	Hue, Vietnam
C005	Vu Minh Thu	thu.vu@example.com	0956789012	Hai Phong, Vietnam
C006	Nguyen Thi Lan	lan.nguyen@example.com	0967890123	Quang Ninh, Vietnam
C007	Bui Minh Tuan	tuan.bui@example.com	0978901234	Bac Giang, Vietnam
C008	Pham Quang Hieu	hieu.pham@example.com	0989012345	Quang Nam, Vietnam
C009	Le Thi Lan	lan.le@example.com	0990123456	Da Lat, Vietnam
C010	Nguyen Thi Mai	mai.nguyen@example.com	0901234567	Can Tho, Vietnam
C011	Trinh Van Quyet	quyet.tv@example.com	0911111111	Vinh Phuc, Vietnam
C012	Do Anh Tuan	tuan.da@example.com	0922222222	Ha Noi, Vietnam
C013	Nguyen Do Lang	lang.nd@example.com	0933333333	Phu Tho, Vietnam
C014	Dao Huu Huyen	huyen.dh@example.com	0944444444	Hung Yen, Vietnam
C016	Tran Van An	an.tran@example.com	0912345670	Nha Trang, Vietnam
\.


--
-- Data for Name: payment; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.payment (payment_id, booking_id, payment_method, payment_date, payment_amount) FROM stdin;
2	2	Credit Card	2025-03-06	600.00
3	3	Bank Transfer	2025-03-07	1000.00
5	5	Credit Card	2025-03-09	800.00
6	6	Bank Transfer	2025-03-10	400.00
7	7	Cash	2025-03-11	600.00
8	8	Credit Card	2025-03-12	1000.00
9	9	Bank Transfer	2025-03-13	480.00
10	10	Cash	2025-03-14	800.00
\.


--
-- Data for Name: room; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.room (room_id, room_type, room_price, room_status, room_area) FROM stdin;
R001	Single	100.00	Available	25
R002	Double	150.00	Booked	40
R003	Suite	250.00	Available	60
R004	Single	120.00	Booked	30
R005	Double	160.00	Available	35
R006	Budget	50.00	Available	20
R007	Budget	50.00	Available	20
\.


--
-- Name: booking booking_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.booking
    ADD CONSTRAINT booking_pkey PRIMARY KEY (booking_id);


--
-- Name: customer customer_customer_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_customer_email_key UNIQUE (customer_email);


--
-- Name: customer customer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (customer_id);


--
-- Name: payment payment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payment
    ADD CONSTRAINT payment_pkey PRIMARY KEY (payment_id);


--
-- Name: room room_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.room
    ADD CONSTRAINT room_pkey PRIMARY KEY (room_id);


--
-- Name: booking check_insert_booking; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER check_insert_booking BEFORE INSERT ON public.booking FOR EACH ROW EXECUTE FUNCTION public.check_booking_dates_function();


--
-- Name: booking update_room_status_on_booking; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER update_room_status_on_booking AFTER INSERT ON public.booking FOR EACH ROW EXECUTE FUNCTION public.update_room_status_function();


--
-- Name: booking booking_customer_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.booking
    ADD CONSTRAINT booking_customer_id_fkey FOREIGN KEY (customer_id) REFERENCES public.customer(customer_id);


--
-- Name: booking booking_room_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.booking
    ADD CONSTRAINT booking_room_id_fkey FOREIGN KEY (room_id) REFERENCES public.room(room_id);


--
-- Name: payment payment_booking_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payment
    ADD CONSTRAINT payment_booking_id_fkey FOREIGN KEY (booking_id) REFERENCES public.booking(booking_id);


--
-- PostgreSQL database dump complete
--

\unrestrict gpWf4lzwDZnMpMQX3YP5yNIuqrpU9aX0gmnDDHo1Y3sTbJlFBY8qYtOC9cwc1dk

