// ВЫПОЛНЕНО
/*Выведите на экран первые 11 
членов последовательности Фибоначчи. 
Первый и второй члены последовательности 
равны единицам, а каждый следующий — сумме 
двух предыдущих.*/
package Task2;
public class Exercise5
{
    public static void main(String[] arg)
    {
        int num1 = 1, num2 = 1;
        for(int i = 0; i <= 5; i++)
        {
            if(i != 5)
            {
                System.out.print(num1 + " " + num2 + " ");
                num1 = num1 + num2;
                num2 = num1 + num2;
            }
            else
            {
                System.out.print(num1);
            }
        }
    }
}
