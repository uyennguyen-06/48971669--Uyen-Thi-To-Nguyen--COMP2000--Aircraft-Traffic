public class Plane {
    private final String planeID;
    private String model;
    private double planeSpeed;
    private String status; 
    private int capacity;
    private final double emptyWeight;

    public Plane(String planeID, String model, int capacity, double planeSpeed, String status, double emptyWeight){
        this.planeID = planeID;
        this.model = model;
        this.capacity = capacity;
        this. planeSpeed = planeSpeed;
        this.emptyWeight = emptyWeight;
        this.status = "GOUNDED"; // Default status of plane
    }

    //setters
    public void setModel(String model){
        this.model = model;
    }
    
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    public void setPlaneSpeed(float planeSpeed){
        this.planeSpeed = planeSpeed;
    }

    public void setStatus(String status){
        this.status = status;
    }
    
    //getters
    public String getPlaneID(){
        return planeID;
    }

    public String getModel(){
        return model;
    }

    public String getPlaneSpeed(){
        return planeSpeed;
    }

    public boolean getStatus(){
        return status;
    }

    public int getCapacity(){
        return capacity;
    }

    public double getEmptyWeight(){
        return emptyWeight;
    }

    public void displayInfo(){
        System.out.println("Plane ID: " + getPlaneID());
        System.out.println("Model: " + getModel());
        System.out.println("Capacity: " + getCapacity());
        System.out.println("Destination: " + getPlaneSpeed());
        System.out.println("Status: " + getStatus());
    }
}
