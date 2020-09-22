package Services;

import DTO.Car;
import DTO.Part;
import DTO.CustomizedCarStatistics;

import java.util.List;

public interface OptimalPartsSelectorService {
    CustomizedCarStatistics findOptimalParts(Car car, List<Part> availablePartsForCar, double budge);
}
