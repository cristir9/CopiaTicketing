CREATE DATABASE TICKETING;

CREATE TABLE TIPO_USUARIO(
ID_USUARIO INTEGER AUTO_INCREMENT PRIMARY KEY,
NOMBRE VARCHAR(30) NOT NULL
);
CREATE TABLE DISPOSITIVO(
ID_DISPOSITIVO INTEGER PRIMARY KEY AUTO_INCREMENT,
TIPO VARCHAR(30) NOT NULL,
MARCA VARCHAR(30) NOT NULL,
MODELO VARCHAR(30) NOT NULL,
DESCRIPCION VARCHAR(150)
);

CREATE TABLE ESTADO(
ID_ESTADO INTEGER PRIMARY KEY AUTO_INCREMENT,
NOMBRE VARCHAR(50) NOT NULL
);

CREATE TABLE TIPO_INCIDENCIA(
ID_TIPOINCIDENCIA INTEGER PRIMARY KEY AUTO_INCREMENT,
NOMBRE VARCHAR(50) NOT NULL
);

CREATE TABLE PRIORIDAD(
ID_PRIORIDAD INTEGER PRIMARY KEY AUTO_INCREMENT,
NOMBRE VARCHAR(50) NOT NULL
);

CREATE TABLE INCIDENCIA(
ID_INCIDENCIA INTEGER PRIMARY KEY AUTO_INCREMENT,
FECHA_INICIO DATE NOT NULL,
FECHA_PUBLICACION DATE NOT NULL,
FECHA_FIN DATE,
ID_ESTADO INTEGER NOT NULL,
ID_USUARIO INTEGER NOT NULL,
ID_TIPOINCIDENCIA INTEGER NOT NULL,
ID_DISPOSITIVO INTEGER NOT NULL,
DESCRIPCION_INCIDENCIA VARCAHR(500),
DESCRIPCION_SOLUCION VARCHAR(500),
ID_PRIORIDAD INTEGER NOT NULL,
ID_USUARIO_TECNICO INTEGER NOT NULL,
CONSTRAINT FK_TECNICO FOREIGN KEY (ID_USUARIO_TECNICO) REFERENCES USUARIO (ID_USUARIO),
CONSTRAINT FK_DISPOSITIVO FOREIGN KEY (ID_DISPOSITIVO) REFERENCES DISPOSITIVO (ID_DISPOSITIVO),
CONSTRAINT FK_PRIORIDAD FOREIGN KEY (ID_PRIORIDAD) REFERENCES PRIORIDAD (ID_PRIORIDAD),
CONSTRAINT FK_TIPOINCIDENCIA FOREIGN KEY (ID_TIPOINCIDENCIA) REFERENCES TIPO_INCIDENCIA (ID_TIPOINCIDENCIA),
CONSTRAINT FK_ESTADO FOREIGN KEY (ID_ESTADO) REFERENCES ESTADO(ID_ESTADO),
CONSTRAINT FK_ID_USUARIO FOREIGN KEY  (ID_USUARIO) REFERENCES USUARIO(ID_USUARIO)
);

CREATE TABLE USUARIO(
ID_USUARIO INTEGER PRIMARY KEY AUTO_INCREMENT,
NOMBRE VARCHAR(50) NOT NULL,
APELLIDO VARCHAR(50) NOT NULL,
NICKNAME VARCHAR(50) NOT NULL,
CONTRASENA VARCHAR(30) NOT NULL,
EMAIL VARCHAR(50) NOT NULL,
IS_ACTIVO BOOLEAN NOT NULL,
ID_TIPOUSUARIO INTEGER NOT NULL,
CONSTRAINT FK_TIPO_USUARIO FOREIGN KEY  (ID_TIPOUSUARIO) REFERENCES TIPO_SUARIO(COD_USUARIO)
);

INSERT INTO TIPO_USUARIO VALUES (1 , 'ADMINISTRADOR');
INSERT INTO TIPO_USUARIO VALUES (2 , 'TECNICO');
INSERT INTO TIPO_USUARIO VALUES (3 , 'GESTOR');
INSERT INTO TIPO_USUARIO VALUES (9 , 'USUARIO');

INSERT INTO ESTADO VALUES (0,'ABIERTA');
INSERT INTO ESTADO VALUES (1,'EN TRAMITE');
INSERT INTO ESTADO VALUES (2,'CERRADA');
INSERT INTO ESTADO VALUES (3,'RESUELTA');

INSERT INTO PRIORIDAD VALUES (0,'ALTA');
INSERT INTO PRIORIDAD VALUES (1,'BAJA');
INSERT INTO PRIORIDAD VALUES (2,'MEDIA');

INSERT INTO TIPO_INCIDENCIA VALUES(0,'HARDWARE');
INSERT INTO TIPO_INCIDENCIA VALUES(1,'SOFTWARE');
INSERT INTO TIPO_INCIDENCIA VALUES(2,'RED');
INSERT INTO TIPO_INCIDENCIA VALUES(3,'PERIFERICOS');



