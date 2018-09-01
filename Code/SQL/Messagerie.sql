-- *********************************************
-- * SQL MySQL generation                      
-- *--------------------------------------------
-- * DB-MAIN version: 10.0.3              
-- * Generator date: Aug 17 2017              
-- * Generation date: Sat Sep  1 14:26:06 2018 
-- * LUN file: D:\Documents\Java projects\MessagerieApp\Analyse\DBMain\Messagerie.lun 
-- * Schema: Logique/1 
-- ********************************************* 


-- Database Section
-- ________________ 

create database messagerie;
use messagerie;


-- Tables Section
-- _____________ 

create table CONFIDENTIALITE (
     adresse_mail varchar(300) not null,
     conf_adresseMail char(1) not null,
     conf_dateNaissance char(1) not null,
     conf_noGsm char(1) not null,
     conf_noFixe char(1) not null,
     constraint FKverrouiller_ID primary key (adresse_mail));

create table DEMANDE_CONTACT (
     id int not null,
     date date not null,
     message varchar(3000) not null,
     adresse_mail varchar(300) not null,
     constraint ID_DEMANDE_CONTACT_ID primary key (id));

create table USER (
     adresse_mail varchar(300) not null,
     password varchar(300) not null,
     pseudo char(1) not null,
     image char(1) not null,
     date_naissance date not null,
     status char(1) not null default 'd',
     description varchar(500) not null,
     no_gsm varchar(20) not null,
     no_fixe varchar(20) not null,
     id int,
     USER_1_ varchar(300),
     constraint ID_USER primary key (adresse_mail));


-- Constraints Section
-- ___________________ 

alter table CONFIDENTIALITE add constraint FKverrouiller_FK
     foreign key (adresse_mail)
     references USER (adresse_mail);

-- Not implemented
alter table DEMANDE_CONTACT add constraint ID_DEMANDE_CONTACT_CHK
    check(exists(select * from USER
                 where USER.id = id)); 

alter table DEMANDE_CONTACT add constraint FKenvoyer
     foreign key (adresse_mail)
     references USER (adresse_mail);

alter table USER add constraint FKrecoit
     foreign key (id)
     references DEMANDE_CONTACT (id);

alter table USER add constraint FKcontact
     foreign key (USER_1_)
     references USER (adresse_mail);
	 
alter table USER 
	add constraint checkStatus
	check (status = 'c' OR status = 'o' OR status = 'n' OR status = 'i' OR status = 'd');
	
alter table CONFIDENTIALITE
	add constraint checkConfAdMail
	check (conf_adresseMail = 'v' OR conf_adresseMail = 'c' OR conf_adresseMail = 'p');
	
alter table CONFIDENTIALITE
	add constraint checkDateNaissance
	check (conf_dateNaissance = 'v' OR conf_dateNaissance = 'c' OR conf_dateNaissance = 'p');
	
alter table CONFIDENTIALITE
	add constraint checkNoGsm
	check (conf_noGsm = 'v' OR conf_noGsm = 'c' OR conf_noGsm = 'p');
	
alter table CONFIDENTIALITE
	add constraint checkNoFixe
	check (conf_noFixe = 'v' OR conf_noFixe = 'c' OR conf_noFixe = 'p');
	

-- Index Section
-- _____________ 

