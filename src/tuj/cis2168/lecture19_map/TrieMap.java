package tuj.cis2168.lecture19_map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class TrieMap<V> implements Cis2168Map<String, V> {
  
  //////////////////////////////////////////////////////////
  
  private static class Node<V> {

    // value may be null
    private V value;

    // each link in the tree represents a character
    private Map<Character, Node<V>> children;
    
    Node() {
      // use Java's HashMap
      this.children = new HashMap<>();
      this.value = null;
    }
  }
  
  
  //////////////////////////////////////////////////////////
  
  private Node<V> root;
  private int count;

  TrieMap() {
    // every trie has a root node (its value may or may not be null)
    this.root = new Node<>();
    this.count = 0;
  }

  //////////////////////////////////////////////////////////
  
  @Override
  public Iterator<String> iterator() {
    // TODO: Exercise for students!
    throw new UnsupportedOperationException("Unimplemented method 'iterator'");
  }

  //////////////////////////////////////////////////////////
  
  List<String> keysWithPrefix(String prefix) {
    // TODO: Exercise for students!
    throw new UnsupportedOperationException("Unimplemented method 'keysWithPrefix'");
  }

  //////////////////////////////////////////////////////////

  /// O(L) where L = length of key
  @Override
  public void put(String key, V value) {
    // 0. reject null keys and values
    Objects.requireNonNull(key);
    Objects.requireNonNull(value);
    // 1. starting from the root node, follow
    // a link for each character in the key
    Node<V> currentNode = this.root;

    for(char c : key.toCharArray()) {
      if(currentNode.children.containsKey(c)) {
        // 1a. this character already exists!
        currentNode = currentNode.children.get(c);
      } else {
        // 1b. the character doesn't yet exist at this
        // position in the trie, create a new node for it
        Node<V> node = new Node<>();
        currentNode.children.put(c, node);
        currentNode = node;
      }
    }

    // 2. after the loop, the path to `currentNode` is `key`
    if(currentNode.value == null) {
      // only increase the count if this key previously had no value
      this.count++;
    }
    currentNode.value = value;
  }

  /// O(L) where L = length of key
  @Override
  public V get(String key) {
        // 0. reject null keys and values
    Objects.requireNonNull(key);
    // 1. starting from the root node, follow
    // a link for each character in the key
    Node<V> currentNode = this.root;

    for(char c : key.toCharArray()) {
      if(currentNode.children.containsKey(c)) {
        // 1a. continue following links
        currentNode = currentNode.children.get(c);
      } else {
        // 1b. trie does not contain this string!
        return null;
      }
    }

    // 2. after the loop, the path to `currentNode` is `key`
    return currentNode.value;
  }

  /// O(L) where L = length of key
  @Override
  public boolean containsKey(String key) {
    return this.get(key) != null;
  }

  @Override
  public V remove(String key) {
    // TODO: Exercise for students!
    throw new UnsupportedOperationException("Unimplemented method 'remove'");
  }

  @Override
  public int size() {
    return this.count;
  }

  @Override
  public boolean isEmpty() {
    return this.size() != 0;
  }

  
}
