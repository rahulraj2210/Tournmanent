package repositories;

import dto.Car;

import java.util.List;

public interface CarRepository {
    public List<Car> findAll();
}
