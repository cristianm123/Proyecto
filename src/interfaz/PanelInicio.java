package interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**Esta clase define objetos de tipo PanelInicio, hereda de JPanel e implementa 
 * la interface ActionListener
 * 
 * @author Alvaro Jose Escobar & Cristian Felipe Molina
 * @version 22/05/2018 Beta 1.0
 */
public class PanelInicio extends JPanel implements ActionListener{
	/**Atributo constante de tipo String NUEVA_PARTIDA
	 */
	public static final String NUEVA_PARTIDA="NUEVAPARTIDA";
	
	/**Atributo constante de tipo String CARGAR
	 */
	public static final String CARGAR="CARGAR";
	
	/**Atributo constante de tipo String RECORDS
	 */
	public static final String RECORDS="RECORDS";
	
	/**Atributo constante de tipo String OPCIONES
	 */
	public static final String OPCIONES="OPCIONES";
	
	/**Atributo constante de tipo String SALIR
	 */
	public static final String SALIR="SALIR";

	/** Componente de tipo JButton btnNuevaPartida
	 */
	private JButton btnNuevaPartida;
	
	/** Componente de tipo JButton btnCargar
	 */
	private JButton btnCargar;
	
	/** Componente de tipo JButton btnRecords
	 */
	private JButton btnRecords;
	
	/** Componente de tipo JButton btnOpciones
	 */
	private JButton btnOpciones;
	
	/** Componente de tipo JButton btnSalir
	 */
	private JButton btnSalir;
	
	/** Relacion con un objeto de tipo VentanaPrincipal
	 */
	private VentanaPrincipal vP;
	
	/**Constructor para los objetos de tipo PanelInicio
	 * 
	 * @param vP es un objeto de tipo VentanaPrincipal
	 */
	public PanelInicio(VentanaPrincipal vP) {
		
		setSize(400,400);
		setLayout(new GridLayout(5,1));
		setBackground(Color.WHITE);
		setVisible(true);
			
		this.vP = vP;
		
		ImageIcon nuevaPartida = new ImageIcon("data/nueva-partida.png");
		btnNuevaPartida = new JButton(nuevaPartida);
		btnNuevaPartida.setBorderPainted(false);
		btnNuevaPartida.setActionCommand(NUEVA_PARTIDA);
		btnNuevaPartida.addActionListener(this);
		btnNuevaPartida.setOpaque(false);
		add(btnNuevaPartida);
		
		ImageIcon cargar = new ImageIcon("data/cargar.png");
		btnCargar = new JButton(cargar);
		btnCargar.setBorderPainted(false);
		btnCargar.setActionCommand(CARGAR);
		btnCargar.addActionListener(this);
		btnCargar.setBorder(null);
		//btnCargar.setContentAreaFilled(false);
		add(btnCargar);
		
		ImageIcon records = new ImageIcon("data/records.png");
		btnRecords = new JButton(records);
		btnRecords.setBackground(Color.WHITE);
		btnRecords.setBorderPainted(false);
		btnRecords.setActionCommand(RECORDS);
		btnRecords.addActionListener(this);
		add(btnRecords);
		
		ImageIcon opciones = new ImageIcon("data/opciones.png");
		btnOpciones = new JButton(opciones);
		btnOpciones.setBackground(Color.WHITE);
		btnOpciones.setBorderPainted(false);
		btnOpciones.setActionCommand(OPCIONES);
		btnOpciones.addActionListener(this);
		add(btnOpciones);
		
		ImageIcon salir = new ImageIcon("data/salir.png");
		btnSalir = new JButton(salir);
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBorderPainted(false);
		btnSalir.setActionCommand(SALIR);
		btnSalir.addActionListener(this);
		add(btnSalir);
		repaint();

	}

	/**Este metodo se encarga de pintar las graficas que se desean mostrar al usuario en
	 * el PanelInicio
	 * 
	 * @pre el PanelInicio se encuentra por defecto con los componentes inicializados en el constructor
	 * @post se pintan las grafias del fondo del PanelInicio
	 * 
	 * @param g es un objeto de tipo Graphics
	 */
	public void paint( Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		ImageIcon fondo = new ImageIcon("data/fondo2.jpg");
	
		g2.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight() , this);
		
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
		
		if(comando.equals(NUEVA_PARTIDA)) {
			vP.getDialogNuevaPartida().setVisible(true);
			vP.setVisible(false);
		}
		if(comando.equals(CARGAR)) {
			String opcion = (String)JOptionPane.showInputDialog(null, "Seleccione la partida que desea cargar", "Cargar partida", JOptionPane.PLAIN_MESSAGE, null, vP.getJuego().getUsers(), 0);
			if(opcion == null)
			{
				System.exit(0);
			}
			vP.getJuego().cargarPartida(opcion);
		}
		if(comando.equals(RECORDS)) {
			vP.getVR().setVisible(true);
		}
		if(comando.equals(OPCIONES)) {
			
		}
		if(comando.equals(SALIR)) {

		}
	}
	
}
