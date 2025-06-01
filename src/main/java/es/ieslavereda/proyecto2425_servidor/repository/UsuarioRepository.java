package es.ieslavereda.proyecto2425_servidor.repository;

import es.ieslavereda.proyecto2425_servidor.repository.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository implements ICRUDUsuario{

    @Autowired
    @Qualifier("mysqlDataSource")
    private DataSource dataSource;


    @Override
    public List<Usuario> getAll() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "select * from usuario";
        try(Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)
        ){
            while(resultSet.next()){
                usuarios.add(new Usuario(
                        resultSet.getInt("idUsuario"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellidos"),
                        resultSet.getInt("Oficio_idOficio")
                        ));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }


        return usuarios;
    }

    @Override
    public Usuario getbyID(int id) throws SQLException {
        Usuario usuario = null;
        String query = "select * from usuario where idUsuario = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                usuario = new Usuario(
                        resultSet.getInt("idUsuario"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellidos"),
                        resultSet.getInt("Oficio_idOficio"));
            }
        }
        return usuario;
    }

    @Override
    public Usuario deleteUser(int id) throws SQLException {
        Usuario usuario = getbyID(id);
        if (usuario != null) {
            String query = "delete from usuario where idUsuario = ?";
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1, id);
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return usuario;
    }

    @Override
    public Usuario addUser(Usuario usuario) throws SQLException {
        String query = "insert into usuario (nombre, apellidos, Oficio_idOficio)" +
                        "values (?,?,?)";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellidos());
            ps.setInt(3, usuario.getOficio_idOficio());
            ps.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }

        return usuario;
    }

    @Override
    public Usuario updateUser(Usuario usuario) throws SQLException {
        String query = "update usuario set nombre = ?, apellidos = ?, Oficio_idOficio = ? " +
                "where idUsuario = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellidos());
            ps.setInt(3, usuario.getOficio_idOficio());
            ps.setInt(4, usuario.getIdUsuario());
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }

        return usuario;
    }
}
