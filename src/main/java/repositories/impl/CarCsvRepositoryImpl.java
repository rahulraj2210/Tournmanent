package repositories.impl;

import dto.Car;
import repositories.CarRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CarCsvRepositoryImpl implements CarRepository {

    private String csvName = "Cars.csv";

    @Override
    public List<Car> findAll() {
        URL url = this.getClass().getResource(csvName);
        List<Car> cars = readCarsFromCSV(url.toString());
        return cars;
    }

    private List<Car> readCarsFromCSV(String fileName) {
        List<Car> cars = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] row = line.split(",");
                Car car = createCar(row);
                cars.add(car);
                line = br.readLine();
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return cars;
    }

    private Car createCar(String[] row) {
        return new Car(Integer.parseInt(row[0]), row[1], Double.parseDouble(row[2]),Double.parseDouble(row[3]), Integer.parseInt(row[4]));
    }


}
