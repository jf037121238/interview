create sequence service_route_id_seq start with 100;
create table service_route (
  service_route_id int4 not null primary key default nextval('service_route_id_seq'),
  service_id int4 not null references service(service_id),
  route_id int4 not null references route(route_id)
);



