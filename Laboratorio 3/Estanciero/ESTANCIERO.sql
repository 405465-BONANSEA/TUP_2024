create database ESTANCIERO2;
GO
use ESTANCIERO2;
GO
create table ZONES(
id_zone int identity(1,1),
zone_name varchar(20)
constraint pk_ZONES primary key (id_zone)
)
GO
create table BOARD_SLOT_TYPES(
id_board_slot_type int identity(1,1),
slot_type varchar(20)
constraint pk_BOARD_SLOT_TYPES primary key (id_board_slot_type)
)
GO
create table PLAYER_STYLES(
id_player_style int identity(1,1),
player_style varchar(20)
constraint pk_PLAYER_STYLES primary key(id_player_style)
)
GO
create table BOT_PLAYERS(
id_bot_player int identity(1,1),
id_player_style int,
bot_name varchar(30)
constraint pk_BOT_PLAYERS primary key (id_bot_player),
constraint fk_BOT_PLAYERS_a_PLAYER_STYLES foreign key (id_player_style)
references PLAYER_STYLES(id_player_style)
)
GO
create table PROVINCES(
id_province int identity(1,1),
id_zone int,
province varchar(30),
ranch_price int
constraint pk_PROVINCES primary key (id_province),
constraint fk_PROVINCES_a_ZONES foreign key(id_zone)
references ZONES(id_zone)
)
GO
create table SPECIAL_CARDS(
id_special_cards int identity(1,1),
id_board_slot_type int,
card_message varchar(200),
amount int,
to_position int
constraint pk_SPECIAL_CARDS primary key (id_special_cards),
constraint fk_SPECIAL_CARDS_a_BOARD_SLOT_TYPES foreign key(id_board_slot_type)
references BOARD_SLOT_TYPES (id_board_slot_type)
)
GO
create table BOARD_SLOTS(
id_board_slot int not null,
id_board_slot_type int,
id_province_zone int
constraint pk_BOARD_SLOTS primary key (id_board_slot),
constraint fk_BOARD_SLOTS_a_BOARD_SLOT_TYPES foreign key(id_board_slot_type)
references BOARD_SLOT_TYPES (id_board_slot_type),
constraint fk_BOARD_SLOTS_a_PROVINCES foreign key(id_province_zone)
references PROVINCES(id_province)
)
GO
create table RENTAL_PRICES(
id_rental_price int identity(1,1),
id_board_slot int,
rental_count int,
price int
constraint pk_RENTAL_PRICES primary key(id_rental_price),
constraint fk_RENTAL_PRICES_a_BOARD_SLOTS foreign key(id_board_slot)
references BOARD_SLOTS(id_board_slot)
)
GO

-------------------------------------------------------------------------INSERTS--------------------------------------------------------------

INSERT INTO ZONES (zone_name)
VALUES ('South Side'), 
	   ('Downtown'), 
	   ('North Side');
GO

INSERT INTO BOARD_SLOT_TYPES(slot_type)
VALUES ('Province'), 
	   ('Railway'), 
	   ('Company'),
	   ('Jail'),
	   ('Rest'),
	   ('Lucky'),
	   ('Destiny'),
	   ('Start Line'),
	   ('Tax'),
	   ('Prize');
GO

INSERT INTO PLAYER_STYLES(player_style)
VALUES ('Conservative'),
	   ('Balanced'),
	   ('Aggressive');
GO

INSERT INTO BOT_PLAYERS(id_player_style,bot_name)
VALUES (1,'La Mona'),
	   (2,'El Chiqui Tapia'),
	   (2,'Francella'),
	   (3,'Commander Richard Fort');
GO
INSERT INTO PROVINCES(id_zone, province,ranch_price)
VALUES	(1,'Formosa',1000),
		(2,'Formosa',1000),
		(3,'Formosa',1000),
		(1,'Rio Negro',1000),
		(3,'Rio Negro',1000),
		(1,'Salta',1500),
		(2,'Salta',1500),
		(3,'Salta',1500),
		(1,'Mendoza',2000),
		(2,'Mendoza',2000),
		(3,'Mendoza',2000),
		(1,'Santa Fe',2500),
		(2,'Santa Fe',2500),
		(3,'Santa Fe',2500),
		(1,'Tucuman',3000),
		(3,'Tucuman',3000),
		(1,'Cordoba',3000),
		(2,'Cordoba',3000),
		(3,'Cordoba',3000),
		(1,'Buenos Aires',4000),
		(2,'Buenos Aires',4000),
		(3,'Buenos Aires',4000);
