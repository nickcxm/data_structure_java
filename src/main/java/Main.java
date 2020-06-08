import linear_table.CArrayList;
import model.Student;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        CArrayList<Student> list = new CArrayList<>();
        CArrayList<Student> list1 = new CArrayList<>();

        for (int i = 0; i < 11; i++) {
            list.add(new Student(i,"nick:"+i));
            list1.add(new Student(i,"nick1111:"+i));
        }
        list.addAll(list1);
//        list.add(5,new Student(1111,"hhhhh"));
//        Student student = list.remove(5);
//        System.out.println(student.toString());

        System.out.println();
    }
}
