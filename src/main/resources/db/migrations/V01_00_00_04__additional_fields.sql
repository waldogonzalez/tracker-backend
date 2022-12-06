alter table device
    add column if not exists battery numeric default 0;

alter table decoded_payload
    add column if not exists beacon_name text;

create table if not exists beacon_uuid_map
(
    id   serial primary key,
    uuid text,
    name text
);
