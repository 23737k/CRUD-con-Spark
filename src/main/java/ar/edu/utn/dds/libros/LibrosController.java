package ar.edu.utn.dds.libros;

import spark.Request;
import spark.Response;

import java.util.Collection;

public class LibrosController {

    private RepoLibros repo;

    public LibrosController(RepoLibros repo) {
        this.repo = repo;
    }

    public Collection<Libro> list(Request req, Response resp) {
        String precio_max = req.queryParams("precio_max");
        Collection<Libro> libros = null;
        if (precio_max != null) {
            Long precioMax = Long.parseLong(precio_max);
            if (precioMax != null) {
                libros = repo.findByMaxPrecio(precioMax);
            }
        } else {
            libros= repo.findAll();
        }
        return libros;
    }
    public Libro get(Request req, Response resp) {
        Long id = Long.parseLong(req.params("id"));
        return repo.findById(id);
    }

    public String delete(Request req, Response resp) {
        Long id = Long.parseLong(req.params("id"));
        repo.delete(repo.findById(id));
        return "deleted";
    }
    public Long create(Request req, Response resp) {
        String autor = req.queryParams("autor");
        String nombre = req.queryParams("nombre");
        Long precio = Long.parseLong(req.queryParams("precio"));
        Libro libro = new Libro(nombre,autor,precio);
        Long id = repo.save(libro).getId();
        resp.status(201); // 201 Created
        return id;
    }
}
