package Task4.Exercise1;
public class List implements ListInterface, StackInterface, QueueInterface
{
    private int data;             // числовые данные
    private List first;           // первый элемент
    private List next;            // следующий элемент
    
    
    List(){}
    List(int data)
    {
        first = new List();       // создание первого элемента
        first.data = data;        // заполнение первого элемента
        this.data = data;
        next = null;
    }
    
    
    @Override
    public void add(int index, List o)
    {
        List end = first;
        int i = 0;
        while(i < (index - 1))
        {
            end = end.next;
            i++;
        }
        List a = o;
        while(o.next != null)
            {
                o = o.next;
            }
        o.next = end.next;
        end.next = a;
    }
    
    
    @Override
    public void addElement(int data)
    {
        List end = first;         // установка указателя на начало списка
        
            while(end.next != null) // цикл переводящий указатель на последний элемент
            {
                end = end.next;
            }
        
        
        end.next = new List();    // создание нового 
        end = end.next;           // переход на следующий элемент
        end.data = data;          // инициализация данных нового объекта
    }
    
    @Override
    public boolean offer(List obj)
    {
        if(first != null)
        {
            List end = first;         // установка указателя на начало списка
        
            while(end.next != null) // цикл переводящий указатель на последний элемент
            {
                end = end.next;
            }
            end.next = obj;      // инициализация данных нового объекта
            return true;
        }
        else
        {
            return false;
        }
    }
    
    void remove()
    {
        List end = first;         // на начало списка
        
        if(end.next == null){System.out.println("В списке всего одно значение"); return;}
        
        while(end.next.next != null)  // переход к предпоследнему элементу
        {
            end = end.next;     // удаление ссылки на последний элемент
        }
        end.next = null;
    }
    
    @Override
    public void deleteElement(int index)       // удаление по индексу
    {
        List end = first;        // на начало списка
        
        for(int i = 0; i < (index - 1); i++)  // переход к элементу, который находится перед указанным элементом
        {
            if(end.next == null){System.out.println("такого элемента в списке нет!"); return;}
            else{end = end.next;}
        }
        end.next = end.next.next;  // перепрыгивание через элемент
    }
    
    @Override
    public int readTop()
    {
        List end = first;         // на начало списка
        
        while(end.next != null)  // переход к последнему элементу
        {
            end = end.next;     // удаление ссылки на последний элемент
        }
        
        return end.data;
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
