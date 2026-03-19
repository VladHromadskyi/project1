import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    static final Scanner sc = new Scanner(System.in);
    static final Random random = new Random();

    public static void main(String[] args) {
        DataList trainingList = null;
        DataList testList = null;
        try {
            trainingList = new DataList("iris_training.txt");
            testList = new DataList("iris_test.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

//        System.out.println("\nIris-training data:");
//        trainingList.show();
//        System.out.println("\nIris-test data:");
//        testList.show();

        System.out.println("\nAccuracy test:");
        System.out.print("Input value of \"k\": ");
        int k = sc.nextInt();
        sc.nextLine();
        double rightClassify =0;
        if(k>trainingList.getData().size()){
            System.out.println("Variable k is more than the amount of neighbors, " +
                    "so variable k was decreased to " + trainingList.getData().size());
            k = trainingList.getData().size();
        }
        for(Observation observation : testList.getData()){
            if(classify(trainingList, observation, k).equals(observation.getFlowerName()))rightClassify++;
        }
        System.out.println("\nAmount of right classifications: "+rightClassify+"\\"+testList.getData().size());
        System.out.println("Accuracy: " + (rightClassify/testList.getData().size()*100)+"%");
        //--------------------------------------------------------
        System.out.println("\n--- Manual Vector Input Mode ---");
        System.out.println("Enter attributes separated by space (e.g., 5.1 3.5 1.4 0.2)");
        System.out.println("Type 'exit' to finish.");
        while(true){
            System.out.print("\nInput attributes: ");
            String input = sc.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting manual mode...");
                break;
            }
            try {
                String[] parts = input.split("\\s+");

                double[] userVector = new double[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    userVector[i] = Double.parseDouble(parts[i].replace(',', '.'));
                }

                Observation userObs = new Observation(userVector);
                String predictedClass = classify(trainingList, userObs, k);

                System.out.println("Result of classification: " + predictedClass);

            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter only numbers separated by spaces.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
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
        int maxVotes = -1;
        for(Integer var : map.values()){
            if(var>maxVotes){
                maxVotes = var;
            }
        }
        List<String> tiedWinners = new ArrayList<>();
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            if(maxVotes == entry.getValue()) tiedWinners.add(entry.getKey());
        }
        int randomIndex = random.nextInt(tiedWinners.size());

//        Observation observation = new Observation(obs.getAttributes(),tiedWinners.get(randomIndex));
//        observation.show();

        return tiedWinners.get(randomIndex);
    }
}