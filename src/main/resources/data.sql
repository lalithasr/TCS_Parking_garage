INSERT into makes (name)  VALUES ('chrysler');
INSERT into makes (name)  VALUES ('honda');
INSERT into makes (name)  VALUES ('mercedes-benz');
INSERT into makes (name)  VALUES ('ram');
INSERT into makes (name)  VALUES ('ford');
INSERT into makes (name)  VALUES ('gmc');
INSERT into makes (name)  VALUES ('audi');
INSERT into makes (name)  VALUES ('subaru');
INSERT into makes (name)  VALUES ('rolls-royce');
INSERT into makes (name)  VALUES ('porsche');
INSERT into makes (name)  VALUES ('bmw');
INSERT into makes (name)  VALUES ('volvo');
INSERT into makes (name)  VALUES ('lincoln');
INSERT into makes (name)  VALUES ('maserati');
INSERT into makes (name)  VALUES ('acura');
INSERT into makes (name)  VALUES ('mclaren');
INSERT into makes (name)  VALUES ('infiniti');
INSERT into makes (name)  VALUES ('fiat');
INSERT into makes (name)  VALUES ('scion');
INSERT into makes (name)  VALUES ('dodge');
INSERT into makes (name)  VALUES ('bently');
INSERT into makes (name)  VALUES ('aston-martin');
INSERT into makes (name)  VALUES ('chevrolet');
INSERT into makes (name)  VALUES ('land-rover');
INSERT into makes (name)  VALUES ('mitsubishi');
INSERT into makes (name)  VALUES ('volkswagon');
INSERT into makes (name)  VALUES ('toyota');
INSERT into makes (name)  VALUES ('jeep');
INSERT into makes (name)  VALUES ('hyundai');
INSERT into makes (name)  VALUES ('cadillac');
INSERT into makes (name)  VALUES ('lamborghini');
INSERT into makes (name)  VALUES ('lexus');
INSERT into makes (name)  VALUES ('alfa-romeo');
INSERT into makes (name)  VALUES ('mini');
INSERT into makes (name)  VALUES ('kia');
INSERT into makes (name)  VALUES ('ferrari');
INSERT into makes (name)  VALUES ('mazda');
INSERT into makes (name)  VALUES ('nissan');
INSERT into makes (name)  VALUES ('buick');
INSERT into makes (name)  VALUES ('jaguar');

-- Roles
INSERT INTO roles(name) VALUES ( 'admin' );
INSERT INTO roles(name) VALUES ( 'customer' );

-- Users
INSERT INTO users (first_name, last_name, username, email, password)
values ('John', 'Doe', 'jdoe','john.doe@example.com', 'test');
INSERT INTO users (first_name, last_name, username, email, password)
values ('Jane', 'Parker', 'jparker','jane.parker@example.com', 'test');

-- User Roles
INSERT INTO user_roles (USER_ID, ROLE_ID) VALUES ( 1, 1 );
INSERT INTO user_roles (USER_ID, ROLE_ID) VALUES ( 1, 2 );
INSERT INTO user_roles (USER_ID, ROLE_ID) VALUES ( 2, 2 );

-- Garages
INSERT INTO garages (street, floors) values ('381 main street', 4);
INSERT INTO garages (street, floors) values ('481 main street', 5);
INSERT INTO garages (street, floors) values ('103 third street', 3);

-- Vehicles
INSERT INTO vehicles (MAKE_ID, LICENSE_PLATE, COLOR, USER_ID)
VALUES (36, 'IAMRICH', 'red', 2  );

-- Parking Spaces
INSERT INTO parking_spaces (GARAGE_ID, FLOOR, NUMBER, VEHICLE_ID)
VALUES ( 2, 1, 33, 1 );
