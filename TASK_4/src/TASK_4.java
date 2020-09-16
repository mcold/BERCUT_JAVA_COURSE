/*
 * Напишите обобщенный метод для перестановки двух элементов в списке по индексам. Напишите junit-тесты.
 */

public class TASK_4 {

    public static void main(String[] args) {
        Spaceship[] outArray = {new Spaceship("Elizabeth", 100),
                                new Spaceship("Andrew", 200),
                                new Spaceship("Броненосец Потемкин", 300),
                                new Spaceship("Челюскин", 400),
                                new Spaceship("Andersen", 500),
                                new Spaceship("Академик Павлов", 600),
                                new Spaceship("Ледокол Ванюшкин", 700),
                                new Spaceship("Saint-Andrews", 800),
                                new Spaceship("Петр I", 900)};
        swap(5, 9, outArray);
        for(int k=0; k < outArray.length; System.out.println(outArray[k++]));
    }
    
    
    public static void swap(int i, int j, Object[] arr){
        if(i > arr.length || j > arr.length || i < 0 || j < 0){
            System.out.println("Index out of bound");
            return;
        }
        
        Object temp = arr[i-1];
        arr[i-1] = arr[j-1];
        arr[j-1] = temp;
    }
}
