package ar.edu.utn.dds.libros;

public class Libro {

    private Long id;
    private String nombre;
    private String autor;
    private Long precio;

    public Libro(String nombre,String autor, Long precio){
        this.nombre=nombre;
        this.autor=autor;
        this.precio=precio;
    }

    public Libro() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }
}
