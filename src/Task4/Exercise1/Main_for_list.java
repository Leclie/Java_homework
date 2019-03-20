// Реализация списка
package Task4.Exercise1;

public class Main_for_list
{
    public static void main(String[] args)
    {
        List arr = new List(0);
        arr.addElement(1);
        arr.addElement(2);
        arr.addElement(3);
        arr.addElement(4);
        arr.addElement(5);
        arr.addElement(6);
        arr.addElement(7);
        
        
        List arr2 = new List(10);
        
        arr.add(5, arr2);
        
        List arr3 = new List(20);
        boolean f = arr.offer(arr3);
        
        arr.out();
    }
}
