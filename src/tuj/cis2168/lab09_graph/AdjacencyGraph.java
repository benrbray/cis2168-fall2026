package tuj.cis2168.lab09_graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class AdjacencyGraph implements DirectedWeightedGraph {

  // An array of lists.  The array contains `List<Edge>` per vertex,
  // each list containing all the outgoing edges from that vertex.
  private List<Edge>[] edges;

  //////////////////////////////////////////////////////////
  
  AdjacencyGraph(int numVertices) {
    // initialize adjacency lists
    @SuppressWarnings("unchecked")
    var edges = (List<Edge>[]) new List[numVertices];
    for(int i = 0; i < edges.length; i++) {
      edges[i] = new LinkedList<>();
    }
    this.edges = edges;
  }

  @Override
  public String toString() {
    String result = "";
    for(int v = 0; v < this.edges.length; v++) {
      result += v + " --> ";
      for(Edge e : this.edges[v]) {
        result += e.target + " ";
      }
      result += "\n";
    }
    return result;
  }

  //////////////////////////////////////////////////////////

  @Override
  public int vertexCount() {
    return this.edges.length;
  }

  @Override
  public int edgeCount() {
    int count = 0;
    for(List<Edge> vertexEdges : this.edges) {
      count += vertexEdges.size();
    }
    return count;
  }

  @Override
  public Iterator<Edge> edgeIterator(int source) {
    return this.edges[source].iterator();
  }

  @Override
  public Edge getEdge(int source, int target) {
    // 1. check all edges for matching source and target
    for(Edge edge : this.edges[source]) {
      if(edge.source == source && edge.target == target) {
        return edge;
      }
    }
    // 2. `null` represents missing edge
    return null;
  }

  @Override
  public boolean containsEdge(int source, int target) {
    return this.getEdge(source, target) == null;
  }

  @Override
  public void insertEdge(int source, int target, double weight) {
    // 1. use a list iterator to search for an edge between `source` and `target`
    ListIterator<Edge> it = this.edges[source].listIterator();
    Edge newEdge = new Edge(source, target, weight);

    while(it.hasNext()) {
      Edge edge = it.next();

      // 1a. if the edge already exists, replace it 
      if(edge.target == target) {
        it.remove();
        break;
      }
    }

    // 2. otherwise, add the edge for the first time
    it.add(newEdge);
  }

  @Override
  public void removeEdge(int source, int target) {
    ListIterator<Edge> it = this.edges[source].listIterator();
    while(it.hasNext()) {
      Edge edge = it.next();

      // 1a. if the edge already exists, replace it 
      if(edge.target == target) {
        it.remove();
        break;
      }
    }
  }

  @Override
  public int degreeOut(int vertex) {
    // TODO: Exercise for students!
    throw new UnsupportedOperationException("Unimplemented method 'degreeOut'");
  }

  @Override
  public int degreeIn(int vertex) {
    // TODO: Exercise for students!
    throw new UnsupportedOperationException("Unimplemented method 'degreeIn'");
  }
  
}
