package t1_3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 约瑟夫环
 * @author cxm E-mail:xumincheng123@gmail.com
 * @version 创建时间：2020-06-16 16:48
 */
public class T1_3_37 {
    public static void main(String[] args) {
        josephus(7,2);
    }

    private static void josephus(int n,int length){
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < length-1; j++) {
                queue.add(queue.poll());
            }
            System.out.println(queue.poll());
        }
        return;
    }
}
