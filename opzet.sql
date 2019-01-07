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
CREATE TABLE telefoonnummer (
    id          SERIAL PRIMARY KEY,
    telnr       varchar(15),
    contact_id  integer REFERENCES contactpersoon(id) ON DELETE CASCADE
);


-- koppeltabel, een contact kan meerdere emails hebben
CREATE TABLE email (
    id          SERIAL PRIMARY KEY,
    email       varchar(60),
    contact_id  integer REFERENCES contactpersoon(id) ON DELETE CASCADE
);

-- als een contact verwijderd wordt, dan wordt ook de opdracht verwijderd??
CREATE TABLE offerte (
    id                  SERIAL PRIMARY KEY,
    opdracht_omschrijving        VARCHAR(250),
    opdracht_afrondingsdatum     VARCHAR(20),
    opdracht_kosten              DOUBLE(9,2),
    contact_id                   integer REFERENCES contactpersoon(id) ON DELETE CASCADE
);

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
    id          SERIAL PRIMARY KEY,
    btw_percentage_hoog      INT(2),
    btw_percentage_laag	     INT(2)
);

CREATE TABLE gebruiker (
    id SERIAL PRIMARY KEY,
    email_adres varchar(25),
    wachtwoord varchar(64),
    rol varchar(25)
);
