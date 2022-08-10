package ar.edu.utn.dds.libros;
import spark.Spark;

public class AppLibros {
    private RepoLibros repo;
    private LibrosController controller;

    public void init(){
        repo = new RepoLibros();
        controller = new LibrosController(repo);
    }
    public void start(){
        Spark.port(9000);
        Router.init();
    }
    public static void main(String[] args) {
        AppLibros app = new AppLibros();
        app.init();
        app.start();
    }
}
