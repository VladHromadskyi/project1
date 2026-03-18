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
    public void show(){
        for(int i = 0;i<attributes.length;i++){
            System.out.print(attributes[i] + " ");
        }
        System.out.println(flowerName+"\n");
    }
}
