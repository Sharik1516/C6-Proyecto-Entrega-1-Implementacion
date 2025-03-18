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

CREATE TABLE Beneficiario(
CONSTRAINT idBeneficiario FOREIGN KEY (idAfiliado) REFERENCES Afiliado(idAfiliado),
parentesco VARCHAR2(50) NOT NULL,
CONSTRAINT fk_Contribuyente FOREIGN KEY (idContribuyente) REFERENCES Contribuyente(idContribuyente),
PRIMARY KEY (idBeneficiario)
);

CREATE TABLE Contribuyente(
CONSTRAINT idContribuyente FOREIGN KEY (idAfiliado) REFERENCES Afiliado(idAfiliado),
nombreEmpresa VARCHAR2(50) NOT NULL,
PRIMARY KEY (idContribuyente)
);

CREATE TABLE AfiliadoBeneficiario(
CONSTRAINT fk_Afiliado FOREIGN KEY (idAfiliado) REFERENCES Afiliado(idAfiliado),
CONSTRAINT fk_Beneficiario FOREIGN KEY (idBeneficiario) REFERENCES Beneficiario(idBeneficiario)
);

CREATE TABLE Usuario(
idUsuario NUMBER(5),
tipoDocumento VARCHAR2(50) NOT NULL,
numeroDocumento VARCHAR2(50) NOT NULL UNIQUE,
nombre VARCHAR2(50) NOT NULL,
PRIMARY KEY (idUsuario)
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

CREATE TABLE Medico(
idMedico NUMBER(5) PRIMARY KEY,
registroMedico VARCHAR2(50) NOT NULL,
idEPS NUMBER(5) NOT NULL,
idEspecialidad NUMBER(5) NOT NULL,
idUsuario NUMBER(5) NOT NULL,
CONSTRAINT fk_EPS_Medico FOREIGN KEY (idEPS) REFERENCES EPS(idEPS),
CONSTRAINT fk_Especialidad_Medico FOREIGN KEY (idEspecialidad) REFERENCES Especialidad(idEspecialidad),
CONSTRAINT fk_Medico_Usuario FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario)
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
CONSTRAINT fk_Servicio_IPSServicio FOREIGN KEY (idServicio) REFERENCES Servicio(idServicio),
CONSTRAINT fk_IPS_IPSServicio FOREIGN KEY (NIT) REFERENCES IPS(NIT)
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