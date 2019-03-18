package Task4.Exercise1;
public class List
{
    private int data;             // числовые данные
    private List first;           // первый элемент
    private List next;            // следующий элемент
    
    
    List(){}
    List(int data)
    {
        first = new List();       // создание первого элемента
        first.data = data;        // заполнение первого элемента
        System.out.println(first.data);
    }
    
    void add(int data)
    {
        List end = first;         // установка указателя на начало списка
        
            while(end.next != null) // цикл переводящий указатель на последний элемент
            {
                end = end.next;
            }
        
        
        end.next = new List();    // создание нового 
        end = end.next;           // переход на следующий элемент
        end.data = data;          // инициализация данных нового объекта
        System.out.println("Ввел" + data); // проверка
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
        
        for(int i = 0; i < (index - 1); i++)  // переход к элементу, который находится перед указанным элементом
        {
            end = end.next;
        }
        end.next = end.next.next;  // перепрыгивание через элемент
    }
    
    void out()
    {
        List end = first;
        while(end.next != null)
        {
            System.out.print(end.data + " ");
            end = end.next;
        }
        System.out.print(end.data + " ");
    }
    
}
