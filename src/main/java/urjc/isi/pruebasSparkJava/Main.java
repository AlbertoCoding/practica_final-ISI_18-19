package urjc.isi.pruebasSparkJava;

import static spark.Spark.*;

import spark.Request;
import spark.Response;

import java.net.URISyntaxException;

public class Main {


    public static String home(Request request, Response response) throws ClassNotFoundException, URISyntaxException {
        String result = new String("TODA LA INFORMACIÓN QUE QUIERAS SOBRE PELÍCULAS");

        return result;

    }
  
    public static String doWork(Request request, Response response) throws ClassNotFoundException, URISyntaxException {
	String result = new String("Hello World");

	return result;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        port(getHerokuAssignedPort());

        // spark server
        get("/", Main::home);
        get("/hello", Main::doWork);

    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}