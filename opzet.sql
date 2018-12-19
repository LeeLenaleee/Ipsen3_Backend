CREATE TABLE contactpersoon (
    id          SERIAL PRIMARY KEY,
    contact_achternaam   varchar(25),
    contact_voornaam    varchar(25),
    contact_bedrijf     varchar(25),
    contact_straatnaam  varchar(25),
    contact_postcode    varchar(25),
    contact_plaats      varchar(25),
    contact_land        varchar(25),
    contact_relatie     varchar(20),
    contact_website     TEXT
);

-- koppeltabel, een contact kan meerdere telefoonnummers hebben
CREATE TABLE telefoonnummers (
    telnr       varchar(25) PRIMARY KEY,
    contact_id  integer REFERENCES contactpersoon(id) ON DELETE CASCADE
);


-- koppeltabel, een contact kan meerdere emails hebben
CREATE TABLE emails (
    email       varchar(25) PRIMARY KEY,
    contact_id  integer REFERENCES contactpersoon(id) ON DELETE CASCADE
);

-- als een contact verwijderd wordt, dan wordt ook de opdracht verwijderd??
CREATE TABLE offerte (
    id                  SERIAL PRIMARY KEY,
    opdracht_omschrijving        TEXT,
    opdracht_afrondingsdatum     DATE,
    opdracht_kosten              INT,
    contact_id                   integer REFERENCES contactpersoon(id) ON DELETE CASCADE
);

CREATE TABLE factuur (
    id             SERIAL PRIMARY KEY,
    factuur_beschrijving   TEXT,
    factuur_status         varchar(25),
    offerte_id            integer REFERENCES offerte(id) ON DELETE SET NULL,
    contact_id             integer REFERENCES contactpersoon(id) ON DELETE SET NULL
);

CREATE TABLE onkosten (
    id              SERIAL PRIMARY KEY,
    onkosten_bedrijf         VARCHAR(50),
    onkosten_datum           DATE,
	onkosten_kostenpost 	 VARCHAR(50),
    onkosten_omschrijving    TEXT,
    onkosten_bruto_kosten    NUMERIC,
	onkosten_btw_percentage	 NUMERIC,
	onkosten_btw_kosten		 NUMERIC,
	onkosten_netto_kosten	 NUMERIC
);

CREATE TABLE btw_percentage (
    btw_percentage_hoog      NUMERIC(2),
	btw_percentage_laag		 NUMERIC(2)
);
