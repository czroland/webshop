INSERT INTO public.users(id, username, fullName, email, phone, password) VALUES (-1, 'proba','J. DOE','jdoe@g.asd', '0000','$2a$10$N4rOzufDNCMGWZtyaNoM4ud.7CWRFtEIXirRlDKOf.hIauBeGErXq');
INSERT INTO public.users(id, username, fullName, email, phone, password) VALUES (-2, 'proba2','J. DOE','jdoe@g.asd', '0000','$2a$10$N4rOzufDNCMGWZtyaNoM4ud.7CWRFtEIXirRlDKOf.hIauBeGErXq');

INSERT INTO public.addresses(id, zipcode, city, street, number) VALUES (-1, 'zc','da','ct','1');
INSERT INTO public.addresses(id, zipcode, city, street, number) VALUES (-2, 'zc','da','ct','2');
INSERT INTO public.agents(id, user_id) VALUES (-1, -1);
INSERT INTO public.agents(id, user_id) VALUES (-2, -2);

INSERT INTO public.roles(id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO public.roles(id, name) VALUES (2, 'ROLE_USER');
INSERT INTO public.agents_roles(agententity_id, roles_id) VALUES (-1, 2);

INSERT INTO public.categories(id, name) VALUES (-1, 'Action Figures');
INSERT INTO public.categories(id, name) VALUES (-2, 'Building Sets & Blocks');
INSERT INTO public.categories(id, name) VALUES (-3, 'Collector Toys');
INSERT INTO public.categories(id, name) VALUES (-4, 'Arts & Crafts');
INSERT INTO public.categories(id, name) VALUES (-5, 'Dolls');
INSERT INTO public.categories(id, name) VALUES (-6, 'DVDs');
INSERT INTO public.categories(id, name) VALUES (-7, 'Games');
INSERT INTO public.categories(id, name) VALUES (-8, 'Mini Figures');
INSERT INTO public.categories(id, name) VALUES (-9, 'Outdoor Toys');

INSERT INTO public.subcategories(id, name, category_id) VALUES (-1, 'DC Universe',-1);
INSERT INTO public.subcategories(id, name, category_id) VALUES (-2, 'Marvel Universe',-1);
INSERT INTO public.subcategories(id, name, category_id) VALUES (-3, 'Mega Bloks',-2);
INSERT INTO public.subcategories(id, name, category_id) VALUES (-4, 'Minecraft',-2);
INSERT INTO public.subcategories(id, name, category_id) VALUES (-5, 'Masters of the Universe',-3);
INSERT INTO public.subcategories(id, name, category_id) VALUES (-6, 'Disney Cars',-3);
INSERT INTO public.subcategories(id, name, category_id) VALUES (-7, 'Rose Art',-4);
INSERT INTO public.subcategories(id, name, category_id) VALUES (-8, 'Barbie',-4);
INSERT INTO public.subcategories(id, name, category_id) VALUES (-9, 'DC SuperHero Girls',-5);
INSERT INTO public.subcategories(id, name, category_id) VALUES (-10, 'Barbi Signature',-5);
INSERT INTO public.subcategories(id, name, category_id) VALUES (-11, 'Barbie movies',-6);
INSERT INTO public.subcategories(id, name, category_id) VALUES (-12, 'Monster High movies',-6);
INSERT INTO public.subcategories(id, name, category_id) VALUES (-13, 'Family Games',-7);
INSERT INTO public.subcategories(id, name, category_id) VALUES (-14, 'Adult & Party Games',-7);
INSERT INTO public.subcategories(id, name, category_id) VALUES (-15, 'My Mini Mixies',-8);
INSERT INTO public.subcategories(id, name, category_id) VALUES (-16, 'Ghostbusters',-8);
INSERT INTO public.subcategories(id, name, category_id) VALUES (-17, 'Hot Wheels',-9);
INSERT INTO public.subcategories(id, name, category_id) VALUES (-18, 'Tyco RC',-9);

INSERT INTO public.products(id,description, name, number, category_id, sub_category_id, price) VALUES (-1,'schőn product','product','123',-1,-1, 5);
INSERT INTO public.products(id,description, name, number, category_id, sub_category_id, price) VALUES (-2,'schőn product2','product2','321',-2,-1, 78);

INSERT INTO public.products_images(id,name,root,product_id) VALUES (-1,'image','root',-1);
INSERT INTO public.products_images(id,name,root,product_id) VALUES (-2,'image2','root2',-2);
INSERT INTO public.carts(id) VALUES (-1);
INSERT INTO public.customers(id, role, billing_address_id, delivery_address_id, user_id, cart_id) VALUES (-1,'ROLE_USER', -1,-1,-1,-1);
INSERT INTO public.carts_products(cartentity_id, products_id) VALUES (-1, -2);
INSERT INTO public.orders(id, issuccess, price, senddate, customer_id) VALUES (-1, false, 5, '2050-05-09', -1);
INSERT INTO public.orders_products(orderentity_id,products_id) VALUES (-1,-1);
INSERT INTO public.customers_orders(customerentity_id, orders_id) VALUES (-1,-1);


