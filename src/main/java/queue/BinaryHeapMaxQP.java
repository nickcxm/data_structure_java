package queue;

import java.util.Arrays;

public class BinaryHeapMaxQP<E extends Comparable<E>> implements MaxPriorityQueue<E> {
    private E[] pg;
    private int size=0;

    public BinaryHeapMaxQP() {
        pg=(E[])new Comparable[10];
    }

    public BinaryHeapMaxQP(int capacity) {
        pg=(E[])new Comparable[capacity+1];
    }

    /**
     * 大的元素上浮
     * @param k
     */
    private void swim(int k){
        while (k>1&&less(k/2,k)){
            exch(k/2,k);
            k/=2;
        }
    }

    /**
     * 小的元素下沉
     * @param k
     */
    private void sink(int k){
        while (2*k<size){
            int j=2*k;
            //找两个子节点大的那个,这样++后的j才有可能比k大
            if (j<size&&less(j,j+1)){
                j++;
            }
            //如果大的都比k小,那就不用下沉了
            if (!less(k,j)) break;
            //大的比k大,j和k交换
            exch(k,j);
            //k变成了j
            k=j;
        }
    }

    @Override
    public void insert(E a) {
        pg[++size]=a;
        swim(size);
    }

    @Override
    public E max() {
        return pg[1];
    }

    @Override
    public E delMax() {
        E max = pg[1];
        exch(1,size--);
        sink(1);
        return max;
    }

    @Override
    public boolean isEmpty() {
        return size>=0;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean less(int i,int j){
        return pg[i].compareTo(pg[j])<0;
    }

    public void exch(int i,int j){
        E temp = pg[i];
        pg[i] = pg[j];
        pg[j] = temp;
    }

    public static void main(String[] args) {
        BinaryHeapMaxQP<Integer> maxQP = new BinaryHeapMaxQP<>(20);
        for (int i = 0; i < 20; i++) {
            maxQP.insert(i);
        }
        for (int i = 0; i < 20; i++) {
            System.out.println(maxQP.delMax());
        }
    }
}
