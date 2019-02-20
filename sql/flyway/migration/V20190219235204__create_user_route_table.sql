create table user_route (
  user_id int4 not null references users(user_id),
  route_id int4 not null references route(route_id)
);