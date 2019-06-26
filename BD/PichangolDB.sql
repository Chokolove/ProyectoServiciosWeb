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
FOREIGN KEY (customerId) REFERENCES Customer(id),
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
INSERT INTO `Local` (`id`, `partnerId`, `name`, `description`, `address`, `latitude`, `longitude`, `anticipation`, `created_at`, `deleted_at`, `status`) VALUES (NULL, '3', 'Canchita de Futbol La Luz', 'Campo de Futbol', 'Jr.Saturno 1080, Cercado de Lima 15088', '-12.122534', '-77.027810', '0', CURRENT_TIMESTAMP, NULL, '1');

/*Lince*/
INSERT INTO `Local` (`id`, `partnerId`, `name`, `description`, `address`, `latitude`, `longitude`, `anticipation`, `created_at`, `deleted_at`, `status`) VALUES (NULL, '4', 'Campo de Fútbol Parque Castilla', 'Campo de Futbol', 'Parque Castilla, Joaquin Bernal, Lince 15073', '-12.088133', '-77.041466', '0', CURRENT_TIMESTAMP, NULL, '1');
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

INSERT INTO `LocalWorkingWeekDay` (`id`, `localId`, `day`, `start`, `end`,`createdAt`) VALUES (null,3,'1',7,22,CURRENT_TIMESTAMP);
INSERT INTO `LocalWorkingWeekDay` (`id`, `localId`, `day`, `start`, `end`,`createdAt`) VALUES (null,3,'2',7,22,CURRENT_TIMESTAMP);
INSERT INTO `LocalWorkingWeekDay` (`id`, `localId`, `day`, `start`, `end`,`createdAt`) VALUES (null,3,'3',7,22,CURRENT_TIMESTAMP);
INSERT INTO `LocalWorkingWeekDay` (`id`, `localId`, `day`, `start`, `end`,`createdAt`) VALUES (null,3,'4',7,22,CURRENT_TIMESTAMP);
INSERT INTO `LocalWorkingWeekDay` (`id`, `localId`, `day`, `start`, `end`,`createdAt`) VALUES (null,3,'5',7,22,CURRENT_TIMESTAMP);
INSERT INTO `LocalWorkingWeekDay` (`id`, `localId`, `day`, `start`, `end`,`createdAt`) VALUES (null,3,'6',7,22,CURRENT_TIMESTAMP);
INSERT INTO `LocalWorkingWeekDay` (`id`, `localId`, `day`, `start`, `end`,`createdAt`) VALUES (null,3,'7',7,22,CURRENT_TIMESTAMP);




INSERT INTO `LocalNonWorkingDay` (`id`, `localId`, `date`, `reason`,`createdAt`) VALUES (null,1,'2019-06-29','Día de San Pedro y San Pablo',CURRENT_TIMESTAMP);
INSERT INTO `LocalNonWorkingDay` (`id`, `localId`, `date`, `reason`,`createdAt`) VALUES (null,1,'2019-07-28','Independencia del Perú',CURRENT_TIMESTAMP);
INSERT INTO `LocalNonWorkingDay` (`id`, `localId`, `date`, `reason`,`createdAt`) VALUES (null,1,'2019-07-29','Fiesta de la Independencia del Perú',CURRENT_TIMESTAMP);
INSERT INTO `LocalNonWorkingDay` (`id`, `localId`, `date`, `reason`,`createdAt`) VALUES (null,1,'2019-07-30','Declarado no laborable',CURRENT_TIMESTAMP);
INSERT INTO `LocalNonWorkingDay` (`id`, `localId`, `date`, `reason`,`createdAt`) VALUES (null,1,'2019-08-30','Festividad de Santa Rosa de Lima',CURRENT_TIMESTAMP);

