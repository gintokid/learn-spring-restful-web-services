insert into user_details(id, birth_date, name) values (10001, current_date(), 'Awa');
insert into user_details(id, birth_date, name) values (10002, current_date(), 'Adama');
insert into user_details(id, birth_date, name) values (10003, current_date(), 'Aminouche');
insert into user_details(id, birth_date, name) values (10004, current_date(), 'Mayssou');

insert into post(id, description, user_id) values (20001, 'I want to learn Spring', 10001);
insert into post(id, description, user_id) values (20002, 'I want to learn AWS', 10001);
insert into post(id, description, user_id) values (20003, 'I want to learn GCP', 10002);
insert into post(id, description, user_id) values (20004, 'I want to learn DevOps', 10003);
