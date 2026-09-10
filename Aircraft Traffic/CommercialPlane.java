public class CommercialPlane extends Plane {
    private final int numSeats;
    private int currentPassengers;

    public CommercialPlane(String planeID, String model, double planeSpeed, String status, double emptyWeight, int capacity, int numSeats, int currentPassengers) {
        super(planeID, model, planeSpeed, status, emptyWeight, capacity);
        this.numSeats = numSeats;
        this.currentPassengers = currentPassengers;
    }

    //setters
    public void setCurrentPassengers (int currentPassengers) {
        if (currentPassengers >= 0 && currentPassengers <= numSeats) {
            this.currentPassengers = currentPassengers;
        }
    }

    //getters 
    public int getNumSeats(){
        return numSeats;
    }

    public int getCurrentPassengers(){
        return currentPassengers;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        
        System.out.println("This is a Commercial Plane.");
        System.out.println("Number of Seats: " + numSeats);
        System.out.println("Current Passengers: " + currentPassengers);
    }

}