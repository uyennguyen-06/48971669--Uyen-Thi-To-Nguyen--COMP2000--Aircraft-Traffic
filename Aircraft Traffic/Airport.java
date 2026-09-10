import java.util.ArrayList;

public class Airport {
    private Node gateNode;
    private Node taxiwayNode;
    private Node runwayNode;
    private Node lowerPathNode;
    private Node upperPathNode;
    private Node runwayEntrance;
    private Node runwayExit;
    private Route departureRoute;
    private Route arrivalRoute;
    private final ArrayList<Plane> planes = new ArrayList<>();

    public Airport() {
        gateNode = new Node("Gate 1", new Vector2(35, 580));
        /*gateNode = new Node("Gate 2", new Vector2(200, 580));
        gateNode = new Node("Gate 3", new Vector2(390, 580));
        gateNode = new Node("Gate 4", new Vector2(580, 580));
        gateNode = new Node("Gate 5", new Vector2(760, 580));*/

        taxiwayNode = new Node("Taxiway 1", new Vector2(35, 280));

        lowerPathNode = new Node("Lower Path", new Vector2(35, 350));

        runwayNode = new Node("Runway 1", new Vector2(35, 90));

        upperPathNode = new Node("Upper Path", new Vector2(35, 150));

        runwayEntrance = new Node("Runway Entrance", new Vector2(35, 52));

        runwayExit = new Node("Runway Exit", new Vector2(850, 52));

        departureRoute = new Route();
        departureRoute.addNode(gateNode);
        departureRoute.addNode(lowerPathNode);
        departureRoute.addNode(taxiwayNode);
        departureRoute.addNode(upperPathNode);
        departureRoute.addNode(runwayEntrance);
        departureRoute.addNode(runwayExit);

        /*arrivalRoute = new Route();
        arrivalRoute.addNode(runwayExit);
        arrivalRoute.addNode(runwayEntrance);
        arrivalRoute.addNode(upperPathNode);
        arrivalRoute.addNode(taxiwayNode);
        arrivalRoute.addNode(lowerPathNode);
        arrivalRoute.addNode(gateNode);*/
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
}