package sort;

import lombok.Data;

@Data
public class HeapSort {

    public static void main(String[] args) {
        Integer[] a = {0,3, 1, 4, 5, 3, 8, 9, 10, 2};
        sort(a);
        print(a);
    }

    public static void print(Comparable[] a){
        for (Comparable i:a){
            System.out.print(i+" ");
        }
    }

    public static void sort(Comparable[] list){
        int N=list.length-1;
        for (int k=N/2;k>=1;k--){
            sink(list,k,N);
        }
        while (N>1){
            exch(list,1,N--);
            sink(list,1,N);
        }


    }

    /**
     * 小的元素下沉
     * @param k
     */
    private static void sink(Comparable[] list, int k,int len){
        while (2*k< len){
            int j=2*k;
            //找两个子节点大的那个,这样++后的j才有可能比k大
            if (j<len&&less(j,j+1)){
                j++;
            }
            //如果大的都比k小,那就不用下沉了
            if (!less(list[k],list[j])) break;
            //大的比k大,j和k交换
            exch(list,k,j);
            //k变成了j
            k=j;
        }
    }

    public static boolean less(Comparable i,Comparable j){
        return i.compareTo(j)<0;
    }

    public static void exch(Comparable[] list,int i,int j){
        Comparable temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}
