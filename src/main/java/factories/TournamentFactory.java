package factories;

import constants.ErrorMessages;
import constants.TournamentNames;
import services.Impl.FastestCarTournamentService;
import services.TournamentService;

public class TournamentFactory {
    public TournamentService getTournamentService(String tournament)  {
        if(tournament == TournamentNames.CRIOLAND_VIRTUAL_TOURNAMENT)
            return new FastestCarTournamentService();
        else
            throw new IllegalArgumentException(ErrorMessages.INVALID_TOURNAMENT_NAME);
    }
}