INSERT INTO `LocalNonWorkingDay` (`id`, `localId`, `date`, `reason`,`createdAt`) VALUES (null,2,'2019-06-29','Día de San Pedro y San Pablo',CURRENT_TIMESTAMP);
INSERT INTO `LocalNonWorkingDay` (`id`, `localId`, `date`, `reason`,`createdAt`) VALUES (null,2,'2019-07-28','Independencia del Perú',CURRENT_TIMESTAMP);
INSERT INTO `LocalNonWorkingDay` (`id`, `localId`, `date`, `reason`,`createdAt`) VALUES (null,2,'2019-07-29','Fiesta de la Independencia del Perú',CURRENT_TIMESTAMP);
INSERT INTO `LocalNonWorkingDay` (`id`, `localId`, `date`, `reason`,`createdAt`) VALUES (null,2,'2019-07-30','Declarado no laborable',CURRENT_TIMESTAMP);
INSERT INTO `LocalNonWorkingDay` (`id`, `localId`, `date`, `reason`,`createdAt`) VALUES (null,2,'2019-08-30','Festividad de Santa Rosa de Lima',CURRENT_TIMESTAMP);

INSERT INTO `LocalNonWorkingDay` (`id`, `localId`, `date`, `reason`,`createdAt`) VALUES (null,3,'2019-06-29','Día de San Pedro y San Pablo',CURRENT_TIMESTAMP);
INSERT INTO `LocalNonWorkingDay` (`id`, `localId`, `date`, `reason`,`createdAt`) VALUES (null,3,'2019-07-28','Independencia del Perú',CURRENT_TIMESTAMP);
INSERT INTO `LocalNonWorkingDay` (`id`, `localId`, `date`, `reason`,`createdAt`) VALUES (null,3,'2019-07-29','Fiesta de la Independencia del Perú',CURRENT_TIMESTAMP);
INSERT INTO `LocalNonWorkingDay` (`id`, `localId`, `date`, `reason`,`createdAt`) VALUES (null,3,'2019-07-30','Declarado no laborable',CURRENT_TIMESTAMP);
INSERT INTO `LocalNonWorkingDay` (`id`, `localId`, `date`, `reason`,`createdAt`) VALUES (null,3,'2019-08-30','Festividad de Santa Rosa de Lima',CURRENT_TIMESTAMP);



/*Polideportivo Sede Norte*/
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,1,'Cancha Deportiva 1',80.0,CURRENT_TIMESTAMP,null);
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,1,'Cancha Deportiva 2',80.0,CURRENT_TIMESTAMP,null);
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,1,'Cancha Deportiva 3',80.0,CURRENT_TIMESTAMP,null);
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,1,'Cancha Deportiva 4',80.0,CURRENT_TIMESTAMP,null);

/*Polideportivo Sede Miraflores*/
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,2,'Cancha Deportiva 1',80.0,CURRENT_TIMESTAMP,null);
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,2,'Cancha Deportiva 2',80.0,CURRENT_TIMESTAMP,null);
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,2,'Cancha Deportiva 3',80.0,CURRENT_TIMESTAMP,null);
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,2,'Cancha Deportiva 4',80.0,CURRENT_TIMESTAMP,null);
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,2,'Cancha Deportiva 5',80.0,CURRENT_TIMESTAMP,null);

/*Complejo Deportivo "Chino" Vasquez*/
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,3,'Cancha Deportiva 1',80.0,CURRENT_TIMESTAMP,null);
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,3,'Cancha Deportiva 2',80.0,CURRENT_TIMESTAMP,null);
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,3,'Cancha Deportiva 3',80.0,CURRENT_TIMESTAMP,null);
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,3,'Cancha Deportiva 4',80.0,CURRENT_TIMESTAMP,null);

/*Futbol En Lima SAC - Campo San Jorge Cancha*/
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,4,'Cancha Deportiva 1',80.0,CURRENT_TIMESTAMP,null);
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,4,'Cancha Deportiva 2',80.0,CURRENT_TIMESTAMP,null);
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,4,'Cancha Deportiva 3',80.0,CURRENT_TIMESTAMP,null);
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,4,'Cancha Deportiva 4',80.0,CURRENT_TIMESTAMP,null);
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,4,'Cancha Deportiva 5',80.0,CURRENT_TIMESTAMP,null);

/*CANCHA LA 10 */
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,5,'Cancha Deportiva 1',80.0,CURRENT_TIMESTAMP,null);
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,5,'Cancha Deportiva 2',80.0,CURRENT_TIMESTAMP,null);
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,5,'Cancha Deportiva 3',80.0,CURRENT_TIMESTAMP,null);
INSERT INTO `SoccerField` (`id`, `localId`, `description`, `price`, `createdAt`, `deletedAt`) VALUES (null,5,'Cancha Deportiva 4',80.0,CURRENT_TIMESTAMP,null);


