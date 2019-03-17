// ВЫПОЛНЕНО
/*В три переменные a, b и c явно записаны 
программистом три целых попарно неравных между собой числа.
Создать программу, которая переставит числа в переменных 
таким образом, чтобы при выводе на экран последовательность 
a, b и c оказалась строго возрастающей.*/
package Task2;
public class Exercise1
{
    public static void main(String[] args)
    {
        int a = 7, b = 0, c = -5;
        if(a > b)
        {
            if(c > b)
            {
                if(a > c)
                {
                    System.out.print(b + " " + c + " " + a);
                }
                else
                {
                    System.out.print(b + " " + a + " " + c);
                }
            }
            else
            {
                System.out.print(c + " " + b + " " + a);
            }
        }
        else
        {
            if(c > a)
            {
                if(b > c)
                {
                    System.out.print(a + " " + c + " " + b);
                }
                else
                {
                    System.out.print(a + " " + b + " " + c);
                }
            }
            else
            {
                System.out.print(c + " " + a + " " + b);
            }
        }
    }
}
