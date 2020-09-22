package repositories;

import dto.Part;

import java.util.List;

public interface PartRepository {
    public List<Part> findAll();
}
