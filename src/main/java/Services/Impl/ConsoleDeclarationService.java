package Services.Impl;

import DTO.Part;
import Responses.Winner;
import Services.ResultDeclarationService;

import java.util.List;

public class ConsoleDeclarationService implements ResultDeclarationService {
    @Override
    public void show(Winner winner) {
        System.out.println("Winner\n=====");
        printTeam(winner.getTeamName());
        printCar(winner.getCarName());
        printSpeedAchieved(winner.getSpeedAchieved());
        printFundsSpent(winner.getFundsSpent());
        printPartsUsed(winner.getPartsUsed());
    }

    private void printTeam(String teamName) {
        System.out.println("Team:\n");
        System.out.println(teamName + "\n");
    }

    private void printCar(String carName) {
        System.out.println("Car:\n");
        System.out.println(carName + "\n");
    }

    private void printSpeedAchieved(double speed) {
        System.out.println("Speed:\n");
        System.out.println(speed + "\n");
    }

    private void printFundsSpent(double fundsSpent) {
        System.out.println("Funds:\n");
        System.out.println(fundsSpent + "\n");
    }

    private void printPartsUsed(List<Part> partsUsed) {
        System.out.println("Parts:\n");
        partsUsed.forEach(part -> System.out.println(part.getPartId()));
    }
}
