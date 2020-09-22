package factories;

import constants.ErrorMessages;
import enums.PartSelectionParameters;
import services.Impl.MaxSpeedBoostService;
import services.OptimalPartsSelectorService;

public class OptimalPartsSelectorFactory {
    public  OptimalPartsSelectorService getOptimalPartsSelectorService(PartSelectionParameters parameter)    {
        if(parameter.equals(PartSelectionParameters.SPEED))
            return new MaxSpeedBoostService();
        else
            throw new IllegalArgumentException(ErrorMessages.INVALID_PART_SELECTION_PARAMETER);
    }
}
