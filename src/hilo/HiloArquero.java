package hilo;

import modelo.Arquero;
import modelo.Tiro;


/**Esta clase define objetos de tipo HiloArquero y hereda de Thread
 * 
 * @author Alvaro Jose Escobar & Cristian Felipe Molina
 * @version 22/05/2018 Beta 1.0
 */
public class HiloArquero extends Thread{

	/** Atributo lado de tipo int 
	 */
	private int lado;
	
	/** Atributo seguir de tipo boolean 
	 */
	private boolean seguir;
	
	/** Relacion con un objeto de tipo Arquero
	 */
	private Arquero arquero;
	
	/** Relacion con un objeto de tipo Tiro
	 */
	private Tiro p;
	
	/**Constructor para los objetos de tipo HiloArquero.
	 * 
	 * @param arquero de tipo Arquero
	 * @param lad de tipo int
	 * @param par  de tipo Tiro
	 */
	public HiloArquero(Arquero arquero, int lad, Tiro par)
	{
		this.arquero = arquero;
		lado = lad;
		p = par;
		seguir= true;
	}
	
	/**Metodo que se encarga de empezar la ejecucion del HiloArquero
	 * 
	 *  @pre el objeto de tipo arquero no realiza ninguna animacion o movimiento
	 *  @post el objeto de tipo arquero se desplaza hacia un sector del arco para atrapar el 
	 *  balon, tiempo de descanso del hilo 3 segundos 
	 */
	public void run(){
		while(seguir){
			arquero.tirarArquero(lado);
			if(arquero.taparBalon(p.getBalon())){
				p.getHb().setRebote();
			}
			
			try {
				Thread.sleep(30);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	/**Metodo que se encarga de interrumpir la ejecucion del hilo del arquero
	 * 
	 *  @pre el arquero se encuentra en movimiento 
	 *  @post se interrumpe el movimiento que esta realizando 
	 */
	public void interrupt(){
		seguir = false;
	}
}
