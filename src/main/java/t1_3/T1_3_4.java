package t1_3;

import java.util.Stack;

/**
 * @author cxm E-mail:xumincheng123@gmail.com
 * @version 创建时间：2020-06-16 15:20
 */
public class T1_3_4 {
    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        String testStr="[(])";
        String[] strs = testStr.split("");
        boolean isFull=false;
        for (String str:strs){
            if (str.equals("[")||str.equals("(")||str.equals("{")){
                stringStack.push(str);
            }else {
                String otherStr = stringStack.pop();
                if (str.equals("]")){
                    if (!otherStr.equals("[")){
                        break;
                    }
                }
                if (str.equals("}")){
                    if (!otherStr.equals("{")){
                        break;
                    }
                }
                if (str.equals(")")){
                    if (!otherStr.equals("(")){
                        break;
                    }
                }
            }
        }
        if (stringStack.isEmpty()){
            isFull=true;
        }
        System.out.println(isFull);

    }
}
