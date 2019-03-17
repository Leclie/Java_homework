// ВЫПОЛНЕНО
/*Найти в строке указанную подстроку и заменить ее на новую. 
Строку, ее подстроку для замены и новую подстроку вводит пользователь.*/
package Task3;

import java.util.Scanner;

public class String1
{
    public static void main(String[] main)
    {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Введи строку");
        String str = in.next();
        
        System.out.println("Введи подстроку для замены");
        String str2 = in.next();
        
        System.out.println("Введи новую строку");
        String str3 = in.next();
        
        System.out.println(str.replaceAll(str2, str3));
        
    }
}
