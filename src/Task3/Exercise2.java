// ВЫПОЛНЕНО
/*Создайте массив из всех нечётных чисел от 1 до 99,
выведите его на экран в строку, 
а затем этот же массив выведите на экран тоже в строку, 
но в обратном порядке (99 97 95 93 … 7 5 3 1). */
package Task3;

import java.util.Arrays;

public class Exercise2
{
    public static void main(String[] arg)
    {
        int[] arr = new int[50];
        int j = 0;
        for(int i = 1; i <= 99; i += 2)
        {
            arr[j] = i;
            j++;
        }
        System.out.println(Arrays.toString(arr));
        for(int i = arr.length - 1; i >= 0; i--)
        {
            System.out.print(arr[i] + " ");
        }
    }
}
