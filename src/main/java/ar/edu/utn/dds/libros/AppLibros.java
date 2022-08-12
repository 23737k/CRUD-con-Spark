package ar.edu.utn.dds.libros;
import spark.Spark;

public class AppLibros {
        public void init(){
    }
    public void start(){
        Spark.port(getHerokuAssignedPort());
        Router.init();
    }
    public static void main(String[] args) {
        AppLibros app = new AppLibros();
        app.init();
        app.start();
    }
    private static int getHerokuAssignedPort() {
        String herokuPort = System.getenv("PORT");
        if (herokuPort != null) {
            return Integer.parseInt(herokuPort);
        }
        return 7000;
    }

}
