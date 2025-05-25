package es.ieslavereda.proyecto2425_servidor.repository;

import es.ieslavereda.proyecto2425_servidor.repository.model.Oficio;

import java.util.List;

public interface IOficioRepository {
    List<Oficio> getAll();
    Oficio getOficioByID(int id);
    String getImagenByID(int id);
}
