public class CargoPlane extends Plane{
    private final double maxWeight; // in KG
    private double currentWeight;

    public CargoPlane(String planeID, String model, String status, double planeSpeed, double emptyWeight, double maxWeight, double currentWeight, int capacity){
        super(planeID, model, planeSpeed, status, emptyWeight, capacity);
        this.maxWeight = maxWeight;

        if (currentWeight >= 0 && currentWeight <= maxWeight){
            this.currentWeight = currentWeight;
        } //call setter from constructor so it would check setter first 
    }

    //getters
    public double getCurrentWeight(){
        return currentWeight;
    }

    public double getMaxWeight(){
        return maxWeight;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        
        System.out.println("This is a Cargo Plane.");
        System.out.println("Max Weight: " + maxWeight);
        System.out.println("Current Weight: " + currentWeight);
    }
}