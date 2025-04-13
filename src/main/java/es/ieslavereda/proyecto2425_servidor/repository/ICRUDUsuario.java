package es.ieslavereda.proyecto2425_servidor.repository;

import es.ieslavereda.proyecto2425_servidor.repository.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface ICRUDUsuario {
    List<Usuario> getAll() throws SQLException;
    Usuario getbyID(int id) throws SQLException;
    Usuario deleteUser(int id) throws SQLException;
    Usuario addUser(Usuario usuario) throws SQLException;
    Usuario updateUser(Usuario usuario) throws SQLException;
}
