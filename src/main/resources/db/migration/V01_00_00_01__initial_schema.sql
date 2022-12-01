create table "user"
(
    id         serial primary key,
    name       text not null,
    password   text not null,
    created_by text,
    created_at timestamp,
    updated_by text,
    updated_at timestamp,
    deleted    boolean
);

create unique index uidx_user_name
    on "user" (name);

create table user_role
(
    id      serial primary key,
    user_id bigint
        constraint fk_user_role_user references "user" (id),
    name    text
);

INSERT INTO "user"
(id, "name", "password", created_by, created_at, deleted)
VALUES (-1, 'admin', '$2a$10$lTWBXf5oAXSNUUWldDMDIe3dx4Rs.0/wjYOeW9TDnuznJqchzHAN2', 'anonymousUser',
        '2021-11-19 09:28:51.868', false);
