package ar.edu.utn.dds.libros;

import spark.Spark;

public class Router {
  public static void init() {
    Router.configure();
  }

  private static void configure() {
    Spark.get("/",(req,res)->"Hola");
  }
  /*
        app.get(  "/home",  (Context ctx) -> ctx.result("hola!"));

        app.get(  "/libros",  controller::list);

        app.get("/libros/{id}", controller::get);

        app.delete("/libros/{id}", controller::delete);

        app.post("/libros/",controller::create);

   */
}
