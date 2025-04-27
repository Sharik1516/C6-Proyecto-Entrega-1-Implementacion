
-- Población de la base de datos para pruebas RF1 - RF8

-- Insertar EPS
INSERT INTO EPS (idEps, nombre, direccion, telefono) VALUES (3, 'Sanitas', 'Calle 75 # 43-10', '3101134587');
INSERT INTO EPS (idEps, nombre, direccion, telefono) VALUES (4, 'Sura', 'Av. Boyaca 100', '3127954321');

-- Insertar IPS
INSERT INTO IPS (NIT, nombre, direccion, telefono, idEps) VALUES (1, 'Clínica Santa María', 'Calle 45 # 23-10', '3101234567', 3);
INSERT INTO IPS (NIT, nombre, direccion, telefono, idEps) VALUES (2, 'Hospital Central', 'Av. Libertad 100', '3117654321', 4);

-- Insertar Servicios de Salud
INSERT INTO Servicio (idServicio, nombre, descripcion) VALUES (1, 'Consulta General', 'Consulta médica general sin especialidad');
INSERT INTO Servicio (idServicio, nombre, descripcion) VALUES (2, 'Pediatría', 'Atención especializada en niños');
INSERT INTO Servicio (idServicio, nombre, descripcion) VALUES (3, 'Cardiología', 'Consulta especializada en corazón');

-- Asignar Servicios a IPS
INSERT INTO IPSservicio (idServicio, NIT, Agenda) VALUES (1, 1, 'Agenda 1');
INSERT INTO IPSservicio (idServicio, NIT, Agenda) VALUES (1, 2, 'Agenda 2');
INSERT INTO IPSservicio (idServicio, NIT, Agenda) VALUES (2, 1, 'Agenda 3');

-- Insertar Especialidades
INSERT INTO Especialidad (idEspecialidad, nombre) VALUES (1, 'Medicina General');
INSERT INTO Especialidad (idEspecialidad, nombre) VALUES (2, 'Pediatría');
INSERT INTO Especialidad (idEspecialidad, nombre) VALUES (3, 'Cardiología');
INSERT INTO Especialidad (idEspecialidad, nombre) VALUES (4, 'Dermatología');

-- Insertar Usuarios
INSERT INTO Usuario (idUsuario, tipoDocumento, numeroDocumento, nombre) VALUES (1, 'CC', '123456789', 'Juan Pérez');
INSERT INTO Usuario (idUsuario, tipoDocumento, numeroDocumento, nombre) VALUES (2, 'CC', '987654321', 'Ana Pérez');
INSERT INTO Usuario (idUsuario, tipoDocumento, numeroDocumento, nombre) VALUES (3, 'CC', '456789123', 'María López');
INSERT INTO Usuario (idUsuario, tipoDocumento, numeroDocumento, nombre) VALUES (4, 'CC', '321654987', 'José López');

-- Insertar Médicos
INSERT INTO Medico (idMedico, registroMedico, idEPS, idEspecialidad, idUsuario) VALUES (1, '12345', 3, 1, 1);
INSERT INTO Medico (idMedico, registroMedico, idEPS, idEspecialidad, idUsuario) VALUES (2, '67890', 4, 2, 2);
INSERT INTO Medico (idMedico, registroMedico, idEPS, idEspecialidad, idUsuario) VALUES (3, '54321', 3, 3, 3);
INSERT INTO Medico (idMedico, registroMedico, idEPS, idEspecialidad, idUsuario) VALUES (4, '09876', 4, 4, 4);

-- Insertar Afiliados
INSERT INTO Afiliado (idAfiliado, fechaNacimiento, direccion, telefono, tipoAfiliado, idUsuario) VALUES (1, TO_DATE('1990-01-01', 'YYYY-MM-DD'), 'Calle 10 # 20-30', '3101234567', 'Contribuyente', 1);
INSERT INTO Afiliado (idAfiliado, fechaNacimiento, direccion, telefono, tipoAfiliado, idUsuario) VALUES (2, TO_DATE('1985-05-15', 'YYYY-MM-DD'), 'Calle 20 # 30-40', '3112345678', 'Beneficiario', 2);
INSERT INTO Afiliado (idAfiliado, fechaNacimiento, direccion, telefono, tipoAfiliado, idUsuario) VALUES (3, TO_DATE('1995-10-10', 'YYYY-MM-DD'), 'Calle 30 # 40-50', '3123456789', 'Contribuyente', 3);
INSERT INTO Afiliado (idAfiliado, fechaNacimiento, direccion, telefono, tipoAfiliado, idUsuario) VALUES (4, TO_DATE('2000-12-12', 'YYYY-MM-DD'), 'Calle 40 # 50-60', '3134567890', 'Beneficiario', 4);

-- Crear Orden de Servicio
INSERT INTO OrdenDeServicio (idOrden, Fecha, Estado, idAfiliado, idMedico) VALUES (1, TO_DATE('2025-05-01', 'YYYY-MM-DD'), 'Vigente', 1, 1);
INSERT INTO OrdenDeServicio (idOrden, Fecha, Estado, idAfiliado, idMedico) VALUES (2, TO_DATE('2025-05-02', 'YYYY-MM-DD'), 'Cancelada', 2, 2);       
INSERT INTO OrdenDeServicio (idOrden, Fecha, Estado, idAfiliado, idMedico) VALUES (3, TO_DATE('2025-05-03', 'YYYY-MM-DD'), 'Completada', 3, 3);
INSERT INTO OrdenDeServicio (idOrden, Fecha, Estado, idAfiliado, idMedico) VALUES (4, TO_DATE('2025-05-04', 'YYYY-MM-DD'), 'Vigente', 4, 4);

-- Agendar Servicios (Citas)
INSERT INTO CitaMedica (idCita, fechaHora, idOrden, NIT) VALUES (1, TO_DATE('2025-05-01 10:00:00', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO CitaMedica (idCita, fechaHora, idOrden, NIT) VALUES (2, TO_DATE('2025-05-02 11:00:00', 'YYYY-MM-DD HH24:MI:SS'), 2, 2);
INSERT INTO CitaMedica (idCita, fechaHora, idOrden, NIT) VALUES (3, TO_DATE('2025-05-03 12:00:00', 'YYYY-MM-DD HH24:MI:SS'), 3, 1);
INSERT INTO CitaMedica (idCita, fechaHora, idOrden, NIT) VALUES (4, TO_DATE('2025-05-04 13:00:00', 'YYYY-MM-DD HH24:MI:SS'), 4, 2);

-- Insertar Parentescos
INSERT INTO Parentesco (idParentesco, Descripcion) VALUES (1, 'Padre');
INSERT INTO Parentesco (idParentesco, Descripcion) VALUES (2, 'Madre');    
INSERT INTO Parentesco (idParentesco, Descripcion) VALUES (3, 'Hermano');
INSERT INTO Parentesco (idParentesco, Descripcion) VALUES (4, 'Hermana');

-- Relacionar Afiliados con Parentescos
INSERT INTO ContribuyenteBeneficiario (idContribuyente, idBeneficiario, idParentesco) VALUES (1, 2, 1);
INSERT INTO ContribuyenteBeneficiario (idContribuyente, idBeneficiario, idParentesco) VALUES (3, 4, 2);