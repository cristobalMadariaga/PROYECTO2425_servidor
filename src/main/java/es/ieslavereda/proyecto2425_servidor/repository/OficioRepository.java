package es.ieslavereda.proyecto2425_servidor.repository;

import es.ieslavereda.proyecto2425_servidor.repository.model.Oficio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OficioRepository implements IOficioRepository{

    @Autowired
    @Qualifier("mysqlDataSource")
    private DataSource dataSource;

    @Override
    public List<Oficio> getAll() {
        List<Oficio> oficios = new ArrayList<>();
        String query = "{call obtener_oficios()}";
        try(Connection connection = dataSource.getConnection();
            CallableStatement cs = connection.prepareCall(query);
            ResultSet resultSet = cs.executeQuery()
            ){
            while(resultSet.next()){
                oficios.add(new Oficio(
                            resultSet.getInt("idOficio"),
                            resultSet.getString("descripcion"),
                            resultSet.getString("image")
                ));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return oficios;
    }

    @Override
    public String getImagenByID(int id) {
        String query = "select * from oficio where id = ?";
        String image = "";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)
        ){
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            image = resultSet.getString("image");

        } catch (SQLException e){
            e.printStackTrace();
        }

        return image;
    }
}
