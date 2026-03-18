import java.io.FileNotFoundException;
import java.util.Scanner;

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
        System.out.println("Input new vector");
        Scanner sc = new Scanner(System.in);
        double[] arr = new double[4];
        for(int i =0;i<4;i++){
            arr[i] = sc.nextDouble();
        }
        for(Observation ob : list.getData()){
            System.out.println(ob.distance(new Observation(arr,"")));
        }
    }
    private static double[] readVector(Scanner sc, int n){
        double[] vector = new double[n];
        for(int i = 0;i<n;i++){
            System.out.println("Input double("+(i+1)+")");
            vector[i] = sc.nextDouble();
        }
        return vector;
    }
}