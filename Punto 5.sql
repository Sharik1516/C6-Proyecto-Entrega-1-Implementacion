-- RFC 1
SELECT s.nombre AS Nombre_Servicio, 
       c.FechaHora AS Fecha_Hora_Disponible, 
       i.nombre AS Nombre_IPS, 
       u.nombre AS Nombre_Medico
FROM CitaMedica c
JOIN OrdenDeServicio o ON c.idOrden = o.idOrden
JOIN IPSservicio s ON c.idServicio = s.idServicio
JOIN ServicoIPS si ON o.idOrden = si.idOrden
JOIN IPS i ON si.NIT = i.NIT
JOIN Medico m ON o.idMedico = m.idMedico
JOIN Usuario u ON m.idMedico = u.numeroDocumento
WHERE c.FechaHora BETWEEN SYSDATE AND SYSDATE + INTERVAL '28' DAY;



-- RFC 2
SELECT s.nombre AS Nombre_Servicio, 
       COUNT(c.idCita) AS Total_Solicitudes
FROM CitaMedica c
JOIN IPSservicio s ON c.idServicio = s.idServicio
WHERE c.FechaHora BETWEEN TO_DATE('YYYY-MM-DD', 'YYYY-MM-DD') 
                     AND TO_DATE('YYYY-MM-DD', 'YYYY-MM-DD')
GROUP BY s.nombre
ORDER BY Total_Solicitudes DESC
FETCH FIRST 20 ROWS ONLY;

-- RFC 3
SELECT s.nombre AS Nombre_Servicio, 
       (COUNT(c.idCita) * 1.0 / COUNT(DISTINCT si.idServicio)) AS Indice_Uso
FROM CitaMedica c
JOIN IPSservicio s ON c.idServicio = s.idServicio
JOIN ServicoIPS si ON s.idServicio = si.idOrden
WHERE c.FechaHora BETWEEN TO_DATE('YYYY-MM-DD', 'YYYY-MM-DD') 
                     AND TO_DATE('YYYY-MM-DD', 'YYYY-MM-DD')
GROUP BY s.nombre;

-- RFC 4
SELECT s.nombre AS Nombre_Servicio, 
       c.FechaHora AS Fecha_Atencion, 
       u.nombre AS Nombre_Medico, 
       i.nombre AS Nombre_IPS
FROM CitaMedica c
JOIN OrdenDeServicio o ON c.idOrden = o.idOrden
JOIN IPSservicio s ON c.idServicio = s.idServicio
JOIN ServicoIPS si ON o.idOrden = si.idOrden
JOIN IPS i ON si.NIT = i.NIT
JOIN Medico m ON o.idMedico = m.idMedico
JOIN Usuario u ON m.idMedico = u.numeroDocumento
WHERE o.idAfiliado = :idAfiliado
AND c.FechaHora BETWEEN TO_DATE('YYYY-MM-DD', 'YYYY-MM-DD') 
                    AND TO_DATE('YYYY-MM-DD', 'YYYY-MM-DD');



