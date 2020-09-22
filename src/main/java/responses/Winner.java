package responses;

import dto.Part;

import java.util.List;

public class Winner {

    String TeamName;

    String carName;

    double speedAchieved;

    double fundsSpent;

    List<Part> partsUsed;

    public Winner(String teamName, String carName, double speedAchieved, double fundsSpent, List<Part> partsUsed) {
        this.TeamName = teamName;
        this.carName = carName;
        this.speedAchieved = speedAchieved;
        this.fundsSpent = fundsSpent;
        this.partsUsed = partsUsed;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public double getSpeedAchieved() {
        return speedAchieved;
    }

    public void setSpeedAchieved(double speedAchieved) {
        this.speedAchieved = speedAchieved;
    }

    public double getFundsSpent() {
        return fundsSpent;
    }

    public void setFundsSpent(double fundsSpent) {
        this.fundsSpent = fundsSpent;
    }

    public List<Part> getPartsUsed() {
        return partsUsed;
    }

    public void setPartsUsed(List<Part> partsUsed) {
        this.partsUsed = partsUsed;
    }

}
