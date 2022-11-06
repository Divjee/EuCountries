package org.example;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.net.URL;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        callApi();


    }

    private static void callApi() {
        try {
            URL url = new URL("https://restcountries.com/v2/regionalbloc/eu?fields=name,capital,currencies,population,area");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder inputData = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                inputData.append(inputLine);
            }


            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write(inputData.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println("Notika kļūda!");
        }
    }
}