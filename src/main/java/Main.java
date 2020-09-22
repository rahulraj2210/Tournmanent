import Enums.ResultDeclarationMethods;
import Constants.TournamentNames;
import Factories.ResultDeclarationFactory;
import Factories.TournamentFactory;
import Repositories.CarRepository;
import Repositories.Impl.CarCsvRepositoryImpl;
import Repositories.Impl.PartCsvRepositoryImpl;
import Repositories.Impl.TeamCsvRepository;
import Repositories.PartRepository;
import Repositories.TeamRepository;
import Responses.Winner;
import Services.ResultDeclarationService;
import Services.TournamentService;


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
