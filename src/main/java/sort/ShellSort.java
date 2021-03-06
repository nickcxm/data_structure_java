package sort;

import edu.princeton.cs.algs4.StdDraw;

/**
 * 希尔排序
 * @author cxm E-mail:xumincheng123@gmail.com
 * @version 创建时间：2020-06-16 19:16
 */
public class ShellSort {
    public static void main(String[] args) {
//        Integer[] a = {3, 1, 4, 5, 3, 8, 9, 10, 2};
        Integer[] a = {9,8,7,6,5,4,3,2,1};
        sort(a);
        print(a);
    }

    public static void print(Comparable[] a){
        for (Comparable i:a){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void sort(Comparable[] list) {
        int len = list.length, h = 1;
        while (h < len / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = 0; i < list.length; i++) {
                for (int j = i; j >= h && less(list[j], list[j - h]); j -= h) {
                    exch(list, j, j - h);
                }
            }
            h /= 3;
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
