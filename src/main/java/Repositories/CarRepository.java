package Repositories;

import DTO.Car;
import DTO.Team;

import java.util.List;

public interface CarRepository {
    public List<Car> findAll();
}
