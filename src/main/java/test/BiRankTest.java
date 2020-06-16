package test;

/**
 * @author cxm E-mail:xumincheng123@gmail.com
 * @version 创建时间：2020-06-15 13:52
 */
public class BiRankTest {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6,7,8,9,122};
        System.out.println(rank(6,a,0,a.length-1));
    }

    public static int rank(int key,int[] a,int low,int high){
        if (low>high){
            return -1;
        }
        int mid=low+(high-low)/2;
        if (a[mid]>key){
            return rank(key,a,low,mid-1);
        }else if (a[mid]<key){
            return rank(key,a,mid+1,high);
        }
        return mid;
    }
}
