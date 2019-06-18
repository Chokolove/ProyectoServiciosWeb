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

