package search_table;

public class BinarySearchTest {
    public static void main(String[] args) {
        BinarySearchTest searchTest = new BinarySearchTest();
        int[] list = {1,2,3,4,5,6,7,8,9};
        for (int i = 1; i < 10; i++) {
//            System.out.println(i+" "+searchTest.rank(list,i,0,list.length));
            System.out.println(i+" "+searchTest.rank(list,i));
        }
        System.out.println(10+" "+searchTest.rank(list,10));
    }

    /**
     * 迭代二分
     * @param list
     * @param key
     * @return
     */
    public int rank(int[] list,int key){
        int low=0,high=list.length-1;
        while (low<=high){
            int mid=low+(high-low)/2;
            if (key>list[mid]){
                low=mid+1;
            }else if (key<list[mid]){
                high=mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 递归二分
     * @param key
     * @return
     */
    public int rank(int[] list,int key,int low,int high){
        if (high<low){
            return -1;
        }
        int mid=low+(high-low)/2;
        if (key>list[mid]){
            low=mid+1;
        }else if (key<list[mid]){
            high=mid-1;
        }else {
            return mid;
        }
        return rank(list,key,low,high);
    }
}
