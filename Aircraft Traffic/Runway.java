public class Runway extends AirportPath{
    private final int capacity;
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

    public boolean canAcceptPlane(Plane plane){
        if (currentPlane == null){
            return true;
        }
        return false; 
    }

    public boolean enterRunway(Plane plane){
        if (canAcceptPlane(plane)){
            currentPlane = plane;
            return true;
        }
        return false;
    }

    public void requestEntry(Plane plane){
        throws RunwayOccupiedException{ 
            if (currentPlane != null){
                throw new RunwayOccupiedException("Runway is currently occupied by " + currentPlane.getPlaneID());
            }
            currentPlane = plane;
    }

    public void exitRunway(Plane plane){
        if (currentPlane == plane){
            currentPlane = null;
        }
    }
}