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

INSERT INTO offerte 
VALUES (DEFAULT, 'Illustratie voor logo van het bedrijf', '2018-08-12', 1.92,0),
(DEFAULT, 'Infographics voor taart', '2018-09-15', 13.12,1),
(DEFAULT, 'omschrijving', '2018-10-02', 4.12,2),
(DEFAULT, 'Illustratie van noten', '2018-11-23', 55.2,3);


INSERT INTO factuur
VALUES (DEFAULT, 'Illustratie logo', 'klant heeft betaald', 1, 1),
(DEFAULT, 'Infographic taart', 'factuur is verstuurd', 2, 1),
(DEFAULT, 'beschrijving', 'klaar voor factuur', 3, 4),
(DEFAULT, 'Noten', 'Nog niet klaar', 4, 5);

INSERT INTO onkosten
VALUES (DEFAULT, 'hema', '2018-07-17', 'kost', 'tekenpennen rood zwart', 6, 10, 1, 14),
(DEFAULT, 'bedrijf', '2018-07-18', 'kost', 'reizen naar klant', 25, 20, 3, 14),
(DEFAULT, 'vogeltre', '2018-07-19', 'kost', 'ruimte om te tekenen', 55, 18, 5, 14),
(DEFAULT, 'what', '2018-07-20', 'kost', 'papier', 6, 17, 1, 14),
(DEFAULT, 'ok', '2018-08-07', 'kost', 'bellen met klant',12, 19, 4, 14),
(DEFAULT, 'wtf', '2018-08-11', 'kost', 'papier', 9, 30, 1, 14),
(DEFAULT, 'iets', '2018-08-13', 'kost', 'reizen naar klant',30, 10, 3, 14),
(DEFAULT, 'vjdfi', '2018-07-18', 'kost', 'koffie met vrouw',10, 10, 2, 14),
(DEFAULT, 'fjdiv', '2018-07-19', 'kost', 'pennen',13, 21, 1, 14),
(DEFAULT, 'fjswo', '2018-08-13', 'kost', 'bellen met klant',13, 5, 4, 14),
(DEFAULT, 'idk', '2018-09-17', 'kost', 'reizen naar klant', 50, 21, 3, 14);

INSERT INTO btw_percentage
VALUES (DEFAULT, 21, 6);

INSERT INTO gebruiker
VALUES (DEFAULT, 'test@test.com', '098f6bcd4621d373cade4e832627b4f6', 'admin'),
(DEFAULT, 'test1@test.com', '5a105e8b9d40e1329780d62ea2265d8a', 'user')
        
