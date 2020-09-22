package Utilities;

import DTO.Car;
import DTO.Part;

import java.util.ArrayList;
import java.util.List;

public class TournamentUtilities {
    public static List<Car> findAvailableCarsForTeam(int carId, List<Car> cars) {
        List<Car> availableCars = new ArrayList<>();
        cars.stream().filter(car -> car.getCarId() == carId)
                .forEach(availableCars::add);
        return availableCars;
    }

    public static List<Part> findAvailablePartsForCar(List<Part> parts, Car car) {
        List<Part> availablePartsForCar = new ArrayList();
        parts.stream().filter(part -> part.getCarPartId() == car.getCarPartId())
                .forEach(availablePartsForCar::add);
        return availablePartsForCar;
    }
}
