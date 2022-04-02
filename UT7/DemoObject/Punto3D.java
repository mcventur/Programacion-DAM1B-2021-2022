
/**
 *    
 */
public class Punto3D extends Punto implements Imprimible
{

    private int z;

    /**
     * Constructor  
     */
    public Punto3D(int x, int y, int z)    {
        super(x, y);
        this.z = z;
    }

    
    public int getZ()    {
        return z;
    }

    
    public String toString()    {
        return super.toString() + " ," + z;  
    }

    
    public boolean equals(Object obj)    {       
        if (super.equals(obj))    {
            Punto3D p3d = (Punto3D) obj;
            return this.z == p3d.getZ();
        }
        return false;
        //         return super.equals(obj) && this.z == ((Punto3D) obj).getZ();
    }

   
    public int hashCode()    {
        return super.hashCode() + z;
    }

    
    public int compareTo(Punto p)    {

        if(p instanceof Punto3D)     {
            int r = super.compareTo(p);
            if (r == 0)            {
                // r = this.z - ((Punto3D) p).getZ();
                r = Integer.compare(this.z, ((Punto3D) p).getZ());
            }
            return r;
        } 
        else         {
            return super.compareTo(p);
        }

    }

   
    public void print()   {
        System.out.println(this.toString());
    }

}
