import enums.ResultDeclarationMethods;
import constants.TournamentNames;
import factories.ResultDeclarationFactory;
import factories.TournamentFactory;
import repositories.CarRepository;
import repositories.impl.CarCsvRepositoryImpl;
import repositories.impl.PartCsvRepositoryImpl;
import repositories.impl.TeamCsvRepository;
import repositories.PartRepository;
import repositories.TeamRepository;
import responses.Winner;
import services.ResultDeclarationService;
import services.TournamentService;


public class Main {
    public static void main(String args[])   {
        //Select Tournament
        TournamentFactory tournamentFactory = new TournamentFactory();
        TournamentService tournamentService = tournamentFactory.getTournamentService(TournamentNames.CRIOLAND_VIRTUAL_TOURNAMENT);

        //Collect Tournament Data
        TeamRepository teamRepository = new TeamCsvRepository();
        CarRepository carRepository = new CarCsvRepositoryImpl();
        PartRepository partRepository = new PartCsvRepositoryImpl();
        tournamentService.collectTournamentData(teamRepository, carRepository, partRepository);

        //Conduct the tournament
        tournamentService.conductTournament();

        //Get the winner
        Winner winner = tournamentService.getWinner();

        //Declare Results
        ResultDeclarationFactory resultDeclarationFactory = new ResultDeclarationFactory();
        ResultDeclarationService resultDeclarationService = resultDeclarationFactory.getResultDeclarationService(ResultDeclarationMethods.CONSOLE_DISPLAY);
        resultDeclarationService.show(winner);
    }

}
