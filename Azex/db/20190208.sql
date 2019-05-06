select * from azex_user;

select * from role;

insert into role(id, name, status) values(nextval('role_seq'), 'CUSTOMER', 1);

insert into role(id, name, status) values(nextval('role_seq'), 'ADMIN', 1);

insert into role(id, name, status) values(nextval('role_seq'), 'MODERATOR', 1);

insert into role(id, name, status) values(nextval('role_seq'), 'STOCK_FOREIGN', 1);

insert into role(id, name, status) values(nextval('role_seq'), 'STOCK_LOCAL', 1);

insert into role(id, name, status) values(nextval('role_seq'), 'CASHIER', 1);

select * from user_role;

update user_role
set status = 0
where  id = 1;

insert into user_role(id, user_id, role_id, status)
values(nextval('user_role_seq'), 1, 2, 1);


select u.id, u.email, u.name, u.surname, ur.role_id, r.name
from azex_user u join user_role ur on u.id = ur.user_id and ur.status = 1
	join role r on r.id = ur.role_id and r.status = 1
where u.id = 1;


select * from customer;