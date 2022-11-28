-- Table: public.topic

-- DROP TABLE IF EXISTS public.topic;

CREATE TABLE IF NOT EXISTS public.topic
(
    id integer NOT NULL,
    topic "char",
    CONSTRAINT topic_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.topic
    OWNER to postgres;

-- Table: public.user

-- DROP TABLE IF EXISTS public."user";

CREATE TABLE IF NOT EXISTS public."user"
(
    id integer NOT NULL,
    name "char",
    CONSTRAINT pk PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."user"
    OWNER to postgres;

-- Table: public.user_topic

-- DROP TABLE IF EXISTS public.user_topic;

CREATE TABLE IF NOT EXISTS public.user_topic
(
    id integer NOT NULL,
    id_user integer NOT NULL,
    id_topic integer NOT NULL,
    CONSTRAINT user_topic_pkey PRIMARY KEY (id_topic),
    CONSTRAINT user_topic_id_topic_fkey FOREIGN KEY (id_topic)
        REFERENCES public.topic (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT user_topic_id_user_fkey FOREIGN KEY (id_user)
        REFERENCES public."user" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.user_topic
    OWNER to postgres;