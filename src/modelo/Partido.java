package modelo;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**Entidad del modelo del mundo que representa el Partido e implementa la interface Serializable
 * 
 * @author Alvaro Jose Escobar & Cristian Felipe Molina
 * @version 22/05/2018 Beta 1.0
 */
public class Partido implements Serializable{

	/**Atributo constante de tipo int LOCAL = 1
	 */
	public static final int LOCAL = 1;
	
	/**Atributo constante de tipo int VISITANTE = 2
	 */
	public static final int VISITANTE = 2;
	
	/** Relacion con un objeto de tipo Tiro
	 */
	private transient Tiro tiro;
	
	/**Variables de tipo int modo, lado;
	 */
	private int modo, lado;
	
	/**ArrayList de tipo boolean golesLocal
	 */
	private ArrayList<Boolean> golesLocal;
	
	/**ArrayList de tipo boolean golesVisitante
	 */
	private ArrayList<Boolean> golesVisitante;
	
	/** Relaciones con objetos de tipo Equipo local, visitante, ganador
	 */
	private Equipo local, visitante, ganador;
	
	/** Relacion con un objeto de tipo Torneo
	 */
	private Torneo torneo;
	
	/**Variable de tipo boolean shoot, indica si ya se realizo el Tiro o no
	 */
	private boolean shoot;
	
