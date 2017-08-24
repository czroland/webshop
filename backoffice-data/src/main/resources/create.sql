INSERT INTO public.users(id, username, fullName, email, phone, password) VALUES (-1, 'proba','J. DOE','jdoe@g.asd', '0000','$2a$10$N4rOzufDNCMGWZtyaNoM4ud.7CWRFtEIXirRlDKOf.hIauBeGErXq');
INSERT INTO public.users(id, username, fullName, email, phone, password) VALUES (-2, 'proba2','J. DOE','jdoe@g.asd', '0000','$2a$10$N4rOzufDNCMGWZtyaNoM4ud.7CWRFtEIXirRlDKOf.hIauBeGErXq');

INSERT INTO public.addresses(id, zipcode, city, street, number) VALUES (-1, 'zc','da','ct','1');
INSERT INTO public.addresses(id, zipcode, city, street, number) VALUES (-2, 'zc','da','ct','2');
INSERT INTO public.agents(id, user_id) VALUES (-1, -1);
INSERT INTO public.agents(id, user_id) VALUES (-2, -2);

INSERT INTO public.roles(id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO public.roles(id, name) VALUES (2, 'ROLE_USER');
INSERT INTO public.agents_roles(agententity_id, roles_id) VALUES (-1, 2);
INSERT INTO public.customers(id, role, billing_address_id, delivery_address_id, user_id) VALUES (-1,'ROLE_USER', -1,-1,-1);

INSERT INTO public.categories(id, name) VALUES (-1, 'gyumolcs');
INSERT INTO public.categories(id, name) VALUES (-2, 'zoldseg');

INSERT INTO public.subcategories(id, name, category_id) VALUES (-1, 'alma',-1);
INSERT INTO public.subcategories(id, name, category_id) VALUES (-2, 'korte',-1);
INSERT INTO public.subcategories(id, name, category_id) VALUES (-3, 'paradicsom',-2);


