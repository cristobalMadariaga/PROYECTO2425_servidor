package es.ieslavereda.proyecto2425_servidor.service;

import es.ieslavereda.proyecto2425_servidor.repository.OficioRepository;
import es.ieslavereda.proyecto2425_servidor.repository.model.Oficio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class OficioService {
    @Autowired
    private OficioRepository oficioRepository;

    public List<Oficio> getAll() throws SQLException {
        return oficioRepository.getAll();
    }
    //añadido el getbyID
    public Oficio getOficioByID(int id) throws SQLException{
        return oficioRepository.getOficioByID(id);
    }
    public String getImagenByID(int id) throws SQLException {
        return oficioRepository.getImagenByID(id);
    }
}
