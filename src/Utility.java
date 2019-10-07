import java.util.ArrayList;

public class Utility {
    private int nodeCount;
    private int clusterCount;
    private ArrayList<Organization> orgs;

    public Utility(ArrayList<Organization> orgs) {
        this.orgs = orgs;
        this.nodeCount = calculateEdgeCount();
        this.clusterCount = orgs.size();
    }

    private int calculateEdgeCount() {
        int sum = 0;
        for (int i = 0; i < orgs.size(); i++) {
            sum += orgs.get(i).getNodes().size();
        }
        return sum;
    }

    public int getNodeCount() {
        return nodeCount;
    }

    public int getClusterCount() {
        return clusterCount;
    }
}
