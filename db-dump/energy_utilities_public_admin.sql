create table admin
(
    id bigint not null
        constraint admin_pkey
            primary key
        constraint fkqer4e53tfnl17s22ior7fcsv8
            references users
);

alter table admin
    owner to postgres;

INSERT INTO public.admin (id) VALUES (25);
INSERT INTO public.admin (id) VALUES (31);
INSERT INTO public.admin (id) VALUES (32);