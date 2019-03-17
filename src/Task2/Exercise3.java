// ВЫПОЛНЕНО
/*Создайте программу, выводящую 
на экран первые 20 элементов 
последовательности 2 4 8 16 32 64 128 ….*/
package Task2;
public class Exercise3
{
    public static void main(String[] arg)
    {
        int num = 2;
        for(int i = 0; i < 20; i++)
        {
            System.out.print(num + " ");
            num *= 2;
        }
    }
}
