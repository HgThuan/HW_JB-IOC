--
-- PostgreSQL database dump
--

\restrict YA5gCEcqiwTBGMG59f1mC7uKPeja1wOMsW1GGag5vKWyAIqJyjTs07Z26k9siZs

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: assignments; Type: TABLE; Schema: elearning; Owner: postgres
--

CREATE TABLE elearning.assignments (
    assignment_id integer NOT NULL,
    course_id integer,
    title character varying(100) NOT NULL,
    due_date date NOT NULL
);


ALTER TABLE elearning.assignments OWNER TO postgres;

--
-- Name: assignments_assignment_id_seq; Type: SEQUENCE; Schema: elearning; Owner: postgres
--

CREATE SEQUENCE elearning.assignments_assignment_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE elearning.assignments_assignment_id_seq OWNER TO postgres;

--
-- Name: assignments_assignment_id_seq; Type: SEQUENCE OWNED BY; Schema: elearning; Owner: postgres
--

ALTER SEQUENCE elearning.assignments_assignment_id_seq OWNED BY elearning.assignments.assignment_id;


--
-- Name: courses; Type: TABLE; Schema: elearning; Owner: postgres
--

CREATE TABLE elearning.courses (
    course_id integer NOT NULL,
    course_name character varying(100) NOT NULL,
    instructor_id integer
);


ALTER TABLE elearning.courses OWNER TO postgres;

--
-- Name: courses_course_id_seq; Type: SEQUENCE; Schema: elearning; Owner: postgres
--

CREATE SEQUENCE elearning.courses_course_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE elearning.courses_course_id_seq OWNER TO postgres;

--
-- Name: courses_course_id_seq; Type: SEQUENCE OWNED BY; Schema: elearning; Owner: postgres
--

ALTER SEQUENCE elearning.courses_course_id_seq OWNED BY elearning.courses.course_id;


--
-- Name: enrollments; Type: TABLE; Schema: elearning; Owner: postgres
--

CREATE TABLE elearning.enrollments (
    enrollment_id integer NOT NULL,
    student_id integer,
    course_id integer,
    enroll_date date NOT NULL
);


ALTER TABLE elearning.enrollments OWNER TO postgres;

--
-- Name: enrollments_enrollment_id_seq; Type: SEQUENCE; Schema: elearning; Owner: postgres
--

CREATE SEQUENCE elearning.enrollments_enrollment_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE elearning.enrollments_enrollment_id_seq OWNER TO postgres;

--
-- Name: enrollments_enrollment_id_seq; Type: SEQUENCE OWNED BY; Schema: elearning; Owner: postgres
--

ALTER SEQUENCE elearning.enrollments_enrollment_id_seq OWNED BY elearning.enrollments.enrollment_id;


--
-- Name: instructors; Type: TABLE; Schema: elearning; Owner: postgres
--

CREATE TABLE elearning.instructors (
    instructor_id integer NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    email character varying(50) NOT NULL
);


ALTER TABLE elearning.instructors OWNER TO postgres;

--
-- Name: instructors_instructor_id_seq; Type: SEQUENCE; Schema: elearning; Owner: postgres
--

CREATE SEQUENCE elearning.instructors_instructor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE elearning.instructors_instructor_id_seq OWNER TO postgres;

--
-- Name: instructors_instructor_id_seq; Type: SEQUENCE OWNED BY; Schema: elearning; Owner: postgres
--

ALTER SEQUENCE elearning.instructors_instructor_id_seq OWNED BY elearning.instructors.instructor_id;


--
-- Name: students; Type: TABLE; Schema: elearning; Owner: postgres
--

CREATE TABLE elearning.students (
    student_id integer NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    email character varying(50) NOT NULL
);


ALTER TABLE elearning.students OWNER TO postgres;

--
-- Name: students_student_id_seq; Type: SEQUENCE; Schema: elearning; Owner: postgres
--

CREATE SEQUENCE elearning.students_student_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE elearning.students_student_id_seq OWNER TO postgres;

--
-- Name: students_student_id_seq; Type: SEQUENCE OWNED BY; Schema: elearning; Owner: postgres
--

ALTER SEQUENCE elearning.students_student_id_seq OWNED BY elearning.students.student_id;


--
-- Name: submissions; Type: TABLE; Schema: elearning; Owner: postgres
--

CREATE TABLE elearning.submissions (
    submission_id integer NOT NULL,
    assignment_id integer,
    student_id integer,
    submission_date date NOT NULL,
    grade numeric(5,2),
    CONSTRAINT submissions_grade_check CHECK (((grade >= (1)::numeric) AND (grade <= (100)::numeric)))
);


