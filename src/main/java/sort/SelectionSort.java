package sort;

/**
 * 选择排序
 *
 * @author cxm E-mail:xumincheng123@gmail.com
 * @version 创建时间：2020-06-16 17:45
 */
public class SelectionSort {

    public static void sort(Comparable[] list) {
        for (int i = 0; i < list.length; i++) {
            int min=i;
            for (int j = i; j < list.length; j++) {
                if (less(list[j],list[min])){
                    min=j;
                }
            }
            exch(list,i,min);
        }
    }

    public static boolean less(Comparable a,Comparable b){
        return a.compareTo(b)<0;
    }

    public static void exch(Comparable[] list,int i,int j){
        Comparable temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    public static void print(Comparable[] a){
        for (Comparable i:a){
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        Integer[] a = {3, 1, 4, 5, 3, 8, 9, 10, 2};
        sort(a);
        print(a);
    }
}
