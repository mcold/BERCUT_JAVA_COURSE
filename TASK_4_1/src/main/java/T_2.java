import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T_2 {

    public static void main(String[] args) {
        List<Number> arr = new ArrayList<>(Arrays.asList(0, 11, 2, 5, 15, 1, 6, 7, 8, 9));
        System.out.println(find_min_arr(2, 6, arr));
    }

    static public <T extends Integer> Integer find_min_arr(int i, int j, List<? super Integer> src){
        int temp = i;
        if(i > j) {i = j; j = temp;}
        if(i > src.size() || j > src.size() || i < 1 || j < 1){
            System.out.println("Index out of bounds!");
            return null;
        }
        T min = (T) src.get(i-1);
        T cur = null;
        for(int k = i; k < j-1; k++){
            cur = (T) src.get(k);
            if(cur.compareTo(min) < 0){
                min = cur;
            };
        }
        return min;
    }
}
