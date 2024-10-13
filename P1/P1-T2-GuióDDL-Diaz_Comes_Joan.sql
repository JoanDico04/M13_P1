CREATE TABLE usuaris (
  login INT PRIMARY KEY,
  nom VARCHAR2(30) NOT NULL,
  password VARCHAR2(30) NOT NULL
);

CREATE TABLE temporada (
  año DATE PRIMARY KEY,
  FOREIGN KEY (id_jugador)
  REFERENCES equip(id_jugador)
);

CREATE TABLE categoria (
  id_categoria INT PRIMARY KEY,
  nom VARCHAR2(30) UNIQUE,
  edat_min INT NOT NULL,
  edat_max INT NOT NULL
);

CREATE TABLE equip(
  id_equip INT PRIMARY KEY,
  nom VARCHAR2(30) NOT NULL,
  tipus VARCHAR2(30) NOT NULL
);

CREATE TABLE jugador(
  id_jugador INT PRIMARY KEY,
  nom VARCHAR2(30) NOT NULL,
  cognoms VARCHAR(50) NOT NULL,
  sexe VARCHAR2(10) NOT NULL,
  data_naix DATE NOT NULL,
  IdLegal INT UNIQUE,
  IBAN VARCHAR2(20) NOT NULL,
  any_fi_revisio_medica DATE NOT NULL,
  adreça VARCHAR2(40) NOT NULL,
  foto BLOB
);

