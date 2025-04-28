package uniandes.edu.co.proyecto.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniandes.edu.co.proyecto.repositorio.CitaMedicaRepository;
import uniandes.edu.co.proyecto.modelo.CitaMedica;

@Service
public class RFC4Service {

    @Autowired
    private CitaMedicaRepository citaMedicaRepository;

    public List<CitaMedica> obtenerCitasPorAfiliadoYRangoFechas(Integer idAfiliado, Date fechaInicio, Date fechaFin) {
        
// ERROR en RFC4:
// El método findByOrdenDeServicio_Afiliado_IdAfiliadoAndFechaHoraBetween(Integer, Date, Date) no existe en CitaMedicaRepository.
// Solución: Se debe crear el método manualmente en el repositorio usando @Query o asegurarse que los nombres de las relaciones
// (OrdenDeServicio -> Afiliado -> idAfiliado) estén correctamente mapeadas y nombradas en las entidades.
// También puede ser necesario corregir la estructura de las clases si el path de atributos no es correcto.
        return citaMedicaRepository.findByOrdenDeServicio_Afiliado_IdAfiliadoAndFechaHoraBetween(idAfiliado, fechaInicio, fechaFin);
    }
}
