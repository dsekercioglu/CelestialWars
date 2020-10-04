package celestialwars;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileUtils {

    public static void writeLines(String path, List<String> lines, boolean append) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path, append));
        for (String line : lines) {
            writer.write(line + "\n");
        }
        writer.close();
    }

    public static List<String> readLines(String path) throws IOException {
        File file = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        List<String> lines = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines;
    }

    public static Map<String, String> loadShips() throws IOException {
        String path = "ships.txt";
        List<String> lines = readLines(path);
        Map<String, String> ships = new HashMap<>();
        for (String line : lines) {
            String shipName = line.split("#")[0];
            String shipCode = line.split("#")[1];
            ships.put(shipName, shipCode);
        }
        return ships;
    }

    public static void saveShips(Map<String, String> ships) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String shipName : ships.keySet()) {
            String shipCode = ships.get(shipName);
            String line = shipName + "#" + shipCode;
            lines.add(line);
        }
        writeLines("ships.txt", lines, false);
    }

}
