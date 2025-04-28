package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import uniandes.edu.co.proyecto.modelo.EPS;
import uniandes.edu.co.proyecto.repositorio.EPSRepository;

@Controller
@RequestMapping( "/eps" )
public class EPSController {
    
    @Autowired
    private EPSRepository epsRepository;

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MedicoController.class);

    @GetMapping
    public ResponseEntity<?> obtenerEps( ) 
    {
        try
        {
            Collection<EPS> eps = epsRepository.darEPSES( );
            return ResponseEntity.ok( eps );

        } catch (Exception e) {
            log.error("Error al ....", e);
            // Este map dará visibilidad de qué está fallando
            Map<String, String> error = new HashMap<>();
            error.put("message", e.getMessage());
            error.put("exception", e.getClass().getSimpleName());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }


   
}
