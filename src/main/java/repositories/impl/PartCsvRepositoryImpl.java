package repositories.impl;

import dto.Part;
import repositories.PartRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PartCsvRepositoryImpl implements PartRepository {
    private String csvName = "Parts.csv";

    @Override
    public List<Part> findAll() {
        URL url = this.getClass().getResource(csvName);
        List<Part> parts = readPartsFromCSV(url.toString());
        return parts;
    }

    private List<Part> readPartsFromCSV(String fileName) {
        List<Part> parts = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] row = line.split(",");
                Part part = createPart(row);
                parts.add(part);
                line = br.readLine();
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return parts;
    }

    private Part createPart(String[] row) {
        return new Part(Integer.parseInt(row[0]), Integer.parseInt(row[1]), Double.parseDouble(row[2]),Double.parseDouble(row[3]));
    }
}
