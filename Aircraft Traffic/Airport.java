import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Airport {
    private ArrayList<Node> nodes = new ArrayList<>();
    private Runway runway;

    //Gate nodes
    private Node gateNode;
    private Node gateNode2;
    private Node gateNode3;
    private Node gateNode4;
    private Node gateNode5;

    //Taxiway nodes
    private Node taxiwayNode;
    private Node taxiwayNode2;
    private Node taxiwayNode3;

    private Node runwayNode;

    //Lower path nodes
    private Node lowerPathNode;
    private Node lowerPathNode2;
    private Node lowerPathNode3;

    //Upper path nodes
    private Node upperPathNode;
    private Node upperPathNode2;
    private Node upperPathNode3;
    private Node upperPathNode4;

    private Node runwayEntrance;
    private Node runwayExit;
    //private Node holdingNode;

    private Route departureRoute;
    private Route arrivalRoute;
    private Route routeGate1;
    private Route routeGate2;

    private ArrayList<Plane> planes;

    public Airport() {
        planes = new ArrayList<>(); 
               
        createNodes();
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

    public Route findRoute(Node startingNode, Node destinationNode) {
        Queue<Node> nodesToCheck = new ArrayDeque<>();
         Map<Node, Node> previousNode = new HashMap<>();

        nodesToCheck.add(startingNode);
        previousNode.put(startingNode, null);

        while (!nodesToCheck.isEmpty()) {
            Node currentNode = nodesToCheck.remove();

            // Destination has been found
            if (currentNode == destinationNode) {
                break;
            }

            // Examine every connected node
            for (Node neighbour : currentNode.getNeighbours()) {
                // If this node has not been checked before
                if (!previousNode.containsKey(neighbour)) {
                    previousNode.put(neighbour, currentNode);
                    nodesToCheck.add(neighbour);
                }
            }
        }

        // BFS could not reach the destination
        if (!previousNode.containsKey(destinationNode)) {
            System.out.println(
                "No route found from "
                + startingNode.getNodeID()
                + " to "
                + destinationNode.getNodeID()
            );

            return null;
        }

        // Rebuild the path by working backwards
        ArrayList<Node> path = new ArrayList<>();

        Node currentNode = destinationNode;

        while (currentNode != null) {
            path.add(currentNode);
            currentNode = previousNode.get(currentNode);
        }

        // It is currently destination → starting node,
        // so reverse it
        Collections.reverse(path);

        Route route = new Route();

        for (Node node : path) {
            route.addNode(node);
        }

        return route;
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
        gateNode2.connectTo(lowerPathNode);
        gateNode3.connectTo(lowerPathNode2);
        gateNode4.connectTo(lowerPathNode3);
        gateNode5.connectTo(lowerPathNode3);

        // Lower paths to taxiway
        lowerPathNode.connectTo(taxiwayNode);
        lowerPathNode2.connectTo(taxiwayNode2);
        lowerPathNode3.connectTo(taxiwayNode3);

        // Taxiway is connected across the airport
        taxiwayNode.connectTo(taxiwayNode2);
        taxiwayNode2.connectTo(taxiwayNode3);

        // Taxiway to upper paths
        taxiwayNode.connectTo(upperPathNode);
        taxiwayNode.connectTo(upperPathNode2);

        taxiwayNode2.connectTo(upperPathNode2);
        taxiwayNode2.connectTo(upperPathNode3);

        taxiwayNode3.connectTo(upperPathNode3);
        taxiwayNode3.connectTo(upperPathNode4);

        // Upper paths to runway
        upperPathNode.connectTo(runwayEntrance);
        upperPathNode2.connectTo(runwayEntrance);
        upperPathNode3.connectTo(runwayExit);
        upperPathNode4.connectTo(runwayExit);

        // Runway movement in both directions
        runwayEntrance.connectTo(runwayExit);
    }

    public Node getGateNode1() {
    return gateNode;
    }

    public Node getGateNode2() {
        return gateNode2;
    }

    public Node getGateNode3() {
        return gateNode3;
    }

    public Node getGateNode4() {
        return gateNode4;
    }

    public Node getGateNode5() {
        return gateNode5;
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