ALTER TABLE elearning.submissions OWNER TO postgres;

--
-- Name: submissions_submission_id_seq; Type: SEQUENCE; Schema: elearning; Owner: postgres
--

CREATE SEQUENCE elearning.submissions_submission_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE elearning.submissions_submission_id_seq OWNER TO postgres;

--
-- Name: submissions_submission_id_seq; Type: SEQUENCE OWNED BY; Schema: elearning; Owner: postgres
--

ALTER SEQUENCE elearning.submissions_submission_id_seq OWNED BY elearning.submissions.submission_id;


--
-- Name: assignments assignment_id; Type: DEFAULT; Schema: elearning; Owner: postgres
--

ALTER TABLE ONLY elearning.assignments ALTER COLUMN assignment_id SET DEFAULT nextval('elearning.assignments_assignment_id_seq'::regclass);


--
-- Name: courses course_id; Type: DEFAULT; Schema: elearning; Owner: postgres
--

ALTER TABLE ONLY elearning.courses ALTER COLUMN course_id SET DEFAULT nextval('elearning.courses_course_id_seq'::regclass);


--
-- Name: enrollments enrollment_id; Type: DEFAULT; Schema: elearning; Owner: postgres
--

ALTER TABLE ONLY elearning.enrollments ALTER COLUMN enrollment_id SET DEFAULT nextval('elearning.enrollments_enrollment_id_seq'::regclass);


--
-- Name: instructors instructor_id; Type: DEFAULT; Schema: elearning; Owner: postgres
--

ALTER TABLE ONLY elearning.instructors ALTER COLUMN instructor_id SET DEFAULT nextval('elearning.instructors_instructor_id_seq'::regclass);


--
-- Name: students student_id; Type: DEFAULT; Schema: elearning; Owner: postgres
--

ALTER TABLE ONLY elearning.students ALTER COLUMN student_id SET DEFAULT nextval('elearning.students_student_id_seq'::regclass);


--
-- Name: submissions submission_id; Type: DEFAULT; Schema: elearning; Owner: postgres
--

ALTER TABLE ONLY elearning.submissions ALTER COLUMN submission_id SET DEFAULT nextval('elearning.submissions_submission_id_seq'::regclass);


--
-- Data for Name: assignments; Type: TABLE DATA; Schema: elearning; Owner: postgres
--

COPY elearning.assignments (assignment_id, course_id, title, due_date) FROM stdin;
\.


--
-- Data for Name: courses; Type: TABLE DATA; Schema: elearning; Owner: postgres
--

COPY elearning.courses (course_id, course_name, instructor_id) FROM stdin;
\.


--
-- Data for Name: enrollments; Type: TABLE DATA; Schema: elearning; Owner: postgres
--

COPY elearning.enrollments (enrollment_id, student_id, course_id, enroll_date) FROM stdin;
\.


--
-- Data for Name: instructors; Type: TABLE DATA; Schema: elearning; Owner: postgres
--

COPY elearning.instructors (instructor_id, first_name, last_name, email) FROM stdin;
\.


--
-- Data for Name: students; Type: TABLE DATA; Schema: elearning; Owner: postgres
--

COPY elearning.students (student_id, first_name, last_name, email) FROM stdin;
\.


--
-- Data for Name: submissions; Type: TABLE DATA; Schema: elearning; Owner: postgres
--

COPY elearning.submissions (submission_id, assignment_id, student_id, submission_date, grade) FROM stdin;
\.


--
-- Name: assignments_assignment_id_seq; Type: SEQUENCE SET; Schema: elearning; Owner: postgres
--

SELECT pg_catalog.setval('elearning.assignments_assignment_id_seq', 1, false);


--
-- Name: courses_course_id_seq; Type: SEQUENCE SET; Schema: elearning; Owner: postgres
--

SELECT pg_catalog.setval('elearning.courses_course_id_seq', 1, false);


--
-- Name: enrollments_enrollment_id_seq; Type: SEQUENCE SET; Schema: elearning; Owner: postgres
--

SELECT pg_catalog.setval('elearning.enrollments_enrollment_id_seq', 1, false);


--
-- Name: instructors_instructor_id_seq; Type: SEQUENCE SET; Schema: elearning; Owner: postgres
--

SELECT pg_catalog.setval('elearning.instructors_instructor_id_seq', 1, false);


--
-- Name: students_student_id_seq; Type: SEQUENCE SET; Schema: elearning; Owner: postgres
--

