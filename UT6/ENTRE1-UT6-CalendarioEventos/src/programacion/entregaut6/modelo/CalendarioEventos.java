package programacion.entregaut6.modelo;

import programacion.entregaut6.io.CalendarioIO;

import java.util.*;

/**
 * Esta clase modela un sencillo calendario de eventos.
 * 
 * Por simplicidad consideraremos que los eventos no se solapan
 * y no se repiten
 * 
 * El calendario guarda en un map los eventos de una serie de meses
 * Cada mes (la clave en el map, un enumerado programacion.entregaut6.modelo.Mes) tiene asociados
 * en una colección ArrayList los eventos de ese mes
 * 
 * Solo aparecen los meses que incluyen algún evento
 * 
 * Las claves se recuperan en orden alfabético
 * 
 */
public class CalendarioEventos {
	private TreeMap<Mes, ArrayList<Evento>> calendario;

	/**
	 * el constructor
	 */
	public CalendarioEventos() {
		this.calendario = new TreeMap<>();
	}

	/**
	 * añade un nuevo evento al calendario
	 * Si la clave (el mes del nuevo evento) no existe en el calendario
	 * se creará una nueva entrada con dicha clave y la colección formada
	 * por ese único evento
	 * Si la clave (el mes) ya existe se añade el nuevo evento insertándolo de forma
	 * que quede ordenado por fecha y hora de inicio
	 * 
	 * Pista! Observa que en la clase programacion.entregaut6.modelo.Evento hay un método antesDe() que vendrá
	 * muy bien usar aquí
	 */
	public void addEvento(Evento nuevo) {
		//Comprobamos si ya hay eventos para el mes del evento a insertar
		 if(!calendario.containsKey(nuevo.getMes())){//No hay eventos para ese mes
			 ArrayList<Evento> valor=new ArrayList<>();
			 valor.add(nuevo);//Insertamos el nuevo evento
			 //Insertamos (o sobreescribimos) el ArrayList en la posición correspondiente del TreeMap
			 calendario.put(nuevo.getMes(),valor);
		 }
		else{//Si ya hay eventos para el mes del evento a insertar.
			insertarOrdenado(nuevo);//Llamamos a la función que inserta el evento en la posición que le corresponde
			 //No hay que hacer put: Modificamos el ArrayList correspondiente dentro de la función insertarOrdenado
		 }
	}

	private void insertarOrdenado(Evento nuevo){
		//Recogemos los eventos del mes correspondiente en un ArrayList
		ArrayList<Evento> eventosMes=calendario.get(nuevo.getMes());

		//Recorremos el ArrayList en busca de la posición donde tenemos que insertar
		int i=0;
		while(i<eventosMes.size() && eventosMes.get(i).antesDe(nuevo)){
			i++;
		}
		//Al salir del bucle, ya tenemos en i la posición de inserción del evento
		eventosMes.add(i,nuevo);
	}



	/**
	 * Representación textual del calendario
	 * Hacer de forma eficiente 
	 * Usar el conjunto de entradas  
	 */
	public String toString() {
		StringBuilder sb=new StringBuilder();
		Set<Map.Entry<Mes, ArrayList<Evento>>> setEntradas=calendario.entrySet();
		//Recorremos el TreeSet calendario con las claves que nos da keySet(), con for mejorado
		for(Map.Entry<Mes, ArrayList<Evento>> entrada:setEntradas){
			Mes mesEnCurso=entrada.getKey();
			sb.append(mesEnCurso.toString() + "\n\n");//Añadimos la cabecera con el nombre del mes a nuestro StringBuilder
			ArrayList<Evento> eventosMes=calendario.get(mesEnCurso);
			//Usamos un iterador para recorrer los eventos del mes
			Iterator<Evento> itEventos=eventosMes.iterator();
			while (itEventos.hasNext()){
				sb.append(itEventos.next() + "\n");
			}
		}
		return sb.toString();
	}

	/**
	 * Dado un mes devolver la cantidad de eventos que hay en ese mes
	 * Si el mes no existe se devuelve 0
	 */
	public int totalEventosEnMes(Mes mes) {
		//Compruebo previamente si existe el mes en el TreeMap. Si no, rompería la función size() para un objeto null
		if(calendario.containsKey(mes)){
			return calendario.get(mes).size();
		}
		else{
			return 0;
		}
	}

