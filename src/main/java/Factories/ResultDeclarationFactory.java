package Factories;

import Constants.ErrorMessages;
import Enums.ResultDeclarationMethods;
import Services.ResultDeclarationService;
import Services.Impl.ConsoleDeclarationService;

public class ResultDeclarationFactory {
    public ResultDeclarationService getResultDeclarationService(ResultDeclarationMethods declarationType)    {
        if(declarationType == ResultDeclarationMethods.CONSOLE_DISPLAY)
            return new ConsoleDeclarationService();
        else
            throw new IllegalArgumentException(ErrorMessages.INVALID_RESULT_DECLARATION_METHOD);
    }
}
