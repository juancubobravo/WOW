CREATE TABLE AUTORIZACION (TIPO VARCHAR, ID_ID VARCHAR NOT NULL, IDAUTORIZADA_IDAUTORIZADA VARCHAR NOT NULL, PRIMARY KEY (ID_ID, IDAUTORIZADA_IDAUTORIZADA))
CREATE TABLE CLIENTE (ID VARCHAR NOT NULL, DTYPE VARCHAR(31), CIUDAD VARCHAR, CODIGOPOSTAL VARCHAR, DIRECCION VARCHAR, ESTADO VARCHAR, FECHAALTA DATE, FECHABAJA DATE, IDENTIFICACION VARCHAR UNIQUE, PAIS VARCHAR, TIPOCLIENTE VARCHAR, RAZONSOCIAL VARCHAR, APELLIDO VARCHAR, FECHANACIMIENTO DATE, NOMBRE VARCHAR, PRIMARY KEY (ID))
CREATE TABLE CUENTA (IBAN VARCHAR NOT NULL, DTYPE VARCHAR(31), SWIFT VARCHAR UNIQUE, CLASIFICACION VARCHAR, ESTADO VARCHAR, FECHAAPERTURA DATE, FECHACIERRE DATE, CUENTA_FINTECH_CLIENTE VARCHAR NOT NULL, NOMBREBANCO VARCHAR, PAIS VARCHAR, SALDO DOUBLE, SUCURSAL VARCHAR, ABREVIATURA_ABREVIATURA VARCHAR, PRIMARY KEY (IBAN))
CREATE TABLE DIVISA (ABREVIATURA VARCHAR NOT NULL, CAMBIOEURO DOUBLE, NOMBRE VARCHAR, SIMBOLO VARCHAR, IDUNICO_IDUNICO VARCHAR, IDUNICO2_IDUNICO VARCHAR, PRIMARY KEY (ABREVIATURA))
CREATE TABLE PERSONAAUTORIZADA (IDAUTORIZADA VARCHAR NOT NULL, APELLIDOS VARCHAR, DIRECCION VARCHAR, ESTADO VARCHAR, FECHAFIN TIMESTAMP, FECHAINICIO TIMESTAMP, FECHANACIMIENTO TIMESTAMP, IDENTIFICACION VARCHAR UNIQUE, NOMBRE VARCHAR, PRIMARY KEY (IDAUTORIZADA))
CREATE TABLE TRANSACCION (IDUNICO VARCHAR NOT NULL, CANTIDAD DOUBLE, COMISION VARCHAR, FECHAEJECUCION DATE, FECHAINSTRUCCION DATE, INTERNACIONAL VARCHAR, TIPO VARCHAR, IBAN_IBAN VARCHAR, IBAN1_IBAN VARCHAR, PRIMARY KEY (IDUNICO))
CREATE TABLE CLIENTE_CUENTA (Cliente_ID VARCHAR NOT NULL, cuentas_IBAN VARCHAR NOT NULL, PRIMARY KEY (Cliente_ID, cuentas_IBAN))
ALTER TABLE AUTORIZACION ADD CONSTRAINT FK_AUTORIZACION_IDAUTORIZADA_IDAUTORIZADA FOREIGN KEY (IDAUTORIZADA_IDAUTORIZADA) REFERENCES PERSONAAUTORIZADA (IDAUTORIZADA)
ALTER TABLE AUTORIZACION ADD CONSTRAINT FK_AUTORIZACION_ID_ID FOREIGN KEY (ID_ID) REFERENCES CLIENTE (ID)
ALTER TABLE CUENTA ADD CONSTRAINT FK_CUENTA_CUENTA_FINTECH_CLIENTE FOREIGN KEY (CUENTA_FINTECH_CLIENTE) REFERENCES CLIENTE (ID)
ALTER TABLE CUENTA ADD CONSTRAINT FK_CUENTA_ABREVIATURA_ABREVIATURA FOREIGN KEY (ABREVIATURA_ABREVIATURA) REFERENCES DIVISA (ABREVIATURA)
ALTER TABLE DIVISA ADD CONSTRAINT FK_DIVISA_IDUNICO_IDUNICO FOREIGN KEY (IDUNICO_IDUNICO) REFERENCES TRANSACCION (IDUNICO)
ALTER TABLE DIVISA ADD CONSTRAINT FK_DIVISA_IDUNICO2_IDUNICO FOREIGN KEY (IDUNICO2_IDUNICO) REFERENCES TRANSACCION (IDUNICO)
ALTER TABLE TRANSACCION ADD CONSTRAINT FK_TRANSACCION_IBAN_IBAN FOREIGN KEY (IBAN_IBAN) REFERENCES CUENTA (IBAN)
ALTER TABLE TRANSACCION ADD CONSTRAINT FK_TRANSACCION_IBAN1_IBAN FOREIGN KEY (IBAN1_IBAN) REFERENCES CUENTA (IBAN)
ALTER TABLE CLIENTE_CUENTA ADD CONSTRAINT FK_CLIENTE_CUENTA_Cliente_ID FOREIGN KEY (Cliente_ID) REFERENCES CLIENTE (ID)
ALTER TABLE CLIENTE_CUENTA ADD CONSTRAINT FK_CLIENTE_CUENTA_cuentas_IBAN FOREIGN KEY (cuentas_IBAN) REFERENCES CUENTA (IBAN)
CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT NUMERIC(38), PRIMARY KEY (SEQ_NAME))
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0)
