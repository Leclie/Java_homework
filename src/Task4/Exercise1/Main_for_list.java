// Реализация списка
package Task4.Exercise1;

public class Main_for_list
{
    public static void main(String[] args)
    {
        List arr = new List(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(5);
        arr.add(5);
        
        
        arr.remove();
        arr.remove(3);
        
        arr.out();
    }
}
