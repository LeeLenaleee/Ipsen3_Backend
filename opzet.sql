CREATE TABLE contactpersoon (
  id 						int not null auto_increment,
  contact_achternaam  varchar(25),
  contact_voornaam    varchar(25),
  contact_bedrijf     varchar(25),
  contact_straatnaam  varchar(50),
  contact_postcode    varchar(25),
  contact_plaats      varchar(25),
  contact_land        varchar(25),
  contact_relatie     varchar(30),
  contact_website     varchar(100),
  primary key(id)
);

-- koppeltabel, een contact kan meerdere telefoonnummers hebben
CREATE TABLE telefoonnummer (
  id 			 int not null auto_increment,
  telnr       varchar(15),
  primary key(id),
  contact_id  integer REFERENCES contactpersoon(id) ON DELETE CASCADE
   
);


-- koppeltabel, een contact kan meerdere emails hebben
CREATE TABLE email (
  id int not null auto_increment,
  email       varchar(60),
  primary key(id),
  contact_id  integer REFERENCES contactpersoon(id) ON DELETE CASCADE
);

-- als een contact verwijderd wordt, dan wordt ook de opdracht verwijderd??
CREATE TABLE offerte (
  id int not null auto_increment,
	datum VARCHAR(12),
	correspondentienummer VARCHAR(25),
	naamklant VARCHAR(25),
	uren VARCHAR(4),
	btwPercentage VARCHAR(3),
	kostenBruto VARCHAR(10),
	kostenBTW VARCHAR(10),
	kostenNetto VARCHAR(10),
  primary key(id)
);

CREATE TABLE factuur (
	id int not null auto_increment,
  datum				VARCHAR(12),
  #id is het factuur nummer
  aflever_datum			VARCHAR(12),
  factuur_omschrijving   		VARCHAR(250),
  bruto_kosten			DOUBLE(9, 2),
  btw_percentage			INT(2),
  btw_kosten				DOUBLE(9, 2),
  netto_kosten			DOUBLE(9, 2),
  primary key(id)
);

CREATE TABLE onkosten (
  id int not null auto_increment,
  onkosten_bedrijf         VARCHAR(50),
  onkosten_datum           VARCHAR(20),
	-- We can't refer to the P-key of kostenpost,
	-- if a `kostenpost` is deleted,
	-- we still want to see onkosten with the deleted kostenpost,
	-- but we dont want deleted kostenposten
	-- to show op in the list we show them in
	--
	-- Having said that, its possible to simulate
	-- a deletion with an `is_dead` column on the kostenpost,
	-- however this requires extra space, and is a little bit weird also.
	--
	-- Now we just copy the VARCHAR from the kostenpost into here,
	-- So we can delete a kostenpost, while it still remains here.
	kostenpost_kostenpost        VARCHAR(50),
  onkosten_omschrijving    VARCHAR(250),
  onkosten_bruto_kosten    DOUBLE(9,2),
	onkosten_btw_percentage	 INT(2),
	onkosten_btw_kosten		 DOUBLE(9,2),
	onkosten_netto_kosten	 DOUBLE(9,2),
	primary key(id)
);

CREATE TABLE kostenpost (
  id int not null auto_increment,
  kostenpost_kostenpost VARCHAR(50),
  primary key(id)
);

CREATE TABLE brief (
  id int not null auto_increment,
  datum				VARCHAR(12),
  correspondentie			VARCHAR(12),
  betreft   		VARCHAR(25),
  adresering			VARCHAR(50),
  verhaal			TEXT,
  primary key(id)
);

CREATE TABLE btw_percentage (
  id int not null auto_increment,
  btw_percentage_hoog      INT(2),
  btw_percentage_laag	     INT(2),
  primary key(id)
);

CREATE TABLE gebruiker (
  id int not null auto_increment,
	gebruikersnaam varchar(25),
  email_adres varchar(25),
  wachtwoord varchar(64),
  rol varchar(25),
  primary key(id)
);
