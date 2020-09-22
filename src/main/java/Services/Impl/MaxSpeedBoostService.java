package Services.Impl;

import DTO.Car;
import DTO.Part;
import DTO.CustomizedCarStatistics;
import Services.OptimalPartsSelectorService;

import java.util.ArrayList;
import java.util.List;

public class MaxSpeedBoostService implements OptimalPartsSelectorService {

    List<Part> selectedParts = new ArrayList<>();

    double maxSpeedAchieved = 0;

    double fundsSpent = 0;

    @Override
    public CustomizedCarStatistics findOptimalParts(Car car, List<Part> availablePartsForCar, double budget)   {
        buildFastestCar(car, availablePartsForCar, budget);
        return new CustomizedCarStatistics(maxSpeedAchieved, fundsSpent, selectedParts);
    }

    void buildFastestCar(Car car, List<Part> availablePartsForCar, double budget)	{
        double[][] table = new double[availablePartsForCar.size()+1][(int)budget+1];
        double speed = 0, funds = 0, partIndex = -1;

        for(int i=0; i<=availablePartsForCar.size(); i++)
            for(int w=0; w<=budget; w++) {
                if (i == 0 || w == 0) {
                    table[i][w] = car.getBaseSpeed();
                    continue;
                }
                if (availablePartsForCar.get(i).getPrice() <= w) {
                    table[i][w] = Math.max(availablePartsForCar.get(i).getSpeedBoost() + table[i - 1][(int) (w - availablePartsForCar.get(i).getPrice())],
                            table[i - 1][w]);
                }
                else    {
                    table[i][w] = table[i-1][w];
                }

                if(table[i][w] > speed && table[i][w] <= car.getTopSpeed()) {
                    speed = table[i][w];
                    funds = w;
                    partIndex = i;
                }
            }

        this.maxSpeedAchieved = speed;
        findFundsAndPartsUsed(table, speed, funds, partIndex, availablePartsForCar);
    }

    void findFundsAndPartsUsed(double[][] table, double speed, double funds, double partIndex, List<Part> availablePartsForCar) {
        double res = speed;
        double w = funds;

        for(int i = (int) partIndex; i>0 && res > 0; i--)    {
            if(res !=  table[i-1][(int) w])   {
                this.selectedParts.add(availablePartsForCar.get(i));
                this.fundsSpent += availablePartsForCar.get(i).getPrice();

                res -= availablePartsForCar.get(i).getSpeedBoost();
                w -= availablePartsForCar.get(i).getPrice();
            }
        }

    }

}