/*Fotos de las canchas de futbol*/
INSERT INTO `SoccesFieldPhoto` (`id`, `soccerFieldId`, `photoUrl`, `description`) VALUES(null,1,'https://firebasestorage.googleapis.com/v0/b/pichangol.appspot.com/o/local1.jpg?alt=media&token=efa4fc62-ec33-4a16-86e5-0f143971ff9a','Polideportivo Sede Norte Cancha Deportiva 1');
INSERT INTO `SoccesFieldPhoto` (`id`, `soccerFieldId`, `photoUrl`, `description`) VALUES(null,2,'https://firebasestorage.googleapis.com/v0/b/pichangol.appspot.com/o/local2.jpg?alt=media&token=b6ac8461-bd31-4bfa-825e-fe6a53bd1a97','Polideportivo Sede Norte Cancha Deportiva 2');
INSERT INTO `SoccesFieldPhoto` (`id`, `soccerFieldId`, `photoUrl`, `description`) VALUES(null,3,'https://firebasestorage.googleapis.com/v0/b/pichangol.appspot.com/o/local3.jpg?alt=media&token=d699a261-e0c0-488d-8d52-bada31a80ff9','Polideportivo Sede Norte Cancha Deportiva 3');
INSERT INTO `SoccesFieldPhoto` (`id`, `soccerFieldId`, `photoUrl`, `description`) VALUES(null,4,'https://firebasestorage.googleapis.com/v0/b/pichangol.appspot.com/o/local4.jpg?alt=media&token=6ccb9165-db01-4197-9b07-de96538956e6','Polideportivo Sede Norte Cancha Deportiva 4');

INSERT INTO `SoccesFieldPhoto` (`id`, `soccerFieldId`, `photoUrl`, `description`) VALUES(null,5,'https://firebasestorage.googleapis.com/v0/b/pichangol.appspot.com/o/local5.jpg?alt=media&token=d3c511bd-3785-40f1-9309-dc89138d4480','Polideportivo Sede Miraflores Cancha Deportiva 1');
INSERT INTO `SoccesFieldPhoto` (`id`, `soccerFieldId`, `photoUrl`, `description`) VALUES(null,6,'https://firebasestorage.googleapis.com/v0/b/pichangol.appspot.com/o/local6.jpg?alt=media&token=dbc71fde-12bc-4126-99e3-57398a03eba0','Polideportivo Sede Miraflores Cancha Deportiva 2');
INSERT INTO `SoccesFieldPhoto` (`id`, `soccerFieldId`, `photoUrl`, `description`) VALUES(null,7,'https://firebasestorage.googleapis.com/v0/b/pichangol.appspot.com/o/local7.jpg?alt=media&token=a79a0292-c50a-438d-b41c-8c00aa650a29','Polideportivo Sede Miraflores Cancha Deportiva 3');
INSERT INTO `SoccesFieldPhoto` (`id`, `soccerFieldId`, `photoUrl`, `description`) VALUES(null,8,'https://firebasestorage.googleapis.com/v0/b/pichangol.appspot.com/o/local8.jpg?alt=media&token=4310e7c0-a98c-4664-8617-73c5c08b7750','Polideportivo Sede Miraflores Cancha Deportiva 4');
INSERT INTO `SoccesFieldPhoto` (`id`, `soccerFieldId`, `photoUrl`, `description`) VALUES(null,9,'https://firebasestorage.googleapis.com/v0/b/pichangol.appspot.com/o/local9.jpg?alt=media&token=43b18d5e-8584-49a0-bda8-e86ffd432229','Polideportivo Sede Miraflores Cancha Deportiva 5');

