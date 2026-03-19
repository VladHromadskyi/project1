import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataList {
    private List<Observation> data = new ArrayList<>();

    public DataList(String filePath)throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(filePath));
        while(fileScanner.hasNextLine()){
            String line  = fileScanner.nextLine();
            if(line.trim().isEmpty()) continue;

            String[] parts = line.trim().split("\\s+");
            double[] attributes = new double[parts.length-1];
            String flowerName = parts[parts.length-1];
            for(int i = 0;i<attributes.length;i++){
                attributes[i] = Double.parseDouble(parts[i].replace(",","."));
            }
            this.data.add(new Observation(attributes,flowerName));
        }
        fileScanner.close();
    }
    public void show(){
        for(Observation ob : data){
            ob.show();
        }
    }
    public List<Observation> getData(){return this.data;}
}