	/**
	 * Devuelve un conjunto (importa el orden) 
	 * con los meses que tienen mayor nº de eventos
	 * Hacer un solo recorrido del map con el conjunto de claves
	 *  
	 */
	public TreeSet<Mes> mesesConMasEventos() {
		TreeSet<Mes> retorno=new TreeSet<>();
		int maxEventos=0;
		for(Mes mesEnCurso:calendario.keySet()){//Recorremos el conjunto de claves
			int numEventosMes = totalEventosEnMes(mesEnCurso);
			if(numEventosMes >maxEventos){//Si el mes comprobado supera en número de eventos a cualquier otro, se queda sólo en el Set
				retorno.clear();
				retorno.add(mesEnCurso);
				maxEventos= numEventosMes;
			}
			else if(numEventosMes ==maxEventos){//Si iguala el número de eventos máximo, se añade al Set
				retorno.add(mesEnCurso);
			}
		}
		return retorno;
	}

	
	/**
	 * Devuelve el nombre del evento de mayor duración en todo el calendario
	 * Se devuelve uno solo (el primero encontrado) aunque haya varios
	 */
	public String eventoMasLargo() {
		int maxDuracion=0;
		String eventoMax="";
		for(Mes mesEnCurso:calendario.keySet()){//Recorremos el calendario mes a mes
			for(Evento e:calendario.get(mesEnCurso)){//Y para cada mes, evento a evento
				if(e.getDuracion()>maxDuracion){
					maxDuracion=e.getDuracion();
					eventoMax=e.getNombre();
				}
			}
		}
		return eventoMax;
	}

	/**
	 * Borrar del calendario todos los eventos de los meses indicados en el array
	 * y que tengan lugar el día de la semana proporcionado (se entiende día de la
	 * semana como 1 - Lunes, 2 - Martes ..  6 - Sábado, 7 - Domingo)
	 * 
	 * Si alguno de los meses del array no existe el el calendario no se hace nada
	 * Si al borrar de un mes los eventos el mes queda con 0 eventos se borra la entrada
	 * completa del map
	 */
	public int cancelarEventos(Mes[] meses, int dia) {
		int numCancelados=0;
		for (int i = 0; i < meses.length; i++) {
			//Como posiblemente tengamos que borrar el mes, no vale un for mejorado. Uso un iterador
			Iterator<Mes> itMesesCalendario=calendario.keySet().iterator();
			while(itMesesCalendario.hasNext()) {
				Mes mesEnCurso=itMesesCalendario.next();
				ArrayList<Evento> eventosMes=calendario.get(mesEnCurso);
				//Si tenemos que borrar NO podemos hacerlo con un for mejorado: Usamos un iterador o un for con índices
				Iterator<Evento> itEventosMes=eventosMes.iterator();
				while(itEventosMes.hasNext()){
					if(itEventosMes.next().getDia()==dia){
						itEventosMes.remove();
						numCancelados++;
					}
				}
				//Comprobamos si hay que borrar el programacion.entregaut6.modelo.Mes del calendario
				if(totalEventosEnMes(mesEnCurso)==0){
					itMesesCalendario.remove();
				}
			}
		}
		return numCancelados;
	}

	/**
	 * Código para testear la clase programacion.entregaut6.modelo.CalendarioEventos
	 */
	public static void main(String[] args) {
		CalendarioEventos calendario = new CalendarioEventos();
		CalendarioIO.cargarEventos(calendario);
		System.out.println(calendario);

		System.out.println();

		Mes mes = Mes.FEBRERO;
		System.out.println("Eventos en " + mes + " = "
		                    + calendario.totalEventosEnMes(mes));
		mes = Mes.MARZO;
		System.out.println("Eventos en " + mes + " = "
		                    + calendario.totalEventosEnMes(mes));
		System.out.println("Mes/es con más eventos "
		                    + calendario.mesesConMasEventos());

		System.out.println();
		System.out.println("Evento de mayor duración: "
		                    + calendario.eventoMasLargo());

		System.out.println();
		Mes[] meses = {Mes.FEBRERO, Mes.MARZO, Mes.MAYO, Mes.JUNIO};
		int dia = 6;
		System.out.println("Cancelar eventos de " + Arrays.toString(meses));
		int cancelados = calendario.cancelarEventos(meses, dia);
		System.out.println("Se han cancelado " + cancelados +
		                    " eventos");
		System.out.println();
		System.out.println("Después de cancelar eventos ...");
		System.out.println(calendario);
	}

}
