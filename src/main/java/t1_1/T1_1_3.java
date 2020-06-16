package t1_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author cxm E-mail:xumincheng123@gmail.com
 * @version 创建时间：2020-06-15 14:24
 */
public class T1_1_3 {
    public static void main(String[] args) {
//        if (args[0].equals(args[1])&&args[0].equals(args[2])){
//            System.out.println(true);
//            return;
//        }
//        System.out.println(false);
        String s="";
        for (int i = 99; i >0; i/=2) {
            s=(i%2)+s;
        }
        System.out.println(s);
    }
}
