INSERT INTO flightreservation.role (`name`) VALUES ('ROLE_ADMIN');
INSERT INTO flightreservation.role (`name`) VALUES ('ROLE_PASSENGER');
INSERT INTO flightreservation.role (`name`) VALUES ('ROLE_AGENT');

INSERT INTO flightreservation.airline (id, code,`name`) VALUES (2,'GN','135 Airways');
INSERT INTO flightreservation.airline (id, code,`name`) VALUES (3,'RN','1Time Airline');
INSERT INTO flightreservation.airline (id, code,`name`) VALUES (4,'WY','2 Sqn No 1 Elementary Flying Training School');
INSERT INTO flightreservation.airline (id, code,`name`) VALUES (5,'TF','213 Flight Unit');
INSERT INTO flightreservation.airline (id, code,`name`) VALUES (6,'CH','223 Flight Unit State Airline');
INSERT INTO flightreservation.airline (id, code,`name`) VALUES (7,'TT','224th Flight Unit');
INSERT INTO flightreservation.airline (id, code,`name`) VALUES (8,'TW','247 Jet Ltd');
INSERT INTO flightreservation.airline (id, code,`name`) VALUES (9,'SE','3D Aviation');
INSERT INTO flightreservation.airline (id, code,`name`) VALUES (10,'ML','40-Mile Air');
INSERT INTO flightreservation.airline (id, code,`name`) VALUES (11,'QR','4D Air');
INSERT INTO flightreservation.airline (id, code,`name`) VALUES (12,'TH','611897 Alberta Limited');
INSERT INTO flightreservation.airline (id, code,`name`) VALUES (13,'AA','Ansett Australia');
INSERT INTO flightreservation.airline (id, code,`name`) VALUES (14,'AI','Abacus International');
INSERT INTO flightreservation.airline (id, code,`name`) VALUES (15,'A2','Abelag Aviation');
INSERT INTO flightreservation.airline (id, code,`name`) VALUES (16,'AA','Army Air Corps');
INSERT INTO flightreservation.airline (id, code,`name`) VALUES (17,'A3','Aero Aviation Centre Ltd.');
INSERT INTO flightreservation.airline (id, code,`name`) VALUES (18,'SI','Aero Servicios Ejecutivos Internacionales');
INSERT INTO flightreservation.airline (id, code,`name`) VALUES (19,'BZ','Aero Biniza');

INSERT INTO flightreservation.airport (id, city,`state`,street,zip,code,`name`) VALUES (2,'Madang','kentucky','kjh',9865,'MAG','Madang');
INSERT INTO flightreservation.airport (id, city,`state`,street,zip,code,`name`) VALUES (3,'Mount Hagen','new york','rty',5678,'HGU','Mount Hagen');
INSERT INTO flightreservation.airport (id, city,`state`,street,zip,code,`name`) VALUES (4,'Nadzab','washington','tyty',3452,'LAE','Nadzab');
INSERT INTO flightreservation.airport (id, city,`state`,street,zip,code,`name`) VALUES (5,'Port Moresby','Illinois','khgfg',6542,'POM','Port Moresby Jacksons Intl');
INSERT INTO flightreservation.airport (id, city,`state`,street,zip,code,`name`) VALUES (6,'Wewak','Iowa','sdf',8975,'WWK','Wewak Intl');
INSERT INTO flightreservation.airport (id, city,`state`,street,zip,code,`name`) VALUES (7,'Narssarssuaq','Texas','rty',3134,'UAK','Narsarsuaq');
INSERT INTO flightreservation.airport (id, city,`state`,street,zip,code,`name`) VALUES (8,'Godthaab','Chicago','tyr',1556,'GOH','Nuuk');
INSERT INTO flightreservation.airport (id, city,`state`,street,zip,code,`name`) VALUES (9,'Sondrestrom','Michigan','hfds',6745,'SFJ','Sondre Stromfjord');
INSERT INTO flightreservation.airport (id, city,`state`,street,zip,code,`name`) VALUES (10,'Thule','California','ghj',6787,'THU','Thule Air Base');
INSERT INTO flightreservation.airport (id, city,`state`,street,zip,code,`name`) VALUES (11,'Akureyri','Florida','mf',2234,'AEY','Akureyri');
INSERT INTO flightreservation.airport (id, city,`state`,street,zip,code,`name`) VALUES (12,'Egilsstadir','Boston','hyuk',1111,'EGS','Egilsstadir');
INSERT INTO flightreservation.airport (id, city,`state`,street,zip,code,`name`) VALUES (13,'Hofn','North Carolina','sdf',2222,'HFN','Hornafjordur');
INSERT INTO flightreservation.airport (id, city,`state`,street,zip,code,`name`) VALUES (14,'Husavik','South Carolina','rty',3333,'HZK','Husavik');
INSERT INTO flightreservation.airport (id, city,`state`,street,zip,code,`name`) VALUES (15,'Isafjordur','Misourie','vbn',4444,'IFJ','Isafjordur');
INSERT INTO flightreservation.airport (id, city,`state`,street,zip,code,`name`) VALUES (16,'Keflavik','Alaska','qwe',5555,'KEF','Keflavik International Airport');
INSERT INTO flightreservation.airport (id, city,`state`,street,zip,code,`name`) VALUES (17,'Patreksfjordur','Nebraska','jkli',6666,'PFJ','Patreksfjordur');
INSERT INTO flightreservation.airport (id, city,`state`,street,zip,code,`name`) VALUES (18,'Reykjavik','Arizona','fghj',7777,'RKV','Reykjavik');
INSERT INTO flightreservation.airport (id, city,`state`,street,zip,code,`name`) VALUES (19,'Siglufjordur','Colorado','rty',8888,'SIJ','Siglufjordur');
INSERT INTO flightreservation.airport (id, city,`state`,street,zip,code,`name`) VALUES (20,'Vestmannaeyjar','Minnesota','hjn',9999,'VEY','Vestmannaeyjar');

