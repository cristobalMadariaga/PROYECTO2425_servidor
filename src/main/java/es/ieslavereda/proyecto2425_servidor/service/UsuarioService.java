package es.ieslavereda.proyecto2425_servidor.service;

import es.ieslavereda.proyecto2425_servidor.repository.UsuarioRepository;
import es.ieslavereda.proyecto2425_servidor.repository.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAll() throws SQLException {
        return usuarioRepository.getAll();
    }
    public Usuario getbyID(int id) throws SQLException {
        return usuarioRepository.getbyID(id);
    }
    public Usuario deleteUser(int id) throws SQLException{
        return usuarioRepository.deleteUser(id);
    }
    public Usuario addUser(Usuario usuario) throws SQLException{
        return usuarioRepository.addUser(usuario);
    }
    public Usuario updateUser(Usuario usuario) throws SQLException{
        return usuarioRepository.updateUser(usuario);
    }

}
