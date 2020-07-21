package search_table;

import lombok.Data;

@Data
public class RedBlackTree<Key extends Comparable<Key>,Value> {
    private static final boolean RED=true;
    private static final boolean BLACK=false;

    private class Node{
        Key key;
        Value value;
        Node left,right;
        int sum;
        boolean color;

        public Node(Key key, Value value, int sum, boolean color) {
            this.key = key;
            this.value = value;
            this.sum = sum;
            this.color = color;
        }
    }


}
