public class Spaceship {
    private int speed;
    private static Spaceship[] arrShips = new Spaceship[0];
    
    
    public Spaceship(int speed) {
        this.speed = speed;
        Spaceship[] sh = new Spaceship[arrShips.length + 1];
        for(int i = 0; i < arrShips.length; i++){
            sh[i] = arrShips[i];
        };
        sh[sh.length - 1] = this;
        arrShips = sh;
    }
    
    public static int getAvgSpeed(){
        /**
         * Средняя скорость корабля
         */
        int avg = 0;
        int surplus = 0;
        for (Spaceship arrShip : arrShips) {
            avg = avg + arrShip.speed / arrShips.length;
            surplus = surplus + arrShip.speed % arrShips.length;
        }
        return avg + surplus/arrShips.length;
    }
    
    public static int getMinSpeed(){
        /**
         * Минимальная скорость корабля
         */
        if(arrShips.length == 0){return 0;}
        int min = arrShips[0].speed;
        for(int i = 1; i < arrShips.length; i++){
            if(arrShips[i].speed >= min){
            } else {
                min = arrShips[i].speed;
            }
        }
        return min;
    }
    
    public static void loadFlot(Spaceship... shipList){
        /**
         * Загрузка флота
         */
        System.out.println("Flot loaded!");
    }
       
    public int getSpeed() {
        return speed;
    }
    public int getAvgSpeed(Spaceship sc){
        return this.speed/2 + sc.speed/2;
    }
    
    public int getMinSpeed(Spaceship sc){
        /**
         * Минимальная скорость среди 2 кораблей
         */
        if(this.speed < sc.speed){
            return this.speed;
        }else{
            return sc.speed;
        }
    }
}