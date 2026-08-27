public class Runway extends AirportPath{
    private String pathID;
    private double lengthInMeters;
    private final int capacity; //final allows only 1 plane at a time
    private String status;
    private final Plane currentPlane; //current plane at the runway

    public Runway(String pathID, double lengthInMeters, double runwayID, int capacity, Plane currentPlane){
        super(pathID, lengthInMeters);
        this.capacity = capacity;
        this.status = status;
        this.currentPlane = currentPlane;
    }

    @Override 
    public boolean canAcceptPlane(Plane currentPlane){
        return false; 
    }

    public boolean enterRunway(Plane currentPlane){
        return false;
    }

    public int getCapacity(){
        return capacity;
    }

    public Plane getCurrentPlane(){
        return currentPlane; 
    }

    public String status(){
        System.out.println("Status: " + currentPlane + "is boarding.");
        return status;
    }
}