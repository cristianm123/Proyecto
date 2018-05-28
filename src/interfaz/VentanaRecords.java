package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaRecords extends JFrame implements ActionListener{

	/**Atributo constante de tipo String NOMBRE
	 */
	public static final String NOMBRE="NOMBRE";
	
	/**Atributo constante de tipo String TROFEOS
	 */
	public static final String TROFEOS="TROFEOS";
	
	/**Atributo constante de tipo String VICTORIAS
	 */
	public static final String VICTORIAS="VICTORIAS";

	/** Componente de tipo JPanel panel
	 */
	private JPanel panel;
	
	/** Componente de tipo JButton nombre, trofeos, victorias;
	 */
	private JButton nombre, trofeos, victorias, buscar;
	
	/**Arreglo de Strings records
	 */
	private String[] records;
	
	/** Relacion con un objeto de tipo VentanaPrincipal
	 */
	private VentanaPrincipal vP;
	
	private JTextField campo;
	
	/**Constructor para los objetos de tipo PanelInicio
	 * 
	 * @param vP es un objeto de tipo VentanaPrincipal
	 * @param records es un arreglo de Strings
	 */
	public VentanaRecords(String[] records, VentanaPrincipal vP){
		
		this.vP = vP;
		this.records = records;
		campo = new JTextField();
		buscar = new JButton("Buscar victorias");
		buscar.addActionListener(this);
		buscar.setActionCommand("buscar");
		setSize(new Dimension(600, 600));
		setLayout(new BorderLayout());
		
		panel = new JPanel();
		panel.setSize(new Dimension(600, 600));
		panel.setLayout(new GridLayout(records.length, 1));
		
		JPanel c = new JPanel();
		c.setLayout(new GridLayout(2, 3));
		
		nombre = new JButton("Ordenar por nombre");
		nombre.addActionListener(this);
		nombre.setActionCommand(NOMBRE);
		c.add(nombre);

		trofeos = new JButton("Ordenar por trofeos");
		trofeos.addActionListener(this);
		trofeos.setActionCommand(TROFEOS);
		c.add(trofeos);

		victorias = new JButton("Ordenar por victorias");
		victorias.addActionListener(this);
		victorias.setActionCommand(VICTORIAS);
		c.add(victorias);
		c.add(campo);
		c.add(buscar);
		add(c, BorderLayout.SOUTH);
		
		add(panel, BorderLayout.CENTER);
		
		
		pintar();

	}
	
	/**Este metodo se encarga de pintar en el panel la informacion sobre los records de los 
	 * usuarios 
	 * 
	 * @pre el panel se encuentra vacio records!=null
	 * @post se muestra la informacion de los records en el panel usando componentes de tipo 
	 * JLabel
	 */
	public void pintar(){
		panel.removeAll();
		for (int i = 0; i < records.length; i++) {
			JLabel j = new JLabel(records[i]);
			j.setMinimumSize(new Dimension(100, 50));
			j.setHorizontalAlignment(JLabel.CENTER);
			j.setVerticalAlignment(JLabel.CENTER);
			panel.add(j);
		}
	}
	
	/**Este metodo se encarga de procesar los eventos realizados por el usuario a traves de 
	 * los componentes disponibles en el panel para interactuar  
	 * 
	 * @pre no se ha realizado ningun evento sobre ningun componente por el usuario
	 * @post se obtiene la informacion del componente con el cual interactuo el usuario
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(NOMBRE)){
			vP.getJuego().ordenarAlfabeto();
			records = vP.getJuego().getDatos();
			pintar();
		}
		else if(e.getActionCommand().equals(TROFEOS)){
			vP.getJuego().ordenarTrofeos();
			records = vP.getJuego().getDatos();
			pintar();
		}
		else if(e.getActionCommand().equals(VICTORIAS)){
			vP.getJuego().ordenarVictorias();
			records = vP.getJuego().getDatos();
			pintar();
		}
		else if(e.getActionCommand().equals("buscar"))
		{
			JOptionPane.showMessageDialog(null, vP.getJuego().busquedaVictorias(Integer.parseInt(campo.getText())));
		}
		pack();
		setSize(new Dimension(600, 600));
	}
}
