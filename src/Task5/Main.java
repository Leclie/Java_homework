package Task5;
public class Main
{
    public static void main(String[] args)
    {
        String ex[] = {"Математика","Биология"}; 
        int marks[] = { 2, 5 };
        Pupil p = new Pupil(1234);
        p.setExams(ex, marks);
        System.out.println(p);
    }
}
