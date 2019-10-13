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

    public double calculateModularity(Chromosome chromo) {
        double modularity = 1.0 / (2.0 * calculateEdgeCount());
        double aux = 0.0;

        for (int i = 0; i < orgs.size(); ++i) {
            for (int j = 0; j < orgs.size(); ++j) {
                aux += (tether(orgs.get(i), orgs.get(j)) - ((calculateDegree(i) * calculateDegree(j)) / (2.0 * calculateEdgeCount())))
                        * calculateDelta(chromo.getGenes().get(i), chromo.getGenes().get(j));
            }
        }
        modularity = modularity * aux;
        return modularity;
    }

    private int tether(Organization A, Organization B) {
            if(A.equals(B)){
                return 1;
            }

        return 0;
    }

    private int calculateDelta(int geneA, int geneB) {
        return geneA == geneB ? 1 : 0;
    }

    private int calculateDegree(int node) {
        int degree = 0;

        degree += orgs.get(node).getDeps().size(); //needs checking, probably faulty

        return degree;
    }

    public int getNodeCount() {
        return nodeCount;
    }

    public int getClusterCount() {
        return clusterCount;
    }
}
