package org.example;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Map;

public class Main2 {

    public static void main(String[] args) {
        String[] cities = {"Ufa", "London", "Moscow", "New%20York", "Dubai", "Ottawa", "Minsk"};

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/weather2.csv"))) {
            writer.write("city, weather, date\n");
            for (String city : cities) {
                URL weatherURL = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=34b7e6c9d4fe785a6e2c53dfcc2711ce&units=metric");
                URLConnection connection = weatherURL.openConnection();
                String jsonString;
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    jsonString = reader.readLine();


                    Map<String, Object> result = JSONParser.parseJson(jsonString);
                    String jsonCityName = (String) result.get("name");
                    Number jsonTemperature = (Number) result.get("main.temp");
                    Integer unixTime = (Integer) result.get("dt");
                    Date jsonDate = new Date(unixTime * 1000L);
                    writer.write(jsonCityName + ", " +  jsonTemperature + ", " + jsonDate + "\n");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