INSERT INTO `SoccesFieldPhoto` (`id`, `soccerFieldId`, `photoUrl`, `description`) VALUES(null,10,'https://firebasestorage.googleapis.com/v0/b/pichangol.appspot.com/o/local10.jpg?alt=media&token=0d586c98-b348-46f9-aa96-27597a09ca6b','Complejo Deportivo "Chino" Vasquez Cancha Deportiva 1');
INSERT INTO `SoccesFieldPhoto` (`id`, `soccerFieldId`, `photoUrl`, `description`) VALUES(null,11,'https://firebasestorage.googleapis.com/v0/b/pichangol.appspot.com/o/local11.jpg?alt=media&token=7274dc55-1768-42f6-b113-10b3a2cc23d4','Complejo Deportivo "Chino" Vasquez Cancha Deportiva 2');
INSERT INTO `SoccesFieldPhoto` (`id`, `soccerFieldId`, `photoUrl`, `description`) VALUES(null,12,'https://firebasestorage.googleapis.com/v0/b/pichangol.appspot.com/o/local12.jpg?alt=media&token=91578729-ce4d-4671-a084-ce94435f8907','Complejo Deportivo "Chino" Vasquez Cancha Deportiva 3');
INSERT INTO `SoccesFieldPhoto` (`id`, `soccerFieldId`, `photoUrl`, `description`) VALUES(null,13,'https://firebasestorage.googleapis.com/v0/b/pichangol.appspot.com/o/local13.jpg?alt=media&token=93a96c41-8668-4e01-8f7d-25cbf032d924','Complejo Deportivo "Chino" Vasquez Cancha Deportiva 4');

INSERT INTO `SoccesFieldPhoto` (`id`, `soccerFieldId`, `photoUrl`, `description`) VALUES(null,14,'https://firebasestorage.googleapis.com/v0/b/pichangol.appspot.com/o/local14.jpg?alt=media&token=83ae7b30-19f3-43bb-ba66-43d6d150df62','Futbol En Lima SAC - Campo San Jorge Cancha Deportiva 1');
INSERT INTO `SoccesFieldPhoto` (`id`, `soccerFieldId`, `photoUrl`, `description`) VALUES(null,15,'https://firebasestorage.googleapis.com/v0/b/pichangol.appspot.com/o/local15.jpg?alt=media&token=db55a8c6-db28-4b59-af37-77556b62115d','Futbol En Lima SAC - Campo San Jorge Cancha Deportiva 2');
INSERT INTO `SoccesFieldPhoto` (`id`, `soccerFieldId`, `photoUrl`, `description`) VALUES(null,16,'https://firebasestorage.googleapis.com/v0/b/pichangol.appspot.com/o/local16.jpg?alt=media&token=61429edc-80c5-4948-a891-76581cfcd12d','Futbol En Lima SAC - Campo San Jorge Cancha Deportiva 3');
INSERT INTO `SoccesFieldPhoto` (`id`, `soccerFieldId`, `photoUrl`, `description`) VALUES(null,17,'https://firebasestorage.googleapis.com/v0/b/pichangol.appspot.com/o/local17.jpg?alt=media&token=fe8b0b90-3615-4a37-8b0d-cbffb3f37a50','Futbol En Lima SAC - Campo San Jorge Cancha Deportiva 4');
INSERT INTO `SoccesFieldPhoto` (`id`, `soccerFieldId`, `photoUrl`, `description`) VALUES(null,18,'https://firebasestorage.googleapis.com/v0/b/pichangol.appspot.com/o/local18.jpg?alt=media&token=68bca5c1-b002-4a0b-b224-aa181684ef87','Futbol En Lima SAC - Campo San Jorge Cancha Deportiva 5');

INSERT INTO `SoccesFieldPhoto` (`id`, `soccerFieldId`, `photoUrl`, `description`) VALUES(null,19,'https://firebasestorage.googleapis.com/v0/b/pichangol.appspot.com/o/local19.jpg?alt=media&token=59ce5450-311a-438a-ae1b-e2061a42d5a7','CANCHA LA 10 Cancha Deportiva 1');
INSERT INTO `SoccesFieldPhoto` (`id`, `soccerFieldId`, `photoUrl`, `description`) VALUES(null,20,'https://firebasestorage.googleapis.com/v0/b/pichangol.appspot.com/o/local20.jpg?alt=media&token=33f0a172-3aad-4c03-9379-437615bf0a99','CANCHA LA 10 Cancha Deportiva 2');
INSERT INTO `SoccesFieldPhoto` (`id`, `soccerFieldId`, `photoUrl`, `description`) VALUES(null,21,'https://firebasestorage.googleapis.com/v0/b/pichangol.appspot.com/o/local21.jpg?alt=media&token=c38fa2f1-7deb-4763-867c-a35eee78241c','CANCHA LA 10 Cancha Deportiva 3');
INSERT INTO `SoccesFieldPhoto` (`id`, `soccerFieldId`, `photoUrl`, `description`) VALUES(null,22,'https://firebasestorage.googleapis.com/v0/b/pichangol.appspot.com/o/local22.jpg?alt=media&token=b8224632-2c7f-45f8-af51-1122b60f65de','CANCHA LA 10 Cancha Deportiva 4');



