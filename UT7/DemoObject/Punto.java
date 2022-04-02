
/**
 *  
 *   
 */
public class Punto  implements Comparable<Punto>
{

    private int x;
    private int y;

    /**
     * Constructor  
     */
    public Punto(int x, int y)
    {
        this.x = x;
        this.y = y;

    }

    
    public int getX()    {
        return x;
    }

   
    public int getY()    {
        return y;
    }

    
    public void setX(int x)    {
        this.x = x;
    }

   
    public void setY(int y)    {
        this.y = y;
    }

   
    public int compareTo(Punto p)    {
        // int rx = this.x - p.getX();
        int rx = Integer.compare(this.x, p.getX());
        if (rx == 0)   {
            // int ry = this.y - p.getY();
            // return ry;
            return Integer.compare(this.y, p.getY());
        }
        return rx;
    }

    
    public  String toString()    {
        Class c = this.getClass();
        return c.getSimpleName() + ":" + x + "," + y;
    }

   
    public boolean equals(Object obj)    {
        if (obj == null)  {
            return false;
        }
        if (this == obj)  {
            return true;
        }        
        if (this.getClass() != obj.getClass())   {
            return false;
        }
        Punto p = (Punto) obj;    
        return x == p.getX() && y == p.getY();

    }

    
    public int hashCode()
    {
        return x + y;
    }

}
