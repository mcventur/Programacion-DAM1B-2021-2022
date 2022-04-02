/**
 *
 *
 */
public abstract class Fichero implements Comparable<Fichero>{
    private String titulo;
    private int tamaño;

    /**
     *
     */
    public Fichero(String titulo, int tamaño) {
        this.titulo = titulo;
        this.tamaño = tamaño;
    }

    /**
     *
     */
    public int getTamaño() {
        return tamaño;
    }

    /**
     *
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     *
     */
    public void display() {
        System.out.println(getClass().getSimpleName());
        System.out.println("Título: " + titulo);
        System.out.println("Tamaño: " + tamaño);
    }

    @Override
    public int hashCode() {
        return titulo.hashCode() + tamaño;
    }

    /**
     * Dos ficheros son iguales si tienen el mismo título y tamaño
     * y si son del mismo tipo
     */
    @Override
    public boolean equals(Object obj) {
        //Las comparaciones básicas
        if(obj==null) return false;
        if(obj==this) return true;
        if(obj.getClass()!=this.getClass()) return false;

        //Nuestra comparación adicional
        Fichero f=(Fichero)obj;
        return f.titulo.equals(this.titulo) && f.getTamaño()==this.tamaño;
    }

    /**
     * Es posible comparar dos ficheros en base a su
     * título (si coincide el título se tendrá en cuenta el tamaño - criterio natural de
     * ordenación)
     */
    @Override
    public int compareTo(Fichero o) {
        if(this.titulo.equals(o.getTitulo())){
            return this.tamaño-o.tamaño;
        }
        else{
            return this.titulo.compareTo(o.getTitulo());
        }
    }
}
