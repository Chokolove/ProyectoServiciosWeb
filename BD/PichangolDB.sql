DROP DATABASE IF EXISTS Pichangol;

CREATE DATABASE Pichangol;

USE Pichangol;


CREATE TABLE IF NOT EXISTS Account(
id int auto_increment  not null,
password varchar(70) not null,
confirmedAt datetime not null,
lockedAt datetime null,
lastLogin datetime null,
PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS Partner(
id int auto_increment  not null,
accountId int not null,
firstName varchar(255) not null,
lastName varchar(255) not null,
createdAt datetime not null,
PRIMARY KEY (id),
FOREIGN KEY (accountId) REFERENCES Account(id)
);





CREATE TABLE IF NOT EXISTS `Local`(
id int auto_increment  not null,
partnerId int not null,
name varchar(255) not null,
description varchar(255) not null,
address varchar(255) not null,
latitude float not null,
longitude float not null,
anticipation int not null,
created_at datetime default now(),
deleted_at datetime null,
status char(1) not null,
PRIMARY KEY (id),
FOREIGN KEY (partnerId) REFERENCES Partner(id)
);


CREATE TABLE IF NOT EXISTS LocalWorkingWeekDay(
id int auto_increment  not null,
localId int not null,
`day` char(1) not null,
`start` int not null,
`end` int not null,
createdAt datetime null,
PRIMARY KEY (id),
FOREIGN KEY (localId) REFERENCES `Local`(id)
);

CREATE TABLE IF NOT EXISTS LocalNonWorkingDay(
id int auto_increment  not null,
localId int not null,
`date` date not null,
reason varchar(500) null,
createdAt datetime null,
PRIMARY KEY (id),
FOREIGN KEY (localId) REFERENCES `Local`(id)
);


CREATE TABLE IF NOT EXISTS SoccerField(
id int auto_increment  not null,
localId int not null,
description varchar(255) not null,
price decimal(6,2) not null,
createdAt datetime null,
deletedAt datetime null,
PRIMARY KEY (id),
FOREIGN KEY (localId) REFERENCES `Local`(id)
);

CREATE TABLE IF NOT EXISTS SoccesFieldPhoto(
id int auto_increment  not null,
soccerFieldId int not null,
photoUrl varchar(255) not null,
description varchar(255) not null,
PRIMARY KEY (id),
FOREIGN KEY (soccerFieldId) REFERENCES SoccerField(id)
);


CREATE TABLE IF NOT EXISTS SoccerFieldMaintenance(
id int auto_increment  not null,
soccerFieldId int not null,
`date` date not null,
`start` int not null,
`end` int not null,
createdAt datetime null,
PRIMARY KEY (id),
FOREIGN KEY (soccerFieldId) REFERENCES SoccerField(id)
);

CREATE TABLE IF NOT EXISTS Guest(
id int auto_increment  not null,
firstName varchar(255) not null,
lastName varchar(255) not null,
phone varchar(255) not null,
email varchar(255) not null,
createdAt datetime null,
PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Customer(
id int auto_increment  not null,
accountId int not null,
firstName varchar(255) not null,
lastName varchar(255) not null,
birthday date not null,
phone varchar(255) not null,
email varchar(255) not null,
createdAt datetime null,
PRIMARY KEY (id),
FOREIGN KEY (accountId) REFERENCES Account(id)
);

CREATE TABLE IF NOT EXISTS Reservation(
id int auto_increment  not null,
soccerFieldId int not null,
reserverId int not null,
reserverType varchar(255) not null,
`date` date not null,
`start` int not null,
`end` int not null,
chargeId int not null,
chargeAmount decimal(6,2) not null,
createdAt datetime null,
PRIMARY KEY (id),
FOREIGN KEY (soccerFieldId) REFERENCES SoccerField(id)
);


CREATE TABLE IF NOT EXISTS Review(
id int auto_increment not null,
customerId int not null,
localId int not null,
stars int not null,
commentary varchar(400) not null,
PRIMARY KEY (id),
FOREIGN KEY (accountId) REFERENCES Customer(id),
FOREIGN KEY (localId) REFERENCES `Local`(id)
);


INSERT INTO `Account` (`id`, `password`, `confirmedAt`, `lockedAt`, `lastLogin`) VALUES (NULL, 'asd', '2019-06-18 19:40:00', NULL, NULL);
INSERT INTO `Account` (`id`, `password`, `confirmedAt`, `lockedAt`, `lastLogin`) VALUES (NULL, 'zxc', '2019-06-18 19:40:00', NULL, NULL);
INSERT INTO `Account` (`id`, `password`, `confirmedAt`, `lockedAt`, `lastLogin`) VALUES (NULL, 'Contrasena', '2019-06-18 19:40:00', NULL, NULL);
INSERT INTO `Account` (`id`, `password`, `confirmedAt`, `lockedAt`, `lastLogin`) VALUES (NULL, 'admin', '2019-06-18 19:40:00', NULL, NULL);
INSERT INTO `Account` (`id`, `password`, `confirmedAt`, `lockedAt`, `lastLogin`) VALUES (NULL, 'cibertec', '2019-06-18 19:40:00', NULL, NULL);

INSERT INTO `Partner` (`id`, `accountId`, `firstName`, `lastName`, `createdAt`) VALUES (NULL, '1', 'Juan', 'Perez', '2019-06-18 19:41:00');
INSERT INTO `Partner` (`id`, `accountId`, `firstName`, `lastName`, `createdAt`) VALUES (NULL, '2', 'Sofia', 'Sanchez', '2019-06-18 19:41:00');
INSERT INTO `Partner` (`id`, `accountId`, `firstName`, `lastName`, `createdAt`) VALUES (NULL, '3', 'Jose', 'Atuncar', '2019-06-18 19:41:00');
INSERT INTO `Partner` (`id`, `accountId`, `firstName`, `lastName`, `createdAt`) VALUES (NULL, '4', 'Pedro', 'Ramos', '2019-06-18 19:41:00');
INSERT INTO `Partner` (`id`, `accountId`, `firstName`, `lastName`, `createdAt`) VALUES (NULL, '5', 'Jaze', 'Martinez', '2019-06-18 19:41:00');

/*Miraflores*/
INSERT INTO `Local` (`id`, `partnerId`, `name`, `description`, `address`, `latitude`, `longitude`, `anticipation`, `created_at`, `deleted_at`, `status`) VALUES (NULL, '1', 'Polideportivo Sede Norte', 'Campo de Futbol', 'Francisco de Paula Camino 220', '-12.120751', ' -77.032059', '0', CURRENT_TIMESTAMP, NULL, '1');
INSERT INTO `Local` (`id`, `partnerId`, `name`, `description`, `address`, `latitude`, `longitude`, `anticipation`, `created_at`, `deleted_at`, `status`) VALUES (NULL, '1', 'Polideportivo Sede Miraflores', 'Campo de Futbol', 'Calle Alcanfores 298', '-12.122534', '-77.027810', '0', CURRENT_TIMESTAMP, NULL, '1');
INSERT INTO `Local` (`id`, `partnerId`, `name`, `description`, `address`, `latitude`, `longitude`, `anticipation`, `created_at`, `deleted_at`, `status`) VALUES (NULL, '1', 'Complejo Deportivo "Chino" Vasquez', 'Campo de Futbol', 'Malecón de la Marina 9, Miraflores 15074', '-12.113770', '-77.049308', '0', CURRENT_TIMESTAMP, NULL, '1');
INSERT INTO `Local` (`id`, `partnerId`, `name`, `description`, `address`, `latitude`, `longitude`, `anticipation`, `created_at`, `deleted_at`, `status`) VALUES (NULL, '1', 'Futbol En Lima SAC - Campo San Jorge', 'Campo de Futbol', 'Genaro Castro Iglesias 360, Miraflores 15048', '-12.124061', '-77.013596', '0', CURRENT_TIMESTAMP, NULL, '1');

/*Surco*/
INSERT INTO `Local` (`id`, `partnerId`, `name`, `description`, `address`, `latitude`, `longitude`, `anticipation`, `created_at`, `deleted_at`, `status`) VALUES (NULL, '2', 'CANCHA LA 10', 'Campo de Futbol', 'Jr Doña Delmira 228, Santiago de Surco 15048', '-12.142015', '-77.005363', '0', CURRENT_TIMESTAMP, NULL, '1');
INSERT INTO `Local` (`id`, `partnerId`, `name`, `description`, `address`, `latitude`, `longitude`, `anticipation`, `created_at`, `deleted_at`, `status`) VALUES (NULL, '2', 'Cancha La Floresta', 'Campo de Futbol', 'Santiago de Surco 15049', '-12.137390', '-77.013885', '0', CURRENT_TIMESTAMP, NULL, '1');
INSERT INTO `Local` (`id`, `partnerId`, `name`, `description`, `address`, `latitude`, `longitude`, `anticipation`, `created_at`, `deleted_at`, `status`) VALUES (NULL, '2', 'Cancha de grass Surco', 'Campo de Futbol', 'Santiago de Surco 15048', '-12.133191', '-77.015355', '0', CURRENT_TIMESTAMP, NULL, '1');
INSERT INTO `Local` (`id`, `partnerId`, `name`, `description`, `address`, `latitude`, `longitude`, `anticipation`, `created_at`, `deleted_at`, `status`) VALUES (NULL, '2', 'Cancha De Futbol Surco', 'Campo de Futbol', 'Av Paseo de la Republica, Santiago de Surco 15048', '-12.142059', ' -77.002951', '0', CURRENT_TIMESTAMP, NULL, '1');
INSERT INTO `Local` (`id`, `partnerId`, `name`, `description`, `address`, `latitude`, `longitude`, `anticipation`, `created_at`, `deleted_at`, `status`) VALUES (NULL, '2', 'Fútbol Plaza', 'Campo de Futbol', 'Av. La República 110, Santiago de Surco 15023', '-12.099161', '-76.976202', '0', CURRENT_TIMESTAMP, NULL, '1');

/*Cercado de Lima*/
INSERT INTO `Local` (`id`, `partnerId`, `name`, `description`, `address`, `latitude`, `longitude`, `anticipation`, `created_at`, `deleted_at`, `status`) VALUES (NULL, '3', 'Cancha de Fútbol 6', 'Campo de Futbol', 'Jirón Rio Piura 481, Cercado de Lima 15021', '-12.122534', '-77.027810', '0', CURRENT_TIMESTAMP, NULL, '1');
INSERT INTO `Local` (`id`, `partnerId`, `name`, `description`, `address`, `latitude`, `longitude`, `anticipation`, `created_at`, `deleted_at`, `status`) VALUES (NULL, '3', 'Cancha de Fulbito El Fanático Fútbol Club', 'Campo de Futbol', 'Avenida Uruguay 191, Cercado de Lima 15001', '-12.122534', '-77.027810', '0', CURRENT_TIMESTAMP, NULL, '1');
INSERT INTO `Local` (`id`, `partnerId`, `name`, `description`, `address`, `latitude`, `longitude`, `anticipation`, `created_at`, `deleted_at`, `status`) VALUES (NULL, '3', 'Cancha de Sosa Pelaez', 'Campo de Futbol', 'Belisario Sosa Pelaez, Cercado de Lima 15083', '-12.122534', '-77.027810', '0', CURRENT_TIMESTAMP, NULL, '1');
INSERT INTO `Local` (`id`, `partnerId`, `name`, `description`, `address`, `latitude`, `longitude`, `anticipation`, `created_at`, `deleted_at`, `status`) VALUES (NULL, '3', 'Canchita de Futbol La Luz ', 'Campo de Futbol', 'Jr.Saturno 1080, Cercado de Lima 15088', '-12.122534', '-77.027810', '0', CURRENT_TIMESTAMP, NULL, '1');

/*Lince*/
INSERT INTO `Local` (`id`, `partnerId`, `name`, `description`, `address`, `latitude`, `longitude`, `anticipation`, `created_at`, `deleted_at`, `status`) VALUES (NULL, '4', 'Campo de Fútbol Parque Castilla ', 'Campo de Futbol', 'Parque Castilla, Joaquin Bernal, Lince 15073', '-12.088133', '-77.041466', '0', CURRENT_TIMESTAMP, NULL, '1');
INSERT INTO `Local` (`id`, `partnerId`, `name`, `description`, `address`, `latitude`, `longitude`, `anticipation`, `created_at`, `deleted_at`, `status`) VALUES (NULL, '4', 'Apugol', 'Campo de Futbol', 'Calle Risso 418, Lince 15046', '-12.085450', '-77.032167', '0', CURRENT_TIMESTAMP, NULL, '1');
INSERT INTO `Local` (`id`, `partnerId`, `name`, `description`, `address`, `latitude`, `longitude`, `anticipation`, `created_at`, `deleted_at`, `status`) VALUES (NULL, '4', 'Campo de Grass Artificial', 'Campo de Futbol', 'Parque Castilla, Av. César Vallejo, Lince 15073', '-12.088078', '-77.041730', '0', CURRENT_TIMESTAMP, NULL, '1');
INSERT INTO `Local` (`id`, `partnerId`, `name`, `description`, `address`, `latitude`, `longitude`, `anticipation`, `created_at`, `deleted_at`, `status`) VALUES (NULL, '4', 'Capoeira Sul De Bahia', 'Campo de Futbol', 'Av. Francisco Lazo 2040, Lince 15046', '-12.084385', '-77.030345', '0', CURRENT_TIMESTAMP, NULL, '1');
INSERT INTO `Local` (`id`, `partnerId`, `name`, `description`, `address`, `latitude`, `longitude`, `anticipation`, `created_at`, `deleted_at`, `status`) VALUES (NULL, '4', 'Complejo Polideportivo Mariscal Ramón Castilla', 'Campo de Futbol', 'Lince 15073', '-12.088171', '-77.041523', '0', CURRENT_TIMESTAMP, NULL, '1');

/*Surquillo*/
INSERT INTO `Local` (`id`, `partnerId`, `name`, `description`, `address`, `latitude`, `longitude`, `anticipation`, `created_at`, `deleted_at`, `status`) VALUES (NULL, '5', 'Cancha La 10 (Principal)', 'Campo de Futbol', 'Pablo Neruda 157, Surquillo 15038', '-12.113294', '-77.007698', '0', CURRENT_TIMESTAMP, NULL, '1');
INSERT INTO `Local` (`id`, `partnerId`, `name`, `description`, `address`, `latitude`, `longitude`, `anticipation`, `created_at`, `deleted_at`, `status`) VALUES (NULL, '5', 'La Once Complejo Deportivo', 'Campo de Futbol', 'Av Tomás Marsano 630, Surquillo 15048', '-12.110130', '-77.014891', '0', CURRENT_TIMESTAMP, NULL, '1');
INSERT INTO `Local` (`id`, `partnerId`, `name`, `description`, `address`, `latitude`, `longitude`, `anticipation`, `created_at`, `deleted_at`, `status`) VALUES (NULL, '5', 'El Templo del fútbol', 'Campo de Futbol', 'Magnolia S/N, Surquillo 15038', '-12.121807', '-77.003279', '0', CURRENT_TIMESTAMP, NULL, '1');
INSERT INTO `Local` (`id`, `partnerId`, `name`, `description`, `address`, `latitude`, `longitude`, `anticipation`, `created_at`, `deleted_at`, `status`) VALUES (NULL, '5', 'Cancha de fulbito', 'Campo de Futbol', 'La Calera de la Merced, Surquillo 15038', '-12.115914', '-77.001301', '0', CURRENT_TIMESTAMP, NULL, '1');


INSERT INTO `LocalWorkingWeekDay` (`id`, `localId`, `day`, `start`, `end`,`createdAt`) VALUES (null,1,'1',7,22,CURRENT_TIMESTAMP);
INSERT INTO `LocalWorkingWeekDay` (`id`, `localId`, `day`, `start`, `end`,`createdAt`) VALUES (null,1,'2',7,22,CURRENT_TIMESTAMP);
INSERT INTO `LocalWorkingWeekDay` (`id`, `localId`, `day`, `start`, `end`,`createdAt`) VALUES (null,1,'3',7,22,CURRENT_TIMESTAMP);
INSERT INTO `LocalWorkingWeekDay` (`id`, `localId`, `day`, `start`, `end`,`createdAt`) VALUES (null,1,'4',7,22,CURRENT_TIMESTAMP);
INSERT INTO `LocalWorkingWeekDay` (`id`, `localId`, `day`, `start`, `end`,`createdAt`) VALUES (null,1,'5',7,22,CURRENT_TIMESTAMP);
INSERT INTO `LocalWorkingWeekDay` (`id`, `localId`, `day`, `start`, `end`,`createdAt`) VALUES (null,1,'6',7,22,CURRENT_TIMESTAMP);
INSERT INTO `LocalWorkingWeekDay` (`id`, `localId`, `day`, `start`, `end`,`createdAt`) VALUES (null,1,'7',7,22,CURRENT_TIMESTAMP);



INSERT INTO `LocalWorkingWeekDay` (`id`, `localId`, `day`, `start`, `end`,`createdAt`) VALUES (null,2,'1',7,22,CURRENT_TIMESTAMP);
INSERT INTO `LocalWorkingWeekDay` (`id`, `localId`, `day`, `start`, `end`,`createdAt`) VALUES (null,2,'2',7,22,CURRENT_TIMESTAMP);
INSERT INTO `LocalWorkingWeekDay` (`id`, `localId`, `day`, `start`, `end`,`createdAt`) VALUES (null,2,'3',7,22,CURRENT_TIMESTAMP);
INSERT INTO `LocalWorkingWeekDay` (`id`, `localId`, `day`, `start`, `end`,`createdAt`) VALUES (null,2,'4',7,22,CURRENT_TIMESTAMP);
INSERT INTO `LocalWorkingWeekDay` (`id`, `localId`, `day`, `start`, `end`,`createdAt`) VALUES (null,2,'5',7,22,CURRENT_TIMESTAMP);
INSERT INTO `LocalWorkingWeekDay` (`id`, `localId`, `day`, `start`, `end`,`createdAt`) VALUES (null,2,'6',7,22,CURRENT_TIMESTAMP);
INSERT INTO `LocalWorkingWeekDay` (`id`, `localId`, `day`, `start`, `end`,`createdAt`) VALUES (null,2,'7',7,22,CURRENT_TIMESTAMP);

INSERT INTO `LocalNonWorkingDay` (`id`, `localId`, `date`, `reason`, `createdAt`) VALUES (null,1,'2019-06-29','Día de San Pedro y San Pablo',CURRENT_TIMESTAMP);
INSERT INTO `LocalNonWorkingDay` (`id`, `localId`, `date`, `reason`,`createdAt`) VALUES (null,1,'2019-07-28','Independencia del Perú',CURRENT_TIMESTAMP);
INSERT INTO `LocalNonWorkingDay` (`id`, `localId`, `date`, `reason`,`createdAt`) VALUES (null,1,'2019-07-29','Fiesta de la Independencia del Perú',CURRENT_TIMESTAMP);
INSERT INTO `LocalNonWorkingDay` (`id`, `localId`, `date`, `reason`,`createdAt`) VALUES (null,1,'2019-07-30','Declarado no laborable',CURRENT_TIMESTAMP);
INSERT INTO `LocalNonWorkingDay` (`id`, `localId`, `date`, `reason`,`createdAt`) VALUES (null,1,'2019-08-30','Festividad de Santa Rosa de Lima',CURRENT_TIMESTAMP);


/*Miraflores*/
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,1,'Cancha 1 Miraflores',80.0,CURRENT_TIMESTAMP,null);
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,1,'Cancha 2 Miraflores',80.0,CURRENT_TIMESTAMP,null);
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,1,'Cancha 3 Miraflores',80.0,CURRENT_TIMESTAMP,null);
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,1,'Cancha 4 Miraflores',80.0,CURRENT_TIMESTAMP,null);

