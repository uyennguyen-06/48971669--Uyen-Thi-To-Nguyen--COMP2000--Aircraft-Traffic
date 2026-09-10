public abstract class Plane {
    private final String planeID;
    private String model;
    private double planeSpeed;
    private String status; 
    private final double emptyWeight;
    private final int capacity;
    private Moveable planePosition = new Moveable();
    
    private Vector2 position;
    private Route route;
    private int currentRouteIndex = 0;
    private Node currentNode;
    private Node targetNode;

    public Plane(String planeID, String model, double planeSpeed, String status, double emptyWeight,  int capacity){
        this.planeID = planeID;
        setModel(model);
        setPlaneSpeed(planeSpeed);
        this.status = "GOUNDED"; // Default status of plane
        this.emptyWeight = emptyWeight;
        this.capacity = capacity;
    }

    //setters
    public void setModel(String model){
        this.model = model;
    }

    public void setPlaneSpeed(double planeSpeed){
        this.planeSpeed = planeSpeed;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setTarget(Vector2 newPos) {
        this.planePosition.setTarget(newPos);
    }

    public void changeTarget() {
        this.planePosition.changeTarget();
    }

    public void moveTowards(int speed) {
        planePosition.moveTowards(speed);
    }

    public Moveable getLocation() {
        return planePosition;
    }

    public boolean getReachedTarget() {
        return planePosition.getReachedTarget();
    }

    public void setReachedTarget(boolean value) {
        planePosition.setReachedTarget(value);
    }
    
    //getters
    public String getPlaneID(){
        return planeID;
    }

    public String getModel(){
        return model;
    }

    public double getPlaneSpeed(){
        return planeSpeed;
    }

    public String getStatus(){
        if(status.equals("GOUNDED")){
            System.out.println("Status: " + planeID + " is grounded.");
        } else if (status.equals("BOARDING")){
            System.out.println("Status: " + planeID + " is boarding.");
        } else if (status.equals("IN-FLIGHT")){
            System.out.println("Status: " + planeID + " is in-flight.");
        }
        return status;
    }

    public int getCapacity(){
        return capacity;
    }

    public double getEmptyWeight(){
        return emptyWeight;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void displayInfo(){
        System.out.println("Plane ID: " + getPlaneID());
        System.out.println("Model: " + getModel());
        System.out.println("Capacity: " + getCapacity());
        System.out.println("Destination: " + getPlaneSpeed());
        System.out.println(getStatus());
    }

    public boolean prepareNextMovement() {
    if (currentRouteIndex + 1 >= route.getNumberOfNodes()) {
        return false;
    }

    Node nextNode = route.getNode(currentRouteIndex + 1);

    if (nextNode.reserve(this)) {
        targetNode = nextNode;
        return true;
    }
        return false;
    }

    public void setRoute(Route route) {
        this.route = route;
        this.currentRouteIndex = 0;

        this.currentNode = route.getNode(0);
        this.position = currentNode.getPosition();
        this.targetNode = null;

        currentNode.reserve(this);
    }

    public void moveTowardsTarget() {
    Vector2 targetPosition = targetNode.getPosition();

    double differenceX =
        targetPosition.getXPos() - position.getXPos();

    double differenceY =
        targetPosition.getYPos() - position.getYPos();

    double distance = Math.sqrt(
        differenceX * differenceX
        + differenceY * differenceY
    );

    double movementSpeed = 4.0;

    if (distance <= movementSpeed) {
        // Snap exactly onto the node
        position = new Vector2(
            targetPosition.getXPos(),
            targetPosition.getYPos()
        );

        arriveAtTarget();
    } else {
        // Move a small distance toward the node
        double newX =
            position.getXPos()
            + differenceX / distance * movementSpeed;

        double newY =
            position.getYPos()
            + differenceY / distance * movementSpeed;

        position = new Vector2(
        (int) Math.round(newX),
        (int) Math.round(newY));
    }
    }

    private void arriveAtTarget() {
    if (currentNode != null) {
        currentNode.release(this);
    }

    currentNode = targetNode;
    currentRouteIndex++;
    targetNode = null;
}
    
    public void updateMovement(Runway runway, Node runwayEntranceNode, Node runwayExitNode) {
        if (route == null) {
        System.out.println(getPlaneID() + ": route is null");
        return;
    }

    if (targetNode == null) {
        int nextIndex = currentRouteIndex + 1;

        if (nextIndex >= route.getNumberOfNodes()) {
            System.out.println(
                getPlaneID()
                + ": route finished at index "
                + currentRouteIndex
            );
            return;
        }

        Node nextNode = route.getNode(nextIndex);

        if (nextNode == runwayEntranceNode) {
            boolean accepted = attemptRunwayEntry(runway);

            if (!accepted) {
                return; // Stay at the previous node and wait
            }
        }

        if (!nextNode.reserve(this)) {
            return;
        }
        targetNode = nextNode;
    }

    moveTowardsTarget();

    if (currentNode == runwayExitNode) {
        runway.exitRunway(this);
    }
}


    public boolean attemptRunwayEntry(Runway runway) {
    try {
            runway.requestEntry(this);
            return true;
    } catch (RunwayOccupiedException exception) {
            setStatus("WAITING");
            return false;
        }
    }
   
}
