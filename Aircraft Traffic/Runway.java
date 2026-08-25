public class Runway extends AirportPath{
    private double runwayID;
    private final int capacity; //final allows only 1 plane at a time
    private final Plane currentPlane; //current plane at the runway

    public Runway(double runwayID, int capacity, Plane currentPlane){
        this.runwayID = runwayID;
        this.capacity = capacity;
        this.currentPlane = currentPlane;
    }

    @Override 
    public 
}