/*Surco*/
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,2,'Cancha 1 Surco',80.0,CURRENT_TIMESTAMP,null);
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,2,'Cancha 1 Surco',80.0,CURRENT_TIMESTAMP,null);
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,2,'Cancha 1 Surco',80.0,CURRENT_TIMESTAMP,null);
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,2,'Cancha 1 Surco',80.0,CURRENT_TIMESTAMP,null);
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,2,'Cancha 1 Surco',80.0,CURRENT_TIMESTAMP,null);

/*Cercado de Lima*/
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,10,'Cancha de Fútbol 6',80.0,CURRENT_TIMESTAMP,null);
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,11,'Cancha de Fulbito El Fanático Fútbol Club',80.0,CURRENT_TIMESTAMP,null);
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,12,'Cancha de Sosa Pelaez',80.0,CURRENT_TIMESTAMP,null);
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,13,'Canchita de Futbol La Luz',80.0,CURRENT_TIMESTAMP,null);

/*Lince*/
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,14,'Campo de Fútbol Parque Castilla',80.0,CURRENT_TIMESTAMP,null);
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,15,'Apugol',80.0,CURRENT_TIMESTAMP,null);
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,16,'Campo de Grass Artificial',80.0,CURRENT_TIMESTAMP,null);
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,17,'Capoeira Sul De Bahia',80.0,CURRENT_TIMESTAMP,null);
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,18,'Complejo Polideportivo Mariscal Ramón Castilla',80.0,CURRENT_TIMESTAMP,null);

