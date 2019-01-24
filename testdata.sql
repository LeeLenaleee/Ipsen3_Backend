INSERT INTO contactpersoon
VALUES (DEFAULT, 'Park', 'Morris', 'Bake Shop', 'Bazuinpad 3', '6295AH', 'Leuven', 'Nederland', 'klant', 'morrisss.nl'),
(DEFAULT, 'Langley', 'Gracie', 'The Movable Feast', 'Tjalkmeen 2', '5921VR', 'Amersfort', 'Nederland', 'vriend', 'themovablefeast.nl'),
(DEFAULT, 'Kane', 'Johnathan', 'Trendkoo', 'Hanzemeen 67', '9372CE', 'Den Bosch', 'Nederland', 'leverancier', 'jfiofg.nlfd'),
(DEFAULT, 'Millar', 'Derek', 'Vogeltre', 'Busken Huetlaan 12', '0563ZN', 'Zutphen', 'Nederland', 'kennis', 'asdfghj.com'),
(DEFAULT, 'Blanchard', 'Zavier', 'Notenkoor', 'Weisteeg 98', '2479KD', 'Deventer', 'Nederland', 'klant', 'dfigovdfjgiv.nl');

INSERT INTO telefoonnummer
VALUES (DEFAULT, '12345678', 1),
(DEFAULT, '23456789', 2),
(DEFAULT, '34567890', 2),
(DEFAULT, '09876543', 3),
(DEFAULT, '98765432', 4),
(DEFAULT, '87654321', 4),
(DEFAULT, '38590215', 4),
(DEFAULT, '58653346', 5);

INSERT INTO email
VALUES (DEFAULT, 'morris@park.nl', 1),
(DEFAULT, 'gracie@langley.nl', 2),
(DEFAULT, 'johnathan@kane.nl', 3),
(DEFAULT, 'info@trendkoo.nl', 3),
(DEFAULT, 'johnny@gmail.nl', 3),
(DEFAULT, 'derek@millar.nl', 4),
(DEFAULT, 'zavier@blanchard.nl', 5),
(DEFAULT, 'info@notenkoor.nl', 5);

insert into offerte values
(DEFAULT,'03-02-1990','124','piet','55','41','55','9','999'),
(DEFAULT,'05-12-2000','98','Klaas','555','34','3','91','7'),
(DEFAULT,'03-05-2136','12','Jan','96','4','74','95','77'),
(DEFAULT,'22-12-5845','95','Melanie','02','7','8','19','23');

INSERT INTO brief VALUES
(DEFAULT,'01-02-2020','1288','Kasper van den Berg','duckstad 11','Pietje ging vissen en ving een karper '),
(DEFAULT,'12-04-1990','48','Jazzlyn TAN','xd 211','im bored so I started smoking weird shit it was great '),
(DEFAULT,'24-02-2002','158','Wietse Nicolaas','testshit 511','you got hacked'),
(DEFAULT,'18-08-2015','2','Jacco van den Berg','henkers 1211','Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley ');

INSERT INTO factuur
VALUES 
(DEFAULT, '12-09-2019', '16-02-2019', 'Schildering van piethje', 1,6,0.06,1.06),
(DEFAULT, '03-04-2019', '04-01-2019', 'geen zin om te typen dus fancy schilderij', 10,21,2.1,12.1),
(DEFAULT, '07-02-2019', '08-03-2019', 'notapd++ gekocht', 40.1,6,2.4,42.5),
(DEFAULT, '08-01-2017', '08-01-2020', 'winrar gekocht', 5665564.6,21,4645656,554456);

INSERT INTO kostenpost
VALUES
(DEFAULT, 'nuttige'),
(DEFAULT, 'test'),
(DEFAULT, 'data'),
(DEFAULT, 'die'),
(DEFAULT, 'daadwerkelijk'),
(DEFAULT, 'aantoont'),
(DEFAULT, 'of'),
(DEFAULT, 'de'),
(DEFAULT, 'frontend'),
(DEFAULT, 'werkt'),
(DEFAULT, 'xd');

INSERT INTO onkosten
VALUES (DEFAULT, 'hema', '2018-07-17', 'nuttige', 'tekenpennen rood zwart', 6, 10, 1, 156),
(DEFAULT, 'bedrijf', '2018-07-18', 'test', 'reizen naar klant', 25, 20, 3, 112.3),
(DEFAULT, 'vogeltre', '2018-07-19', 'data', 'ruimte om te tekenen', 55, 18, 5, 245.32),
(DEFAULT, 'what', '2018-07-20', 'die', 'papier', 6, 17, 1, 3.99),
(DEFAULT, 'ok', '2018-08-07', 'daadwerkelijk', 'bellen met klant',12, 19, 4, 2),
(DEFAULT, 'wtf', '2018-08-11', 'aantoont', 'papier', 9, 30, 1, 1234),
(DEFAULT, 'iets', '2018-08-13', 'of', 'reizen naar klant',30, 10, 3, 1094.21),
(DEFAULT, 'vjdfi', '2018-07-18', 'de', 'koffie met vrouw',10, 10, 2, 123.1),
(DEFAULT, 'fjdiv', '2018-07-19', 'frontend', 'pennen',13, 21, 1, 92.12),
(DEFAULT, 'fjswo', '2018-08-13', 'werkt', 'bellen met klant',13, 5, 4, 14.12),
(DEFAULT, 'idk', '2018-09-17', 'xd', 'reizen naar klant', 50, 21, 3, 14.15);

INSERT INTO btw_percentage
VALUES (DEFAULT, 21, 6);

INSERT INTO gebruiker
VALUES (DEFAULT, 'KAAAAAAZPER','test@test.com', '9F86D081884C7D659A2FEAA0C55AD015A3BF4F1B2B0B822CD15D6C15B0F00A08', 'ADMIN'),
(DEFAULT, 'Meneer Nicolaas','test1@test.com', '1B4F0E9851971998E732078544C96B36C3D01CEDF7CAA332359D6F1D83567014', 'USER')
