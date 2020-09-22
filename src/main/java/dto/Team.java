package dto;

public class Team {

    int teamId;

    String teamName;

    int carId;

    double maxFunds;

    public Team(int teamId, String teamName, int carId, double maxFunds) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.carId = carId;
        this.maxFunds = maxFunds;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public double getMaxFunds() {
        return maxFunds;
    }

    public void setMaxFunds(double maxFunds) {
        this.maxFunds = maxFunds;
    }
}
