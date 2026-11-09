import java.util.ArrayList;

public class Node {
    private final String nodeID;
    private final Vector2 position;
    private Plane occupyingPlane;

    private final ArrayList<Node> neighbours = new ArrayList<>();

    public Node(String nodeID, Vector2 position) {
        this.nodeID = nodeID;
        this.position = position;
    }

    public void connectTo(Node otherNode) {
        if (!neighbours.contains(otherNode)) {
            neighbours.add(otherNode);
        }

        if (!otherNode.neighbours.contains(this)) {
            otherNode.neighbours.add(this);
        }
}

    public ArrayList<Node> getNeighbours() {
        return neighbours;
    }

    public Vector2 getPosition() {
        return position;
    }

    public String getNodeID() {
        return nodeID;
    }

    public boolean reserve(Plane plane) {
        if (occupyingPlane == null || occupyingPlane == plane) {
            occupyingPlane = plane;
            return true;
        }

        return false;
    }

    public void release(Plane plane) {
        if (occupyingPlane == plane) {
            occupyingPlane = null;
        }
    }
}