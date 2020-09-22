package services;

import repositories.CarRepository;
import repositories.PartRepository;
import repositories.TeamRepository;
import responses.Winner;

public interface TournamentService {

    void conductTournament();

    Winner getWinner();

    void collectTournamentData(TeamRepository teamRepository, CarRepository carRepository, PartRepository partRepository);
}
