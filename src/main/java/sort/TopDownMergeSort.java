package sort;

/**
 * 自顶向下归并排序
 * @author cxm E-mail:xumincheng123@gmail.com
 * @version 创建时间：2020-06-17 16:59
 */
public class TopDownMergeSort {
    public static void sort(Comparable[] list,int low,int high) {
        if (low>=high){
            return;
        }
        int mid=low+(high-low)/2;
        sort(list,low,mid);
        sort(list,mid+1,high);
        merge(list,low,mid,high);
    }

    private static void merge(Comparable[] list,int low,int mid,int high){
        int len = list.length;
        int left=low,right=mid+1;
        Comparable[] temp = new Comparable[len];
        for (int i = low; i <= high; i++) {
            temp[i]=list[i];
        }
        for (int i = low; i <= high; i++) {
            if (left>mid){
                list[i]=temp[right++];
            }else if (right>high){
                list[i]=temp[left++];
            }else if (less(temp[left],temp[right])){
                list[i]=temp[left++];
            }else {
                list[i]=temp[right++];
            }
        }
    }

    public static void print(Comparable[] a){
        for (Comparable i:a){
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        Integer[] a = {3, 1, 4, 5, 3, 8, 9, 10, 2};
        sort(a,0,a.length-1);
        print(a);
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
