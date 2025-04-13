package es.ieslavereda.proyecto2425_servidor.repository;

import es.ieslavereda.proyecto2425_servidor.repository.model.Oficio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class OficioRepository implements IOficioRepository{

    @Autowired
    @Qualifier("mysqlDataSource")
    private DataSource dataSource;

    @Override
    public List<Oficio> getAll() {
        return null;
    }

    @Override
    public Integer getImagenByID(int id) {
        return 0;
    }
}
