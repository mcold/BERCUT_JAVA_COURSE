/*
 * Создать 10 случайных фигур Circle, Triangle, Rectangle со случайными параметрами – радиусом, длиной стороны.
 * Все фигуры имплементируют интерфейс Shape с одним методом getPerimeter():double, возвращающим периметр (или длину окружности)
 * Найти и вывести информацию о фигуре с максимальным/минимальным периметром
 */

public class TASK_29 {

    public static void main(String[] args) {
        int rdm = 0;
        Shape sh;
        Shape max = null;
        for(int i = 0; i < 10; i++){
            rdm = (int)(Math.random()*3);
            switch(rdm){
                case 1: 
                    sh = new Circle((int)(Math.random()*100));
                    break;
                case 2:
                    sh = new Triangle((int)(Math.random()*100));
                    break;
                default:
                    sh = new Rectangle((int)(Math.random()*100));
            }
            if(i == 0){
                max = sh;
            }else{
                if(max.getPerimeter() < sh.getPerimeter()){
                    max = sh;
                }
            }
        }
        System.out.println(max);
    }
    
}

class Circle implements Shape{
    private int radius = 0;
    private double perimeter = 0;
    
    public Circle(int radius){
        this.radius = radius;
    }
    
    @Override
    public double getPerimeter(){
        this.perimeter = 2*Math.PI*this.radius;
        return this.perimeter;
    }
    
    @Override
    public String toString(){
        return "Type: circle radius: " + this.radius + " perimeter: " + this.perimeter;
    }
}

class Triangle implements Shape{
    private int side = 0;
    private double perimeter = 0;
    
    public Triangle(int side){
        this.side = side;
    }
    
    @Override
    public double getPerimeter(){
        this.perimeter = 3*this.side;
        return this.perimeter;
    }
    
    @Override
    public String toString(){
        return "Type: triangle side: " + this.side + " perimeter: " + this.perimeter;
    }
}


class Rectangle implements Shape{
    private int side = 0;
    private double perimeter = 0;
    
    public Rectangle(int side){
        this.side = side;
    }
    
    @Override
    public double getPerimeter(){
        this.perimeter = 4 * this.side;
        return this.perimeter;
    }
    
    @Override
    public String toString(){
        return "Type: rectangle side: " + this.side + " perimeter: " + this.perimeter;
    }
}

interface Shape{
    double getPerimeter();
    
}
