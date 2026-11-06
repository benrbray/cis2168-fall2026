package tuj.cis2168.lecture19_map;

// A collection that contains no duplicate elements.
public interface Cis2168Map<K,V> extends Iterable<K> {

  /// Updates the map to include the given `(key, value)` pair.
  /// If the map already contains this key, replaces the old value.
  /// Otherwise, inserts a new key-value pair.
  /// REQUIRES: `key != null`
  void put(K key, V value);

  /// Returns the value associated with the given `key`,
  /// or `null` if the key is not in the map.
  /// REQUIRES: `key != null`
  V get(K key);

  /// Returns `true` if this map has a value for `key`.
  /// REQUIRES: `key != null`
  boolean containsKey(K key);

  /// Removes the corresponding key and its value from the map.
  /// Returns `null` if the key is not in the map.
  /// REQUIRES: `key != null`
  V remove(K key);
  
  // The number of elements in the set.
  int size();
  
  // Returns `true` if the set has no elements.
  boolean isEmpty();
}
