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
	if(i > anArray.length || j > anArray.length || i < 0 || j < 0){return false;}
        int temp = anArray[i-1];
        anArray[i-1] = anArray[j-1];
        anArray[j-1] = temp;
        return true;
        }
}
