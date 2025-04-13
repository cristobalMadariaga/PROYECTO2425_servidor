package es.ieslavereda.proyecto2425_servidor.controller;

import es.ieslavereda.proyecto2425_servidor.repository.model.Usuario;
import es.ieslavereda.proyecto2425_servidor.service.OficioService;
import es.ieslavereda.proyecto2425_servidor.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/apiProyecto")
public class OficioController {
    @Autowired
    private OficioService oficioService;

    @GetMapping("/oficios/")
    public ResponseEntity<?> getAll(){
        try {
            return new ResponseEntity<>(oficioService.getAll(), HttpStatus.OK);
        } catch (SQLException e){
            return response(e);
        }
    }

    @GetMapping("/oficios/imagen/{id}")
    public ResponseEntity<?> getImagenByID(@PathVariable("id") int id){
        try {
            Integer imagen = oficioService.getImagenByID(id);
            if (imagen==null)
                return new ResponseEntity<>("Imagen no encontrada", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(imagen, HttpStatus.OK);
        } catch (SQLException e){
            return response(e);
        }
    }

    private ResponseEntity<?> response(SQLException e){
        Map<String,Object> response = new HashMap<>();
        response.put("code", e.getErrorCode());
        response.put("message",e.getMessage());
        response.put("sqlstate",e.getSQLState());
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