INSERT INTO flightreservation.airline_history (history,id) VALUES ('United States',2);
INSERT INTO flightreservation.airline_history (history,id) VALUES ('South Africa',3);
INSERT INTO flightreservation.airline_history (history,id) VALUES ('United Kingdom',4);
INSERT INTO flightreservation.airline_history (history,id) VALUES ('Russia',5);
INSERT INTO flightreservation.airline_history (history,id) VALUES ('Russia',6);
INSERT INTO flightreservation.airline_history (history,id) VALUES ('Russia',7);
INSERT INTO flightreservation.airline_history (history,id) VALUES ('United Kingdom',8);
INSERT INTO flightreservation.airline_history (history,id) VALUES ('United States',9);
INSERT INTO flightreservation.airline_history (history,id) VALUES ('United States',10);
INSERT INTO flightreservation.airline_history (history,id) VALUES ('Thailand',11);
INSERT INTO flightreservation.airline_history (history,id) VALUES ('Canada',12);
INSERT INTO flightreservation.airline_history (history,id) VALUES ('Australia',13);
INSERT INTO flightreservation.airline_history (history,id) VALUES ('Singapore',14);
INSERT INTO flightreservation.airline_history (history,id) VALUES ('Belgium',15);
INSERT INTO flightreservation.airline_history (history,id) VALUES ('United Kingdom',16);
INSERT INTO flightreservation.airline_history (history,id) VALUES ('Canada',17);
INSERT INTO flightreservation.airline_history (history,id) VALUES ('Mexico',18);
INSERT INTO flightreservation.airline_history (history,id) VALUES ('Mexico',19);

INSERT INTO flightReservation.Flight (id, arrivalTime, capacity, departureTime, flightNumber, arrival_id, departure_id, operateBy_id) VALUES (1, '2021-10-03 11:30:00', 100, '2021-10-03 10:00:00', 'RNX213', 3, 2, 3);
INSERT INTO flightReservation.Flight (id, arrivalTime, capacity, departureTime, flightNumber, arrival_id, departure_id, operateBy_id) VALUES (2, '2021-10-03 11:30:00', 100, '2021-10-03 10:00:00', 'RNX212', 3, 2, 3);

INSERT INTO flightReservation.Person (id, birthDate, email, firstName, lastName, city, state, street, zip) VALUES (1, null, 'admin@miu.edu', 'admin', 'ONE', null, null, null, null);
INSERT INTO flightReservation.Person (id, birthDate, email, firstName, lastName, city, state, street, zip) VALUES (2, null, 'pass@miu.edu', 'jorge', 'ONE', null, null, null, null);
INSERT INTO flightReservation.Person (id, birthDate, email, firstName, lastName, city, state, street, zip) VALUES (3, null, 'henok@miu.edu', 'Henok', 'Pass', '', '', '', '');
INSERT INTO flightReservation.Person (id, birthDate, email, firstName, lastName, city, state, street, zip) VALUES (4, null, 'passenger@miu.edu', 'henok', 'ONE', null, null, null, null);
INSERT INTO flightReservation.Person (id, birthDate, email, firstName, lastName, city, state, street, zip) VALUES (6, null, 'email@miu.edu', 'Henok', 'Pass', '', '', '', '');
INSERT INTO flightReservation.Person (id, birthDate, email, firstName, lastName, city, state, street, zip) VALUES (7, null, 'seb@miu.edu', 'Sebastian', 'Pass', '', '', '', '');
INSERT INTO flightReservation.Person (id, birthDate, email, firstName, lastName, city, state, street, zip) VALUES (9, null, 'kato@miu.edu', 'kato', 'ONE', null, null, null, null);
INSERT INTO flightReservation.Person (id, birthDate, email, firstName, lastName, city, state, street, zip) VALUES (10, null, 'alvin@miu.edu', 'Alvin', 'Pass', '', '', '', '');

INSERT INTO flightReservation.UserCredentials (id, password, username, role_id) VALUES (1, '$2a$10$kOMQ/peuZ4SU8YAslTMg6e0E612KucH.Rl7JQPqymb/7Crvq8k2TC', 'admin', 1);
INSERT INTO flightReservation.UserCredentials (id, password, username, role_id) VALUES (2, '$2a$10$Rwis9weNh1hmxlY3IplC8.GeLrnctW4lRt9FxCoXuPgQ67gSj.P9e', 'passenger', 3);
INSERT INTO flightReservation.UserCredentials (id, password, username, role_id) VALUES (3, '$2a$10$qv6ETf41GwqHmXKFfam7jeyPTXOExRP2fXeJF2.LCnXKjlJWhz/zO', 'henok', 2);
INSERT INTO flightReservation.UserCredentials (id, password, username, role_id) VALUES (4, '$2a$10$0od2RGRnB6i23OsAmd2MD.L5mKHW8ojKsgouFqSmjoWNQYqYn21WG', 'kato', 3);

INSERT INTO flightReservation.user_person (person_id, id) VALUES (1, 1);
INSERT INTO flightReservation.user_person (person_id, id) VALUES (2, 2);
INSERT INTO flightReservation.user_person (person_id, id) VALUES (4, 3);
INSERT INTO flightReservation.user_person (person_id, id) VALUES (9, 4);




