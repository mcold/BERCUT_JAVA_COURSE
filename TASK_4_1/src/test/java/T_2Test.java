import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T_2Test {

    @Test
    public <T> void find_min_arr(){
        List<Number> arr = new ArrayList<>(Arrays.asList(0, 11, 2, 5, 15, 1, 6, 7, 8, 9));

        Integer min = T_2.find_min_arr(2,6, arr);
        assertEquals(min.intValue(), 2);


        Integer min2 = T_2.find_min_arr(1,9, arr);
        assertEquals(min2.intValue(), 0);

        // проверяем на выход за диапазон
        Integer min3 = T_2.find_min_arr(-1,9, arr);
        assertNull(min3);


    }
}