SELECT pg_catalog.setval('elearning.students_student_id_seq', 1, false);


--
-- Name: submissions_submission_id_seq; Type: SEQUENCE SET; Schema: elearning; Owner: postgres
--

SELECT pg_catalog.setval('elearning.submissions_submission_id_seq', 2, true);


--
-- Name: assignments assignments_pkey; Type: CONSTRAINT; Schema: elearning; Owner: postgres
--

ALTER TABLE ONLY elearning.assignments
    ADD CONSTRAINT assignments_pkey PRIMARY KEY (assignment_id);


--
-- Name: courses courses_pkey; Type: CONSTRAINT; Schema: elearning; Owner: postgres
--

ALTER TABLE ONLY elearning.courses
    ADD CONSTRAINT courses_pkey PRIMARY KEY (course_id);


--
-- Name: enrollments enrollments_pkey; Type: CONSTRAINT; Schema: elearning; Owner: postgres
--

ALTER TABLE ONLY elearning.enrollments
    ADD CONSTRAINT enrollments_pkey PRIMARY KEY (enrollment_id);


--
-- Name: instructors instructors_email_key; Type: CONSTRAINT; Schema: elearning; Owner: postgres
--

ALTER TABLE ONLY elearning.instructors
    ADD CONSTRAINT instructors_email_key UNIQUE (email);


--
-- Name: instructors instructors_pkey; Type: CONSTRAINT; Schema: elearning; Owner: postgres
--

ALTER TABLE ONLY elearning.instructors
    ADD CONSTRAINT instructors_pkey PRIMARY KEY (instructor_id);


--
-- Name: students students_email_key; Type: CONSTRAINT; Schema: elearning; Owner: postgres
--

ALTER TABLE ONLY elearning.students
    ADD CONSTRAINT students_email_key UNIQUE (email);


--
-- Name: students students_pkey; Type: CONSTRAINT; Schema: elearning; Owner: postgres
--

ALTER TABLE ONLY elearning.students
    ADD CONSTRAINT students_pkey PRIMARY KEY (student_id);


--
-- Name: submissions submissions_pkey; Type: CONSTRAINT; Schema: elearning; Owner: postgres
--

ALTER TABLE ONLY elearning.submissions
    ADD CONSTRAINT submissions_pkey PRIMARY KEY (submission_id);


--
-- Name: assignments assignments_course_id_fkey; Type: FK CONSTRAINT; Schema: elearning; Owner: postgres
--

ALTER TABLE ONLY elearning.assignments
    ADD CONSTRAINT assignments_course_id_fkey FOREIGN KEY (course_id) REFERENCES elearning.courses(course_id);


--
-- Name: courses courses_instructor_id_fkey; Type: FK CONSTRAINT; Schema: elearning; Owner: postgres
--

ALTER TABLE ONLY elearning.courses
    ADD CONSTRAINT courses_instructor_id_fkey FOREIGN KEY (instructor_id) REFERENCES elearning.instructors(instructor_id);


--
-- Name: enrollments enrollments_course_id_fkey; Type: FK CONSTRAINT; Schema: elearning; Owner: postgres
--

ALTER TABLE ONLY elearning.enrollments
    ADD CONSTRAINT enrollments_course_id_fkey FOREIGN KEY (course_id) REFERENCES elearning.courses(course_id);


--
-- Name: enrollments enrollments_student_id_fkey; Type: FK CONSTRAINT; Schema: elearning; Owner: postgres
--

ALTER TABLE ONLY elearning.enrollments
    ADD CONSTRAINT enrollments_student_id_fkey FOREIGN KEY (student_id) REFERENCES elearning.students(student_id);


--
-- Name: submissions submissions_assignment_id_fkey; Type: FK CONSTRAINT; Schema: elearning; Owner: postgres
--

ALTER TABLE ONLY elearning.submissions
    ADD CONSTRAINT submissions_assignment_id_fkey FOREIGN KEY (assignment_id) REFERENCES elearning.assignments(assignment_id);


--
-- Name: submissions submissions_student_id_fkey; Type: FK CONSTRAINT; Schema: elearning; Owner: postgres
--

ALTER TABLE ONLY elearning.submissions
    ADD CONSTRAINT submissions_student_id_fkey FOREIGN KEY (student_id) REFERENCES elearning.students(student_id);


--
-- PostgreSQL database dump complete
--

\unrestrict YA5gCEcqiwTBGMG59f1mC7uKPeja1wOMsW1GGag5vKWyAIqJyjTs07Z26k9siZs

