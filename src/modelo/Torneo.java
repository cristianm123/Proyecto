package modelo;

import java.io.Serializable;

import javax.swing.JOptionPane;

/**Entidad del modelo del mundo que representa el Partido e implementa la interface Serializable
 * 
 * @author Alvaro Jose Escobar & Cristian Felipe Molina
 * @version 22/05/2018 Beta 1.0
 */
public class Torneo implements Serializable{

	/**Atributo constante de tipo int CUARTOS = 3
	 */
	private static final int CUARTOS = 3;
	
	/**Atributo constante de tipo int SEMIS = 2
	 */
	private static final int SEMIS = 2;
	
	/**Atributo constante de tipo int FINAL = 1
	 */
	private static final int FINAL = 1;
	
	/**Arreglos con objetos de tipo Equipo clubes, selecciones;
	 */
	private Equipo[] clubes, selecciones;
	
	/** Relacion con un objeto de tipo Equipo
	 */
	private Equipo campeon;
	
	/** Relacion con un objeto de tipo Partido
	 */
	private Partido partido;
	
	/**Variable de tipo int jugador, indica si es Visitante o Local
	 */
	private int jugador;
	
	/**Variable de tipo int stage, indica la posicion del Torneo en la que se encuentra 
	 */
	private int stage;
	
	/** Relacion con un objeto de tipo Club
	 */
	private Club primero;
	
	/** Relacion con un objeto de tipo Seleccion
	 */
	private Seleccion primera;
	
	/** Relacion con un objeto de tipo Juego
	 */
	private transient Juego juego;
	
