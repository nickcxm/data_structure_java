package sort;

/**
 * 插入排序
 * @author cxm E-mail:xumincheng123@gmail.com
 * @version 创建时间：2020-06-16 19:16
 */
public class InsertSort {
    public static void main(String[] args) {
        Integer[] a = {3, 1, 4, 5, 3, 8, 9, 10, 2};
        sort(a);
        System.out.println();
    }

    public static void sort(Comparable[] list){
        int length = list.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j>0&&less(list[j],list[j-1]); j--) {
                exch(list,j,j-1);
            }
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
}
