
/*Вводится строка, содержащая буквы,
целые неотрицательные числа и иные символы. 
Требуется все числа, которые встречаются в
строке, поместить в отдельный целочисленный массив. 
Например, если дана строка "дом 48, корпус 9,
парадная 7, этаж 4", то в массиве должны 
оказаться числа 48, 9, 7 и 4*/
package Task3;

import java.util.Scanner;

public class String3
{
    public static void main(String[] arg)
    {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        
        char[] arrstr = str.toCharArray();
        
        char[] arrnum = new char[255];
        int j = 0;
        
        for(int i = 0; i < arrstr.length; i++)
        {
            if((int)arrstr[i]>47 && (int)arrstr[i]<58)
            {
                arrnum[j] = arrstr[i];
                j++;
            }
            else
            {
                arrnum[j] = ' ';
                j++;
            }
        }
        
        for(int i = 0; i < j; i++)
        {
            if(arrnum[i] == arrnum[i+1] && arrnum[i] == ' ') {}
            else
            {
                System.out.print(arrnum[i]);
            }
        }
    }
}