/*Mantenimiento de Canchas: Dia y horas */
INSERT INTO `SoccerFieldMaintenance` (`id`, `soccerFieldId`, `date`, `start`, `end`, `createdAt`) VALUES(null,1,'2019-08-30',7,20,CURRENT_TIMESTAMP);
INSERT INTO `SoccerFieldMaintenance` (`id`, `soccerFieldId`, `date`, `start`, `end`, `createdAt`) VALUES(null,2,'2019-08-30',7,20,CURRENT_TIMESTAMP);
INSERT INTO `SoccerFieldMaintenance` (`id`, `soccerFieldId`, `date`, `start`, `end`, `createdAt`) VALUES(null,3,'2019-08-30',7,20,CURRENT_TIMESTAMP);
INSERT INTO `SoccerFieldMaintenance` (`id`, `soccerFieldId`, `date`, `start`, `end`, `createdAt`) VALUES(null,4,'2019-08-30',7,20,CURRENT_TIMESTAMP);
INSERT INTO `SoccerFieldMaintenance` (`id`, `soccerFieldId`, `date`, `start`, `end`, `createdAt`) VALUES(null,5,'2019-08-30',7,20,CURRENT_TIMESTAMP);
INSERT INTO `SoccerFieldMaintenance` (`id`, `soccerFieldId`, `date`, `start`, `end`, `createdAt`) VALUES(null,6,'2019-08-30',7,20,CURRENT_TIMESTAMP);
INSERT INTO `SoccerFieldMaintenance` (`id`, `soccerFieldId`, `date`, `start`, `end`, `createdAt`) VALUES(null,7,'2019-08-30',7,20,CURRENT_TIMESTAMP);
INSERT INTO `SoccerFieldMaintenance` (`id`, `soccerFieldId`, `date`, `start`, `end`, `createdAt`) VALUES(null,8,'2019-08-30',7,20,CURRENT_TIMESTAMP);
INSERT INTO `SoccerFieldMaintenance` (`id`, `soccerFieldId`, `date`, `start`, `end`, `createdAt`) VALUES(null,9,'2019-08-30',7,20,CURRENT_TIMESTAMP);
INSERT INTO `SoccerFieldMaintenance` (`id`, `soccerFieldId`, `date`, `start`, `end`, `createdAt`) VALUES(null,10,'2019-08-30',7,20,CURRENT_TIMESTAMP);
INSERT INTO `SoccerFieldMaintenance` (`id`, `soccerFieldId`, `date`, `start`, `end`, `createdAt`) VALUES(null,11,'2019-08-30',7,20,CURRENT_TIMESTAMP);
INSERT INTO `SoccerFieldMaintenance` (`id`, `soccerFieldId`, `date`, `start`, `end`, `createdAt`) VALUES(null,12,'2019-08-30',7,20,CURRENT_TIMESTAMP);
INSERT INTO `SoccerFieldMaintenance` (`id`, `soccerFieldId`, `date`, `start`, `end`, `createdAt`) VALUES(null,13,'2019-08-30',7,20,CURRENT_TIMESTAMP);
INSERT INTO `SoccerFieldMaintenance` (`id`, `soccerFieldId`, `date`, `start`, `end`, `createdAt`) VALUES(null,14,'2019-08-30',7,20,CURRENT_TIMESTAMP);
INSERT INTO `SoccerFieldMaintenance` (`id`, `soccerFieldId`, `date`, `start`, `end`, `createdAt`) VALUES(null,15,'2019-08-30',7,20,CURRENT_TIMESTAMP);
INSERT INTO `SoccerFieldMaintenance` (`id`, `soccerFieldId`, `date`, `start`, `end`, `createdAt`) VALUES(null,16,'2019-08-30',7,20,CURRENT_TIMESTAMP);
INSERT INTO `SoccerFieldMaintenance` (`id`, `soccerFieldId`, `date`, `start`, `end`, `createdAt`) VALUES(null,17,'2019-08-30',7,20,CURRENT_TIMESTAMP);
INSERT INTO `SoccerFieldMaintenance` (`id`, `soccerFieldId`, `date`, `start`, `end`, `createdAt`) VALUES(null,18,'2019-08-30',7,20,CURRENT_TIMESTAMP);
INSERT INTO `SoccerFieldMaintenance` (`id`, `soccerFieldId`, `date`, `start`, `end`, `createdAt`) VALUES(null,19,'2019-08-30',7,20,CURRENT_TIMESTAMP);
INSERT INTO `SoccerFieldMaintenance` (`id`, `soccerFieldId`, `date`, `start`, `end`, `createdAt`) VALUES(null,20,'2019-08-30',7,20,CURRENT_TIMESTAMP);
INSERT INTO `SoccerFieldMaintenance` (`id`, `soccerFieldId`, `date`, `start`, `end`, `createdAt`) VALUES(null,21,'2019-08-30',7,20,CURRENT_TIMESTAMP);
INSERT INTO `SoccerFieldMaintenance` (`id`, `soccerFieldId`, `date`, `start`, `end`, `createdAt`) VALUES(null,22,'2019-08-30',7,20,CURRENT_TIMESTAMP);


