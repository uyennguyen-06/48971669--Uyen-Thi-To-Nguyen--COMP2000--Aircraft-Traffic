public class BusLane extends AirportPath {
    private String pathID;
    private double lengthInMeters;
    private double busID;
    private int capacity; 
    private double maxSpeedKnots;

    public BusLane(String pathID, double lengthInMeters, double busID, int capacity, double maxSpeedKnots){
        super(pathID, lengthInMeters);
        this.busID = busID;
        this.capacity = capacity;
        this.maxSpeedKnots = maxSpeedKnots;
    } 

    @Override

    public boolean canAcceptPlane(Plane plane) {
        return false; // needs to be modified (come up with logic)
  }

  /**
   * 
   * Adds a plane to the busLane is space allows
   */
  public boolean enterBusLane(Plane plane) {
    if (canAcceptPlane(plane)) {
      // logic
      return true;
    }
    return false;
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