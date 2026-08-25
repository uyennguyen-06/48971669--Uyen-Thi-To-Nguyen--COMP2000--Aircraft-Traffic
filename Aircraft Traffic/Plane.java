public class Plane {
    private String planeID;
    private String model;
    private float planeSpeed;
    private String status; 
    private int capacity;

    public void setPlane (String planeID, String model, String destination, boolean bording, int capacity){
        this.planeID = planeID;
        this.model = model;
        this.capacity = capacity;
        this.destination = destination;
        this.status = "GOUNDED"; // Default status of plane
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

    public String getDestination(){
        return destination;
    }

    public boolean getStatus(){
        return status;
    }

    public int getCapacity(){
        return capacity;
    }

    //setters
    public void setPlaneID(String planeID){
        this.planeID = planeID;
    }

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

    public void displayInfo(){
        System.out.println("Plane ID: " + getPlaneID());
        System.out.println("Model: " + getModel());
        System.out.println("Capacity: " + getCapacity());
        System.out.println("Destination: " + getPlaneSpeed());
        System.out.println("Status: " + getStatus());
    }
}
