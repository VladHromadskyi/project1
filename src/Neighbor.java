public class Neighbor implements Comparable<Neighbor>{
    private Observation observation;
    private double distance;

    public Neighbor(Observation observation, double distance){
        this.observation = observation;
        this.distance = distance;
    }
    @Override
    public int compareTo(Neighbor o) {
        return Double.compare(this.distance,o.distance);
    }

    public Observation getObservation(){return this.observation;}
    public double getDistance(){return this.distance;}
    public void show(){
        System.out.print("{ Vector: ");
        observation.show();
        System.out.println("Distance: "+distance+"}");
    }
}
