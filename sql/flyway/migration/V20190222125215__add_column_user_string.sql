alter table service add column user_string varchar(50);

update service set user_string = 'PREPEND';
update service set user_string = 'POSTPEND' where service = 'Komoot';

alter table service add constraint user_string_ck check (user_string in ('PREPEND', 'POSTPEND'));

