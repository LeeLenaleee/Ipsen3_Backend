INSERT INTO contactpersoon
VALUES (DEFAULT, 'Park', 'Morris', 'Bake Shop', 'Bazuinpad', '6295AH', 'Leuven', 'Nederland', 'klant', 'morrisss.nl'),
(DEFAULT, 'Langley', 'Gracie', 'The Movable Feast', 'Tjalkmeen', '5921VR', 'Amersfort', 'Nederland', 'vriend', 'themovablefeast.nl'),
(DEFAULT, 'Kane', 'Johnathan', 'Trendkoo', 'Hanzemeen', '9372CE', 'Den Bosch', 'Nederland', 'leverancier', 'jfiofg.nlfd'),
(DEFAULT, 'Millar', 'Derek', 'Vogeltre', 'Busken Huetlaan', '0563ZN', 'Zutphen', 'Nederland', 'kennis', 'asdfghj.com'),
(DEFAULT, 'Blanchard', 'Zavier', 'Notenkoor', 'Weisteeg', '2479KD', 'Deventer', 'Nederland', 'klant', 'dfigovdfjgiv.nl');

INSERT INTO telefoonnummers
VALUES ('12345678', 1),
('23456789', 2),
('34567890', 2),
('09876543', 3),
('98765432', 4),
('87654321', 4),
('38590215', 4),
('58653346', 5);

INSERT INTO emails
VALUES ('morris@park.nl', 1),
('gracie@langley.nl', 2),
('johnathan@kane.nl', 3),
('info@trendkoo.nl', 3),
('johnny@gmail.nl', 3),
('derek@millar.nl', 4),
('zavier@blanchard.nl', 5),
('info@notenkoor.nl', 5);

INSERT INTO offerte 
VALUES (DEFAULT, 'Illustratie voor logo van het bedrijf', '2018-08-12', 1),
(DEFAULT, 'Infographics voor taart', '2018-09-15', 1),
(DEFAULT, 'omschrijving', '2018-10-02', 4),
(DEFAULT, 'Illustratie van noten', '2018-11-23', 5);

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
VALUES (21, 6);
