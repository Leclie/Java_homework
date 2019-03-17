
package Task4.Exercise2;

public class Circle
{
    private double s; // площадь
    private double p; // периметр
    
    private double rx, ry; // координаты точки на дуге окружности
    private double cx, cy; // координаты центра окружности

    public void setR(double x, double y)
    {
        rx = x;
        ry = y;
    }
    
    public void setC(double x, double y)
    {
        cx = x;
        cy = y;
    }
    
    double calculationS()
    {
        double x = rx - cx;
        double y = ry - cy;
        double r = Math.pow((x*x + y*y), (1./2));
        return (3.14 * r * r);
    }
    
    double calculationP()
    {
        double x = rx - cx;
        double y = ry - cy;
        double r = Math.pow((x*x + y*y), (1./2));
        return (2 * 3.14 * r);
    }
}
