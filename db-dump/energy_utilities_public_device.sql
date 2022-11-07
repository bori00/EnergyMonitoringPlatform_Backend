create table device
(
    id        bigint       not null
        constraint device_pkey
            primary key,
    name      varchar(255) not null,
    client_id bigint       not null
        constraint fkdu2w3cqp9s5nydbum1dkl1wcb
            references client
);

alter table device
    owner to postgres;

INSERT INTO public.device (id, name, client_id) VALUES (34, 'Lamp1', 26);
INSERT INTO public.device (id, name, client_id) VALUES (35, 'Lamp2', 27);
INSERT INTO public.device (id, name, client_id) VALUES (36, 'Switch1', 26);
INSERT INTO public.device (id, name, client_id) VALUES (37, 'Switch2', 26);
INSERT INTO public.device (id, name, client_id) VALUES (38, 'Switch3', 28);
INSERT INTO public.device (id, name, client_id) VALUES (33, 'Lamp1', 26);