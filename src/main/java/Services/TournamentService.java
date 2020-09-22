package Services;

import Repositories.CarRepository;
import Repositories.PartRepository;
import Repositories.TeamRepository;
import Responses.Winner;

public interface TournamentService {

    void conductTournament();

    Winner getWinner();

    void collectTournamentData(TeamRepository teamRepository, CarRepository carRepository, PartRepository partRepository);
}
