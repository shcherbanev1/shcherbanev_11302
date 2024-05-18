import java.io.*;
import java.util.Collection;

public class HumanDataParser {

    private final BufferedReader reader;

    public HumanDataParser(String filepath) throws FileNotFoundException {
        this.reader = new BufferedReader(new FileReader(filepath));
    }

    public void parseFromFileToCollection(Collection<HumanData> collection) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            HumanData data = new HumanData(line);
            collection.add(data);
        }
    }

}
