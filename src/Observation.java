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
    public double distance(Observation obj){
        if(this.attributes.length!=obj.attributes.length){
            throw new IllegalArgumentException("Vectors have different length: "+this.attributes.length
            +" and " + obj.attributes.length);
        }
        double sum = 0;
        for(int i =0;i<this.attributes.length;i++){
            double diff = obj.attributes[i]-this.attributes[i];
            sum+=diff*diff;
        }
        return Math.sqrt(sum);
    }
}
