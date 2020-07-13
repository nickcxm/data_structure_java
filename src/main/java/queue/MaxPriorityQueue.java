package queue;

public interface MaxPriorityQueue<Key extends Comparable<Key>> {
    void insert(Key a);
    Key max();
    Key delMax();
    boolean isEmpty();
    int size();
}
