public class CargoPlane extends Plane{
    private final double maxWeight; // in KG
    private double currentWeight;

    public CargoPlane(String planeID, String model, double planeSpeed, String status, double emptyWeight, double maxWeight, double currentWeight, int capacity){
        super(planeID, model, planeSpeed, status, emptyWeight, capacity);
        this.maxWeight = maxWeight;
        setCurrentWeight(currentWeight); //call setter from constructor so it would check setter first 
    }

    //setter
    public void setCurrentWeight(double currentWeight){
        if (currentWeight >= 0 && currentWeight <= maxWeight){
            this.currentWeight = currentWeight;
        }
    }
    
    /* No setter for maxWeight because it is fixed when the plane is created */

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