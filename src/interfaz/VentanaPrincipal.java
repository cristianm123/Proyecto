package interfaz;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hilo.HiloCancha;
import modelo.Arquero;
import modelo.Balon;
import modelo.Club;
import modelo.Juego;
import modelo.Jugador;
import modelo.Partido;
import modelo.Tiro;
import modelo.Torneo;

/**Esta clase define objetos de tipo VentanaPrincipal y hereda de JFrame
 * 
 * @author Alvaro Jose Escobar & Cristian Felipe Molina
 * @version 22/05/2018 Beta 1.0
 */
public class VentanaPrincipal extends JFrame {
	
	/** Relacion con un objeto de tipo PanelInicio
	 */
	private PanelInicio panelInicio;
	
	/** Relacion con un objeto de tipo DialogNuevaPartida
	 */
	private DialogNuevaPartida dialogNuevaPartida;
	
	/** Relacion con un objeto de tipo DialogJuego
	 */
	private DialogJuego dialogJuego;
	
	/** Relacion con un objeto de tipo HiloCancha
	 */
	private HiloCancha h;
	
	/** Relacion con un objeto de tipo Torneo
	 */
	private Torneo torneo;
	
	/** Relacion con un objeto de tipo Juego
	 */
	private Juego juego;
	
	private VentanaRecords records;

	/**Constructor para los objetos de tipo VentanaPrincipal
	 */
	public VentanaPrincipal() {
		juego = null;
		
		setSize(800, 800);
		setTitle(".: Hot Penalties :.");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		panelInicio = new PanelInicio(this);
		add(panelInicio, BorderLayout.CENTER);
		juego = new Juego(this);
		torneo = new Torneo(juego);
		dialogNuevaPartida = new DialogNuevaPartida(this);
		records = new VentanaRecords(juego.getDatos(), this);
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * al HiloCancha
	 * 
	 * @return h es un objeto de tipo HiloCancha.
	 */
	public HiloCancha getHilo(){
		return h;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases modificar 
	 * el HiloCancha
	 * 
	 * @pre el HiloCancha se encuentra por defecto con los valores establecidos en el constructor
	 * @post se cambia el HiloCancha anterior por el que se recibe por parametro
	 * 
	 *  @param b es un objeto de tipo HiloCancha
	 */
	public void setHilo(HiloCancha b){
		h = b;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * al DialogJuego
	 * 
	 * @return dialogJuego es un objeto de tipo DialogJuego.
	 */
	public DialogJuego getDialogJuego() {
		return dialogJuego;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases modificar 
	 * el DialogJuego
	 * 
	 * @pre el DialogJuego se encuentra por defecto con los valores establecidos en el constructor
	 * @post se cambia el DialogJuego anterior por el que se recibe por parametro
	 * 
	 *  @param dialogJuego es un objeto de tipo DialogJuego
	 */
	public void setDialogJuego(DialogJuego dialogJuego) {
		this.dialogJuego = dialogJuego;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * al PanelInicio
	 * 
	 * @return panelInicio es un objeto de tipo PanelInicio.
	 */
	public PanelInicio getPanelInicio() {
		return panelInicio;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases modificar 
	 * el PanelInicio
	 * 
	 * @pre el PanelInicio se encuentra por defecto con los valores establecidos en el constructor
	 * @post se cambia el PanelInicio anterior por el que se recibe por parametro
	 * 
	 * @param panelInicio es un objeto de tipo PanelInicio
	 */
	public void setPanelInicio(PanelInicio panelInicio) {
		this.panelInicio = panelInicio;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * al DialogNuevaPartida
	 * 
	 * @return dialogNuevaPartida es un objeto de tipo DialogNuevaPartida.
	 */
	public DialogNuevaPartida getDialogNuevaPartida() {
		return dialogNuevaPartida;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases modificar 
	 * el DialogNuevaPartida
	 * 
	 * @pre el DialogNuevaPartida se encuentra por defecto con los valores establecidos en el constructor
	 * @post se cambia el DialogNuevaPartida anterior por el que se recibe por parametro
	 * 
	 * @param dialogNuevaPartida es un objeto de tipo DialogNuevaPartida
	 */
	public void setDialogNuevaPartida(DialogNuevaPartida dialogNuevaPartida) {
		this.dialogNuevaPartida = dialogNuevaPartida;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * al Partido
	 * 
	 * @return amistoso es un objeto de tipo Partido.
	 */
	public Partido getPartida(){
		return juego.getJugador().getAmistoso();
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases modificar 
	 * el Torneo
	 * 
	 * @pre el Torneo se encuentra por defecto con los valores establecidos en el constructor
	 * @post se cambia el Torneo anterior por el que se recibe por parametro
	 * 
	 * @param t es un objeto de tipo Torneo
	 */
	public void setTorneo(Torneo t){
		juego.getJugador().setTorneo(t);
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * al Torneo
	 * 
	 * @return torneo es un objeto de tipo Torneo.
	 */
	public Torneo getTorneo(){
		return torneo;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * al Juego
	 * 
	 * @return juego es un objeto de tipo Juego.
	 */
	public Juego getJuego(){
		return juego;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases modificar 
	 * el Juego
	 * 
	 * @pre el Juego se encuentra por defecto con los valores establecidos en el constructor
	 * @post se cambia el Juego anterior por el que se recibe por parametro
	 * 
	 * @param j es un objeto de tipo Juego
	 */
	public void setJuego(Juego j){
		juego = j;
	}
	
	/**Este metodo se encarga de reiniciar el tiro a su estado inicial para poder continuar
	 * 
	 * @pre se realiza un tiro por el usuario y los valores de las variables se mantienen
	 * @post se vuelven las variables necesarias a su estado original para poder preparar 
	 * otro tiro
	 */
	public void Reiniciar(){
		juego.getJugador().getTorneo().getPartida().nextTiro();
	}
	
	/**Este metodo se encarga de hacer visible la clase DialogJuego, de inicializar la clase
	 * HiloCancha y de empezar a ejecutar el hilo
	 * 
	 * @pre dialogJuego == null, dialogJuego invisible, h==null 
	 * @post dialogJuego != null, dialogJuego visible, h!=null e inicio del HiloCancha
	 */
	public void start(){
		dialogJuego = new DialogJuego(this);
		dialogJuego.setVisible(true);
		h = new HiloCancha(dialogJuego.getPJ(), juego.getJugador().getTorneo().getPartida());
		h.start();
	}
	
	public static void main(String[] args) {
		VentanaPrincipal vP= new VentanaPrincipal();
		vP.setVisible(true);
	}
	
	public void amistoso()
	{
		dialogJuego = new DialogJuego(this);
		dialogJuego.setVisible(true);
		h = new HiloCancha(dialogJuego.getPJ(), juego.getJugador().getAmistoso());
		h.start();
	}
	
	public void mostrarMensaje(String msg)
	{
		JOptionPane.showMessageDialog(null, msg);
	}
	
	public VentanaRecords getVR()
	{
		return records;
	}
}
