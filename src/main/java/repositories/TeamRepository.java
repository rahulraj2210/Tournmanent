package repositories;

import dto.Team;

import java.util.List;

public interface TeamRepository {
    public List<Team> findAll();
}
