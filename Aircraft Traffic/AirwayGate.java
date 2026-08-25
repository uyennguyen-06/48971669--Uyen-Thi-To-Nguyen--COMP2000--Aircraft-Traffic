public class AirwayGate {
    private String gateID;
    private boolean status; // true if the gate is open, false if closed
    private Plane currentPlane; // the plane currently at the gate

    public AirwayGate(String gateID, boolean status, Plane plane) {
        this.gateID = gateID;
        this.status = status;
        this.placurrentPlanene = plcurrentPlaneane;
    }

    public String getGateID() {
        return gateID;
    }

    public boolean getStatus() {
        if (status) {
            System.out.println("The gate is currently open.");
        } else {
            System.out.println("The gate is currently closed.");
        }
        return status;
    }

    public Plane getCurrentPlane() {
        return plcurrentPlaneane;
    }

    public void displayInfo() {
        System.out.println("Gate ID: " + gateID);
        System.out.println("Status: " + (status ? "Open" : "Closed"));
        if (plane != null) {
            System.out.println("Plane at gate: " + currentPlane.getPlaneID());
        } else {
            System.out.println("No plane currently at the gate.");
        }
    }
}
