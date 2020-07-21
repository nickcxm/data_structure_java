package search_table;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 递归二叉查找树
 * @param <Key>
 * @param <Value>
 */
@Data
public class BinaryTreeSearchTable<Key extends Comparable<Key>,Value> implements SearchTable<Key,Value> {
    public static void main(String[] args) {
        BinaryTreeSearchTable<Integer, String> searchTable = new BinaryTreeSearchTable<>();
        searchTable.put(5,"hi5");
        searchTable.put(4,"hi4");
        searchTable.put(1,"hi1");
        searchTable.put(3,"hi3");
        searchTable.put(2,"hi2");
        searchTable.put(2,"hi22");
        searchTable.print();
    }

    private Node root;

    public void print(){
        midPrint(root);
    }

    private void midPrint(Node node){
        if (node==null){
            return;
        }
        midPrint(node.left);
        System.out.print(" "+node.key+" ");
        midPrint(node.right);
    }

    @Data
    @AllArgsConstructor
    private class Node{
        Key key;
        Value value;
        Node left;
        Node right;
        int N;
    }

    private Key floor(Key key){
        Node node = floor(root, key);
        if (node==null){
            return null;
        }
        return node.key;
    }

    /**
     * 找出某节点下，小于等于key的值
     * @param rootNode
     * @param key
     * @return
     */
    private Node floor(Node rootNode,Key key){
        if (rootNode==null){
            return null;
        }
        int cmp = rootNode.key.compareTo(key);
        if (cmp==0){
            return rootNode;
        }else if (cmp>0){
            return floor(rootNode.getLeft(),key);
        }else if (cmp<0){
            Node node = floor(rootNode.getRight(), key);
            if (node==null){
                return null;
            }
            return node;
        }
        return rootNode;
    }

    public Key min(){
        return min(root.getLeft());
    }

    /**
     * 获取某个node下面最小的键
     * @param rootNode
     * @return
     */
    private Key min(Node rootNode){
        if (rootNode.getLeft()==null){
            return rootNode.key;
        }
        return min(rootNode.getLeft());
    }

    private int size(Node node){
        if (node==null){
            return 0;
        }
        return node.N;
    }

    @Override
    public void put(Key key, Value value) {
        root=put(root,key,value);
    }

    private Node put(Node rootNode,Key key,Value value){
        if (rootNode==null){
            return new Node(key,value,null,null,1);
        }
        int cmp = rootNode.getKey().compareTo(key);
        if (cmp==0){
            rootNode.setValue(value);
        }else if (cmp>0){
            rootNode.setLeft(put(rootNode.getLeft(),key,value));
        }else if (cmp<0){
            rootNode.setRight(put(rootNode.getRight(),key,value));
        }
        rootNode.N=size(rootNode.getLeft())+size(rootNode.getRight())+1;
        return rootNode;
    }

    @Override
    public Value get(Key key) {
        return get(root,key);
    }

    /**
     * 获取某个节点下面键为key的值
     * @param rootNode
     * @param key
     * @return
     */
    private Value get(Node rootNode,Key key){
        if (rootNode==null){
            return null;
        }
        if (rootNode.getKey().compareTo(key)==0){
            return rootNode.getValue();
        }else if (rootNode.getKey().compareTo(key)>0){
            //key比该节点要小，应该在左子树里面查找
            return get(rootNode.getLeft(),key);
        }else {
            //key比该节点要大，应该在右子树里面查找
            return get(rootNode.getRight(),key);
        }
    }

    @Override
    public void delete(Key key) {

    }

    @Override
    public boolean contains(Key key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return size(root);
    }

    @Override
    public Iterable<Key> keys() {
        return null;
    }
}
