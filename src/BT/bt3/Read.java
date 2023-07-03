package BT.bt3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Read {
    public static void main(String[] args) {
        String filePath = "C:\\IdeaProjects\\SS16\\hieuga.txt";

        List<Country> countries = readCountriesFromFile(filePath);
        printCountryList(countries);
    }

    public static List<Country> readCountriesFromFile(String filePath) {
        List<Country> countries = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0].trim());
                    String code = parts[1].trim().replaceAll("\"", "");
                    String name = parts[2].trim().replaceAll("\"", "");

                    Country country = new Country(id, code, name);
                    countries.add(country);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return countries;
    }

    public static void printCountryList(List<Country> countries) {
        for (Country country : countries) {
            System.out.println(country.getId() + " " + country.getCode() + " " + country.getName());
        }
    }
}


