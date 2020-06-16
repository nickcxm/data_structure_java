import com.google.common.collect.Lists;
import linear_table.CArrayList;
import linear_table.COneDirectLinkList;
import model.Student;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<Student> list = Lists.newArrayList();

        for (int i = 0; i < 11; i++) {
            list.add(new Student(i,"nick:"+i));
        }

        COneDirectLinkList<Student> linkList = new COneDirectLinkList<>();
        linkList.addAll(0,list);

        linkList.remove(2);
        linkList.remove(0);
        linkList.remove(9);
        System.out.println();
    }
}
