import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadFromFile {


    public ArrayList<String> readFromFile(String path){
        File file = new File(path);
        try (BufferedReader bReader = new BufferedReader(new FileReader(file))) {

            StringBuilder stringBuilder = new StringBuilder();

            String line;
            while ((line = bReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            String allLines = String.valueOf(stringBuilder);
            ArrayList<String> buffer = new ArrayList<>(Arrays.asList(allLines.split(";")));
            return buffer;
        } catch (Exception ignored) {

        }
        return null;
    }
}
