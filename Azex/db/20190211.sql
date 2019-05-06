select id, name from flexible_list;

select * from flexible_list_item;

insert into flexible_list(id, name, status)
values(nextval('flexible_list_seq'), 'acquisition_channel', 1);

insert into flexible_list_item(id, list_id, value_id, value_name, insert_date, status)
values(nextval('flexible_list_item_seq'), 1, 1, 'Dost mesleheti', current_timestamp, 1);

select fl.id, fl.name, fli.id, fli.value_id, fli.value_name, fli.insert_date
from flexible_list fl join flexible_list_item fli on fl.id = fli.list_id
	and fl.status = 1 and fli.status = 1
where fl.id = 1
order by fli.value_id


insert into flexible_list_item(id, list_id, value_id, value_name, insert_date, status)
values(nextval('flexible_list_item_seq'), 1, 2, 'Facebook', current_timestamp, 1);


insert into flexible_list_item(id, list_id, value_id, value_name, insert_date, status)
values(nextval('flexible_list_item_seq'), 1, 3, 'Instagram', current_timestamp, 1);


insert into flexible_list_item(id, list_id, value_id, value_name, insert_date, status)
values(nextval('flexible_list_item_seq'), 1, 4, 'Axtaris sistemleri', current_timestamp, 1);


insert into flexible_list_item(id, list_id, value_id, value_name, insert_date, status)
values(nextval('flexible_list_item_seq'), 1, 5, 'TV', current_timestamp, 1);


insert into flexible_list_item(id, list_id, value_id, value_name, insert_date, status)
values(nextval('flexible_list_item_seq'), 1, 6, 'Radio', current_timestamp, 1);


insert into flexible_list_item(id, list_id, value_id, value_name, insert_date, status)
values(nextval('flexible_list_item_seq'), 1, 7, 'Diger', current_timestamp, 1);


select id, name from flexible_list
where name = 'acquisition_channel' and status = 1