package tuj.cis2168.lab09_graph;

import java.util.Iterator;

public class MatrixGraph implements DirectedWeightedGraph {
  
  /// constant representing missing edge in weight matrix
  public static final double NO_EDGE = Double.POSITIVE_INFINITY;

  private double[][] matrix;

  //////////////////////////////////////////////////////////
  
  public MatrixGraph(int numVertices) {
    // TODO: Implement me!
    throw new UnsupportedOperationException("Unimplemented constructor 'MatrixGraph'");
  }

  //////////////////////////////////////////////////////////

  @Override
  public int vertexCount() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'vertexCount'");
  }

  @Override
  public int edgeCount() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'edgeCount'");
  }

  @Override
  public Iterator<Edge> edgeIterator(int source) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'edgeIterator'");
  }

  @Override
  public Edge getEdge(int source, int target) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getEdge'");
  }

  @Override
  public boolean containsEdge(int source, int target) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'containsEdge'");
  }

  @Override
  public void insertEdge(int source, int target, double weight) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'insertEdge'");
  }

  @Override
  public void removeEdge(int source, int target) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'removeEdge'");
  }

  @Override
  public int degreeOut(int vertex) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'degreeOut'");
  }

  @Override
  public int degreeIn(int vertex) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'degreeIn'");
  }
  
}
