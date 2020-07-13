package search_table;

import java.util.Arrays;

public class BinarySearchTable<Key extends Comparable<Key>,Value> implements SearchTable<Key,Value> {
    Key[] keys;
    Value[] values;
    private int N;

    public BinarySearchTable(int capacity) {
        keys=(Key[])new Comparable[capacity];
        values=(Value[])new Comparable[capacity];
    }

    private int rank(Key key){
        return rank(key,0,N-1);
    }

    /**
     * 迭代二分查找
     * @param key
     * @return
     */
    private int rankV2(Key key){
        int low=0,high=N-1;
        while (low<=high){
            int mid=low+(high-low)/2;
            int cmp=key.compareTo(keys[mid]);
            if (cmp<0){
                high=mid-1;
            }else if (cmp<0){
                low=mid+1;
            }else {
                return mid;
            }
        }
        return low;
    }

    /**
     * 递归二分查找
     * @param key
     * @param low
     * @param high
     * @return
     */
    private int rank(Key key,int low,int high){
        if (low>high){
            return low;
        }
        int mid=low+(high-low)/2;
        int cmp=key.compareTo(keys[mid]);
        if (cmp<0){
            return rank(key,low,mid-1);
        }else if (cmp>0){
            return rank(key,mid+1,high);
        }else {
            return mid;
        }
    }

    @Override
    public void put(Key key, Value value) {
        int index = rank(key);
        if (index<N&&keys[index].compareTo(key)==0){
            values[index]=value;
            return;
        }
        for (int i = N; i>index; i--) {
            keys[i]=keys[i-1];
            values[i]=values[i-1];
        }
        keys[index]=key;
        values[index]=value;
        N++;
    }

    @Override
    public Value get(Key key) {
        int index = rank(key);
        if (index<N&&keys[index].compareTo(key)==0){
            return values[index];
        }
        return null;
    }

    @Override
    public void delete(Key key) {

    }

    @Override
    public boolean contains(Key key) {
        return rank(key)>0;
    }

    @Override
    public boolean isEmpty() {
        return N==0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterable<Key> keys() {
        return null;
    }
}
