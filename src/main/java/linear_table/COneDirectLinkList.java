package linear_table;

import lombok.Data;

import java.util.Collection;

/**
 * 反向链表
 * @author cxm E-mail:xumincheng123@gmail.com
 * @version 创建时间：2020-06-10 17:11
 */
public class COneDirectLinkList<E> {

    Node<E> first;

    int size=0;

    @Data
    class Node<E> {
        private Node next;
        private E data;

        public Node(Node next, E data) {
            this.next = next;
            this.data = data;
        }
    }

    public boolean addAll(int index, Collection<E> c){
        checkPositionIndex(index);
        Object[] lists = c.toArray();
        Node<E> pre;
        if (index==size){
            pre=node(size);
        }else {
            pre=node(index);
        }
        for (Object obj:lists){
            E e=(E)obj;
            Node<E> node = new Node<>(null, e);
            if (first==null){
                first=node;
            }else {
                pre.next=node;
            }
            pre=node;
        }
        size+=c.size();
        return true;
    }

    Node<E> node(int index){
        Node<E> node = this.first;
        for (int i = 0; i < index; i++) {
            node=node.next;
        }
        return node;
    }

    private void checkPositionIndex(int index){
        if (!isPositionIndex(index)){
            throw new IndexOutOfBoundsException(index+"越界了");
        }
    }

    private boolean isPositionIndex(int index){
        return index>=0&&index<=size;
    }

    public E get(int index){
        checkPositionIndex(index);
        return node(index).getData();
    }

    public Node<E> nodeBefore(int index){
        checkPositionIndex(index);
        if (index==0){
            return null;
        }else {
            return node(index-1);
        }
    }

    public boolean remove(int index){
        checkPositionIndex(index);
        Node<E> pre = nodeBefore(index);
        if (pre==null){
            if (first.next!=null){
                first=first.next;
                size--;
                return true;
            }
            return false;
        }
        if (pre.next!=null){
            pre.next=pre.next.next;
            size--;
        }
        return false;
    }
}
