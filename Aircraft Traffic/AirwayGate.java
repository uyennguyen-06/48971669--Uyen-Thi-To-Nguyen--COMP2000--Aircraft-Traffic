public class AirwayGate {
    private final String gateID;
    private boolean status; // true if the gate is open, false if closed
    private Plane currentPlane; // the plane currently at the gate

    public AirwayGate(String gateID, boolean status, Plane currentPlane) {
        this.gateID = gateID;
        this.status = status;
        this.currentPlane = currentPlane;
    }

    //setters
    public boolean parkPlane (Plane plane){
        if (status && currentPlane == null){
            currentPlane = plane;
            return true;
        }
        return false;
    }

    public Plane removePlane(){
        Plane departingPlane = currentPlane;
        currentPlane = null;
        return departingPlane;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    //getters
    public String getGateID() {
        return gateID;
    }

    public boolean getStatus() {
        return status;
    }

    public Plane getCurrentPlane() {
        return currentPlane;
    }

    public void displayInfo() {
        System.out.println("Gate ID: " + gateID);
        System.out.println("Status: " + (status ? "Open" : "Closed"));
        if (currentPlane != null) {
            System.out.println("Plane at gate: " + currentPlane.getPlaneID());
        } else {
            System.out.println("No plane currently at the gate.");
        }
    }
}
