package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

/**Esta clase define objetos de tipo DialogFinJuego, hereda de JDialog e implementa 
 * la interface ActionListener
 * 
 * @author Alvaro Jose Escobar & Cristian Felipe Molina
 * @version 22/05/2018 Beta 1.0
 */
public class DialogFinJuego extends JDialog implements ActionListener{

	/**Atributo constante de tipo String GUARDAR
	 */
	public static final String GUARDAR="GUARDAR";
	
	/**Atributo constante de tipo String MENU
	 */
	public static final String MENU="MENU";
	
	/** Componente de tipo JButton btnGuardar
	 */
	private JButton btnGuardar;
	
	/** Componente de tipo JButton btnMenu
	 */
	private JButton btnMenu;

	/** Relacion con un objeto de tipo VentanaPrincipal
	 */
	private VentanaPrincipal vP;

	/**Constructor para los objetos de tipo DialogFinJuego
	 * 
	 * @param vP es un objeto de tipo VentanaPrincipal
	 */
	public DialogFinJuego(VentanaPrincipal vP) {
		
		setSize(400, 400);
		setVisible(false);
		setLayout(new BorderLayout());
		setTitle(".: Juego :.");
		setLocationRelativeTo(null);
		
		this.vP = vP;

		
//		ImageIcon guardar = new ImageIcon("");
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBackground(Color.WHITE);
		btnGuardar.setBorderPainted(false);
		btnGuardar.setActionCommand(GUARDAR);
		btnGuardar.addActionListener(this);
		add(btnGuardar);
		
//		ImageIcon menu = new ImageIcon("");
		btnMenu = new JButton("MENU");
		btnMenu.setBackground(Color.WHITE);
		btnMenu.setBorderPainted(false);
		btnMenu.setActionCommand(MENU);
		btnMenu.addActionListener(this);
		add(btnMenu);
		
	}

	/**Este metodo se encarga de procesar los eventos realizados por el usuario a traves de 
	 * los componentes disponibles en el panel para interactuar  
	 * 
	 * @pre no se ha realizado ningun evento sobre ningun componente por el usuario
	 * @post se obtiene la informacion del componente con el cual interactuo el usuario
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String comando = e.getActionCommand();
		
		if(comando.equals(GUARDAR)) {
			
		}
		if(comando.equals(MENU)) {
			
		}
	}
	
}