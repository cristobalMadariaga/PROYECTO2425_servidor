package es.ieslavereda.proyecto2425_servidor.controller;

import es.ieslavereda.proyecto2425_servidor.repository.model.Usuario;
import es.ieslavereda.proyecto2425_servidor.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/apiProyecto")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios/")
    public ResponseEntity<?> getAll(){
        try {
            return new ResponseEntity<>(usuarioService.getAll(), HttpStatus.OK);
        } catch (SQLException e){
            return response(e);
        }
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<?> getByID(@PathVariable("id") int id){
        try {
            Usuario usuario = usuarioService.getbyID(id);
            if (usuario==null)
                return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } catch (SQLException e){
            return response(e);
        }
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id){
        try {
            Usuario usuario = usuarioService.deleteUser(id);
            if (usuario==null)
                return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } catch (SQLException e){
            return response(e);
        }
    }

    @PostMapping("/usuarios/")
    public ResponseEntity<?> addUser(@RequestBody Usuario usuario){
        try{
            Usuario usuario1 = usuarioService.addUser(usuario);
            if (usuario1==null)
                return new ResponseEntity<>("Usuario ya existente", HttpStatus.FOUND);
            return new ResponseEntity<>(usuario1, HttpStatus.OK);
        } catch (SQLException e){
            return response(e);
        }
    }

    @PutMapping("/usuarios/")
    public ResponseEntity<?> updateUser(@RequestBody Usuario usuario){
        try{
            Usuario usuario1 = usuarioService.updateUser(usuario);
            if (usuario1==null)
                return new ResponseEntity<>("Usuario no existe", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(usuario1, HttpStatus.OK);
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
