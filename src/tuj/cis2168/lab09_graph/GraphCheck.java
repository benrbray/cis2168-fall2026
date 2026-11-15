package tuj.cis2168.lab09_graph;

public class GraphCheck {
  public static void main() {
    DirectedWeightedGraph g = new AdjacencyGraph(6);
    g.insertEdge(0, 1);
    g.insertEdge(0, 3);
    g.insertEdge(1, 4);
    g.insertEdge(2, 4);
    g.insertEdge(2, 5);
    g.insertEdge(3, 1);
    g.insertEdge(4, 2);
    g.insertEdge(4, 3);

    System.out.println(g);
  }
}