INSERT INTO `Guest` (`id`, `firstName`, `lastName`, `phone`, `email`, `createdAt`) VALUES(null,'Carlos','Llamosas','987654321','carlos@pichangol.com',CURRENT_TIMESTAMP);
INSERT INTO `Guest` (`id`, `firstName`, `lastName`, `phone`, `email`, `createdAt`) VALUES(null,'Carlos','Duran','987654322','carlos2@pichangol.com',CURRENT_TIMESTAMP);
INSERT INTO `Guest` (`id`, `firstName`, `lastName`, `phone`, `email`, `createdAt`) VALUES(null,'Joel','Verastegui','987654323','joel@pichangol.com',CURRENT_TIMESTAMP);
INSERT INTO `Guest` (`id`, `firstName`, `lastName`, `phone`, `email`, `createdAt`) VALUES(null,'Daniel','Palomino','987654324','palomino@pichangol.com',CURRENT_TIMESTAMP);
INSERT INTO `Guest` (`id`, `firstName`, `lastName`, `phone`, `email`, `createdAt`) VALUES(null,'Joe','Hermoza','987654325','hermoza@pichangol.com',CURRENT_TIMESTAMP);


INSERT INTO `Customer` (`id`, `accountId`, `firstName`, `lastName`, `birthday`, `phone`, `email`, `createdAt`) VALUES(null,1,'Juan','Perez','1996-08-11','928205738','juan@pichangol.com',CURRENT_TIMESTAMP);
INSERT INTO `Customer` (`id`, `accountId`, `firstName`, `lastName`, `birthday`, `phone`, `email`, `createdAt`) VALUES(null,2,'Sofia', 'Sanchez','1993-03-01','938205775','sofia@pichangol.com',CURRENT_TIMESTAMP);
INSERT INTO `Customer` (`id`, `accountId`, `firstName`, `lastName`, `birthday`, `phone`, `email`, `createdAt`) VALUES(null,3,'Jose', 'Atuncar','1991-06-22','958205769','jose@pichangol.com',CURRENT_TIMESTAMP);
INSERT INTO `Customer` (`id`, `accountId`, `firstName`, `lastName`, `birthday`, `phone`, `email`, `createdAt`) VALUES(null,4,'Pedro', 'Ramos','1989-09-16','978205749','pedro@pichangol.com',CURRENT_TIMESTAMP);
INSERT INTO `Customer` (`id`, `accountId`, `firstName`, `lastName`, `birthday`, `phone`, `email`, `createdAt`) VALUES(null,5,'Jaze', 'Martinez','1988-10-19','968205727','jaze@pichangol.com',CURRENT_TIMESTAMP);

