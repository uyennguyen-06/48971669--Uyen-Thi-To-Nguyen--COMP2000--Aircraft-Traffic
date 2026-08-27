public class Runway extends AirportPath{
    private int capacity;
    private String status;
    private Plane currentPlane; //current plane at the runway

    public Runway(String pathID, double lengthInMeters, double runwayID, int capacity, Plane currentPlane, String status){
        super(pathID, lengthInMeters);
        this.capacity = capacity;
        this.status = status;
        this.currentPlane = currentPlane;
    }

    //setters
    public void setStatus(String status){
        this.status = status;
    }

    //getters
    public int getCapacity(){
        return capacity;
    }

    public Plane getCurrentPlane(){
        return currentPlane; 
    }

    public String getStatus(){
        System.out.println("Status: " + currentPlane + "is boarding.");
        return status;
    }

    @Override 
    public boolean canAcceptPlane(Plane plane){
        if (currentPlane == null){
            return true;
        }
        return false; 
    }

    @Override
    public boolean enterRunway(Plane plane){
        if (canAcceptPlane(plane)){
            currentPlane = plane;
            return true;
        }
        return false;
    }

}