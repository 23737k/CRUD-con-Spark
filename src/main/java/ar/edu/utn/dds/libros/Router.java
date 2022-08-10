package ar.edu.utn.dds.libros;

import com.google.gson.Gson;
import spark.Spark;

public class Router {
  public static void init() {
    Router.configure();
  }

  private static void configure() {
    RepoLibros repo = new RepoLibros();
    LibrosController controller = new LibrosController(repo);
    Gson gson = new Gson();           //AGREGO gson para que convierta y devuelva los objetos en json

    Spark.get("/",(req,res)->"Hola");

    Spark.get("/libros",controller::list,gson::toJson);

    Spark.get("/libros/:id", controller::get,gson::toJson);

    Spark.delete("/libros/:id", controller::delete);

    Spark.post("/libros/",controller::create,gson::toJson);
  }
}
