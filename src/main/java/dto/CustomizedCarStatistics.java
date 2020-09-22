package dto;

import java.util.List;

public class CustomizedCarStatistics {

    double maxSpeedAchieved;

    double fundsSpent;

    List<Part> parts;

    public CustomizedCarStatistics(double maxSpeedAchieved, double fundsSpent, List<Part> parts) {
        this.maxSpeedAchieved = maxSpeedAchieved;
        this.fundsSpent = fundsSpent;
        this.parts = parts;
    }

    public double getMaxSpeedAchieved() {
        return maxSpeedAchieved;
    }

    public double getFundsSpent() {
        return fundsSpent;
    }

    public List<Part> getParts() {
        return parts;
    }
}