/*Surquillo*/
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,19,'Cancha La 10 (Principal)',80.0,CURRENT_TIMESTAMP,null);
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,20,'La Once Complejo Deportivo',80.0,CURRENT_TIMESTAMP,null);
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,21,'El Templo del fútbol',80.0,CURRENT_TIMESTAMP,null);
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,22,'Cancha de fulbito',80.0,CURRENT_TIMESTAMP,null);




INSERT INTO `Guest` (`id`, `firstName`, `lastName`, `phone`, `email`, `createdAt`) VALUES(null,'Carlos','Llamosas','987654321','carlos@pichangol.com',CURRENT_TIMESTAMP);
INSERT INTO `Guest` (`id`, `firstName`, `lastName`, `phone`, `email`, `createdAt`) VALUES(null,'Carlos','Duran','987654322','carlos2@pichangol.com',CURRENT_TIMESTAMP);
INSERT INTO `Guest` (`id`, `firstName`, `lastName`, `phone`, `email`, `createdAt`) VALUES(null,'Joel','Verastegui','987654323','joel@pichangol.com',CURRENT_TIMESTAMP);
INSERT INTO `Guest` (`id`, `firstName`, `lastName`, `phone`, `email`, `createdAt`) VALUES(null,'Daniel','Palomino','987654324','palomino@pichangol.com',CURRENT_TIMESTAMP);
INSERT INTO `Guest` (`id`, `firstName`, `lastName`, `phone`, `email`, `createdAt`) VALUES(null,'Joe','Hermoza','987654325','hermoza@pichangol.com',CURRENT_TIMESTAMP);


INSERT INTO `Reservation` (`id`, `soccerFieldId`, `reserverId`, `reserverType`, `date`, `start`, `end`, `chargeId`, `chargeAmount`, `createdAt`) VALUES
(1, 1, 1, 'GUEST', '2019-06-24', 11, 12, 999,80.00, '2019-06-24 08:08:11'),
(2, 1, 2, 'GUEST', '2019-06-23', 14, 15, 888,80.00, '2019-06-23 10:17:29'),
(3, 1, 1, 'GUEST', '2019-06-23', 16, 18, 777,160.00, '2019-06-23 08:08:11'),
(4, 3, 3, 'GUEST', '2019-06-24', 11, 13, 999,160.00, '2019-06-24 08:08:11');

INSERT INTO `review` (`id`, `customerId`, `localId`, `stars`, `commentary`) VALUES
(1, 1, 1, 4, 'Tengo sueño'),
(2, 2, 1, 4, 'Tengo sueño x2'),
(3, 1, 2, 4, 'Tengo sueño alguien ayudeme'),
(4, 1, 2, 4, 'Tengo sueño quiero dormir');
