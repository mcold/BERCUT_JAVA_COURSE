import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T_1 {
    /**
     * Напишите обобщенный метод для перестановки двух элементов в списке по индексам
     * @param args
     */

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        exchange(3, 8, arr);

        for(int i = 0; i < arr.size(); i++){
            System.out.println(arr.get(i));
        }

    }
    static public <T> void exchange(int i, int j, List<T> src){
        if(i > src.size() || j > src.size() || i < 1 || j < 1){
            return;
        }
        T temp = src.get(i-1);
        src.set(i-1, src.get(j-1));
        src.set(j-1, temp);
    }

}
