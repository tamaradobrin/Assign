--
-- PostgreSQL database dump
--

-- Dumped from database version 10.0
-- Dumped by pg_dump version 10.0

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: assign; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA assign;


ALTER SCHEMA assign OWNER TO postgres;

SET search_path = assign, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: project; Type: TABLE; Schema: assign; Owner: postgres
--

CREATE TABLE project (
    id integer NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(300),
    quota integer
);


ALTER TABLE project OWNER TO postgres;

--
-- Name: project_id_seq; Type: SEQUENCE; Schema: assign; Owner: postgres
--

CREATE SEQUENCE project_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE project_id_seq OWNER TO postgres;

--
-- Name: project_id_seq; Type: SEQUENCE OWNED BY; Schema: assign; Owner: postgres
--

ALTER SEQUENCE project_id_seq OWNED BY project.id;


--
-- Name: projectskill; Type: TABLE; Schema: assign; Owner: postgres
--

CREATE TABLE projectskill (
    projectid integer NOT NULL,
    skillid integer NOT NULL
);


ALTER TABLE projectskill OWNER TO postgres;

--
-- Name: skill; Type: TABLE; Schema: assign; Owner: postgres
--

CREATE TABLE skill (
    id integer NOT NULL,
    name character varying(100) NOT NULL
);


ALTER TABLE skill OWNER TO postgres;

--
-- Name: skill_id_seq; Type: SEQUENCE; Schema: assign; Owner: postgres
--

CREATE SEQUENCE skill_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE skill_id_seq OWNER TO postgres;

--
-- Name: skill_id_seq; Type: SEQUENCE OWNED BY; Schema: assign; Owner: postgres
--

ALTER SEQUENCE skill_id_seq OWNED BY skill.id;


--
-- Name: student; Type: TABLE; Schema: assign; Owner: postgres
--

CREATE TABLE student (
    id integer NOT NULL,
    name character varying NOT NULL,
    projectid integer
);


ALTER TABLE student OWNER TO postgres;

--
-- Name: student_id_seq; Type: SEQUENCE; Schema: assign; Owner: postgres
--

CREATE SEQUENCE student_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE student_id_seq OWNER TO postgres;

--
-- Name: student_id_seq; Type: SEQUENCE OWNED BY; Schema: assign; Owner: postgres
--

ALTER SEQUENCE student_id_seq OWNED BY student.id;


--
-- Name: studentskill; Type: TABLE; Schema: assign; Owner: postgres
--

CREATE TABLE studentskill (
    studentid integer NOT NULL,
    skillid integer NOT NULL
);


ALTER TABLE studentskill OWNER TO postgres;

--
-- Name: project id; Type: DEFAULT; Schema: assign; Owner: postgres
--

ALTER TABLE ONLY project ALTER COLUMN id SET DEFAULT nextval('project_id_seq'::regclass);


--
-- Name: skill id; Type: DEFAULT; Schema: assign; Owner: postgres
--

ALTER TABLE ONLY skill ALTER COLUMN id SET DEFAULT nextval('skill_id_seq'::regclass);


--
-- Name: student id; Type: DEFAULT; Schema: assign; Owner: postgres
--

ALTER TABLE ONLY student ALTER COLUMN id SET DEFAULT nextval('student_id_seq'::regclass);


--
-- Data for Name: project; Type: TABLE DATA; Schema: assign; Owner: postgres
--

COPY project (id, name, description, quota) FROM stdin;
2	PROJ829V	another exciting description	4
1	PROJ38U	project description	3
\.


--
-- Data for Name: projectskill; Type: TABLE DATA; Schema: assign; Owner: postgres
--

COPY projectskill (projectid, skillid) FROM stdin;
1	5
1	3
2	3
2	4
2	6
2	7
\.


--
-- Data for Name: skill; Type: TABLE DATA; Schema: assign; Owner: postgres
--

COPY skill (id, name) FROM stdin;
1	Data structures and algorithms
2	Computation theory
3	Formal methods
4	Computer architecture
5	Computer networks
6	Distributed systems
7	Computer graphics
8	Security & cryptography
9	Artificial intelligence
\.


--
-- Data for Name: student; Type: TABLE DATA; Schema: assign; Owner: postgres
--

COPY student (id, name, projectid) FROM stdin;
2	Amelia Cojocaru	1
1	Tudor Gradinaru	1
3	Denis Priboi	2
\.


--
-- Data for Name: studentskill; Type: TABLE DATA; Schema: assign; Owner: postgres
--

COPY studentskill (studentid, skillid) FROM stdin;
1	3
1	5
2	4
2	1
2	7
3	5
\.


--
-- Name: project_id_seq; Type: SEQUENCE SET; Schema: assign; Owner: postgres
--

SELECT pg_catalog.setval('project_id_seq', 2, true);


--
-- Name: skill_id_seq; Type: SEQUENCE SET; Schema: assign; Owner: postgres
--

SELECT pg_catalog.setval('skill_id_seq', 9, true);


--
-- Name: student_id_seq; Type: SEQUENCE SET; Schema: assign; Owner: postgres
--

SELECT pg_catalog.setval('student_id_seq', 3, true);


--
-- Name: project project_pkey; Type: CONSTRAINT; Schema: assign; Owner: postgres
--

ALTER TABLE ONLY project
    ADD CONSTRAINT project_pkey PRIMARY KEY (id);


--
-- Name: skill skill_pkey; Type: CONSTRAINT; Schema: assign; Owner: postgres
--

ALTER TABLE ONLY skill
    ADD CONSTRAINT skill_pkey PRIMARY KEY (id);


--
-- Name: student student_pkey; Type: CONSTRAINT; Schema: assign; Owner: postgres
--

ALTER TABLE ONLY student
    ADD CONSTRAINT student_pkey PRIMARY KEY (id);


--
-- Name: student project_fkey; Type: FK CONSTRAINT; Schema: assign; Owner: postgres
--

ALTER TABLE ONLY student
    ADD CONSTRAINT project_fkey FOREIGN KEY (projectid) REFERENCES project(id);


--
-- Name: projectskill project_fkey; Type: FK CONSTRAINT; Schema: assign; Owner: postgres
--

ALTER TABLE ONLY projectskill
    ADD CONSTRAINT project_fkey FOREIGN KEY (projectid) REFERENCES project(id);


--
-- Name: projectskill skill_fkey; Type: FK CONSTRAINT; Schema: assign; Owner: postgres
--

ALTER TABLE ONLY projectskill
    ADD CONSTRAINT skill_fkey FOREIGN KEY (skillid) REFERENCES skill(id);


--
-- Name: studentskill skill_fkey; Type: FK CONSTRAINT; Schema: assign; Owner: postgres
--

ALTER TABLE ONLY studentskill
    ADD CONSTRAINT skill_fkey FOREIGN KEY (skillid) REFERENCES skill(id);


--
-- Name: studentskill student_fkey; Type: FK CONSTRAINT; Schema: assign; Owner: postgres
--

ALTER TABLE ONLY studentskill
    ADD CONSTRAINT student_fkey FOREIGN KEY (studentid) REFERENCES student(id);


--
-- PostgreSQL database dump complete
--

