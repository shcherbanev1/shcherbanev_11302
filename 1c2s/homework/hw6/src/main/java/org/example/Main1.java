package org.example;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

// 2 мейн класса потому что есть вариант попроще (на паре сделанный)
// и с полным парсингом джейсона - 2 мейн
public class Main1 {

    public static void main(String[] args) {

        String[] cities = {"Ufa", "London", "Moscow", "New%20York", "Dubai", "Ottawa", "Minsk"};

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/weather1.csv"))) {
            writer.write("city, weather, date\n");
            for (String city : cities) {
                URL weatherURL = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=34b7e6c9d4fe785a6e2c53dfcc2711ce&units=metric");
                URLConnection connection = weatherURL.openConnection();
                String jsonString;
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    jsonString = reader.readLine();

                    String jsonCityName = extractValue(jsonString, "name");
                    String jsonTemperature = extractValue(jsonString, "temp");
                    String unixTime = extractValue(jsonString, "dt");
                    Date jsonDate = new Date(Integer.parseInt(unixTime) * 1000L);

                    writer.write(jsonCityName + ", " +  jsonTemperature + ", " + jsonDate + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }

    }

    private static String extractValue(String jsonString, String key) {
        int startIndex = jsonString.indexOf("\"" + key + "\":") + key.length() + 3; // +3 для ":"
        int endIndex = jsonString.indexOf(",", startIndex);
        if (endIndex == -1) {
            endIndex = jsonString.indexOf("}", startIndex);
        }
        return jsonString.substring(startIndex, endIndex);
    }

}