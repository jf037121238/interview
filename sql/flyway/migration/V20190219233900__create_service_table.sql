create sequence service_seq start with 100;
create table service (
  service_id int4 not null primary key default nextval('service_seq'),
  service varchar(255) unique not null
);
