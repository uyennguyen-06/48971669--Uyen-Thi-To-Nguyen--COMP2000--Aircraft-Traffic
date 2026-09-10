import java.util.ArrayList;

public class Route {
    private final ArrayList<Node> nodes;

    public Route() {
        nodes = new ArrayList<>();
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public Node getNode(int index) {
        return nodes.get(index);
    }

    public int getNumberOfNodes() {
        return nodes.size();
    }
}