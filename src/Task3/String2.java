// ВЫПОЛНЕНО
/*Требуется удалить из нее повторяющиеся символы и все пробелы. 
Например, если было введено "abc cde def", то должно быть выведено "abcdef".*/
package Task3;

import java.util.Scanner;

public class String2
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        
        char[] arrstr = str.toCharArray(); 
        
        for(int i = 0; i < arrstr.length; i++)
        {
            for(int j = i + 1; j < arrstr.length; j++)
            {
                if(arrstr[i] == arrstr[j])
                {
                    arrstr[j] = (char)' ';
                }
            }
        }
        String str2 = new String(arrstr);
        System.out.println(str2.replaceAll(" ", ""));
    }
}