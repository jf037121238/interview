create table user_service_route (
  user_id int4 not null references users(user_id),
  service_route_id int4 not null references service_route(service_route_id)
);