	/**Constructor para los objetos de tipo Torneo,inicializa los valores de las variables 
	 * 
	 * @param j de tipo Juego, es un objeto de tipo Juego
	 */
	public Torneo(Juego j){
		clubes = new Equipo[]{new Club("barcelona", 1), new Club("realMadrid", 3),
				new Club("inter", 5), new Club("city", 7), new Club("united", 9),
				new Club("chelsea", 11), new Club("milan", 13), new Club("psg", 15)
		};
		selecciones = new Equipo[]{new Seleccion("colombia", 1), new Seleccion("alemania", 3),
				new Seleccion("brasil", 5), new Seleccion("españa", 7), new Seleccion("francia", 9),
				new Seleccion("argentina", 11), new Seleccion("portugal", 13), new Seleccion("italia", 15)
		};
		stage = CUARTOS;
		juego = j;
		iniciarListaC();
		iniciarListaS();
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * a la relacion de la clase Torneo con la clase Equipo
	 * 
	 * @return primero es un objeto de tipo Equipo.
	 */
	public Equipo getPrimero(){
		return primero;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * a la relacion de la clase Torneo con la clase Equipo
	 * 
	 * @return primera es un objeto de tipo Equipo.
	 */
	public Equipo getPrimera(){
		return primera;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases modificar 
	 * el atributo jugador de la clase Torneo
	 * 
	 * @pre el jugador se encuentra por defecto con los valores establecidos en el constructor
	 * @post se cambia el jugador anterior por el que se recibe por parametro
	 * 
	 * @param jugador es un atributo de tipo int
	 */
	public void setJugador(int jugador){
		this.jugador = jugador;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * a la relacion de la clase Torneo con la clase Juego
	 * 
	 * @return juego es un objeto de tipo Juego.
	 */
	public Juego getJuego(){
		return juego;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases modificar 
	 * la relacion de la clase Torneo con la clase Juego
	 * 
	 * @pre el juego se encuentra por defecto con los valores establecidos en el constructor
	 * @post se cambia el juego anterior por el que se recibe por parametro
	 * 
	 * @param juego es un objeto de tipo Juego
	 */
	public void setJuego(Juego juego){
		this.juego = juego;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases modificar 
	 * la relacion de la clase Torneo con la clase Partido
	 * 
	 * @pre el partido se encuentra por defecto con los valores establecidos en el constructor
	 * @post se cambia el partido anterior por el que se recibe por parametro
	 * 
	 * @param partido es un objeto de tipo Partido
	 */
	public void setPartido(Partido partido){
		this.partido = partido;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * a la relacion de la clase Torneo con la clase Partido
	 * 
	 * @return partido es un objeto de tipo Partido.
	 */
	public Partido getPartida(){
		return partido;
	}
	
	public void nextStage(){
		stage--;
		if(stage==SEMIS){
			Plaza e = (Plaza)buscar(4);
			e.nextStage(partido.getGanador());
			e = (Plaza)buscar(12);
			e.nextStage(partido.getGanador());
			if(buscar(jugador)!=null){
				e = (Plaza)buscar(buscar(jugador).getRaiz().getIndex());
				if(jugador>e.getIndex()){
					partido = new Partido(e.getIzq(), e.getDer(), this, Partido.VISITANTE);
				}
				else{
					partido = new Partido(e.getIzq(), e.getDer(), this, Partido.LOCAL);
				}
				juego.start();
			}
		}
		else if(stage == FINAL){
			Plaza e = (Plaza)buscar(8);
			e.nextStage(partido.getGanador());
			
			if(partido.getGanador().getIndex()==jugador){
				if(partido.getGanador().getIndex()>8){
					partido = new Partido(e.getIzq(), e.getDer(), this, Partido.VISITANTE);
				}
				else{
					partido = new Partido(e.getIzq(), e.getDer(), this, Partido.LOCAL);
				}
				
				juego.start();
			}
		}
		if(JOptionPane.showConfirmDialog(null, "¿Desea guardar la partida?")==0){
			juego.guardarJuego();
		}
	}
	
	public Equipo buscar(int i){
		return campeon == null? null:campeon.buscar(i);
	}
	
	public void add(Equipo e){
		if(campeon == null){
			campeon = e;
		}
		else{
			campeon.add(e);
		}
	}
	
	public void jugarPartido() {
		
		if(jugador>buscar(jugador).getRaiz().getIndex())
		{
			partido = new Partido(buscar(jugador).getRaiz().getIzq(), buscar(jugador), this, Partido.VISITANTE);
		}
		else
		{
			partido = new Partido(buscar(jugador), buscar(jugador).getRaiz().getDer(), this, Partido.LOCAL);
		}
	}
	
	public void iniciarListaC(){
		primero = (Club)clubes[0];
		for(int i = 0; i<clubes.length; i++){
			if(i==0){
				clubes[i].setBack(clubes[clubes.length-1]);
			}
			else{
				clubes[i].setBack(clubes[i-1]);
			}
			if(i==clubes.length-1){
				clubes[i].setNext(clubes[0]);
			}
			else{
				clubes[i].setNext(clubes[i+1]);
			}
		}
	}
	
	public void iniciarListaS(){
		primera = (Seleccion)selecciones[0];
		for(int i = 0; i<selecciones.length; i++){
			if(i==0){
				selecciones[i].setBack(selecciones[selecciones.length-1]);
			}
			else{
				selecciones[i].setBack(selecciones[i-1]);
			}
			if(i==selecciones.length-1){
				selecciones[i].setNext(selecciones[0]);
			}
			else{
				selecciones[i].setNext(selecciones[i+1]);
			}
		}
	}
	
	public void iniciarArbol(int i){
		if(i==0){
			add(new Plaza(8));
			add(new Plaza(4));
			add(new Plaza(2));
			add(new Club("barcelona", 1));
			add(new Club("realMadrid", 3));
			add(new Plaza(6));
			add(new Club("inter", 5));
			add(new Club("city", 7));
			add(new Plaza(12));
			add(new Plaza(10));
			add(new Club("united", 9));
			add(new Club("chelsea", 11));
			add(new Plaza(14));
			add(new Club("milan", 13));
			add(new Club("psg", 15));
		}
		else{
			add(new Plaza(8));
			add(new Plaza(4));
			add(new Plaza(2));
			add(new Seleccion("colombia", 1));
			add(new Seleccion("alemania", 3));
			add(new Plaza(6));
			add(new Seleccion("brasil", 5));
			add(new Seleccion("españa", 7));
			add(new Plaza(12));
			add(new Plaza(10));
			add(new Seleccion("francia", 9));
			add(new Seleccion("argentina", 11));
			add(new Plaza(14));
			add(new Seleccion("portugal", 13));
			add(new Seleccion("italia", 15));
		}
	}
}
