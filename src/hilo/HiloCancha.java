package hilo;

import interfaz.PanelJuego;
import modelo.Partido;

/**Esta clase define objetos de tipo HiloCancha y hereda de Thread
 * 
 * @author Alvaro Jose Escobar & Cristian Felipe Molina
 * @version 22/05/2018 Beta 1.0
 */
public class HiloCancha extends Thread {
	
	/** Atributo seguir de tipo boolean 
	 */
	private boolean seguir;

	/** Relacion con un objeto de tipo PanelJuego
	 */
	private PanelJuego pj;
	
	/** Relacion con un objeto de tipo Partido
	 */
	private Partido partido;
	
	/**Constructor para los objetos de tipo HiloCancha.
	 * 
	 * @param pj de tipo PanelJuego
	 * @param p de tipo Partido
	 */
	public HiloCancha(PanelJuego pj, Partido p){
		this.pj = pj;
		partido = p;
		seguir = true;
	}
	
	/**Metodo que se encarga de empezar la ejecucion del HiloCancha
	 * 
	 *  @pre no se muestra el marcador del juego al usuario
	 *  @post aparece una imagen que indica si acerto o no,tiempo 
	 *  de descanso del hilo 1 segundo 
	 */
	public void run(){
		while(seguir)
		{	
			pj.repaint();
			partido.mostrarMarcador();
			
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	/**Metodo que se encarga de interrumpir la ejecucion del hilo de la cancha para 
	 * poder mostrar el marcador al usuario
	 * 
	 *  @pre aparece la imagen del marcador 
	 *  @post se detiene el hilo para que la imagen permanezca
	 */
	public void interrupt(){
		seguir = false;
	}
	
}
