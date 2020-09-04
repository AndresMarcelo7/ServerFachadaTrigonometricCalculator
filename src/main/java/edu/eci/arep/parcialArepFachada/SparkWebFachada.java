package edu.eci.arep.parcialArepFachada;

import org.json.JSONObject;
import spark.Request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class SparkWebFachada
{

    public static void main(String[] args) {
        port(getPort());
        get("/",(req,res)-> "Bienvenido al Servidor Fachada del parcial de Arep :D");
        post("/results", (req, res) -> {
            res.status(200);
            res.type("application/json");
            return connection(req);});
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set(i.e on localhost)
    }

    static JSONObject connection(Request req) throws IOException {
        URL url = new URL("https://parcialarepcalc.herokuapp.com/results");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        String in = req.body();
        try (OutputStream os = con.getOutputStream()) {
            byte[] input = in.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String out = null;
            while ((out = br.readLine()) != null) {
                System.out.println(out);
                response.append(out.trim());
            }
            return new JSONObject(response.toString());
        }
    }
}
