import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrainingList {
    private List<Observation> data = new ArrayList<>();

    public TrainingList(String filePath)throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(filePath));
        while(fileScanner.hasNextLine()){
            String line  = fileScanner.nextLine();
            if(line.isEmpty()) continue;

            String[] parts = line.split("\\s+");
            double[] attributes = new double[parts.length-1];
            String flowerName = parts[parts.length-1];
            for(int i = 0;i<attributes.length;i++){
                attributes[i] = Double.parseDouble(parts[i].replace(',','.'));
            }
            this.data.add(new Observation(attributes,flowerName));
        }
        fileScanner.close();
    }
}
