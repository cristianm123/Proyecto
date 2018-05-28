package interfaz;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import hilo.HiloCancha;

/**Esta clase define objetos de tipo DialogJuego, hereda de JFrame
 * 
 * @author Alvaro Jose Escobar & Cristian Felipe Molina
 * @version 22/05/2018 Beta 1.0
 */
public class DialogJuego extends JFrame{

	/** Relacion con un objeto de tipo VentanaPrincipal
	 */
	private VentanaPrincipal vP;
	
	/** Relacion con un objeto de tipo PanelJuego
	 */
	private PanelJuego pj;

	/**Constructor para los objetos de tipo DialogJuego
	 * 
	 * @param vP es un objeto de tipo VentanaPrincipal
	 */
	public DialogJuego(VentanaPrincipal vP) {
		
		setLayout(new BorderLayout());
		setTitle(".: Juego :.");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.vP = vP;
		pj = new PanelJuego(vP);
		add(pj, BorderLayout.CENTER);
		setSize(1400, 675);
		pack();
		
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * al PanelJuego
	 * 
	 * @return pj es un objeto de tipo PanelJuego.
	 */
	public PanelJuego getPJ()
	{
		return pj;
	}
}