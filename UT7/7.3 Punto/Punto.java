
/**
 *  Modela un punto del espacio bidimensional
 *   
 */
public class Punto implements Comparable<Punto>
{

    private int x;
    private int y;

    /**
     * Constructor  
     */
    public Punto(int x, int y)   {
        this.x = x;
        this.y = y;

    }

    /**
     *  
     */
    public int getX()   {
        return x;
    }

    /**
     *   
     */
    public int getY()   {
        return y;
    }

    /**
     *  
     */
    public void setX(int x)   {
        this.x = x;
    }

    /**
     *  
     */
    public void setY(int y)   {
        this.y = y;
    }

    /**
     * 
     */
    public  String toString()    {
        Class c = this.getClass();
        return c.getSimpleName() + ":" + x + "," + y;
    }

   
    /**
     *  
     *
     */
    public boolean equals(Object obj)    {
        if (obj == null)     {
            return false;
        }
        if (this == obj)    {
            return true;
        }        
        if (this.getClass() != obj.getClass())    {
            return false;
        }
        Punto p = (Punto) obj;    
        return x == p.getX() && y == p.getY();
    }

    /**
     *  
     */
    public int hashCode()    {
        return x + y;
    }

    /**
     * 
     */
    public int compareTo(Punto p)    {
        // if (this.x < p.getX()) {
            // return -1;
        // }
        // if (this.x > p.getX())  {
            // return 1;
        // }
        // if (this.y < p.getY())  {
            // return -1;
        // }
        // if (this.y > p.getY())  {
            // return 1;
        // }
        // return 0;
        
        
        int r = Integer.compare(this.x, p.getX());
        if (r == 0) {
            return Integer.compare(this.y, p.getY());
        }
        return r;
    }

}
