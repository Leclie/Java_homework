// ВЫПОЛНЕНО
/*В городе N проезд в трамвае 
осуществляется по бумажным отрывным 
билетам. Каждую неделю трамвайное депо 
заказывает в местной типографии рулон 
билетов с номерами от 000001 до 999999. 
«Счастливым» считается билетик у которого 
сумма первых трёх цифр номера равна сумме 
последних трёх цифр, как, например, в билетах 
с номерами 003102 или 567576. Трамвайное депо 
решило подарить сувенир обладателю каждого 
счастливого билета и теперь раздумывает, как 
много сувениров потребуется. С помощью программы 
подсчитайте сколько счастливых билетов в одном рулоне?*/
package Task2;
public class Exercise6
{
    public static void main(String[] arg)
    {
        int x, y, sum = 0;
        for(int i = 1; i <= 999999; i++)
        {
            int sumx, sumy;
            
            x = i / 1000;
            y = i % 1000;
            
            sumx = (x%10) + ((x/10)%10) + ((x/100)%10);
            sumy = (y%10) + ((y/10)%10) + ((y/100)%10);
            
            //System.out.println(x + " " + sumx);
            //System.out.println(y + " " + sumy);
            
            if(sumx == sumy)
            {
                sum++;
            }
        }
        System.out.println(sum);
    }
}