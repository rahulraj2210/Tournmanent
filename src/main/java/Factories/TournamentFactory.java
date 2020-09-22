package Factories;

import Constants.ErrorMessages;
import Constants.TournamentNames;
import Services.Impl.FastestCarTournamentService;
import Services.TournamentService;

public class TournamentFactory {
    public TournamentService getTournamentService(String tournament)  {
        if(tournament == TournamentNames.CRIOLAND_VIRTUAL_TOURNAMENT)
            return new FastestCarTournamentService();
        else
            throw new IllegalArgumentException(ErrorMessages.INVALID_TOURNAMENT_NAME);
    }
}
