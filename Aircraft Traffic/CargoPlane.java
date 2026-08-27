public class CargoPlane extends Plane{
    private String planeID;
    private String model;
    private double planeSpeed;
    private String status; 
    private double maxWeight; //in KG
    private double currentWeight;

    public CargoPlane(String planeID, String model, double planeSpeed, String status, double maxWeight, double currentWeight){
        super(planeID, model, planeSpeed, status);
        this.maxWeight = maxWeight;
        this.currentWeight = currentWeight;
    }
}