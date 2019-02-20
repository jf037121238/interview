create table service_route (
  service_id int4 not null references service(service_id),
  route_id int4 not null references route(route_id),
  primary key (service_id, route_id)
);



