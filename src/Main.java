import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        TrainingList list = null;
        try {
            list = new TrainingList("iris_training.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        list.show();
        //--------------------------------------------------------
        System.out.println("New test\n");
        Scanner sc = new Scanner(System.in);
        double[] arr = readVector(sc,4);
        classify(list,new Observation(arr));
    }
    private static double[] readVector(Scanner sc, int n){
        double[] vector = new double[n];
        for(int i = 0;i<n;i++){
            System.out.println("Input double("+(i+1)+")");
            vector[i] = sc.nextDouble();
        }
        return vector;
    }
    private static void classify(TrainingList list, Observation obs){
        List<Neighbor> neighborList = new ArrayList<>();
        for(Observation ob : list.getData()){
            neighborList.add(new Neighbor(ob,ob.distance(obs)));
        }
        Collections.sort(neighborList);
        for(Neighbor n : neighborList){
            n.show();
        }
    }
}