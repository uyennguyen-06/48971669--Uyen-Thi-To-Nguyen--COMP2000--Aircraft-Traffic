public class Plane {
    private final String planeID;
    private String model;
    private double planeSpeed;
    private String status; 
    private final double emptyWeight;
    private final int capacity;

    public Plane(String planeID, String model, double planeSpeed, String status, double emptyWeight,  int capacity){
        this.planeID = planeID;
        this.model = model;
        this.planeSpeed = planeSpeed;
        this.status = "GOUNDED"; // Default status of plane
        this.emptyWeight = emptyWeight;
        this.capacity = capacity;
    }

    //setters
    public void setModel(String model){
        this.model = model;
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

    public double getPlaneSpeed(){
        return planeSpeed;
    }

    public String getStatus(){
        if(status.equals("GOUNDED")){
            System.out.println("Status: " + planeID + " is grounded.");
        } else if (status.equals("BOARDING")){
            System.out.println("Status: " + planeID + " is boarding.");
        } else if (status.equals("IN-FLIGHT")){
            System.out.println("Status: " + planeID + " is in-flight.");
        }
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
        System.out.println(getStatus());
    }
}
