INSERT INTO contactpersoon
VALUES (DEFAULT, 'Park', 'Morris', 'Bake Shop', 'Bazuinpad', '6295AH', 'Leuven', 'Nederland', 'klant', 'morrisss.nl'),
(DEFAULT, 'Langley', 'Gracie', 'The Movable Feast', 'Tjalkmeen', '5921VR', 'Amersfort', 'Nederland', 'vriend', 'themovablefeast.nl'),
(DEFAULT, 'Kane', 'Johnathan', 'Trendkoo', 'Hanzemeen', '9372CE', 'Den Bosch', 'Nederland', 'leverancier', 'jfiofg.nlfd'),
(DEFAULT, 'Millar', 'Derek', 'Vogeltre', 'Busken Huetlaan', '0563ZN', 'Zutphen', 'Nederland', 'kennis', 'asdfghj.com'),
(DEFAULT, 'Blanchard', 'Zavier', 'Notenkoor', 'Weisteeg', '2479KD', 'Deventer', 'Nederland', 'klant', 'dfigovdfjgiv.nl');

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
(DEFAULT,'03-02-1990','654','piet','55','4','55','9','999'),
(DEFAULT,'05-12-2000','654','Klaas','555','4','3','9','7'),
(DEFAULT,'03-05-2136','654','Jan','96','4','74','9','77'),
(DEFAULT,'22-12-5845','654','Melanie','02','7','8','9','23')

INSERT INTO brief VALUES
(DEFAULT,'01-02-2020','988','Kasper van den Berg','Zernikdreef 11','Pietje ging vissen en ving een karper '),
(DEFAULT,'12-04-1990','988','Jazzlyn TAN','Zernikdreef 11','im bored so I started smoking weird shit it was great '),
(DEFAULT,'24-02-2002','988','Wietse Nicolaas','Zernikdreef 11','you got hacked'),
(DEFAULT,'18-08-2015','988','Jacco van den Berg','Zernikdreef 11','Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley ')

INSERT INTO factuur
VALUES 
(DEFAULT, '12-09-2019', '16-02-2019', 'Schildering van piethje', 1,6,0.06,1.06),
(DEFAULT, '03-04-2019', '04-01-2019', 'geen zin om te typen dus fancy schilderij', 10,21,2.1,12.1),
(DEFAULT, '07-02-2019', '08-03-2019', 'notapd++ gekocht', 40.1,6,2.4,42.5),
(DEFAULT, '08-01-2017', '08-01-2020', 'winrar gekocht', 5665564.6,21,4645656,554456);

INSERT INTO onkosten
VALUES (DEFAULT, 'hema', '2018-07-17', 'nuttige', 'tekenpennen rood zwart', 6, 10, 1, 156),
(DEFAULT, 'bedrijf', '2018-07-18', 'test', 'reizen naar klant', 25, 20, 3, 112.3),
(DEFAULT, 'vogeltre', '2018-07-19', 'data', 'ruimte om te tekenen', 55, 18, 5, 245.32),
(DEFAULT, 'what', '2018-07-20', 'die', 'papier', 6, 17, 1, 3.99),
(DEFAULT, 'ok', '2018-08-07', 'daadwerkelijk', 'bellen met klant',12, 19, 4, 2),
(DEFAULT, 'wtf', '2018-08-11', 'aantoond', 'papier', 9, 30, 1, 1234),
(DEFAULT, 'iets', '2018-08-13', 'of', 'reizen naar klant',30, 10, 3, 1094.21),
(DEFAULT, 'vjdfi', '2018-07-18', 'de', 'koffie met vrouw',10, 10, 2, 123.1),
(DEFAULT, 'fjdiv', '2018-07-19', 'frontend', 'pennen',13, 21, 1, 92.12),
(DEFAULT, 'fjswo', '2018-08-13', 'werkt', 'bellen met klant',13, 5, 4, 14.12),
(DEFAULT, 'idk', '2018-09-17', 'xd', 'reizen naar klant', 50, 21, 3, 14.15);

INSERT INTO btw_percentage
VALUES (DEFAULT, 21, 6);

INSERT INTO gebruiker
VALUES (DEFAULT, 'test@test.com', '098f6bcd4621d373cade4e832627b4f6', 'admin'),
(DEFAULT, 'test1@test.com', '5a105e8b9d40e1329780d62ea2265d8a', 'user')
