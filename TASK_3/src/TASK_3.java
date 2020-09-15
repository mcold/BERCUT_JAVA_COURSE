public class TASK_3 {

    public static void main(String[] args) {
//        Spaceship s1 = new Spaceship(100);
//        Spaceship s2 = new Spaceship(200);
//        Spaceship s3 = new Spaceship(300);
//        Spaceship s4 = new Spaceship(400);
        Spaceship.loadFlot(new Spaceship(Integer.MAX_VALUE)
                           ,new Spaceship(Integer.MAX_VALUE)
                           ,new Spaceship(Integer.MAX_VALUE)
                           ,new Spaceship(Integer.MAX_VALUE)
                           );
        System.out.println("Average: " + Spaceship.getAvgSpeed());
        System.out.println("Minimum: "+ Spaceship.getMinSpeed());
        
    }    
}


