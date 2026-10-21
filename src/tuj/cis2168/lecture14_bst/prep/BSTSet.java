package tuj.cis2168.lecture14_bst.prep;

import java.util.Iterator;
import java.util.Objects;

import tuj.cis2168.lecture14_bst.Cis2168Set;

public class BSTSet<E extends Comparable<E>> implements Cis2168Set<E> {

  //////////////////////////////////////////////////////////
  
  private static class Node<E extends Comparable<E>> {

    E data;
    Node<E> left;
    Node<E> right;

    Node(E data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }

    public String toString() {
      String l = this.left == null ? "*" : this.left.toString();
      String r = this.right == null ? "*" : this.right.toString();
      return "(" + l + " " + this.data + " " + r + ")";
    }

  }

  //////////////////////////////////////////////////////////
  
  Node<E> root;
  int count;

  BSTSet() {
    this.root = null;
    this.count = 0;
  }

  //////////////////////////////////////////////////////////
  
  /// Adds `element` to the left subtree of `node`.
  private void addLeft(Node<E> node, E element) {
    // 1. BASE CASE: if there is no left subtree, create one
    if(node.left == null) {
      node.left = new Node<>(element);
      this.count++;
      return;
    }

    // 2. RECURSION: otherwise, descend the left subtree
    this.addToNode(node.left, element);
  }

  /// Adds `element` to the right subtree of `node`.
  private void addRight(Node<E> node, E element) {
    // 1. BASE CASE: if there is no right subtree, create one
    if(node.right == null) {
      node.right = new Node<>(element);
      this.count++;
      return;
    }

    // 2. RECURSION: otherwise, descend the right subtree
    this.addToNode(node.right, element);
  }

  /// CAUTION:  If used incorrectly, this method risks
  /// breaking the invariant.  Be careful!
  /// REQUIRES: `node != null` and `element != null`
  private void addToNode(Node<E> node, E element) {
    // 0. ensure `element` is not null
    Objects.requireNonNull(element);
    // 1. compare `element` to data in this `node`
    int compareResult = element.compareTo(node.data);
    // 2. if they are equal, do nothing, because sets have no duplicates
    if(compareResult == 0) { return; }
    // 3. otherwise, choose either left or right to maintain BST invariant
    if(compareResult < 0) {
      this.addLeft(node, element);
    } else {
      this.addRight(node, element);
    }
  }

  /// REQUIRES: `element != null`
  private boolean treeContains(Node<E> node, E element) {
    // 1. BASE CASE:  empty tree
    if(node == null) { return false; }
    // 2. compare `element` to data in this `node`
    int compareResult = element.compareTo(node.data);
    // 3. BASE CASE: `node.data` equals `element`
    if(compareResult == 0) { return true; }
    // 4. RECURSION: descend into either the left or right subtree
    if(compareResult < 0) {
      return treeContains(node.left, element);
    } else {
      return treeContains(node.right, element);
    }
  }

  /// Deletes `node` from the tree, and returns the subtree
  /// that should replace it (may or may not be `null`).
  /// REQUIRES: `node != null`
  private Node<E> deleteNode(Node<E> node) {
    // Case 1:  `node` has no children
    if(node.left == null && node.right == null) {
      // this subtree, without `node` itself, is now empty!
      this.count--;
      return null;
    }

    // Case 2a:  `node` has only a left child
    if(node.right == null) {
      this.count--;
      return node.left;
    }
    // Case 2b:  `node` has only a right child
    if(node.left == null) {
      this.count--;
      return node.right;
    }
    
    // Case 3:  `node` has two children
    // 3a. find the predecessor of `node` by exhaustively
    //     following all right links in the left subtree
    Node<E> parent = node;
    Node<E> current = node.left;
    while(current.right != null) {
      parent = current;
      current = current.right;
    }

    // 3b. preserve the data from predecessor
    E predecessor = current.data;

    // 3b. delete the predecessor from the tree
    if(parent.left == current) {
      // this will occur if the left subtree of `node` has no `.right`
      parent.left = deleteNode(current);
    } else {
      parent.right = deleteNode(current);
    }

    // 3c. replace data in `node` with `predecessor`
    node.data = predecessor;

    return node;
  }

  /// Delete `element` from the subtree starting at `node`.
  /// REQUIRES: `element != null`
  private Node<E> removeFromSubtree(Node<E> node, E element) {
    // 0. reject null `element`s
    Objects.requireNonNull(element);
    // 1. if `node` is `null`, nothing needs to be done
    if(node == null) { return null; }
    // 2. compare `element` to data in this `node`
    int compareResult = element.compareTo(node.data);
    // 3. if element belongs to the left or right subtrees, descend
    if(compareResult < 0) {
      node.left = removeFromSubtree(node.left, element);
      return node;
    } else if(compareResult > 0) {
      node.right = removeFromSubtree(node.right, element);
      return node;
    }
    // 3. if this `node` contains the element to delete
    return deleteNode(node);
  }

  //////////////////////////////////////////////////////////

  /// REQUIRES: `element != null`
  @Override
  public void add(E element) {
    // 0. ensure `element` is not null
    Objects.requireNonNull(element);

    // Case 1:  If the tree is empty, create a root.
    if(this.root == null) {
      this.root = new Node<>(element);
      this.count++;
      return;
    }

    // Case 2:  Otherwise, find the correct insertion position.
    this.addToNode(this.root, element);
  }

  /// REQUIRES: `element != null`
  @Override
  public boolean contains(E element) {
    // 0. reject null `element`s
    Objects.requireNonNull(element);
    // 1. recursively search the tree for `element`
    return this.treeContains(this.root, element);
  }

  /// REQUIRES: `element != null`
  @Override
  public boolean remove(E element) {
    // 0. reject null `element`s
    Objects.requireNonNull(element);

    // 1. remove element from tree
    int beforeCount = this.count;
    this.root = this.removeFromSubtree(this.root, element);

    // 2. to determine whether an element was actually removed
    //    by the recursive deletion functions, we have to check
    //    whether the count has decreased
    int afterCount = this.count;
    return (afterCount < beforeCount);
  }

  //////////////////////////////////////////////////////////

  @Override
  public Iterator<E> iterator() {
    // TODO: Exercise for students!
    throw new UnsupportedOperationException("Unimplemented method 'iterator'");
  }

  @Override
  public int size() {
    return this.count;
  }

  @Override
  public boolean isEmpty() {
    return this.size() == 0;
  }
  
  @Override
  public String toString() {
    return this.count + "\t" + Objects.toString(this.root);
  }
}
