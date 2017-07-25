INSERT INTO public.users(id, username, fullName, email, phone, password) VALUES (-1, 'proba','J. DOE','jdoe@g.asd', '0000','1234');
INSERT INTO public.addresses(id, zipcode, city, street, number) VALUES (-1, 'zc','da','ct','1');
INSERT INTO public.addresses(id, zipcode, city, street, number) VALUES (-2, 'zc','da','ct','2');

INSERT INTO public.customers(id, billing_address_id, delivery_address_id, user_id) VALUES (-1, -1,-1,-1);