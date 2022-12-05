-- Table: public.topic

-- DROP TABLE IF EXISTS public.topic;

CREATE TABLE IF NOT EXISTS public.topic
(
    id SERIAL NOT NULL,
    topic VARCHAR,
    CONSTRAINT topic_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.topic
    OWNER to postgres;

-- Table: public.utilisateur

-- DROP TABLE IF EXISTS public."utilisateur";

CREATE TABLE IF NOT EXISTS public."utilisateur"
(
    id SERIAL NOT NULL,
    name VARCHAR,
    CONSTRAINT pk PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."utilisateur"
    OWNER to postgres;

-- Table: public.user_topic

-- DROP TABLE IF EXISTS public.user_topic;

CREATE TABLE IF NOT EXISTS public.user_topic
(
    id SERIAL NOT NULL,
    id_user integer NOT NULL,
    id_topic integer NOT NULL,
    CONSTRAINT user_topic_pkey PRIMARY KEY (id),
    CONSTRAINT user_topic_id_topic_fkey FOREIGN KEY (id_topic)
        REFERENCES public."topic" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT user_topic_id_user_fkey FOREIGN KEY (id_user)
        REFERENCES public."utilisateur" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.user_topic
    OWNER to postgres;

INSERT INTO topic (topic) VALUES ('savoie');

INSERT into utilisateur (name) VALUES ('expertsavoie');

INSERT INTO user_topic (id_user, id_topic) VALUES(1,1);