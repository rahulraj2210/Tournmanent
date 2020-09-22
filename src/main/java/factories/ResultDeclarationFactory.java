package factories;

import constants.ErrorMessages;
import enums.ResultDeclarationMethods;
import services.ResultDeclarationService;
import services.Impl.ConsoleDeclarationService;

public class ResultDeclarationFactory {
    public ResultDeclarationService getResultDeclarationService(ResultDeclarationMethods declarationType)    {
        if(declarationType == ResultDeclarationMethods.CONSOLE_DISPLAY)
            return new ConsoleDeclarationService();
        else
            throw new IllegalArgumentException(ErrorMessages.INVALID_RESULT_DECLARATION_METHOD);
    }
}
