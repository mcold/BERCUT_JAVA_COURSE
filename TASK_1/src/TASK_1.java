public class TASK_1 {
    public static void main(String[] args) {
        int[] outArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        if(swap(5, 9, outArray))
        {
            for(int k=0; k < outArray.length; System.out.println(outArray[k++]));
        }else{
            System.out.println("Index out of bounds!!!");
        }
    }
    
    static boolean swap(int i, int j, int[] anArray){
        // определяем максимум
        int max, min;
        if(j < i){
            min = j-1;
            max = i;
        }else{
            max = j;
            min = i-1;
        }
        if(max > anArray.length){return false;}

        // меняем местами элементы
        int temp;
        for(int v = 0; v < (max-min)/2; v++){
            temp = anArray[min+v];
            anArray[min+v] = anArray[max-1-v];
            anArray[max-1-v] = temp;
        }
        return true;
        }
}
