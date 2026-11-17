package tuj.cis2168.lecture20_graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class AdjListGraph implements SimpleGraph {

  // An array of lists.  The array contains `List<Integer>` per vertex,
  // each list containing all the outgoing edges from that vertex.
  private List<Integer>[] neighbors;

  //////////////////////////////////////////////////////////
  
  AdjListGraph(int numVertices) {
    // initialize adjacency lists
    @SuppressWarnings("unchecked")
    var neighbors = (List<Integer>[]) new List[numVertices];
    for(int i = 0; i < neighbors.length; i++) {
      neighbors[i] = new LinkedList<>();
    }
    this.neighbors = neighbors;
  }

  //////////////////////////////////////////////////////////

  @Override
  public String toString() {
    String result = "";
    for(int v = 0; v < this.neighbors.length; v++) {
      result += v + " --> ";
      for(int neighbor : this.neighbors[v]) {
        result += neighbor + " ";
      }
      result += "\n";
    }
    return result;
  }

  @Override
  public int vertexCount() {
    return this.neighbors.length;
  }

  @Override
  public int edgeCount() {
    int count = 0;

    for(int a = 0; a < this.neighbors.length; a++){
      count += this.neighbors[a].size();
    }

    // every undirected edge is counted twice in the adjacency list
    return count / 2;
  }

  @Override
  public boolean containsEdge(int v1, int v2) {
    // 0. no self-loops
    if(v1 == v2) { return false; }
    // 1. only need to check for edge v1 -> v2
    return this.neighbors[v1].contains(v2);
  }

  @Override
  public void insertEdge(int v1, int v2) {
    // 0. no self-loops
    if(v1 == v2) { throw new UnsupportedOperationException("Self-loops forbidden!"); }
    // 1. check for existing edge
    if(this.containsEdge(v1, v2)) { return; }
    // 2a. insert edge from v1 -> v2
    this.neighbors[v1].add(v2);
    // 2b. insert edge from v2 -> v1
    this.neighbors[v2].add(v1);
  }

  //////////////////////////////////////////////////////////

  @Override
  public Iterable<Integer> neighbors(int v1) {
    // create a single-use iterable
    return () -> this.neighbors[v1].iterator();
  }
  
}