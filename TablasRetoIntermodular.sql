create database contenidomultimedia;
use contenidomultimedia;


CREATE TABLE Autor (
  DNI char(9) PRIMARY KEY,
  Nombre VARCHAR(50) NOT NULL,
  Fecha_nac DATE NOT NULL,
  Ciudad_nac VARCHAR(50) NOT NULL
);


CREATE TABLE Editorial (
  ID_Editorial INT(4) PRIMARY KEY,
  Nombre VARCHAR(50) NOT NULL,
  Director VARCHAR(50) NOT NULL,
  Ubicacion VARCHAR(50) NOT NULL
);





CREATE TABLE Proveedor (
  NIF VARCHAR(50) PRIMARY KEY,
  Nombre VARCHAR(50) NOT NULL,
  Ubicacion VARCHAR(50) NOT NULL
);


CREATE TABLE Usuario (
  Codigo_Usuario int auto_increment PRIMARY KEY ,
  Email VARCHAR(50) NOT NULL,
  Nombre VARCHAR(50) NOT NULL,
  Apellido VARCHAR(50) NOT NULL,
  Contraseña VARCHAR(50) NOT NULL
);


CREATE TABLE ContenidoMultimedia (
  Codigo INT(4) PRIMARY KEY,
  Titulo VARCHAR(50) NOT NULL,
  Año_ini YEAR NOT NULL,
  Estado VARCHAR(50) NOT NULL,
  Puntuacion INT NOT NULL,
  Codigo_Autor char(9),
  FOREIGN KEY (Codigo_Autor) REFERENCES Autor(DNI)
);

CREATE TABLE Manga (
  Codigo INT(4) PRIMARY KEY,
  ISBN int NOT NULL,
  NumTomos INT NOT NULL,
  Periodicidad VARCHAR(50) NOT NULL,
  Precio DECIMAL(10,2) NOT NULL,
  Stock INT NOT NULL,
  ID_Editorial INT,
  FOREIGN KEY (ID_Editorial) REFERENCES Editorial(ID_Editorial),
  FOREIGN KEY (Codigo) REFERENCES ContenidoMultimedia(Codigo)
);
CREATE TABLE Compra (
   Codigo_Usuario int, 
   Codigo INT(4) ,
   PRIMARY KEY(Codigo_Usuario ,Codigo),
  FOREIGN KEY (Codigo_Usuario) REFERENCES Usuario(Codigo_Usuario),
  FOREIGN KEY (Codigo) REFERENCES Manga(Codigo)
);
CREATE TABLE Estudio (
  Nombre VARCHAR(50) PRIMARY KEY,
  Fecha_fun DATE NOT NULL,
  NumEmp INT NOT NULL,
  PreAnu DECIMAL(10,2) NOT NULL,
  AnimacionCaracteristica VARCHAR(50) NOT NULL
);


CREATE TABLE Anime (
  Codigo INT(4) PRIMARY KEY,
  TipoAnime VARCHAR(50) NOT NULL,
  Capitulos INT NOT NULL,
  Temporadas INT NOT NULL,
  Estudio VARCHAR(50),
  FOREIGN KEY (Estudio) REFERENCES Estudio(Nombre),
  FOREIGN KEY (Codigo) REFERENCES ContenidoMultimedia(Codigo)
);

CREATE TABLE Actor (
  DNI char(9) PRIMARY KEY,
  Nombre VARCHAR(50) NOT NULL,
  Fecha_nac DATE NOT NULL,
  Lugar_nac VARCHAR(50) NOT NULL
);

CREATE TABLE Actua (
  Codigo_Anime INT (4),
  DNI_Actor char(9),
  PRIMARY KEY (Codigo_Anime, DNI_Actor),
  FOREIGN KEY (Codigo_Anime) REFERENCES Anime(Codigo),
  FOREIGN KEY (DNI_Actor) REFERENCES Actor(DNI)
);

use contenidomultimedia;
select * from Usuario;