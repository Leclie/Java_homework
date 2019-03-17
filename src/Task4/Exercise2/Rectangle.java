package Task4.Exercise2;
public class Rectangle
{
    private double s; // площадь
    private double p; // периметр
    
    private double x1, x2, x3, x4;
    private double y1, y2, y3, y4;
    
    private static int i = 1;

    public void set(double x, double y)
    {
        switch(i)
        {
            case 1: x1 = x; y1 = y; break;
            case 2: x2 = x; y2 = y; break;
            case 3: x3 = x; y3 = y; break;
            case 4: x4 = x; y4 = y; break;
        }
        i++;
        if(i == 4){i = 1;}
    }
    
    double calculationS()
    {
        double x = x2 - x1;
        double y = y2 - y1;
        double r1 = Math.pow(x*x+y*y, 1./2);
        
        x = x4 - x1;
        y = y4 - y1;
        double r2 = Math.pow(x*x+y*y, 1./2);
        
        return r1 * r2;
    }
    
    double calculationP()
    {
        double x = x2 - x1;
        double y = y2 - y1;
        double r1 = Math.pow(x*x+y*y, 1./2);
        
        x = x4 - x1;
        y = y4 - y1;
        double r2 = Math.pow(x*x+y*y, 1./2);
        
        return r1*2. + r2*2.;
    }
}
