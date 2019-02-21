create sequence route_seq start with 100;
create table route (
  route_id int4 not null primary key default nextval('route_seq'),
  route text
);

