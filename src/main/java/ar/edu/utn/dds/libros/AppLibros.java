package ar.edu.utn.dds.libros;
import spark.Spark;

public class AppLibros {
        public void init(){
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
