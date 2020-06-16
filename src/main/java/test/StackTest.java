package test;

import java.util.Stack;

/**
 * @author cxm E-mail:xumincheng123@gmail.com
 * @version 创建时间：2020-06-16 13:59
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> values = new Stack<>();
        String str="(1+((2+3)*(4*5)))";
        String[] vals = str.split("");
        for (String val:vals){
            if (val.equals("(")){
                continue;
            }else if (val.equals("+")||val.equals("-")||val.equals("*")||val.equals("/")||val.equals("sqrt")){
                ops.push(val);
            }else if (val.equals(")")){
                String op=ops.pop();
                double v=values.pop();
                if (op.equals("+")){
                    v=values.pop()+v;
                }else if (op.equals("-")){
                    v=values.pop()-v;
                }else if (op.equals("*")){
                    v=values.pop()*v;
                }else if (op.equals("/")){
                    v=values.pop()/v;
                }else if (op.equals("sqrt")){
                    v=Math.sqrt(v);
                }
                values.push(v);
            }else {
                values.push(Double.parseDouble(val));
            }
        }
        System.out.println(values.pop());
    }
}
