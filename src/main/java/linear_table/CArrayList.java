package linear_table;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author cxm E-mail:xumincheng123@gmail.com
 * @version 创建时间：2020-06-08 14:57
 */
public class CArrayList<E> implements Iterable<E>{
    private Object[] elements;

    private static Object[] EMPTY_LIST = {};

    private static Object[] DEFAULT_EMPTY_LIST = {};

    private static final int DEFAULT_TABLE_LENGTH = 10;

    private static final int MAX_TABLE_LENGTH = Integer.MAX_VALUE - 8;

    private int size = 0;

    public CArrayList(Collection<? extends E> list) {
        this.elements = list.toArray();
        if ((size = elements.length) != 0) {
            //toArray 有时候不能返回Object[]
            if (elements.getClass() != Object[].class) {
                this.elements = Arrays.copyOf(elements, size, Object[].class);
            }
        } else {
            this.elements = EMPTY_LIST;
        }
    }

    public CArrayList() {
        this.elements = DEFAULT_EMPTY_LIST;
    }

    public CArrayList(int capacity) {
        if (capacity>0){
            this.elements = new Object[capacity];
        }else if (capacity==0){
            this.elements=EMPTY_LIST;
        }else {
            throw new IllegalArgumentException("CArrayList 默认长度需要大于0");
        }
    }

    /**
     * 指定位置设置值
     * @param index
     * @param e
     * @return
     */
    public boolean set(int index,E e){
        checkSize(index);
        elements[index]=e;
        return true;
    }

    /**
     * 批量添加
     * @param list
     * @return
     */
    public boolean addAll(CArrayList<?extends E> list){
        if (size+list.size()>=elements.length){
            checkAndGrow(size+list.size());
        }
        System.arraycopy(list.elements,0,elements,size,list.size());
        size+=list.size();
        return true;
    }

    /**
     * 检查是否包含某个元素
     * @param e
     * @return
     */
    public boolean contains(Object e){
        return indexOf(e)!=-1;
    }

    /**
     * 检查某个元素在数组中的位置
     * @param e
     * @return
     */
    public int indexOf(Object e){
        if (e==null){
            for (int i = 0; i < size; i++) {
                if (elements[i]==null){
                    return i;
                }
            }
        }else{
            for (int i = 0; i < size; i++) {
                if (e.equals(elements[i])){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 返回长度
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 移除第一个元素,并返回
     * @return
     */
    public E removeFirst(){
        checkSize(0);
        return remove(0);
    }

    /**
     * 指定位置插入
     * @param index
     * @param e
     * @return
     */
    public boolean add(int index,E e){
        if (size>=elements.length){
            checkAndGrow(size+1);
        }
        System.arraycopy(elements,index,elements,index+1,size-index);
        elements[index]=e;
        size++;
        return true;
    }

    /**
     * 移除指定位置的元素并返回
     * @param index
     * @return
     */
    public E remove(int index){
        checkSize(index);
        E removedValue = this.get(index);
        int needMove = elements.length-index-1;
        if (needMove>0){
            System.arraycopy(elements,index+1,elements,index,needMove);
        }
        elements[--size]=null;
        return removedValue;
    }

    /**
     * 添加
     *
     * @param element
     * @return
     */
    public boolean add(E element) {
        if (size >= elements.length) {
            this.checkAndGrow(size+1);
        }
        elements[size++]=element;
        return true;
    }

    /**
     * 获取指定位置的元素
     * @param index
     * @return
     */
    public E get(int index){
        checkSize(index);
        return elements(index);
    }


    /**
     * 获取第一个
     *
     * @return
     */
    public E getFirst() {
        checkSize(0);
        return elements(0);
    }

    /**
     * 获取最后一个
     *
     * @return
     */
    public E getLast() {
        checkSize(size - 1);
        return elements(size - 1);
    }

    /**
     * 检查index是否越界
     *
     * @param index
     */
    private void checkSize(int index) {
        if (index >= size) {
            throw new IllegalArgumentException("CArrayList 越界");
        }
    }

    /**
     * 检查并扩容
     * @param minLength
     */
    private void checkAndGrow(int minLength){
        if (elements==DEFAULT_EMPTY_LIST){
            minLength=Math.max(minLength,DEFAULT_TABLE_LENGTH);
        }
        this.grow(minLength);
    }

    /**
     * 扩容
     * @param minLength
     */
    private void grow(int minLength) {
        int oldLength = elements.length;
        int newLength = oldLength + (oldLength >> 1);
        if (newLength - minLength < 0) {
            newLength = minLength;
        }
        if (newLength>MAX_TABLE_LENGTH){
            newLength=MAX_TABLE_LENGTH;
        }
        elements=Arrays.copyOf(elements,newLength);
    }

    /**
     * 获取数组index位置的元素,并转型
     *
     * @param index
     * @return
     */
    E elements(int index) {
        return (E) elements[index];
    }

    public Iterator<E> iterator() {
        return new Itr<E>();
    }

    class Itr<E> implements Iterator<E> {
        int cur;

        @Override
        public boolean hasNext() {
            return cur != size;
        }

        @Override
        public E next() {
            return (E) elements[cur++];
        }
    }
}
