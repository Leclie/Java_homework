package task1;
public class Task1 
{
    public static void main(String[] args) 
    {
        System.out.println("Задача 1.");
        double height = 28, length = 42, width = 15, square;
        square = 2*length*width + 2*width*height + 2*length*height;
        System.out.println("Площадь = " + square);
        if(width > height)
        {
            System.out.println("Ширина больше");
        }
        else
        {
            System.out.println("Высота больше");
        }
        //------------------------------------------------------------------
        System.out.println("\nЗадача 2.");
        int s, beds;
        s = 100*10;
        beds = 15*25;
        s = s - beds;
        System.out.println("Осталось " + s + " м^2");
        //------------------------------------------------------------------
        System.out.println("\nЗадача 3.");
        int s1 = 15, s2 = 600, s3;
        s1 *= 100;
        s3 = s1 - s2;
        System.out.println("Площадь овального кольца = " + s3 + " см^2");
        //------------------------------------------------------------------
        System.out.println("\nЗадача 4.");
        double m = 8.5, n = 11.45, mm, nn;
        mm = m - 10; Math.abs(mm);
        nn = n - 10; Math.abs(nn);
        if(mm > nn)
        {
            System.out.println("Ближайшее к десяти " + m);
        }
        else
        {
            System.out.println("Ближайшее к десяти " + n);
        }
        //------------------------------------------------------------------
        System.out.println("\nЗадача 5.");
        double a = 2, b = -5, c = 1, d, x1, x2;
        d = b*b - 4*a*c;
        if(d >= 0)
        {
            d = Math.sqrt(d);
            x1 = (-b + d)/(2*a);
            x2 = (-b - d)/(2*a);
            System.out.println(x1 + " " + x2);
        }
        else{System.out.println("Нет корней");}
        //-------------------------------------------------------------------
        System.out.println("\nЗадача 6.");
        int number = 774, max = 0;
        if(number%10 > max){max = number % 10;}
        number /= 10;
        if(number%10 > max){max = number % 10;}
        number /= 10;
        if(number%10 > max){max = number % 10;}
        System.out.println(max);
    }
    
}
