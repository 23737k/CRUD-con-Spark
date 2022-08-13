package ar.edu.utn.dds.libros;
import javax.mail.MessagingException;
import spark.Spark;

public class AppLibros {
        public void init(){
    }
    public void start() throws MessagingException {
        Spark.port(getHerokuAssignedPort());
        MailSender mailSender=new MailSender(); //ATENCION: NO FUNCIONA. HAT QUE PONER LA PASS EN MAILSENDER Y UN MAIL VALIDO EN SENDMAIL
        mailSender.sendMail("unMail","Hola, usted tiene una nueva notificacion");
        Router.init();
    }
    public static void main(String[] args) throws MessagingException {
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
