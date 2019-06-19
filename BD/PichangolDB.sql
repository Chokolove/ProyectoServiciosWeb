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
createdAt datetime null,
PRIMARY KEY (id),
FOREIGN KEY (soccerFieldId) REFERENCES SoccerField(id)
);

INSERT INTO `account` (`id`, `password`, `confirmedAt`, `lockedAt`, `lastLogin`) VALUES (NULL, 'asd', '2019-06-18 19:40:00', NULL, NULL);
INSERT INTO `account` (`id`, `password`, `confirmedAt`, `lockedAt`, `lastLogin`) VALUES (NULL, 'zxc', '2019-06-18 19:40:00', NULL, NULL);

INSERT INTO `partner` (`id`, `accountId`, `firstName`, `lastName`, `createdAt`) VALUES (NULL, '1', 'Juan', 'Perez', '2019-06-18 19:41:00');
INSERT INTO `partner` (`id`, `accountId`, `firstName`, `lastName`, `createdAt`) VALUES (NULL, '2', 'Sofia', 'Sanchez', '2019-06-18 19:41:00');

INSERT INTO `local` (`id`, `partnerId`, `name`, `description`, `address`, `latitude`, `longitude`, `anticipation`, `created_at`, `deleted_at`, `status`) VALUES (NULL, '1', 'Polideportivo Sede Norte', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris ', 'Francisco de Paula Camino 220', '-12.120751', ' -77.032059', '0', CURRENT_TIMESTAMP, NULL, '1');
INSERT INTO `local` (`id`, `partnerId`, `name`, `description`, `address`, `latitude`, `longitude`, `anticipation`, `created_at`, `deleted_at`, `status`) VALUES (NULL, '2', 'Polideportivo Sede Miraflores', 'Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."', 'Calle Alcanfores 298', '-12.122534', '-77.027810', '0', CURRENT_TIMESTAMP, NULL, '1');


