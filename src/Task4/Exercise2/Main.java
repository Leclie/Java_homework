package Task4.Exercise2;
public class Main
{
    public static void main(String[] args)
    {
        Circle c = new Circle();
        
        c.setR(5.45, 61.3);
        c.setC(5.45, 61.3);
        
        System.out.println("Периметр круга = " + c.calculationP());
        System.out.println("Площадь круга = " + c.calculationS());
        
        Rectangle r = new Rectangle();
        
        r.set(0, 0);
        r.set(0, 2);
        r.set(3, 2);
        r.set(3, 0);
        
        System.out.println("Периметр прямоугольника = " + r.calculationP());
        System.out.println("Площадь прямоугольника = " + r.calculationS());
    }
}
