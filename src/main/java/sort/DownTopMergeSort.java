package sort;

/**
 * 自底向上归并排序
 * @author cxm E-mail:xumincheng123@gmail.com
 * @version 创建时间：2020-06-17 16:59
 */
public class DownTopMergeSort {
    static Comparable[] temp;

    public static void sort(Comparable[] list) {
        int len = list.length;
        for (int childLen = 1; childLen < len; childLen*=2) {
            for (int index = 0; index < len -childLen; index=index+2*childLen) {
                merge(list,index,index+childLen-1,Math.min(index+2*childLen-1,len-1));
            }
        }
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
        sort(a);
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
