public class TASK_2 {

    public static void main(String[] args) {
        System.out.println(min(0, 8, 11));
    }
    
    static public int min(int a, int b, int c){
	return (a < b) ?((a < c) ? a : c) : ((b < c) ? b : c);    
    }
    
}