	/**Constructor para los objetos de tipo Partido,inicializa los valores de las variables 
	 * 
	 * @param loc es un objeto de tipo Equipo
	 * @param vis es un objeto de tipo Equipo
	 * @param t es un objeto de tipo Torneo
	 * @param l es una variable de tipo int, indica si el jugador es visitante o local
	 */
	public Partido(Equipo loc, Equipo vis, Torneo t, int l){
		modo = l;
		golesLocal = new ArrayList<>();
		golesVisitante = new ArrayList<>();
		tiro = new Tiro(this, modo-1);
		local = loc;
		visitante = vis;
		ganador = null;
		torneo = t;
		lado = l;
		shoot = false;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * a la relacion de la clase Partido con la clase Tiro
	 * 
	 * @return tiro es un objeto de tipo Tiro.
	 */
	public Tiro getTiro(){
		return tiro;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * a la relacion de la clase Partido con la clase Equipo
	 * 
	 * @return ganador es un objeto de tipo Equipo.
	 */
	public Equipo getGanador(){
		return ganador;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * a la relacion de la clase Partido con la clase Equipo
	 * 
	 * @return local es un objeto de tipo Equipo.
	 */
	public Equipo getLocal(){
		return local;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * a la relacion de la clase Partido con la clase Equipo
	 * 
	 * @return visitante es un objeto de tipo Equipo.
	 */
	public Equipo getVisitante(){
		return visitante;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases modificar 
	 * el atributo shoot de la clase Partido
	 * 
	 * @pre el shoot se encuentra por defecto con los valores establecidos en el constructor
	 * @post se cambia el shoot anterior por el que se recibe por parametro
	 * 
	 * @param shoot es un atributo de tipo boolean
	 */
	public void setShoot(boolean shoot){
		this.shoot = shoot;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * al atributo shoot de la clase Partido
	 * 
	 * @return shoot es un atributo de tipo boolean.
	 */
	public boolean getShoot(){
		return shoot;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * ala relacion de la clase Partido con la clase Torneo
	 * 
	 * @return torneo es un objeto de tipo Torneo.
	 */
	public Torneo getTorneo(){
		return torneo;
	}
	
	/**Este metodo se encarga de preparar el estado del Juego para realizar un nuevo tiro
	 * 
	 * @pre se termina de realizar un tiro y las variables cambian su estado a comparacion
	 * del que tenia por defecto Tiro!=null,golesLocal!=null,golesVisitante!=null
	 * @post se verifica si fue gol o no el tiro, se añade el valor de verdad a la ArrayList,
	 * se verifica si alguien ya gano o no y se prepara el proximo Tiro
	 */
	public void nextTiro(){
		shoot = false;
		if(tiro.isGol()&&(golesLocal.size()+golesVisitante.size())%2==0){
			golesLocal.add(true);
		}
		else if(!tiro.isGol()&&(golesLocal.size()+golesVisitante.size())%2==0){
			golesLocal.add(false);
		}
		else if(tiro.isGol()&&(golesLocal.size()+golesVisitante.size())%2!=0){
			golesVisitante.add(true);
		}
		else{
			golesVisitante.add(false);
		}
		if(verificarVictoria()==0){
			modo ++;
			tiro = new Tiro(this, modo-1);
		}
		else if(verificarVictoria()==lado){
			torneo.getJuego().parar();
			tiro.getHb().interrupt();
			tiro.getHa().interrupt();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(lado==LOCAL){
				ganador = local;
			}
			else{
				ganador = visitante;
			}
			torneo.getJuego().mostrarVictoria();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			torneo.getJuego().apagar();
			torneo.nextStage();
		}
		else{
			torneo.getJuego().parar();
			tiro.getHb().interrupt();
			tiro.getHa().interrupt();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(lado==LOCAL){
				ganador = visitante;
			}
			else{
				ganador = local;
			}
			torneo.getJuego().mostrarDerrota();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			torneo.getJuego().apagar();
			torneo.nextStage();
		}
	}
	
	/**Este metodo se encarga de tener en cuenta el marcador del partido 
	 * 
	 * @pre golesLocal!=null y golesVisitante!=null
	 * @post se modifica el marcador con los valores de verdad de ambas ArrayList para poder
	 * mostrarselo luego al usuario
	 */
	public void mostrarMarcador(){
		
		Boolean[] a = new Boolean[golesLocal.size()];
		a = golesLocal.toArray(a);
		
		Boolean[] b = new Boolean[golesVisitante.size()];
		b = golesVisitante.toArray(b);
		torneo.getJuego().mostrarMarcador(a, b);
	}
	
	/**Este metodo se encarga de contar el numero de goles que lleva el Equipo Local
	 * 
	 * @pre golesLocal!=null 
	 * @post se realiza la cuenta de cuantos goles a favor lleva el Equipo Local
	 * 
	 * @return goles de tipo int, es el numero de goles a favor del Local
	 */
	public int contarGolesLocal(){
		int goles = 0;
		for (int i = 0; i < golesLocal.size(); i++) {
			if(golesLocal.get(i)){
				goles++;
			}
		}
		return goles;
	}
	
	/**Este metodo se encarga de contar el numero de goles que lleva el Equipo Visitante
	 * 
	 * @pre golesVisitante!=null 
	 * @post se realiza la cuenta de cuantos goles a favor lleva el Equipo Visitante
	 * 
	 * @return goles de tipo int, es el numero de goles a favor del Visitante
	 */
	public int contarGolesVisitante(){
		int goles = 0;
		for (int i = 0; i < golesVisitante.size(); i++) {
			if(golesVisitante.get(i)){
				goles++;
			}
		}
		return goles;
	}
	
	/**Este metodo se encarga de verificar quien fue el Equipo gandor del Partido
	 * 
	 * @pre golesVisitante!=null y golesLocal!=null
	 * @post teniendo en cuenta la cantidad de goles se verifica quien fue el ganador 
	 * 
	 * @return victoria de tipo int, devuelve victoria=1 si gana el Local y victoria=2 si gana 
	 * el Visitante
	 */
	public int verificarVictoria(){
		int victoria = 0;
		
		if((golesLocal.size()+golesVisitante.size())>5&&(golesLocal.size()+golesVisitante.size())<11){
			switch (golesLocal.size()+golesVisitante.size()) {
			case 6:
				if((contarGolesVisitante()-contarGolesLocal())==3){
					victoria = VISITANTE;
				}
				else if((contarGolesLocal()-contarGolesVisitante())==3){
					victoria = LOCAL;
				}
				break;
			case 7:
				if((contarGolesLocal()-contarGolesVisitante())==3){
					victoria = LOCAL;
				}
				else if((contarGolesVisitante()-contarGolesLocal())==2){
					victoria = VISITANTE;
				}
				break;
			case 8:
				if((contarGolesVisitante()-contarGolesLocal())==2){
					victoria = VISITANTE;
				}
				else if((contarGolesLocal()-contarGolesVisitante())==2){
					victoria = LOCAL;
				}
				break;
			case 9:
				if((contarGolesLocal()-contarGolesVisitante())==2){
					victoria = LOCAL;
				}
				else if((contarGolesVisitante()-contarGolesLocal())==1){
					victoria = VISITANTE;
				}
				break;
			case 10:
				if((contarGolesVisitante()-contarGolesLocal())==1){
					victoria = VISITANTE;
				}
				else if((contarGolesLocal()-contarGolesVisitante())==1){
					victoria = LOCAL;
				}
				break;
			}
			
		}else if((golesLocal.size()+golesVisitante.size())>10&&(golesLocal.size()+golesVisitante.size())%2==0){
			if((contarGolesLocal()-contarGolesVisitante())==1){
				victoria = LOCAL;
			}
			else if((contarGolesVisitante()-contarGolesLocal())==1){
				victoria = VISITANTE;
			}
		}
		return victoria;
	}
}