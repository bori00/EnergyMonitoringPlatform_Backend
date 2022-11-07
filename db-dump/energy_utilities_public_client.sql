create table client
(
    id bigint not null
        constraint client_pkey
            primary key
        constraint fk70dfjxvqnmgixqht3vea50voj
            references users
);

alter table client
    owner to postgres;

INSERT INTO public.client (id) VALUES (26);
INSERT INTO public.client (id) VALUES (27);
INSERT INTO public.client (id) VALUES (28);
INSERT INTO public.client (id) VALUES (29);
INSERT INTO public.client (id) VALUES (30);