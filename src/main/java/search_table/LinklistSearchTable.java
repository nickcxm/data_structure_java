package search_table;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 基于链表的符号表
 */
@Data
public class LinklistSearchTable<Key extends Comparable<Key>,Value> implements SearchTable<Key,Value>{

    public static void main(String[] args) {
        LinklistSearchTable<Integer, String> searchTable = new LinklistSearchTable<>();
        searchTable.put(1,"hi1");
        searchTable.put(2,"hi2");
        searchTable.put(3,"hi3");
        searchTable.put(2,"h3");

        System.out.println(searchTable.get(3));
    }

    public LinklistSearchTable() {
    }

    Node first;

    @Data
    @AllArgsConstructor
    private class Node{
        Key key;
        Value value;
        Node next;
    }

    @Override
    public void put(Key key, Value value) {
        for (Node cur=first;cur!=null;cur=cur.next){
            if (cur.key.compareTo(key)==0){
                cur.value=value;
                break;
            }
        }
        first=new Node(key, value, null);
    }

    @Override
    public Value get(Key key) {
        Node cur=first;
        while (cur!=null){
            if (cur.key.compareTo(key)==0){
                return cur.value;
            }
            cur=cur.next;
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        Node cur=first;
        Node pre=null;
        while (cur!=null){
            if (cur.key.compareTo(key)==0){
                if (pre!=null){
                    pre.next=cur.next;
                    break;
                }else {
                    first=first.next;
                    break;
                }
            }
            pre=cur;
            cur=cur.next;
        }
    }

    @Override
    public boolean contains(Key key) {
        return get(key)!=null;
    }

    @Override
    public boolean isEmpty() {
        return first==null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterable<Key> keys() {
        return null;
    }
}
