CREATE TABLE Especialidad(
idEspecialidad NUMBER(5),
nombre VARCHAR2(50) NOT NULL UNIQUE,
PRIMARY KEY (idEspecialidad)
);

CREATE TABLE EPS(
idEPS NUMBER(5),
nombre VARCHAR2(50) NOT NULL UNIQUE,
direccion VARCHAR2(50) NOT NULL UNIQUE,
telefono VARCHAR2(50) NOT NULL UNIQUE,
PRIMARY KEY (idEPS)
);

CREATE TABLE IPS(
NIT NUMBER(5) PRIMARY KEY,
nombre VARCHAR2(50) NOT NULL UNIQUE,
direccion VARCHAR2(50) NOT NULL UNIQUE,
telefono VARCHAR2(50) NOT NULL UNIQUE,
idEps NUMBER(5) NOT NULL,
CONSTRAINT fk_EPS FOREIGN KEY (idEPS) REFERENCES EPS(idEPS)
);

-- Creación de la tabla de Usuarios.
CREATE TABLE USUARIOS
(   ID NUMBER PRIMARY KEY, 
    NOMBRE VARCHAR2(256 BYTE), 
    TIPO_DOCUMENTO VARCHAR2(256 BYTE), -- (CC, TI, Pasaporte, etc.)
    NUMERO_DOCUMENTO VARCHAR2(256 BYTE)
);

-- Creación de la tabla de Médicos.
CREATE TABLE MEDICOS
(   ID NUMBER PRIMARY KEY,
    ESPECIALIDAD VARCHAR2(256 BYTE), 
    REGISTRO_MEDICO VARCHAR2(256 BYTE), 

    -- Establece una relación de herencia con la tabla USUARIOS, lo que significa que un médico es un usuario
    CONSTRAINT FK_ID_MEDICO FOREIGN KEY(ID)
    REFERENCES USUARIOS(ID)
);

CREATE TABLE Afiliado(
idAfiliado NUMBER(5) PRIMARY KEY,
fechaNacimiento DATE NOT NULL,
direccion VARCHAR2(50) NOT NULL,
telefono VARCHAR2(50) NOT NULL,
tipoAfiliado VARCHAR2(50) NOT NULL,
idUsuario NUMBER(5) NOT NULL,
CONSTRAINT fk_Afiliado_Usuario FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario)
);

CREATE TABLE OrdenDeServicio(
idOrden NUMBER(5) PRIMARY KEY,
Fecha DATE NOT NULL,
Estado VARCHAR2(50) CHECK (Estado IN ('Vigente', 'Cancelada', 'Completada')),
idAfiliado NUMBER(5) NOT NULL,
idMedico NUMBER(5) NOT NULL,
CONSTRAINT fk_Orden_Afiliado FOREIGN KEY (idAfiliado) REFERENCES Afiliado(idAfiliado),
CONSTRAINT fk_Orden_Medico FOREIGN KEY (idMedico) REFERENCES Medico(idMedico)
);

CREATE TABLE Servicio (
    idServicio NUMBER(5) PRIMARY KEY,
    nombre VARCHAR2(150),
    descripcion VARCHAR2(500)
);

CREATE TABLE IPSservicio(
idServicio NUMBER(5) NOT NULL,
NIT NUMBER(5) NOT NULL,
Agenda VARCHAR(500),
CONSTRAINT fk_Servicio_IPSServicio FOREIGN KEY (idServicio) REFERENCES Servicio(idServicio),
CONSTRAINT fk_IPS_IPSServicio FOREIGN KEY (NIT) REFERENCES IPS(NIT),
PRIMARY KEY (idServicio, NIT)
);

CREATE TABLE CitaMedica (
idCita NUMBER(5) PRIMARY KEY,
fechaHora DATE NOT NULL,
idOrden NUMBER(5) NOT NULL,
NIT NUMBER(5) NOT NULL,
CONSTRAINT fk_CitaMedica_Orden FOREIGN KEY (idOrden) REFERENCES OrdenDeServicio(idOrden),
CONSTRAINT fk_CitaMedica_Servicio FOREIGN KEY (NIT) REFERENCES IPS(NIT)
);

CREATE TABLE Parentesco (
    IdParentesco NUMBER(5) PRIMARY KEY,
    Descripcion VARCHAR2(100)
);

CREATE TABLE ContribuyenteBeneficiario (
    idContribuyente NUMBER(5) NOT NULL,
    idBeneficiario NUMBER(5) NOT NULL,
    idParentesco NUMBER(5) NOT NULL,
    CONSTRAINT fk_Beneficiario_Afiliado FOREIGN KEY (idBeneficiario) REFERENCES Afiliado(idAfiliado),
    CONSTRAINT fk_Contribuyente_Afiliado FOREIGN KEY (idContribuyente) REFERENCES Afiliado(idAfiliado),
    CONSTRAINT fk_Beneficiario_Parentesco FOREIGN KEY (idParentesco) REFERENCES Parentesco(idParentesco),
    PRIMARY KEY (idBeneficiario, idContribuyente)
);

select * from medicos;
select * from ips;
select * from eps;
select * from especialidad;
select * from usuarios;
select * from afiliado;
select * from ordenDeServicio;
select * from servicio;
select * from ipsservicio;
select * from citamedica;
select * from parentesco;
