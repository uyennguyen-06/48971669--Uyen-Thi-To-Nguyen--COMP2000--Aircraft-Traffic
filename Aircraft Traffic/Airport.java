import java.util.ArrayList;

public class Airport {
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

    private void createNodes() {
        gateNode = new Node("Gate 1", new Vector2(35, 580));
        gateNode2 = new Node("Gate 2", new Vector2(200, 580));
        gateNode3 = new Node("Gate 3", new Vector2(390, 580));
        gateNode4 = new Node("Gate 4", new Vector2(580, 580));
        gateNode5 = new Node("Gate 5", new Vector2(760, 580));

        lowerPathNode = new Node("Lower Path", new Vector2(35, 350));
        lowerPathNode2 = new Node("Lower Path 2", new Vector2(200, 350));
        lowerPathNode3 = new Node("Lower Path 3", new Vector2(390, 350)); 

        taxiwayNode = new Node("Taxiway 1", new Vector2(35, 280));
        runwayNode = new Node("Runway 1", new Vector2(35, 90));
        runwayEntrance = new Node("Runway Entrance", new Vector2(35, 52));
        runwayExit = new Node("Runway Exit", new Vector2(850, 52));
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
        routeGate2.addNode(runwayExit);
        routeGate2.addNode(runwayEntrance);
        routeGate2.addNode(upperPathNode4);
        routeGate2.addNode(taxiwayNode);
        routeGate2.addNode(lowerPathNode3);
        routeGate2.addNode(gateNode5);
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