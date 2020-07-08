package sort;

/**
 * 自顶向下归并排序
 * @author cxm E-mail:xumincheng123@gmail.com
 * @version 创建时间：2020-06-17 16:59
 */
public class TopDownMergeSort {
    public static void sort(Comparable[] list,int low,int high) {
        //需要进行递归
        //条件是low不能大于等于high
        if (low>=high){
            return;
        }
        int mid=low+(high-low)/2;
        sort(list,low,mid);
        sort(list,mid+1,high);
        merge(list,low,mid,high);
    }

    private static void merge(Comparable[] list,int low,int mid,int high){
        int i=low,j=mid+1;
        Comparable[] temp = new Comparable[list.length];
        for (int k = low; k <= high; k++) {
            temp[k]=list[k];
        }
        for (int k = low; k <= high; k++) {
            //左边数组已经全部用完了，把右边剩余的放进去
            if (i>mid){
                list[k]=temp[j++];
            }else if (j>high){
                //右边的用完了，把左边剩余的放进去
                list[k]=temp[i++];
            }else if (less(temp[i],temp[j])){
                //取小的那个
                list[k]=temp[i++];
            }else {
                list[k]=temp[j++];
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
