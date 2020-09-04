package edu.eci.arep.parcialArepFachada.client;

import org.json.JSONObject;
import spark.Request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Client {
    public static void main(String[] args) {
        try{
            String[] data = new String[]{"090,sin","180,cos","360,tan"};
            for(String i: data){
                System.out.println("FUNCION:" + i.substring(4));
                System.out.println("Servidor Logico: "+ runServerLogic(i));
                System.out.println( "Servidor Fachada: " + runServerFachada(i));
                System.out.println("-----------------------------");
            }

        }
        catch(IOException e){
            System.out.println("IO Exception");
        }
    }

    private static String runServerLogic(String req) throws IOException {
        URL url = new URL("https://parcialarepcalc.herokuapp.com/results");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        try (OutputStream os = con.getOutputStream()) {
            byte[] input = req.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String out = null;
            while ((out = br.readLine()) != null) {
                response.append(out.trim());
            }
            return response.toString();
        }
    }

    private static String runServerFachada(String req) throws IOException {
        URL url = new URL("https://parcialarepcalcfachada.herokuapp.com/results");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        try (OutputStream os = con.getOutputStream()) {
            byte[] input = req.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String out = null;
            while ((out = br.readLine()) != null) {
                response.append(out.trim());
            }
            return response.toString();
        }
    }

}
