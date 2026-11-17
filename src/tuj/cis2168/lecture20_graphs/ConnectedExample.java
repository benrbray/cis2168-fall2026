package tuj.cis2168.lecture20_graphs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class ConnectedExample {
  public static void main() {
    SimpleGraph g = makeGraph();
    System.out.println(g);

    System.out.println(connectedBfs(g, 8, 2));
  }

  public static SimpleGraph makeGraph() {
    SimpleGraph g = new AdjListGraph(9);
    g.insertEdge(0, 1);
    g.insertEdge(0, 5);
    g.insertEdge(1, 2);
    g.insertEdge(1, 4);
    g.insertEdge(2, 3);
    g.insertEdge(3, 4);
    g.insertEdge(3, 8);
    g.insertEdge(4, 5);
    g.insertEdge(4, 7);
    g.insertEdge(5, 6);
    g.insertEdge(6, 7);
    g.insertEdge(7, 8);

    return g;
  }

  // Returns `True` if there is a path from `source` to `target` in the graph.
  public static boolean connectedDfs(SimpleGraph graph, int source, int target) {
    // 1. keep track of vertices already visited
    Set<Integer> visited = new HashSet<>();
    
    // 2. use a stack to represent the frontier (top of stack = front of deque)
    //    the frontier represents nodes we might want to visit in the future
    Deque<Integer> stack = new ArrayDeque<Integer>();
    stack.push(source);

    // 3. depth-first search
    // RUNTIME: O(V+E)
    boolean found = false;
    while(!stack.isEmpty()) {
      // 3a. get next frontier vertex
      int vertex = stack.pop();

      // 3b. skip if it has already been visited
      // (this check is necessary because )
      if(visited.contains(vertex)) { continue; }

      // 3c. visit this node
      System.out.println("visit " + vertex);
      visited.add(vertex);
      
      // 3c. if this is the vertex we're looking for, stop!
      if(vertex == target) {
        found = true;
        break;
      }

      // 3d. add all unvisited neighbors to the frontier
      for(int neighbor : graph.neighbors(vertex)) {
        if(!visited.contains(neighbor)) {
          System.out.println("push " + neighbor);
          stack.push(neighbor);
        }
      }
    }

    return found;
  }

  // Returns `True` if there is a path from `source` to `target` in the graph.
  public static boolean connectedBfs(SimpleGraph g, int source, int target) {
    // 1. keep track of vertices already visited
    Set<Integer> visited = new HashSet<>();
    
    // 2. use a queue to represent the frontier
    Deque<Integer> queue = new ArrayDeque<Integer>();
    queue.add(source);

    // 3. visit the source
    System.out.println("visit " + source);
    visited.add(source);

    // 4. breadth-first search
    boolean found = false;
    while(!queue.isEmpty()) {
      // 4a. get next frontier vertex
      int vertex = queue.remove();

      // 4b. visit all unvisited neighbors and add them frontier
      for(int neighbor : g.neighbors(vertex)) {
        if(!visited.contains(neighbor)) {
          // 4bi. visit neighbor
          System.out.println("visit " + neighbor);
          visited.add(neighbor);
      
          // 4bii. if this is the vertex we're looking for, stop!
          if(neighbor == target) {
            found = true;
            break;
          }
          
          // 4biii. add to frontier
          System.out.println("push " + neighbor);
          queue.push(neighbor);
        }
      }
    }

    return found;
  }
}
