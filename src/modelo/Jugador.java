package modelo;

import java.io.Serializable;

/**Entidad del modelo del mundo que representa el Jugador e implementa la interface Serializable
 * 
 * @author Alvaro Jose Escobar & Cristian Felipe Molina
 * @version 22/05/2018 Beta 1.0
 */
public class Jugador implements Serializable{

	/** Relacion con un objeto de tipo Torneo
	 */
	private Torneo torneo;
	
	/** Relacion con un objeto de tipo Partido
	 */
	private Partido amistoso;
	
	/**Variables de tipo int trofeos, victorias, goles
	 */
	private int trofeos, victorias, goles;
	
	/**Variable de tipo String nombre
	 */
	private String nombre;
	
	/**Constructor para los objetos de tipo Jugador,inicializa los valores de las variables 
	 * este constructor se utiliza cuando el jugador desea realizar un Torneo
	 * 
	 * @param torneo es un objeto de tipo Torneo
	 * @param n es una variable de tipo String, representa el nombre del Jugador
	 */
	public Jugador(Torneo torneo, String n) {
		this.torneo = torneo;
		nombre = n;
		amistoso = null;
		trofeos = 0;
		victorias = 0;
		goles = 0;
	}
	
	/**Constructor para los objetos de tipo Jugador,inicializa los valores de las variables,
	 * este constructor se utiliza cuando el jugador desea realizar un Partido amistoso 
	 * 
	 * @param p es un objeto de tipo Partido
	 */
	public Jugador(Partido p){
		amistoso = p;
		torneo = null;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * a la relacion de la clase Jugador con la clase Torneo
	 * 
	 * @return torneo es un objeto de tipo Torneo.
	 */
	public Torneo getTorneo() {
		return torneo;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * a la relacion de la clase Jugador con la clase Partido
	 * 
	 * @return amistoso es un objeto de tipo Partido.
	 */
	public Partido getAmistoso() {
		return amistoso;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * al atributo trofeos de la clase Jugador
	 * 
	 * @return trofeos es un atributo de tipo int.
	 */
	public int getTrofeos() {
		return trofeos;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * al atributo victorias de la clase Jugador
	 * 
	 * @return victorias es un atributo de tipo int.
	 */
	public int getVictorias() {
		return victorias;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases modificar 
	 * la relacion con la clase Torneo
	 * 
	 * @pre el torneo se encuentra por defecto con los valores establecidos en el constructor
	 * @post se cambia el torneo anterior por el que se recibe por parametro
	 * 
	 * @param torneo es un objeto de tipo Torneo
	 */
	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases modificar 
	 * la relacion con la clase Partido
	 * 
	 * @pre el Partido amistoso se encuentra por defecto con los valores establecidos en el constructor
	 * @post se cambia el Partido amistoso anterior por el que se recibe por parametro
	 * 
	 * @param amistoso es un objeto de tipo Partido
	 */
	public void setAmistoso(Partido amistoso) {
		this.amistoso = amistoso;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases modificar 
	 * el atributo trofeos de la clase Jugador
	 * 
	 * @pre el trofeos se encuentra por defecto con los valores establecidos en el constructor
	 * @post se cambia el trofeos anterior por el que se recibe por parametro
	 * 
	 * @param trofeos es un atributo de tipo int
	 */
	public void setTrofeos(int trofeos) {
		this.trofeos = trofeos;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases modificar 
	 * el atributo victorias de la clase Jugador
	 * 
	 * @pre el victorias se encuentra por defecto con los valores establecidos en el constructor
	 * @post se cambia el victorias anterior por el que se recibe por parametro
	 * 
	 * @param victorias es un atributo de tipo int
	 */
	public void setVictorias(int victorias) {
		this.victorias = victorias;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * al atributo nombre de la clase Jugador
	 * 
	 * @return nombre es un atributo de tipo String.
	 */
	public String getNombre() {
		return nombre;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases modificar 
	 * el atributo nombre de la clase Jugador
	 * 
	 * @pre el nombre se encuentra por defecto con los valores establecidos en el constructor
	 * @post se cambia el nombre anterior por el que se recibe por parametro
	 * 
	 * @param nombre es un atributo de tipo String
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * al atributo goles de la clase Jugador
	 * 
	 * @return goles es un atributo de tipo int.
	 */
	public int getGoles() {
		return goles;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases modificar 
	 * el atributo goles de la clase Jugador
	 * 
	 * @pre el goles se encuentra por defecto con los valores establecidos en el constructor
	 * @post se cambia el goles anterior por el que se recibe por parametro
	 * 
	 * @param goles es un atributo de tipo int
	 */
	public void setGoles(int goles) {
		this.goles = goles;
	}
}