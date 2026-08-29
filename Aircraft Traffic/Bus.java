public class Bus {
    private final String busID;
    private String busStatus;
    private final int busCapacity;
    private int currentPassengers;

    public Bus (String busID, String busStatus, int busCapacity, int currentPassengers) {
        this.busID = busID;
        this.busStatus = busStatus;
        this.busCapacity = busCapacity;

        if (currentPassengers >= 0 && currentPassengers <= busCapacity) {
            this.currentPassengers = currentPassengers;
        } // Call setter to validate current passengers
    }

    //setters
    public void setBusStatus(String busStatus) {
        this.busStatus = busStatus;
    }

    //getters
    public String getBusID() {
        return busID;
    }

    public String getBusStatus() {
        if (busStatus.equals("IN SERVICE")) {
            System.out.println("Status: " + busID + " is in service.");
        } else if (busStatus.equals("OUT OF SERVICE")) {
            System.out.println("Status: " + busID + " is out of service.");
        }
        return busStatus;
    }

    public int getBusCapacity() {
        return busCapacity;
    }

    public int getCurrentPassengers() {
        return currentPassengers;
    }

    public void displayInfo() {
        System.out.println("Bus ID: " + busID);
        System.out.println(getBusStatus());
        System.out.println("Bus Capacity: " + busCapacity);
        System.out.println("Current Passengers: " + currentPassengers);
    }
}