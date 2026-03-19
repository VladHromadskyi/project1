import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        DataList trainingList = null;
        DataList testList = null;
        try {
            trainingList = new DataList("iris_training.txt");
            testList = new DataList("iris_test.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Iris-training:");
        trainingList.show();
        System.out.println("Iris-test:");
        testList.show();
        System.out.println("Test:");
        double rightClassify =0;
        for(Observation observation : testList.getData()){
            if(classify(trainingList, observation, 3).equals(observation.getFlowerName()))rightClassify++;
        }
        System.out.println("Accuracy: " + (rightClassify/testList.getData().size()*100)+"%");
        //--------------------------------------------------------
//        System.out.println("New test");
//        Scanner sc = new Scanner(System.in);
//        double[] arr = readVector(sc,4);
//        classify(trainingList,new Observation(arr),7);
    }

    private static double[] readVector(Scanner sc, int n){
        double[] vector = new double[n];
        for(int i = 0;i<n;i++){
            System.out.println("Input double("+(i+1)+")");
            vector[i] = sc.nextDouble();
        }
        return vector;
    }

    private static String classify(DataList trainingList, Observation obs, int k){
        List<Neighbor> neighborList = new ArrayList<>();
        for(Observation ob : trainingList.getData()){
            neighborList.add(new Neighbor(ob,ob.distance(obs)));
        }
        Collections.sort(neighborList);
        //----------------------------------------------
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0;i<k;i++){
            String flowerName = neighborList.get(i).getObservation().getFlowerName();
            map.put(flowerName,map.getOrDefault(flowerName,0)+1);
        }

        String winner = null;
        int maxVotes = -1;
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue()>maxVotes){
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }
        Observation observation = new Observation(obs.getAttributes(),winner);
        observation.show();
        return winner;
    }
}