GO
INSERT INTO SPECIAL_CARDS(id_board_slot_type,card_message,amount,to_position)
				   VALUES(6,'Advance to Salta, North Side, collect $5.000 if you pass through the Start Line',null, 13),
						(6,'Advance to Santa Fe, North Side, collect $5.000 if you pass through the Start Line',null, 26),
						(6,'OH NO! YOU WILL GO STRAIGHT TO JAIL FOR TAX EVASION',null, 14),
						(6,'Advance to Buenos Aires, North Side',null,40),
						(6,'Advance to the Start Line',null, 0),
						(6,'Advence to La Bodega, collect $5.000 if you pass through the Start Line',null,16),
						(6,'Pay a speed fee of $300',-300, null),
						(6,'Collect $1.000 in bank interest',1000, null),
						(6,'Habeas Corpus concedeed!, With this card you can escape form Prison!, you are free of keep it or sell it.',null,null),
						(6,'You spend $3.000 in school expenses',-3000,null),
						(6,'YOU WON THE LOTTERY! CONGRATULATIONS! Collect $10.000',10000,null),
						(6,'Pay a speed fee of $400',-400,null),
						(6,'You won $3.000 in the race bets!',3000,null),
						(7,'Advance to the Start Line',null, 0),
						(7,'Return to Formosa, South Side',null,1),
						(7,'OH NO! YOU WILL GO STRAIGHT TO JAIL FOR MONEY LAUNDRY',null, 14),
						(7,'You inherit $2.000',2000,null),
						(7,'You sold shares, collect $1.000',1000,null),
						(7,'"You are "inimputable", brother!", With this card you can escape form Prison!, you are free of keep it or sell it.',null,null),
						(7,'You spent $1000 on your insurance policy',-1000,null),
						(7,'You won an agricultural contest!, collect $2.000',2000,null),
						(7,'You won the second prize in a beauty contest!, collect $200',200,null),
						(7,'You collected 5% of the interest on mortgage bonds, collect $500',500,null),
						(7,'Tax refund, collect $500',500,null),
						(7,'Calculation error by the bank, collect $5.000',5000,null),
						(7,'You won $2.000 in a cow contest!',2000,null),
						(7,'Happy birthday!, get $600',600,null),
						(7,'You spent $1.000 in health care expenses',-1000,null),
						(7,'Pay a speed fee of $200',-200,null);
GO				
INSERT INTO BOARD_SLOTS(id_board_slot,id_board_slot_type,id_province_zone)
				 VALUES(0,8,null),
					   (1,1,1),
					   (2,1,2),
					   (3,1,3),
					   (4,6,null),
					   (5,1,4),
					   (6,1,5),
					   (7,10,null),
					   (8,3,null),
					   (9,1,6),
					   (10,7,null),
					   (11,1,7),
					   (12,2,null),
					   (13,1,8),
					   (14,4,null),
					   (15,6,null),
					   (16,3,null),
					   (17,1,9),
					   (18,2,null),
					   (19,1,10),
					   (20,1,11),
					   (21,5,null),
					   (22,2,null),
					   (23,1,12),
					   (24,1,13),
					   (25,7,null),
					   (26,1,14),
					   (27,2,null),
					   (28,5,null),
					   (29,1,15),
					   (30,1,16),
					   (31,9,null),
					   (32,1,17),
					   (33,1,18),
					   (34,1,19),
					   (35,4,null),
					   (36,6,null),
					   (37,1,20),
					   (38,7,null),
					   (39,1,21),
					   (40,1,22),
					   (41,9,null);
GO
INSERT INTO RENTAL_PRICES(id_board_slot, rental_count, price)
                                                    VALUES
---------------------------FORMOSA ZONA SUR-----------------------------------

                                                        (1,0,40), 
                                                        (1,1,200), 
                                                        (1,2,600),
                                                        (1,3,1700), 
                                                        (1,4,3000), 
                                                        (1,5,4750),
---------------------------FORMOSA CENTRO--------------------------------------
 
                                                        (2,0,40), 
                                                        (2,1,200), 
                                                        (2,2,600), 
                                                        (2,3,1700), 
                                                        (2,4,3000), 
                                                        (2,5,4750),
---------------------------FORMOSA NORTE---------------------------------------

                                                        (3,0,80),
                                                        (3,1,400),
                                                        (3,2,800),
                                                        (3,3,3400), 
                                                        (3,4,6000),
                                                        (3,5,9500),
---------------------------RIO NEGRO SUR---------------------------------------

                                                        (5,0,110),
                                                        (5,1,570), 
                                                        (5,2,1700), 
                                                        (5,3,3150), 
                                                        (5,4,7600), 
                                                        (5,5,9500),
---------------------------RIO NEGRO NORTE-------------------------------------

                                                        (6,0,150), 
                                                        (6,1,750), 
                                                        (6,2,2000), 
                                                        (6,3,5700), 
                                                        (6,4,8500), 
                                                        (6,5,11500),
---------------------------SALTA SUR-------------------------------------------

                                                        (9,0,200), 
                                                        (9,1,1000), 
                                                        (9,2,2800), 
                                                        (9,3,8500), 
                                                        (9,4,12000), 
                                                        (9,5,14200),
---------------------------SALTA CENTRO----------------------------------------

                                                        (11,0,200), 
                                                        (11,1,1000), 
                                                        (11,2,2800), 
                                                        (11,3,8500), 
                                                        (11,4,12000), 
                                                        (11,5,14200),
