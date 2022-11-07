create table measurement
(
    id                 bigint           not null
        constraint measurement_pkey
            primary key,
    datetime           timestamp        not null,
    energy_consumption double precision not null,
    device_id          bigint           not null
        constraint fkfk341lu27m89eohc71wnwf8bt
            references device
);

alter table measurement
    owner to postgres;

INSERT INTO public.measurement (id, datetime, energy_consumption, device_id) VALUES (1, '2022-11-08 01:36:45.000000', 10, 34);
INSERT INTO public.measurement (id, datetime, energy_consumption, device_id) VALUES (2, '2022-11-08 03:36:58.000000', 12, 34);
INSERT INTO public.measurement (id, datetime, energy_consumption, device_id) VALUES (3, '2022-11-08 04:37:10.000000', 13, 34);
INSERT INTO public.measurement (id, datetime, energy_consumption, device_id) VALUES (4, '2022-11-08 05:39:03.000000', 12, 34);
INSERT INTO public.measurement (id, datetime, energy_consumption, device_id) VALUES (5, '2022-11-08 06:39:09.000000', 9, 34);
INSERT INTO public.measurement (id, datetime, energy_consumption, device_id) VALUES (6, '2022-11-08 07:39:22.000000', 10, 34);
INSERT INTO public.measurement (id, datetime, energy_consumption, device_id) VALUES (7, '2022-11-08 12:40:03.000000', 8, 34);
INSERT INTO public.measurement (id, datetime, energy_consumption, device_id) VALUES (8, '2022-11-09 01:40:16.000000', 5, 34);
INSERT INTO public.measurement (id, datetime, energy_consumption, device_id) VALUES (9, '2022-11-09 02:40:33.000000', 6, 34);
INSERT INTO public.measurement (id, datetime, energy_consumption, device_id) VALUES (10, '2022-11-09 03:40:49.000000', 11, 34);
INSERT INTO public.measurement (id, datetime, energy_consumption, device_id) VALUES (11, '2022-11-08 01:41:53.000000', 26, 36);
INSERT INTO public.measurement (id, datetime, energy_consumption, device_id) VALUES (12, '2022-11-08 03:42:04.000000', 29, 36);