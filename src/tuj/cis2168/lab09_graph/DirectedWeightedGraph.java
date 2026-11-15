package tuj.cis2168.lab09_graph;

import java.util.Iterator;

/// A weighted, directed graph.
/// - Vertices are represented as integers, starting from zero.
/// - Edges are represented with the `Edge` class.
public interface DirectedWeightedGraph {
  /// Returns |V|, the number of vertices in the graph.
  int vertexCount();
  /// Returns |E|, the number of edges in the graph.
  int edgeCount();
  /// Returns an iterator to the edges that originate from a given vertex.
  Iterator<Edge> edgeIterator(int source);
  /// Returns the `Edge` between two vertices, if it exists.  Otherwise, `null`.
  Edge getEdge(int source, int target);
  /// Returns `true` if `source` and `target` are connected by an edge.
  boolean containsEdge(int source, int target);
  /// Add a new edge to the graph.
  void insertEdge(int source, int target, double weight);
  /// Remove an edge from the graph.
  void removeEdge(int source, int target);

  /// Number of outgoing edges from this vertex.
  int degreeOut(int vertex);
  /// Number of incoming edges from this vertex.
  int degreeIn(int vertex);

  /// Add a new edge to the graph, with `weight = 1.0`.
  default void insertEdge(int source, int target) {
    this.insertEdge(source, target, 1.0);
  }
}
