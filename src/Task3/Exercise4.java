
/*Пользователь должен указать с 
клавиатуры чётное положительное число, 
а программа должна создать массив указанного 
размера из случайных целых чисел из [-5;5] и 
вывести его на экран в строку. 
После этого программа должна определить
и сообщить пользователю о том, сумма модулей 
какой половины массива больше: 
левой или правой, либо сообщить, что эти 
суммы модулей равны. Если пользователь введёт 
неподходящее число, то программа должна 
требовать повторного ввода 
до тех пор, пока не будет указано корректное значение. 
*/
package Task3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Exercise4
{
    public static void main(String[] arg)
    {
        Scanner in = new Scanner(System.in);
        Random ran = new Random();
        int n;
        do
        {
           System.out.println("Введите чётное положительное число");
           n = in.nextInt();
        }while((n%2) != 0 || n <= 0);
        
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++)
        {
            arr[i] = ran.nextInt(11) - 5;
        }
        
        System.out.println(Arrays.toString(arr));
        
        int sum1 = 0, sum2 = 0;
        
        for(int i = 0; i < (n/2); i++)
        {
            sum1 += Math.abs(arr[i]);
        }
        for(int i = (n/2); i < n; i++)
        {
            sum2 += Math.abs(arr[i]);
        }
        
        if(sum1 == sum2)
        {
            System.out.println("равны");
        }
        else if(sum1 > sum2)
        {
            System.out.println("левая часть больше");
        }
        else
        {
            System.out.println("правая часть больше");
        }
    }
}
