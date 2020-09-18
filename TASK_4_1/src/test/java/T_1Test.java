import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class T_1Test {

    @Test
    public <T> void exchange(){
        List<Integer> arr = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        Integer arg_1 = arr.get(2);
        Integer arg_2 = arr.get(7);
        T_1.exchange(3, 8, arr);

        assertEquals(arg_1, arr.get(7));
        assertEquals(arg_2, arr.get(2));
    }

    @Test
    public <T> void exchange2(){
        List<Number> arr = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        Number arg_1 = arr.get(3);
        Number arg_2 = arr.get(8);
        T_1.exchange(4, 9, arr);

        assertEquals(arg_1, arr.get(8));
        assertEquals(arg_2, arr.get(3));
    }
}
