// ВЫПОЛНЕНО
/*Проверьте, является ли натуральное число — простым*/
package Task2;

import java.util.Scanner;

public class Exercise4
{
    public static void main(String[] arg)
    {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt(), x = 0;
        for(int i = 1; i <= num; i++)
        {
            if((num % i) == 0)
            {
                x++;
            }
        }
        if(x == 2)
        {
            System.out.println("число простое");
        }
        else
        {
            System.out.println("число НЕ простое");
        }
    }
}