---------------------------SALTA NORTE-----------------------------------------

                                                        (13,0,230), 
                                                        (13,1,1150), 
                                                        (13,2,3400), 
                                                        (13,3,9500), 
                                                        (13,4,13000), 
                                                        (13,5,17000),
---------------------------MENDOZA SUR-----------------------------------------

                                                        (17,0,250), 
                                                        (17,1,1350), 
                                                        (17,2,3800), 
                                                        (17,3,10500), 
                                                        (17,4,14200), 
                                                        (17,5,18000),
---------------------------MENDOZA CENTRO--------------------------------------

                                                        (19,0,250), 
                                                        (19,1,1350), 
                                                        (19,2,3800), 
                                                        (19,3,10500), 
                                                        (19,4,14200), 
                                                        (19,5,18000),
---------------------------MENDOZA NORTE---------------------------------------

                                                        (20,0,300), 
                                                        (20,1,1500), 
                                                        (20,2,4200), 
                                                        (20,3,11500), 
                                                        (20,4,15000), 
                                                        (20,5,19000),
---------------------------SANTA FE SUR----------------------------------------

                                                        (23,0,350), 
                                                        (23,1,1700), 
                                                        (23,2,4750), 
                                                        (23,3,13000), 
                                                        (23,4,16000), 
                                                        (23,5,20000),
---------------------------SANTA FE CENTRO-------------------------------------

                                                        (24,0,350), 
                                                        (24,1,1700), 
                                                        (24,2,4750), 
                                                        (24,3,13000), 
                                                        (24,4,16000), 
                                                        (24,5,20000),
---------------------------SANTA FE NORTE--------------------------------------

                                                        (26,0,400), 
                                                        (26,1,2000), 
                                                        (26,2,5750), 
                                                        (26,3,14000), 
                                                        (26,4,17000), 
                                                        (26,5,21000),
---------------------------TUCUMAN SUR-----------------------------------------

                                                        (29,0,400), 
                                                        (29,1,2200), 
                                                        (29,2,6000), 
                                                        (29,3,15000), 
                                                        (29,4,18000), 
                                                        (29,5,21000),
---------------------------TUCUMAN NORTE--------------------------------------- REVISAR PRECIOS

                                                        (30,0,450), 
                                                        (30,1,2400), 
                                                        (30,2,6800), 
                                                        (30,3,16000), 
                                                        (30,4,19500), 
                                                        (30,5,23000),
---------------------------CORDOBA SUR-----------------------------------------  

                                                        (32,0,500), 
                                                        (32,1,2500), 
                                                        (32,2,6500), 
                                                        (32,3,17000), 
                                                        (32,4,21000), 
                                                        (32,5,24000),
---------------------------CORDOBA CENTRO-------------------------------------- 

                                                        (33,0,450), 
                                                        (33,1,2400), 
                                                        (33,2,6800), 
                                                        (33,3,16000), 
                                                        (33,4,19500), 
                                                        (33,5,23000),
---------------------------CORDOBA NORTE--------------------------------------- 

                                                        (34,0,550), 
                                                        (34,1,2850), 
                                                        (34,2,8500), 
                                                        (34,3,19000), 
                                                        (34,4,23000), 
                                                        (34,5,27000),
---------------------------BS.AIRES SUR----------------------------------------

                                                        (37,0,650), 
                                                        (37,1,3300), 
                                                        (37,2,9500), 
                                                        (37,3,22000), 
                                                        (37,4,25000), 
                                                        (37,5,30000),
---------------------------BS.AIRES CENTRO----------------------------------------

                                                        (39,0,650), 
                                                        (39,1,3300), 
                                                        (39,2,9500), 
                                                        (39,3,22000), 
                                                        (39,4,25000), 
                                                        (39,5,30000),
---------------------------BS.AIRES NORTE----------------------------------------

                                                        (40,0,1000), 
                                                        (40,1,4000), 
                                                        (40,2,12000), 
                                                        (40,3,26000), 
                                                        (40,4,31000), 
                                                        (40,5,36000),
---------------------------FERROCARRIL GRAL. BELGRANO----------------------------

                                                        (12,1,500), 
                                                        (12,2,1000), 
                                                        (12,3,2000), 
                                                        (12,4,4000),
---------------------------FERROCARRIL GRAL. SAN MARTIN--------------------------

                                                        (18,1,500), 
                                                        (18,2,1000), 
                                                        (18,3,2000), 
                                                        (18,4,4000),
---------------------------FERROCARRIL GRAL. B. MITRE----------------------------

                                                        (22,1,500), 
                                                        (22,2,1000), 
                                                        (22,3,2000), 
                                                        (22,4,4000),
---------------------------FERROCARRIL GRAL. URQUIZA-----------------------------

                                                        (27,1,500), 
                                                        (27,2,1000), 
                                                        (27,3,2000), 
                                                        (27,4,4000),
---------------------------COMPAÑIA PETROLERA------------------------------------

                                                        (8,1,100), 
                                                        (8,2,200),
---------------------------BODEGA------------------------------------------------

                                                        (16,1,100), 
                                                        (16,2,200);
GO


