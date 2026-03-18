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