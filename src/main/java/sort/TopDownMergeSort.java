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

    private static void merge(Comparable[] a,int low,int mid,int high){
        int i=low,j=mid+1;
        Comparable[] temp=new Comparable[a.length];
        for (int k = low; k <=high; k++) {
            temp[k]=a[k];
        }
        for (int k = low; k <=high; k++) {
            if (i>mid){
                a[k]=temp[j++];
            }else if (j>high){
                a[k]=temp[i++];
            }else if (less(temp[j],temp[i])){
                a[k]=temp[j++];
            }else {
                a[k]=temp[i++];
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
