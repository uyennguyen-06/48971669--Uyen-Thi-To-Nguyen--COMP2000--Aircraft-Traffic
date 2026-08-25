public class BusLane extends AirportPath {
    private final int capacity; 
    private final double maxSpeedKnots;

    public BusLane(double busID, int capacity){
        super(pathID, lengthInMeters);
        this.capacity = capacity;
        this.maxSpeedKnots = maxSpeedKnots;
    } 

    @Override

    public boolean canAcceptPlane(Plane plane) {
        return false; // needs to be modified (come up with logic)
  }

  /**
   * 
   * Adds an aircraft to the taxiway is space allows
   */
  public boolean enterBusLane(Plane plane) {
    if (canAcceptPlane(plane)) {
      // logic
      return true;
    }
    return false;
  }

  public Plane exitBusLane() {
    // return
  }

  // change return val
  public int getCurrentOccupancy() {
    return 0;
  }

  public int getCapacity() {
    return capacity;
  }

  public double getMaxSpeedKnots() {
    return maxSpeedKnots;
  }
}