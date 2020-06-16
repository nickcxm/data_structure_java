package t1_3;

import java.util.Stack;

/**
 * 中序转为后序
 * @author cxm E-mail:xumincheng123@gmail.com
 * @version 创建时间：2020-06-16 16:25
 */
public class T1_3_10 {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<String> values = new Stack<>();
        String str="(1+((2+3)*(4*5)))";
        String[] vals = str.split("");
        for (String val:vals){
            if (val.equals("+")||val.equals("-")||val.equals("*")||val.equals("/")||val.equals("sqrt")){
                ops.push(val);
            }else if (val.equals("(")){

            }else if (val.equals(")")){
                String rightValue = values.pop();
                String leftValue = values.pop();
                values.push("("+leftValue+rightValue+ops.pop()+val);
            }else {
                values.push(val);
            }
        }
        System.out.println(values.pop());
    }
}
