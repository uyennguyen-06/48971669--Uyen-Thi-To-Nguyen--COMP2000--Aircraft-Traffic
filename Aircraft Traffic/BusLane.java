public class BusLane extends AirportPath {
    private int capacity; 
    private double maxSpeedKnots;

    public BusLane(String pathID, double lengthInMeters, int capacity, double maxSpeedKnots){
        super(pathID, lengthInMeters);
        this.capacity = capacity;
        this.maxSpeedKnots = maxSpeedKnots;
    } 

    //setters
    public void setCapacity(int capacity){
      this.capacity = capacity;
    }

    public void setMaxSpeedKnots(double maxSpeedKnots){
      this.maxSpeedKnots = maxSpeedKnots;
    }

    // getters
    public int getCapacity() {
      return capacity;
    }

    public double getMaxSpeedKnots() {
      return maxSpeedKnots;
    }
    
    /*@Override
    public boolean enterBusLane(Plane plane) {
      if (canAcceptPlane(plane)) {
        // logic
        return true;
      }
      return false;
    }*/

}