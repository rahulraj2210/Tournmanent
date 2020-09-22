package services;

import dto.Car;
import dto.Part;
import dto.CustomizedCarStatistics;

import java.util.List;

public interface OptimalPartsSelectorService {
    CustomizedCarStatistics findOptimalParts(Car car, List<Part> availablePartsForCar, double budge);
}
