import java.util.Arrays;

/**
 *  Modela un grupo de alumnos de un curso
 */
public class Curso
{

    private static final int MAX_ALUMNOS = 10;

    private String nombreCurso;
    private Alumno[] alumnos;
    private int total;

    /**
     * Constructor de la clase Curso
     */
    public Curso(String nombreCurso)
    {
        this.nombreCurso = nombreCurso;
        alumnos = new Alumno[MAX_ALUMNOS];
        total = 0;
    }

    /**
     *
     * Añade un alumno al curso al final - Si el curso está completo se mostrará un mensaje    
     */
    public void addAlumno(String nombre, int nota)
    {
        if(total<alumnos.length){
            alumnos[total]= new Alumno(nombre, nota);
            total++;
        }
        else{
            System.out.println("No quedan plazas libres para nuevos alumnos");
        }
    }
    

    /**
     *  Añade un alumno al curso al final - Si el curso está completo se mostrará un mensaje  
     */
    public void addAlumno(Alumno alumno)
    {
        if(total<alumnos.length){
            alumnos[total] = alumno;
            total++;
        }
        else{
            System.out.println("No quedan plazas libres para nuevos alumnos");
        }
    }

    /**
     * devuelve la cantidad de aprobados en el curso
     */ 
    public int totalAprobados()
    { 
        int aprobados = 0;
        for(int i = 0; i<total; i++){
            if(alumnos[i].getNota()>=5){
                aprobados++;
            }
        }
        return aprobados;
    }
    
    /**
     * devuelve un array de String con los nombres de los alumnos que han aprobado todo
     */ 
    public String[] alumnosConTodoAprobado()
    {
        String[] aprobados = new String[totalAprobados()];
        int posAprob = 0;
        for(int i = 0; i<total; i++){
            if(alumnos[i].getNota()>=5){
                aprobados[posAprob] = alumnos[i].getNombre();
                posAprob++;
            }
            
        }
        return aprobados;
    }

    /**
     * ordena el curso de mayor a menor nota por el método de selección directa (se modifica el array original)
     */
    public void ordenarPorSeleccionDirecta()
    {
        
        for (int i = 0; i < total - 1; i++){
            int posmax = i;
            
            for (int j = i + 1; j < total; j++){
                if (alumnos[j].getNota() > alumnos[posmax].getNota()){
                    posmax = j;
                }
            }
            Alumno aux = alumnos[posmax];
            alumnos[posmax] = alumnos[i];
            alumnos[i] = aux;
        }
        
        
    }
    
    /**
     * Borrar los alumnos que han obtenido un 3 devolviendo la cantidad de alumnos borrados
     */
    public  int borrarLosDeNota3()
    {
        int sacanTres = 0;
        
        for(int i = 0; i < total; i++){
            if (alumnos[i].getNota()==3) {
                System.arraycopy(alumnos, i+1, alumnos, i, total - i - 1);
                total--;
                sacanTres++;
             }
        }
        return sacanTres;
    }
        
    /**
     * Representación textual del curso
     *
     */
    public String toString()
    { 
        String str="";
        str+="Nombre curso: " + nombreCurso + "\n";
        for(int i=0;i<total;i++){
            str+=alumnos[i].toString();
        }
        return str;
    }
    /**
     *  crea una copia del array alumnos
     *  Ordena la copia de menor a mayor nota por el método de inserción directa y lo devuelve.
     */
    public Alumno[] ordenarPorInsercionDirecta(){
        
        Alumno[] copia = new Alumno[total];
        System.arraycopy(alumnos, 0, copia, 0, total);
        for(int i = 1; i < total; i++){
            Alumno aux = copia[i];
            int j = i - 1;
            while(j>=0 && copia[j].getNota()>aux.getNota()){
                copia[j+1]=copia[j];
                i--;
            }
            copia[j+1] = aux;
        }
        return copia;
    }
    
    /**
     *  obtiene un array con los nombres de los alumnos que han aprobado
     *  Ordena alfabéticamente ese  array usando un método de la clase Arrays
     */
    public String[] ordenarPorNombreAprobados()
    {
        String[] aprobados = new String[total];
        for(int i = 0; i < alumnos.length; i++){
            if(alumnos[i].getNota()>=5){
                aprobados[i]=alumnos[i].getNombre();
            }
        }
        Arrays.sort(aprobados);
        return aprobados;
    }
}
