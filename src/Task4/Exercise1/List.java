package Task4.Exercise1;
public class List
{
    public int data;             // числовые данные
    private static List first = new List();    // первый элемент. static, потому что для всего списка один
    private List next;            // следующий элемент
    
    
    void add(int data)
    {
        List end = first;         // установка указателя на начало списка
        
        while(end.next != null)
        {
            end = end.next;
        }
        
        end.next = new List();    // создание нового 
        
        end.data = data;          // инициализация данных нового объекта
        System.out.println("Ввел" + data);
    }
    
    void remove()
    {
        List end = first;         // на начало списка
        
        while(end.next.next != null)  // переход к предпоследнему элементу
        {
            end = end.next;     // удаление ссылки на последний элемент
        }
        end.next = null;
    }
    
    void remove(int index)       // удаление по индексу
    {
        List end = first;        // на начало списка
        
        for(int i = 0; i < (index - 2); i++)
        {
            end = end.next;
        }
        end.next = end.next.next;
    }
    
    void out()
    {
        List end = first;
        while(end.next != null)
        {
            System.out.print(end.data + " ");
            end = end.next;
        }
    }
    
}
