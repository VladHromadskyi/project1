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
//        Scanner scanner = new Scanner(System.in);
//        double[] vector1 = readVector(scanner,4);
//        double[] vector2 = readVector(scanner,4);
//        double distance = 0;
//        for(int i =0;i<4;i++){
//            distance+=Math.pow(vector2[i]-vector1[i],2);
//        }
//        distance=Math.sqrt(distance);
//        System.out.println("Distance = "+ distance);

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