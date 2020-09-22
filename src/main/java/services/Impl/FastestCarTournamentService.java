package services.Impl;

import enums.PartSelectionParameters;
import dto.Car;
import dto.Part;
import dto.CustomizedCarStatistics;
import dto.Team;
import factories.OptimalPartsSelectorFactory;
import repositories.CarRepository;
import repositories.PartRepository;
import repositories.TeamRepository;
import responses.Winner;
import services.OptimalPartsSelectorService;
import services.TournamentService;
import utilities.TournamentUtilities;

import java.util.List;

public class FastestCarTournamentService implements TournamentService {

    Winner winner;

    List<Team> teams;

    List<Part> parts;

    List<Car> cars;

    @Override
    public void collectTournamentData(TeamRepository teamRepository, CarRepository carRepository, PartRepository partRepository)   {
        teams = teamRepository.findAll();
        parts = partRepository.findAll();
        cars = carRepository.findAll();
    }

    @Override
    public void conductTournament() {
        winner = null;

        OptimalPartsSelectorFactory optimalPartsSelectorFactory = new OptimalPartsSelectorFactory();
        OptimalPartsSelectorService optimalPartsSelectorService = optimalPartsSelectorFactory.getOptimalPartsSelectorService(PartSelectionParameters.SPEED);

        for(Team team : teams) {
            List<Car> availableCarsForTeam = TournamentUtilities.findAvailableCarsForTeam(team.getCarId(), cars);

            for(Car car : availableCarsForTeam)	{
                List<Part> availablePartsForCar = TournamentUtilities.findAvailablePartsForCar(parts, car);

                CustomizedCarStatistics customizedCarStatistics = optimalPartsSelectorService.findOptimalParts(car, availablePartsForCar, team.getMaxFunds());

                if(winner == null || customizedCarStatistics.getMaxSpeedAchieved() > winner.getSpeedAchieved())	{
                    winner = new Winner(team.getTeamName(), car.getCarName(), customizedCarStatistics.getMaxSpeedAchieved(), customizedCarStatistics.getFundsSpent(), customizedCarStatistics.getParts());
                }
            }
        }
    }

    @Override
    public Winner getWinner() {
        return winner;
    }
}
