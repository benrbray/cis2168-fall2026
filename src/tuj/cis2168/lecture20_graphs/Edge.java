package tuj.cis2168.lecture20_graphs;

/// Immutable class representing an Edge in a graph.
public class Edge {
  public final int source;
  public final int target;
  public final double weight;

  public Edge(int source, int target, double weight) {
    this.source = source;
    this.target = target;
    this.weight = weight;
  }
}
