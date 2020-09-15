public class TASK_2 {

    public static void main(String[] args) {
        System.out.println(min(0, 8, 11));
    }
    
    static public int min(int a, int b, int c){
        int min = 0;
        if(a < b){
            if(a < c){
                min = a;
            }else{
                min = c;
            }
        }else{
            if(b < c){
                min = b;
            }else{
                min = c;
            }
        }
        return min;
    }
    
}
