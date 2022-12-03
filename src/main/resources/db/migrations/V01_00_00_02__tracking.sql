create table if not exists decoded_payload
(
    id         serial primary key,
    raw        text,
    addr       text,
    alarm      bigint,
    batV       numeric,
    major      bigint,
    minor      bigint,
    rssi       bigint,
    step_count bigint,
    uuid       text,
    device_id  text,
    ts         timestamp,
    created_at timestamp,
    created_by text
);
