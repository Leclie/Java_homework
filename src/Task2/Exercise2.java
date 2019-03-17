// ВЫПОЛНЕНО
/*Создайте программу, выводящую 
на экран все неотрицательные элементы 
последовательности 90 85 80 75 70 65 60 ….*/
package Task2;
public class Exercise2
{
    public static void main(String[] args)
    {
        int num = 90;
        while(num >= 0)
        {
            System.out.print(num + " ");
            num -= 5;
        }
    }
}
