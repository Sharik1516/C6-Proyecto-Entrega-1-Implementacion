package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Medico;
import uniandes.edu.co.proyecto.repositorio.MedicoRepository;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;

@RestController
@RequestMapping( "/medicos" )
public class MedicoController 
{
    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MedicoController.class);

    @GetMapping
    public ResponseEntity<?> obtenerMedicos( ) 
    {
        try
        {
            Collection<Medico> medicos = medicoRepository.darMedicos( );
            return ResponseEntity.ok( medicos );

        } catch (Exception e) {
            log.error("Error al agendar cita", e);
            // Este map dará visibilidad de qué está fallando
            Map<String, String> error = new HashMap<>();
            error.put("message", e.getMessage());
            error.put("exception", e.getClass().getSimpleName());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<Medico> obtenerMedico( @PathVariable Integer id ) 
    {
        try
        {
            Medico medico = medicoRepository.darMedico( id );
            if ( medico != null ) {
                return ResponseEntity.ok( medico );
            }
            else {
                return ResponseEntity.notFound( ).build( );
            }
        }
        catch ( Exception e ) {
            return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR ).build( );
        }
    }

    @PostMapping
    public ResponseEntity<Medico> crearMedico( @RequestBody Medico medico ) 
    {
        try
        {
            medico.setIdMedico( usuarioRepository.obtenerSiguienteId() );

            medicoRepository.insertarMedico( medico.getEspecialidad(), medico.getRegistroMedico(),medico.getIdEps(), medico.getIdUsuario() );

            return ResponseEntity.status( HttpStatus.CREATED ).body( medico );
        }
        catch ( Exception e ) {
            return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR ).build();
        }
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<Medico> actualizarMedico( @PathVariable("id") Integer id, @RequestBody Medico medico ) 
    {
        try
        {
            medico.setIdMedico( id );
            medicoRepository.actualizarMedico( id, medico.getEspecialidad(), medico.getRegistroMedico() ,medico.getIdEps(), medico.getIdUsuario() );
            return ResponseEntity.ok( medico );
        }
        catch ( Exception e ) {
            return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR ).build();
        }
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<String> medicoEliminar( @PathVariable("id") Integer id ) 
    {
        try
        {
            medicoRepository.eliminarMedico( id );
            usuarioRepository.eliminarUsuario( id );

            return ResponseEntity.noContent().build();
        }
        catch ( Exception e ) {
            return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR ).body( "Error al eliminar el medico" );
        }
    }
}
