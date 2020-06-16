package t1_1;

/**
 * @author cxm E-mail:xumincheng123@gmail.com
 * @version 创建时间：2020-06-15 14:47
 */
public class T1_1_13 {
    public static void main(String[] args) {
        int[][] ints = {{1,2,3,4,5},{6,7,8,9,10}};
        reverse(ints);
    }

    public static void reverse(int[][] a){
        int rows = a.length;
        int columns = a[0].length;
        int[][] res = new int[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                res[j][i]=a[i][j];
            }
        }
        System.out.println();
    }
}
