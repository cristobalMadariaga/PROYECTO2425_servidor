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

    //He cambiado el procedimiento de la bbdd para que solo haga select *
    @Override
    public List<Oficio> getAll() {
        List<Oficio> oficios = new ArrayList<>();
        String query = "{call obtener_oficios()}";
        try(Connection connection = dataSource.getConnection();
            CallableStatement cs = connection.prepareCall(query);
            ){
            ResultSet resultSet = cs.executeQuery();

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

    //he hecho otro procedimiento para sacar otro oficio por id
    @Override
    public Oficio getOficioByID(int id) {
        Oficio oficio = null;
        String query = "{call obtener_oficio(?)}";
        try(Connection connection = dataSource.getConnection();
            CallableStatement cs = connection.prepareCall(query)){
            cs.setInt(1, id);
            ResultSet rs = cs.executeQuery();

            oficio = new Oficio(
                    rs.getInt("idOficio"),
                    rs.getString("descripcion"),
                    rs.getString("image")
            );
        } catch (SQLException e){
            e.printStackTrace();
        }
        return oficio;
    }


    @Override
    public String getImagenByID(int id) {
        String query = "{call obtener_image_oficio(?,?)}";
        String image = "";
        try(Connection connection = dataSource.getConnection();
            CallableStatement cs = connection.prepareCall(query);

        ){
            cs.registerOutParameter(1, Types.VARCHAR);
            cs.setInt(2, id);

            cs.execute();
            image = cs.getString(1);

        } catch (SQLException e){
            e.printStackTrace();
        }

        return image;
    }
}
