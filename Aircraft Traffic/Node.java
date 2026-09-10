public class Node {
    private final String nodeID;
    private final Vector2 position;
    private Plane occupyingPlane;

    public Node(String nodeID, Vector2 position) {
        this.nodeID = nodeID;
        this.position = position;
        this.occupyingPlane = null;
    }

    public boolean isAvailable() {
        return occupyingPlane == null;
    }

    public boolean reserve(Plane plane) {
        if (isAvailable()) {
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

    public Vector2 getPosition() {
        return position;
    }

    public String getNodeID() {
        return nodeID;
    }
}