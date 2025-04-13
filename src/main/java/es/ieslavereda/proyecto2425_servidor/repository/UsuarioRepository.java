package es.ieslavereda.proyecto2425_servidor.repository;

import es.ieslavereda.proyecto2425_servidor.repository.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UsuarioRepository implements ICRUDUsuario{

    @Autowired
    @Qualifier("mysqlDataSource")
    private DataSource dataSource;


    @Override
    public List<Usuario> getAll() throws SQLException {
        return null;
    }

    @Override
    public Usuario getbyID(int id) throws SQLException {
        return null;
    }

    @Override
    public Usuario deleteUser(int id) throws SQLException {
        return null;
    }

    @Override
    public Usuario addUser(Usuario usuario) throws SQLException {
        return null;
    }

    @Override
    public Usuario updateUser(Usuario usuario) throws SQLException {
        return null;
    }
}
