package Factories;

import Constants.ErrorMessages;
import Enums.PartSelectionParameters;
import Services.Impl.MaxSpeedBoostService;
import Services.OptimalPartsSelectorService;

public class OptimalPartsSelectorFactory {
    public  OptimalPartsSelectorService getOptimalPartsSelectorService(PartSelectionParameters parameter)    {
        if(parameter.equals(PartSelectionParameters.SPEED))
            return new MaxSpeedBoostService();
        else
            throw new IllegalArgumentException(ErrorMessages.INVALID_PART_SELECTION_PARAMETER);
    }
}
