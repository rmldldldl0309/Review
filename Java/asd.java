import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class asd {
    public static void main(String[] args) {
        
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[4] = 5;

        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 0, 5]
        
        List<String> list = new ArrayList<String>();
        list.add("값1");
        list.add("값2");
        list.add("값3");
        System.out.println(list.size());
        
        System.out.println(list.get(1));

        ArrayList<String> arraylist = new ArrayList<String>(5);
        arraylist.add("값1");
        arraylist.add("값2");
        arraylist.add("값3");
        
        System.out.println(arraylist.size());
    }
}
