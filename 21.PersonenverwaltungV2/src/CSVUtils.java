import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {
    public static List<String[]> readCSV(String filepath) throws IOException {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line.split(", "));
            }
        }
        return data;
    }

    public static void writeCSV(String filepath, List<String[]> data) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath))) {
            for (String[] line : data) {
                bw.write(String.join(", ", line));
                bw.newLine();
            }
        }
    }
}
