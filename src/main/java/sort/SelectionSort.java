package sort;

/**
 * 选择排序
 *
 * @author cxm E-mail:xumincheng123@gmail.com
 * @version 创建时间：2020-06-16 17:45
 */
public class SelectionSort {

    public static void sort(Comparable[] list) {
        int length = list.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (list[min].compareTo(list[j]) > 0) {
                    min = j;
                }
            }
            Comparable temp = list[i];
            list[i] = list[min];
            list[min] = temp;
        }
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
