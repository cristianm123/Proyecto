package hilo;

import modelo.Balon;
import modelo.Tiro;

/**Esta clase define objetos de tipo HiloBalon y hereda de Thread
 * 
 * @author Alvaro Jose Escobar & Cristian Felipe Molina
 * @version 22/05/2018 Beta 1.0
 */
public class HiloBalon extends Thread{

	/** Atributo finx, finy de tipo int 
	 */
	private int finx, finy;
	
	/** Atributo rebote de tipo boolean 
	 */
	private boolean rebote;
	
	/** Atributo seguir de tipo boolean 
	 */
	private boolean seguir;
	
	/** Relacion con un objeto de tipo Balon
	 */
	private Balon balon;
	
	/** Relacion con un objeto de tipo Tiro
	 */
	private Tiro p;
	
	/**Constructor para los objetos de tipo HiloBalon.
	 * 
	 * @param b de tipo Balon
	 * @param x de tipo int
	 * @param y  de tipo int
	 * @param pa  de tipo Tiro
	 */
	public HiloBalon(Balon balon,int x, int y, Tiro pa){
		this.balon = balon;
		this.finx = x;
		this.finy = y;
		this.p = pa;
		this.rebote = false;
		this.seguir = true;
	}
	
	/**Metodo que se encarga de prestar el servicio a las demas clases de modificar
	 * el estado del atributo rebote
	 *
	 *  @pre el atributo rebote mantiene su valor por defecto false
	 *  @post el atributo rebote cambia su valor a true 
	 */
	public void setRebote(){
		rebote = true;
	}
	
	/**Metodo que se encarga de empezar la ejecucion del HiloBalon
	 * 
	 *  @pre el objeto de tipo balon no realiza ninguna animacion o movimiento
	 *  @post el objeto de tipo balon se desplaza hacia un sector del arco,tiempo 
	 *  de descanso del hilo 1 segundo 
	 */
	public void run(){
		
		while(seguir){
			
			p.fueGol();
			if(!rebote){
				balon.moverBalon(finx, finy);
			}
			else{
				balon.rebotar();
			}
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				System.out.println("ERROR");
			}
		}
	}
	
	/**Metodo que se encarga de interrumpir la ejecucion del hilo del balon
	 * 
	 *  @pre el balon se encuentra en movimiento 
	 *  @post se interrumpe el movimiento que esta realizando 
	 */
	public void interrupt(){
		seguir = false;
	}
}
