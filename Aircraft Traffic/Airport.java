import java.util.ArrayList;

public class Airport {
    private ArrayList<Node> nodes = new ArrayList<>();
    private Runway runway;
    private Node gateNode;
    private Node gateNode2;
    private Node gateNode3;
    private Node gateNode4;
    private Node gateNode5;

    private Node taxiwayNode;
    private Node taxiwayNode2;
    private Node taxiwayNode3;

    private Node runwayNode;

    private Node lowerPathNode;
    private Node lowerPathNode2;
    private Node lowerPathNode3;

    private Route routeGate1;
    private Route routeGate2;

    private Node upperPathNode;
    private Node upperPathNode2;
    private Node upperPathNode3;
    private Node upperPathNode4;

    private Node runwayEntrance;
    private Node runwayExit;
    private Node holdingNode;
    private Route departureRoute;
    private Route arrivalRoute;
    
    private ArrayList<Plane> planes;

    public Airport() {
        planes = new ArrayList<>(); 
               
        createNodes();
        createRoutes();
        connectNodes();

        runway = new Runway ("Runway 1", 1000.0, 1, 1, null, "Available");
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    private Node createNode(String name, int x, int y) {
        Node node = new Node(name, new Vector2(x, y));
        nodes.add(node);
        return node;
    }

    private void createNodes() {
        gateNode = createNode("Gate 1", 35, 600);
        gateNode2 = createNode("Gate 2", 215, 600);
        gateNode3 = createNode("Gate 3", 405, 600);
        gateNode4 = createNode("Gate 4", 595, 600);
        gateNode5 = createNode("Gate 5", 775, 600);
        

        lowerPathNode = createNode("Lower Path 1", 35, 350);
        lowerPathNode2 = createNode("Lower Path 2", 415, 350);
        lowerPathNode3 = createNode("Lower Path 3", 775, 350);

        taxiwayNode = createNode("Taxiway 1", 35, 270);
        taxiwayNode2 = createNode("Taxiway 2", 415, 270);
        taxiwayNode3 = createNode("Taxiway 3", 775, 270);

        upperPathNode = createNode("Upper Path 1", 35, 170);
        upperPathNode2 = createNode("Upper Path 2", 275, 170);
        upperPathNode3 = createNode("Upper Path 3", 545, 170);
        upperPathNode4 = createNode("Upper Path 4", 775, 170);

        runwayEntrance = createNode("Runway Entrance", 35, 55);

        runwayExit = createNode("Runway Exit", 850, 55);
    }

    private void connectNodes(){
        gateNode.connectTo(lowerPathNode);
        lowerPathNode.connectTo(taxiwayNode);
        taxiwayNode.connectTo(upperPathNode);
        upperPathNode.connectTo(runwayEntrance);
        runwayEntrance.connectTo(runwayExit);

        gateNode2.connectTo(lowerPathNode2);
        lowerPathNode2.connectTo(taxiwayNode);
    }

    public void createRoutes() {
        routeGate1 = new Route();
        routeGate1.addNode(gateNode);
        routeGate1.addNode(lowerPathNode);
        routeGate1.addNode(taxiwayNode);
        routeGate1.addNode(upperPathNode);
        routeGate1.addNode(runwayEntrance);
        routeGate1.addNode(runwayExit);

        routeGate2 = new Route();
        routeGate2.addNode(gateNode2);
        routeGate2.addNode(lowerPathNode2);
        routeGate2.addNode(taxiwayNode);
        routeGate2.addNode(upperPathNode2);
        routeGate2.addNode(runwayEntrance);
        routeGate2.addNode(runwayExit);
    }

    public Route getRouteGate1() {
        return routeGate1;
    }

    public Route getRouteGate2() {
        return routeGate2;
    }

    public Route getDepartureRoute() {
        return departureRoute;
    }

    public Route getArrivalRoute() {
        return arrivalRoute;
    }

    public void addPlane(Plane plane) {
        planes.add(plane);
    }

    public ArrayList<Plane> getPlanes() {
        return planes;
    }

    public Runway getRunway() {
    return runway;
}

    public Node getRunwayEntrance() {
        return runwayEntrance;
    }

    public Node getRunwayExit() {
        return runwayExit;
    }
}