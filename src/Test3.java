import java.util.ArrayList;
import java.util.List;

public class Test3  {
    public static void main(String[] args) {
/*
        List<String> list = new ArrayList<>();
        list.add("dsa");
        list.add("cse");
        list.add("dd");
        list.add("cc");
        list.add("daa");


        for(int i = 0 ; i < list.size(); i++) {
            System.out.println(list.get(i));
            list.remove(i);
        }
*/

       /* for(String s : list) {
            list.remove(s);
        }*/

       int[] data = new int[]{1,2,3};
       int[] data2 =data;
       data2[0] = 9999;
        System.out.println(data[0]);

    }


}
