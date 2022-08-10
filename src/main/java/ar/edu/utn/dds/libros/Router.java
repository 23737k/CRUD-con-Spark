package ar.edu.utn.dds.libros;

import com.google.gson.Gson;
import spark.Spark;

public class Router {
  public static void init() {
    Router.configure();          //aca inicializo el Router. Por ahora solo tiene configure()
  }

  //aca es donde el servidor se queda esperando a recibir alguna request. Cada vez que reciba una, matchera con la correpondiente
  private static void configure() {
    RepoLibros repo = new RepoLibros();
    LibrosController controller = new LibrosController(repo);  //aca deberia instanciar todos mis controllers.
    Gson gson = new Gson();           //AGREGO gson para que convierta y devuelva los objetos en json

    Spark.get("/",(req,res)->"Hola");

    Spark.get("/libros",controller::list,gson::toJson);  //delego en cada controller la accion a realizar por cada request

    Spark.get("/libros/:id", controller::get,gson::toJson); //uso siempre el "::", nunca controller.unMetodo()

    Spark.delete("/libros/:id", controller::delete);  //el :id hace que se guarde como valor esa parte del path
                                                            //en este caso, guardar el id me servira para buscar el libro
    Spark.post("/libros/",controller::create,gson::toJson); //el gson se encarga de transformar lo que devuelva el
                                                                  //metodo a json
  }
}
