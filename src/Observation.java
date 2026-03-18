public class Observation {
    private double[] attributes;
    private String flowerName;

    public Observation(double[] attributes, String flowerName){
        this.attributes = attributes;
        this.flowerName = flowerName;
    }

    public double[] getAttributes() {
        return attributes;
    }
    public String getFlowerName(){
        return flowerName;
    }
}
