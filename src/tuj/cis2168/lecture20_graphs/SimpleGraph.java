package tuj.cis2168.lecture20_graphs;

import java.util.Iterator;

/// Simplified interface for an undirected graph.
public interface SimpleGraph {
  /// Returns |V|, the number of vertices in the graph.
  int vertexCount();
  /// Returns |E|, the number of edges in the graph.
  int edgeCount();
  /// Returns an iterator to the edges that originate from a given vertex.
  Iterable<Integer> neighbors(int v1);
  /// Returns `true` if `a` and `b` are connected by an edge.
  boolean containsEdge(int v1, int v2);
  /// Add a new edge to the graph between `a` and `b`.
  void insertEdge(int v1, int v2);
}
