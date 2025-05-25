package es.ieslavereda.proyecto2425_servidor.repository.model;

public class Oficio {

    private int idOficio;
    private String descripcion, image;

    public Oficio(int idOficio, String descripcion, String image){
        this.idOficio = idOficio;
        this.descripcion = descripcion;
        this.image = image;
    }

    public int getIdOficio() {
        return idOficio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getImage() {
        return image;
    }

    //para pruebas
    @Override
    public String toString(){
        return  "\n--------------------------------"+
                "\n---"+"idOficio: "+idOficio+
                "\n---"+"nombre: "+descripcion+
                "\n---"+"image: "+image;

    }

}
