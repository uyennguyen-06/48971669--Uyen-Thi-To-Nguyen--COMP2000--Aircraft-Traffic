public class Runway extends AirportPath{
    private final int capacity; //final allows only 1 plane at a time
    private String status;
    private final Plane currentPlane; //current plane at the runway

    public Runway(double runwayID, int capacity, Plane currentPlane){
        super(pathID, lengthInMeters);
        this.capacity = capacity;
        this.status = status;
        this.currentPlane = currentPlane;
    }

    @Override 
    public boolean canAcceptPlane(Plane currentPlane){
        return false; 
    }

    public boolean enterRunway(Plane currentPlane)

    public int getCapacity(){
        return capacity;
    }

    public Plane getCurrentPlane(){
        return currentPlane; 
    }

    public String status(){
        System.out.println("Status: " + currentPlane + "is boarding".);
        return status;
    }
}