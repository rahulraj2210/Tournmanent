package repositories.impl;

import dto.Team;
import repositories.TeamRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TeamCsvRepository implements TeamRepository {
    private String csvName = "Teams.csv";

    @Override
    public List<Team> findAll() {
        URL url = this.getClass().getResource(csvName);
        List<Team> teams = readPartsFromCSV(url.toString());
        return teams;
    }

    private List<Team> readPartsFromCSV(String fileName) {
        List<Team> teams = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] row = line.split(",");
                Team team = createPart(row);
                teams.add(team);
                line = br.readLine();
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return teams;
    }

    private Team createPart(String[] row) {
        return new Team(Integer.parseInt(row[0]), row[1], Integer.parseInt(row[2]),Double.parseDouble(row[3]));
    }
}
