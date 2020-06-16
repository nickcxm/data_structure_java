//package linear_table;
//
//import lombok.Data;
//
///**
// * @author cxm E-mail:xumincheng123@gmail.com
// * @version 创建时间：2020-06-16 14:47
// */
//public class CStack<E> {
//    private Node<E> first;
//    private int N;
//
//    public void push(E e){
//        Node<E> oldFirst = this.first;
//        first=new Node<E>();
//        first.next=oldFirst;
//        first.data=e;
//        N++;
//    }
//
//    public E pop(){
//        E data = first.data;
//        first=first.next;
//        N--;
//        return data;
//    }
//
//    @Data
//    class Node<E> {
//        private Node next;
//        private E data;
//
//        public Node(Node next, E data) {
//            this.next = next;
//            this.data = data;
//        }
//    }
//}
