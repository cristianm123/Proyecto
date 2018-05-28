package modelo;

import java.awt.Rectangle;
import hilo.*;

/**Entidad del modelo del mundo que representa el Tiro realizado por el usuario
 * 
 * @author Alvaro Jose Escobar & Cristian Felipe Molina
 * @version 22/05/2018 Beta 1.0
 */
public class Tiro {
	
	/**Atributo constante de tipo int TIRO_PATEADOR = 0
	 */
	public static final int TIRO_PATEADOR = 0;
	
	/**Atributo constante de tipo int TIRO_ARQUERO = 1
	 */
	public static final int TIRO_ARQUERO = 1;
	
	/**Variable de tipo int modo, indica si el jugador es Local o Visitante
	 */
	private int modo;
	
	/** Relacion con un objeto de tipo Arquero
	 */
	private Arquero arquero;
	
	/** Relacion con un objeto de tipo Balon
	 */
	private Balon balon;	
	
	/** Relacion con un objeto de tipo HiloBalon
	 */
	private HiloBalon hb;
	
	/** Relacion con un objeto de tipo HiloArquero
	 */
	private HiloArquero ha;
	
	/**Variable de tipo Rectangle areaGol
	 */
	private Rectangle areaGol;
	
	/**Variable de tipo Rectangle areaIzq
	 */
	private Rectangle areaIzq;
	
	/**Variable de tipo Rectangle areaTravesano
	 */
	private Rectangle areaTravesano;
	
	/**Variable de tipo Rectangle areaDer
	 */
	private Rectangle areaDer;
	
	/** Relacion con un objeto de tipo Partido
	 */
	private Partido partido;
	
	/**Variable de tipo boolean gol
	 */
	private boolean gol;
	
	/**Constructor para los objetos de tipo Club,inicializa los valores de las variables 
	 * 
	 * @param p de tipo Partido
	 * @param modo de tipo int, indica si el Jugador es el Arquero o el Pateador
	 */
	public Tiro(Partido p, int modo){
		partido = p;
		arquero = new Arquero();
		balon = new Balon();
		areaGol = new Rectangle(325, 225, 750, 270);
		areaIzq = new Rectangle(310, 210, 15, 285);
		areaTravesano = new Rectangle(310, 210, 780, 15);
		areaDer = new Rectangle(1075, 210, 15, 285);
		this.modo = modo;
		gol = false;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * a la relacion de la clase Tiro con la clase Arquero
	 * 
	 * @return arquero es un objeto de tipo Arquero.
	 */
	public Arquero getArquero() {
		return arquero;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * a la relacion de la clase Tiro con la clase Balon
	 * 
	 * @return balon es un objeto de tipo Balon.
	 */
	public Balon getBalon() {
		return balon;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases modificar 
	 * la relacion de la clase Tiro con la clase Arquero
	 * 
	 * @pre el arquero se encuentra por defecto con los valores establecidos en el constructor
	 * @post se cambia el arquero anterior por el que se recibe por parametro
	 * 
	 * @param arquero es un objeto de tipo Arquero
	 */
	public void setArquero(Arquero arquero) {
		this.arquero = arquero;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases modificar 
	 * la relacion de la clase Tiro con la clase Balon
	 * 
	 * @pre el balon se encuentra por defecto con los valores establecidos en el constructor
	 * @post se cambia el balon anterior por el que se recibe por parametro
	 * 
	 * @param balon es un objeto de tipo Balon
	 */
	public void setBalon(Balon balon) {
		this.balon = balon;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * a la relacion de la clase Tiro con la clase HiloBalon
	 * 
	 * @return hb es un objeto de tipo HiloBalon.
	 */
	public HiloBalon getHb() {
		return hb;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * a la relacion de la clase Tiro con la clase HiloArquero
	 * 
	 * @return ha es un objeto de tipo HiloArquero.
	 */
	public HiloArquero getHa() {
		return ha;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * al atributo gol y conocer su valor de verdad 
	 * 
	 * @return gol es un atributo de tipo boolean.
	 */
	public boolean isGol() {
		return gol;
	}
	
	// falta comentar
	
	public void lanzo(int finx, int finy){
		if(modo%2==TIRO_PATEADOR){
			hb = new HiloBalon(balon, finx, finy, this);
			hb.start();
			ha = new HiloArquero(arquero, (int)(Math.random()*2), this);
			ha.start();
		}
		else{
			hb = new HiloBalon(balon, (int)(Math.random()*780)+310, (int)(Math.random()*250)+210, this);
			hb.start();
			if(finx<650){
				ha = new HiloArquero(arquero, 0, this);
			}
			else{
				ha = new HiloArquero(arquero, 1, this);
			}
			ha.start();
		}
	}
	
	/**Este metodo se encarga de decidir si el Tiro fue gol o no 
	 * 
	 * @pre balon!=null, hb!=null, ha!=null, partido !=null
	 * @post se calcula si el balon se intersecto con alguna de las areas de la cancha
	 * areaIzq,areaTravesano,areaDer o con el Arquero y se cambia el valor de verdad de la 
	 * variable gol dependiendo del caso
	 */
	public void fueGol(){
		if(balon.getAltura()==40){
			if(balon.getAreaBalon().intersects(areaIzq)||balon.getAreaBalon().intersects(areaTravesano)||balon.getAreaBalon().intersects(areaDer)){
				hb.setRebote();
			}
			else if(areaGol.contains(balon.getX(), balon.getY(), balon.getAncho(), balon.getAltura())){
				gol = true;
			}
		}
		if((balon.getAltura()==35 && balon.getY()>445 && balon.getY()<455) || balon.getAltura()>140){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
			hb.interrupt();
			ha.interrupt();
			partido.getTorneo().getJuego().reiniciar();
		}
	}
}