INSERT INTO `reservation` (`id`, `soccerFieldId`, `reserverId`, `reserverType`, `date`, `start`, `end`, `chargeId`, `chargeAmount`, `createdAt`) VALUES
(1, 1, 1, 'GUEST', '2019-06-24', 11, 12, 999,80.00, '2019-06-24 08:08:11'),
(2, 1, 2, 'CUSTOMER', '2019-06-23', 14, 15, 888,80.00, '2019-06-23 10:17:29'),
(3, 1, 1, 'GUEST', '2019-06-23', 16, 18, 777,160.00, '2019-06-23 08:08:11'),
(4, 3, 2, 'CUSTOMER', '2019-06-24', 11, 13, 999,160.00, '2019-06-24 08:08:11');

INSERT INTO `reservation` (`id`, `soccerFieldId`, `reserverId`, `reserverType`, `date`, `start`, `end`, `chargeId`, `chargeAmount`, `createdAt`) VALUES
(5, 2, 1, 'GUEST', '2019-06-24', 11, 12, 999,80.00, '2019-06-24 08:08:15'),
(6, 2, 2, 'CUSTOMER', '2019-06-23', 14, 15, 888,80.00, '2019-06-23 10:17:30'),
(7, 2, 1, 'GUEST', '2019-06-23', 16, 18, 777,160.00, '2019-06-23 08:09:11'),
(8, 3, 1, 'GUEST', '2019-06-24', 11, 13, 999,160.00, '2019-06-24 08:10:11');

INSERT INTO `reservation` (`id`, `soccerFieldId`, `reserverId`, `reserverType`, `date`, `start`, `end`, `chargeId`, `chargeAmount`, `createdAt`) VALUES
(9, 4, 1, 'GUEST', '2019-06-24', 11, 12, 999,80.00, '2019-06-24 08:05:11'),
(10, 5, 2, 'CUSTOMER', '2019-06-23', 14, 15, 888,80.00, '2019-06-23 10:12:29'),
(11, 6, 1, 'GUEST', '2019-06-23', 16, 18, 777,160.00, '2019-06-23 08:03:13'),
(12, 7, 1, 'GUEST', '2019-06-24', 11, 13, 999,160.00, '2019-06-24 08:06:19');

INSERT INTO `reservation` (`id`, `soccerFieldId`, `reserverId`, `reserverType`, `date`, `start`, `end`, `chargeId`, `chargeAmount`, `createdAt`) VALUES
(13, 8, 1, 'GUEST', '2019-06-24', 11, 12, 999,80.00, '2019-06-24 08:01:11'),
(14, 8, 2, 'CUSTOMER', '2019-06-23', 14, 15, 888,80.00, '2019-06-23 10:15:29'),
(15, 9, 2, 'CUSTOMER', '2019-06-23', 16, 18, 777,160.00, '2019-06-23 08:30:30'),
(16, 9, 1, 'GUEST', '2019-06-24', 11, 13, 999,160.00, '2019-06-24 08:20:59');

INSERT INTO `review` (`id`, `customerId`, `localId`, `stars`, `commentary`) VALUES
(1, 1, 1, 4, 'Tengo sueño'),
(2, 2, 1, 4, 'Tengo sueño x2'),
(3, 1, 2, 4, 'Tengo sueño alguien ayudeme'),
(4, 1, 2, 4, 'Tengo sueño quiero dormir');

INSERT INTO `Reservation`
(`id`,
`soccerFieldId`,
`reserverId`,
`reserverType`,
`date`,
`start`,
`end`,
`chargeId`,
`chargeAmount`,
`createdAt`)
VALUES
(null, 2, 1, 'GUEST', '2019-06-26', 11, 13, 334, 160.00, CURRENT_TIMESTAMP),
(null, 2, 1, 'GUEST', '2019-06-26', 16, 18, 422, 160.00, CURRENT_TIMESTAMP),
(null, 1, 1, 'GUEST', '2019-06-27', 10, 11, 523, 80.00, CURRENT_TIMESTAMP),
(null, 2, 1, 'GUEST', '2019-06-27', 16, 19, 955, 240.00, CURRENT_TIMESTAMP),
(null, 4, 1, 'GUEST', '2019-06-28', 13, 14, 111, 80.00, CURRENT_TIMESTAMP),
(null, 3, 1, 'GUEST', '2019-06-28', 14, 16, 120, 160.00, CURRENT_TIMESTAMP)
;
