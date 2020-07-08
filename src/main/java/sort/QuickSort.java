package sort;

import lombok.Data;

@Data
public class QuickSort {
    public static void main(String[] args) {
        Integer[] a = {6, 1, 4, 5, 3, 8, 9, 10, 2};
        sort(a,0,a.length-1);
//        partition(a,0,a.length-1);
        print(a);

    }

    public static int partition(Comparable[] list,int low,int high){
        int i=low,j=high+1;
        Comparable v=list[i];
        while (true){
            while (less(list[++i],v)){
                if (i==high){
                    break;
                }
            }
            while (less(v,list[--j])){
                if (j==low){
                    break;
                }
            }
            if (i>=j){
                break;
            }
            exch(list,i,j);
        }
        exch(list,low,j);
        return j;
    }

    public static void print(Comparable[] a){
        for (Comparable i:a){
            System.out.print(i+" ");
        }
    }

    public static void sort(Comparable[] list,int low,int high){
        if (low>=high){
            return;
        }
        int j = partition(list, low, high);
        sort(list,low,j-1);
        sort(list,j+1,high);
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
