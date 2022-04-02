import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.Collections;   

/**
 *   
 */
public  class Coche implements  Cloneable, Comparable<Coche>
{
    private int velocidad;

    /**
     * 
     */
    public  Coche(int velocidad)    {
        this.velocidad = velocidad;
    }

    /**
     * 
     */
    public  int getVelocidad()   {
        return velocidad;
    }

    /**
     * 
     */
    public  void setVelocidad(int velocidad)    {
        this.velocidad = velocidad;

    }

    /**
     * redefinición de clone  
     */
    public  Coche clone() throws CloneNotSupportedException {
        Coche c = (Coche) super.clone();  
        return c;
    }

    /**
     * 
     */
    public int compareTo(Coche otro)    {
        
        return Integer.compare(this.velocidad, otro.getVelocidad());
    }

    /**
     * 
     */
    public  String toString()    {
        return this.getClass().getName() + "\nVelocidad: " + velocidad;
    }

    public  static void main(String[] args)    {
        Set<Coche> conjunto = new TreeSet<>();
        conjunto.add(new Coche(200));
        conjunto.add(new Coche(200));
        conjunto.add(new Coche(190));
        conjunto.add(new Coche(220));
        System.out.println(conjunto.toString());

        Set<Coche> otro = new TreeSet<>(Collections.reverseOrder());
        otro.add(new Coche(200));
        otro.add(new Coche(200));
        otro.add(new Coche(190));
        otro.add(new Coche(220));
        System.out.println(otro.toString());

        Coche[] array = new Coche[2];
        array[0] = new Coche(120);
        array[1] = new Coche(200);
        System.out.println(java.util.Arrays.toString(array));
        System.out.println(java.util.Arrays.binarySearch(array, new Coche(120)));
    }

}