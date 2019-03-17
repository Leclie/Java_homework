// ВЫПОЛНЕНО
/*Создайте массив из 15 случайных 
целых чисел из отрезка [0;9]. Выведите 
массив на экран.Подсчитайте сколько в 
массиве чётных элементов и выведете это 
количество на экран на отдельной строке. */
package Task3;

import java.util.Random;

public class Exercise3
{
    public static void main(String[] arg)
    {
        int[] arr = new int[15];
        int x = 0;
        Random ran = new Random();
        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = ran.nextInt(10);
        }
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
            if((arr[i]%2) == 0)
            {
                x++;
            }
        }
        System.out.println();
        System.out.println("Количество нечётных элементов = " + x);
    }
}
