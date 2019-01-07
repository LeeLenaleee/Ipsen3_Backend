CREATE TABLE contactpersoon (
    id          SERIAL PRIMARY KEY,
    contact_achternaam   varchar(25),
    contact_voornaam    varchar(25),
    contact_bedrijf     varchar(25),
    contact_straatnaam  varchar(50),
    contact_postcode    varchar(25),
    contact_plaats      varchar(25),
    contact_land        varchar(25),
    contact_relatie     varchar(30),
    contact_website     varchar(100)
);

-- koppeltabel, een contact kan meerdere telefoonnummers hebben
CREATE TABLE telefoonnummers (
    telnr       varchar(15) PRIMARY KEY,
    contact_id  integer REFERENCES contactpersoon(id) ON DELETE CASCADE
);


-- koppeltabel, een contact kan meerdere emails hebben
CREATE TABLE emails (
    email       varchar(60) PRIMARY KEY,
    contact_id  integer REFERENCES contactpersoon(id) ON DELETE CASCADE
);

-- als een contact verwijderd wordt, dan wordt ook de opdracht verwijderd??
INSERT INTO factuur
VALUES (DEFAULT, 'Illustratie logo', 'klant heeft betaald', 13.5, 1),
(DEFAULT, 'Infographic taart', 'factuur is verstuurd', 2.3, 1),
(DEFAULT, 'beschrijving', 'klaar voor factuur', 3.11, 4),
(DEFAULT, 'Noten', 'Nog niet klaar', 43.4, 5);


CREATE TABLE factuur (
    id             SERIAL PRIMARY KEY,
    factuur_beschrijving   VARCHAR(250),
    factuur_status         varchar(25),
    offerte_id            integer REFERENCES offerte(id) ON DELETE SET NULL,
    contact_id             integer REFERENCES contactpersoon(id) ON DELETE SET NULL
);

CREATE TABLE onkosten (
    id              SERIAL PRIMARY KEY,
    onkosten_bedrijf         VARCHAR(50),
    onkosten_datum           VARCHAR(20),
	onkosten_kostenpost 	 VARCHAR(50),
    onkosten_omschrijving    VARCHAR(250),
    onkosten_bruto_kosten    DOUBLE(9,2),
	onkosten_btw_percentage	 INT(2),
	onkosten_btw_kosten		 DOUBLE(9,2),
	onkosten_netto_kosten	 DOUBLE(9,2)
);

CREATE TABLE btw_percentage (
    btw_percentage_hoog      INT(2),
	btw_percentage_laag		 INT(2)
);
