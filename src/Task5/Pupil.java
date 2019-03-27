package Task5;
public class Pupil
{
    private final int id;
    private ExamResult[] res;
    
    public Pupil(int id)
    {
        this.id = id;
        res = new ExamResult[5];
    }
    
    public void setExams(String[] ex, int[] marks)
    {
        for(int i = 0; i < ex.length; ++i)
        {
            res[i] = new ExamResult(ex[i], marks[i]);
        }
    }

    @Override
    public String toString()
    {
        String result = "";
        for(int i = 0; res[i] != null; i++)
        {
            result = result + res[i].getSub() + " " + res[i].getStatus() + "\n";
        }
        
        return "Студент: " + id + "\n" + result;
    }
    
    
    
    public class ExamResult
    {
        private String sub;
        private int mark;
        private String status;

        public String getSub()
        {
            return sub;
        }

        public String getStatus()
        {
            return status;
        }
        
        public ExamResult(String ex, int marks)
        {
            this.sub = ex;
            this.mark = marks;
            if(marks > 2) { status = "сдал"; }
            else { status = "не сдал"; }
        }
    }
}
