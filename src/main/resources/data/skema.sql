create table hotel(

    idhotel serial,
    name varchar(255) NOT NULL,

    PRIMARY KEY(idhotel)
);

insert into hotel(name) values('hotel jw marriot');
insert into hotel(name) values('hotel bunga');
insert into hotel(name) values('hotel melati');
insert into hotel(name) values('hotel rio de jenairo');
insert into hotel(name) values('hotel kembang');
insert into hotel(name) values('hotel burj khalifa');
insert into hotel(name) values('hotel london');
insert into hotel(name) values('hotel new york');
insert into hotel(name) values('hotel los angles');
insert into hotel(name) values('hotel california');
insert into hotel(name) values('hotel bengaluru bangalor');

create table roles(

    idroles serial,
    roles_name varchar(255) NOT NULL,
    description varchar(255) NOT NULL,

    PRIMARY KEY(idroles)
);

insert into roles(roles_name, description)
values ('ADMIN_USER', 'ADMIN HAS SUPER SUPER ADMINISTRATOR');

insert into roles(roles_name, description)
values ('STANDARD_USER', 'STANDARD HAS STANDARD USER');


create table users(

    idusers serial,
    firstname varchar(255) NOT NULL,
    lastname varchar(255) NOT NULL,
    username varchar(255) NOT NULL UNIQUE,
    password varchar(255) NOT NULL,

    PRIMARY KEY(idusers)

);


insert into users(firstname, lastname, username, password)
values('Muhammad Dicka', 'Nirwansyah', 'dickanirwansyah', '821f498d827d4edad2ed0960408a98edceb661d9f34287ceda2962417881231a');

insert into users(firstname, lastname, username, password)
values('Muhammad Joni', 'Ilyas', 'jonidep', '821f498d827d4edad2ed0960408a98edceb661d9f34287ceda2962417881231a');

create table users_roles(

    idusers int NOT NULL,
    idroles int NOT NULL,

    PRIMARY KEY (idusers, idroles),

    CONSTRAINT fk_users_roles_idusers FOREIGN KEY (idusers)
    REFERENCES users (idusers) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,

    CONSTRAINT fk_users_roles_idroles FOREIGN KEY (idroles)
    REFERENCES roles (idroles) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION

);

insert into users_roles(idusers, idroles)
values (1, 1);
insert into users_roles(idusers, idroles)
values (1, 2);
insert into users_roles(idusers, idroles)
values (2, 2);