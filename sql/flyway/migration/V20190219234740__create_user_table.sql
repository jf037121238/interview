create sequence users_seq;
create table users (
  user_id int4 not null primary key default nextval('users_seq'),
  user_name text
);
