package modelo;

import java.io.Serializable;

/**Entidad del modelo del mundo que representa los Equipos disponibles para jugar, es abstracta
 * e implementa la interface Serializable, tambien es la clase que contiene el Arbol Binario y
 * las listas doblemente en lazadas 
 * 
 * @author Alvaro Jose Escobar & Cristian Felipe Molina
 * @version 22/05/2018 Beta 1.0
 */
public abstract class Equipo implements Serializable{

	/**Variable de tipo String nombre, representa el nombre del Equipo
	 */
	private String nombre;
	
	/**Variable de tipo int index, representa el indice de la lista en el que se encuentra el Equipo
	 */
	private int index;
	
	/** Relaciones con objetos de tipo Equipo izq,der ,raiz.
	 */
	private Equipo izq, der, raiz;
	
	/** Relaciones con objetos de tipo Equipo next, back.
	 */
	private Equipo next, back;
	
	/**Constructor para los objetos de tipo Equipo,inicializa los valores de las variables 
	 * 
	 * @param nom de tipo String,es el nombre del Equipo
	 * @param ind de tipo int,es el indice del Equipo
	 */
	public Equipo(String nom, int ind){
		nombre = nom;
		index = ind;
		next = null;
		back = null;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * a la relacion que tiene la clase Equipo para acceder a los nodos del lado izquiero del
	 * arbol binario
	 * 
	 * @return izq es un atributo de tipo Equipo.
	 */
	public Equipo getIzq() {
		return izq;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * a la relacion que tiene la clase Equipo para acceder a los nodos del lado derecho del
	 * arbol binario
	 * 
	 * @return der es un atributo de tipo Equipo.
	 */
	public Equipo getDer() {
		return der;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * a la relacion que tiene la clase Equipo para acceder a la raiz del arbol binario
	 * 
	 * @return raiz es un atributo de tipo Equipo.
	 */
	public Equipo getRaiz() {
		return raiz;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases modificar 
	 * la relacion izq de la clase Equipo
	 * 
	 * @pre el izq se encuentra por defecto con los valores establecidos en el constructor
	 * @post se cambia el izq anterior por el que se recibe por parametro
	 * 
	 * @param izq es una relacion con un objeto de tipo Equipo
	 */
	public void setIzq(Equipo izq) {
		this.izq = izq;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases modificar 
	 * la relacion der de la clase Equipo
	 * 
	 * @pre el der se encuentra por defecto con los valores establecidos en el constructor
	 * @post se cambia el der anterior por el que se recibe por parametro
	 * 
	 * @param der es una relacion con un objeto de tipo Equipo
	 */
	public void setDer(Equipo der) {
		this.der = der;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases modificar 
	 * la relacion raiz de la clase Equipo
	 * 
	 * @pre el raiz se encuentra por defecto con los valores establecidos en el constructor
	 * @post se cambia el raiz anterior por el que se recibe por parametro
	 * 
	 * @param raiz es una relacion con un objeto de tipo Equipo
	 */
	public void setRaiz(Equipo raiz) {
		this.raiz = raiz;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * al atributo nombre de la clase Equipo
	 * 
	 * @return nombre es un atributo de tipo String.
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * al atributo index de la clase Equipo
	 * 
	 * @return index es un atributo de tipo int.
	 */
	public int getIndex(){
		return index;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * a la relacion que tiene la clase Equipo para acceder al siguiente elemento de la lista
	 * 
	 * @return next es un atributo de tipo Equipo.
	 */
	public Equipo getNext() {
		return next;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * a la relacion que tiene la clase Equipo para acceder al elemento anterior de la lista
	 * 
	 * @return back es un atributo de tipo Equipo.
	 */
	public Equipo getBack() {
		return back;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases modificar 
	 * la relacion next de la clase Equipo
	 * 
	 * @pre el next se encuentra por defecto con los valores establecidos en el constructor
	 * @post se cambia el next anterior por el que se recibe por parametro
	 * 
	 * @param next es una relacion con un objeto de tipo Equipo
	 */
	public void setNext(Equipo next) {
		this.next = next;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases modificar 
	 * la relacion back de la clase Equipo
	 * 
	 * @pre el back se encuentra por defecto con los valores establecidos en el constructor
	 * @post se cambia el back anterior por el que se recibe por parametro
	 * 
	 * @param back es una relacion con un objeto de tipo Equipo
	 */
	public void setBack(Equipo back) {
		this.back = back;
	}
	
	/**Este metodo se encarga de añadir los elementos de tipo Equipo al Arbol Binario segun
	 * su index
	 * 
	 * @pre el arbol se encuentra basio con todos los nodos en null, raiz==null,izq==null,der==null
	 * @post se añaden los elementos al arbol,raiz!=null,izq!=null,der!=null 
	 * 
	 * @param e es un objeto de tipo Equipo
	 */
	public void add(Equipo e){
		if(index>e.getIndex()){
			if(izq == null){
				e.setRaiz(this);
				izq = e;
			}
			else{
				izq.add(e);
			}
		}
		else{
			if(der == null){
				e.setRaiz(this);
				der = e;
			}
			else{
				der.add(e);
			}
		}
	}
	
	/**Este metodo se encarga de buscar un Equipo en la lista segun el indice
	 * 
	 * @post retorna el equipo que se encuentra en el indice ingresado por parametro,si no 
	 * lo encuentra retorna null.
	 * 
	 * @param i es una variable de tipo int, indica el indice del equipo que se desea buscar 
	 */
	public Equipo buscar(int i){
		Equipo p = this;
		while(p!= null){
			if(p.getIndex()==i){
				return p;
			}
			else if(p.getIndex()>i){
				p = p.getIzq();
			}
			else{
				p = p.getDer();
			}
		}
		return null;
	}
}