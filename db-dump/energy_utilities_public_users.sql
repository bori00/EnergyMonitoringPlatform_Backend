create table users
(
    id            bigint       not null
        constraint users_pkey
            primary key,
    email_address varchar(255) not null,
    password      varchar(255) not null,
    user_name     varchar(255) not null
);

alter table users
    owner to postgres;

INSERT INTO public.users (id, email_address, password, user_name) VALUES (25, 'admin1@a.com', '$2a$10$2KplinZnNnABPQnDkbvM7Om33xuNyhONXW55Fz0XTBaBwaEjbnMkO', 'admin1');
INSERT INTO public.users (id, email_address, password, user_name) VALUES (26, 'client1@c.com', '$2a$10$8yINJCz1SdTlSsUJmiyw2eQdkIIy7NQppOf/EjqVcx3yKu0b9Fe3C', 'client1');
INSERT INTO public.users (id, email_address, password, user_name) VALUES (27, 'client2@c.com', '$2a$10$trX3YJd6Kmr9uMVageBb1eVCOqBHAx6QvDMLuqFNS/Z700tnYetPS', 'client2');
INSERT INTO public.users (id, email_address, password, user_name) VALUES (28, 'michael@gmail.com', '$2a$10$CWcqbd.qfs3mwH4NDHGhKuRN/e0C2ng2dL7VS8.RnqYKRbxPCZW1.', 'client3');
INSERT INTO public.users (id, email_address, password, user_name) VALUES (29, 'michael@gmail.com', '$2a$10$reRLKogNsbZejG2hbow9N./hp/VFbRgqVQzGb2jorW6CurgHUi8IG', 'client4');
INSERT INTO public.users (id, email_address, password, user_name) VALUES (30, 'michael@gmail.com', '$2a$10$FDc5jrUtCYVk/YdQv6tTPO7/mmBBaQVDIVMU23u3HA8XhZbhUv3xO', 'client5');
INSERT INTO public.users (id, email_address, password, user_name) VALUES (31, 'a2@g.com', '$2a$10$WpqUvOGiSOixH/SAFY34GuC1DKb0v9euTHVu9/0x.mLNM/fYWjDVS', 'admin2');
INSERT INTO public.users (id, email_address, password, user_name) VALUES (32, 'a3@g.com', '$2a$10$zT3M6ijIA6w092tnsXB19.SaLfjA7S8kbdBbQ6Myse2jhZpKyQxBq', 'admin3');