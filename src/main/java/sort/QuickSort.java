package sort;

import lombok.Data;

@Data
public class QuickSort {
    public static void main(String[] args) {
        Integer[] a = {6, 1, 4, 5, 3, 8, 9, 10, 2};
        sort(a,0,a.length-1);
        print(a);

    }

    public static int partition(Comparable[] list,int low,int high){
        int left=low,right=high+1;
        Comparable v = list[left];
        while (true){
            while (less(list[++left],v)){
                if (left==high){
                    break;
                }
            }
            while (less(v,list[--right])){
                if (right==low){
                    break;
                }
            }
            if (left>=right){
                break;
            }
            exch(list,left,right);
        }
        exch(list,low,right);
        return right;
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
        int mid=partition(list,low,high);
        sort(list,low,mid-1);
        sort(list,mid+1,high);
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
