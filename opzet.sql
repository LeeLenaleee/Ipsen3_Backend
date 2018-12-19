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
CREATE TABLE opdracht (
    id                  SERIAL PRIMARY KEY,
    opdracht_omschrijving        TEXT,
    opdracht_afrondingsdatum     DATE,
    opdracht_kosten              INT,
    contact_id                   integer REFERENCES contactpersoon(id) ON DELETE CASCADE
);

CREATE TABLE kostenpost (
    id       SERIAL PRIMARY KEY,
    kostenpost_naam     varchar(15)
);

CREATE TABLE factuur (
    id             SERIAL PRIMARY KEY,
    factuur_beschrijving   TEXT,
    factuur_status         varchar(25),
    opdracht_id            integer REFERENCES opdracht(id) ON DELETE SET NULL,
    contact_id             integer REFERENCES contactpersoon(id) ON DELETE SET NULL
);

CREATE TABLE onkosten (
    id              SERIAL PRIMARY KEY,
    onkosten_bedrijf         VARCHAR(50),
    onkosten_datum           DATE,
    onkosten_prijs           NUMERIC,
    onkosten_omschrijving    TEXT,
    onkosten_bruto_cost      NUMERIC,
    onkosten_btw_percentage  NUMERIC(2),
    kostenpost_id            integer REFERENCES kostenpost(id) ON DELETE SET NULL
);

CREATE TABLE btw_percentage (
    percentage              NUMERIC(2)
);
