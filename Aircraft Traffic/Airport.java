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
        gateNode = createNode("Gate 1", 35, 580);
        gateNode2 = createNode("Gate 2", 200, 580);

        lowerPathNode = createNode("Lower Path 1", 35, 350);
        lowerPathNode2 = createNode("Lower Path 2", 200, 350);

        taxiwayNode = createNode("Taxiway 1", 35, 280);

        upperPathNode = createNode("Upper Path 1", 35, 150);

        runwayEntrance =
            createNode("Runway Entrance", 35, 70);

        runwayExit =
            createNode("Runway Exit", 790, 70);
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