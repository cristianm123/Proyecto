package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import exceptions.NombreNoValidoException;
import exceptions.NombreRepetidoException;
import modelo.Club;
import modelo.Juego;
import modelo.Jugador;
import modelo.Partido;
import modelo.Torneo;

/**Esta clase define objetos de tipo DialogNuevaPartida, hereda de JDialog e implementa 
 * la interface ActionListener 
 * 
 * @author Alvaro Jose Escobar & Cristian Felipe Molina
 * @version 22/05/2018 Beta 1.0
 */
public class DialogNuevaPartida extends JDialog implements ActionListener {
	
	/**Atributo constante de tipo String SELECCION
	 */
	public static final String SELECCION="SELECCION";
	
	/**Atributo constante de tipo String CLUB
	 */
	public static final String CLUB="CLUB";
	
	/**Atributo constante de tipo String SIGUIENTE
	 */
	public static final String SIGUIENTE="SIGUIENTE";
	
	/**Atributo constante de tipo String ANTERIOR
	 */
	public static final String ANTERIOR="ANTERIOR";

	/**Atributo constante de tipo String TORNEO
	 */
	public static final String TORNEO="TORNEO";
	
	/**Atributo constante de tipo String AMISTOSO
	 */
	public static final String AMISTOSO="AMISTOSO";
	
	/**Atributo constante de tipo String ATRAS
	 */
	public static final String ATRAS="ATRAS";
	
	/**Atributo constante de tipo String CONTINUAR
	 */
	public static final String CONTINUAR="CONTINUAR";

	/** Componente de tipo JCheckBox cbTorneo
	 */
	private JCheckBox cbTorneo;
	
	/** Componente de tipo JCheckBox cbAmistoso
	 */
	private JCheckBox cbAmistoso;
	
	/** Componente de tipo JButton btnAtras
	 */
	private JButton btnAtras;
	
	/** Componentes de tipo JButton btnContinuar, siguiente, anterior
	 */
	private JButton btnContinuar, siguiente, anterior;
	
	/** Componente de tipo JTextField tfNickName
	 */
	private JTextField tfNickName;
	
	/** Componentes de tipo JCheckBox sele, club
	 */
	private JCheckBox cbSeleccion, cbClub;
	
	/** Relacion con un objeto de tipo PanelEleccion
	 */
	private PanelEleccion eleccion;

	/** Relacion con un objeto de tipo VentanaPrincipal
	 */
	private VentanaPrincipal vP;
	
	/**Constructor para los objetos de tipo DialogNuevaPartida
	 * 
	 * @param vP es un objeto de tipo VentanaPrincipal
	 */
	public DialogNuevaPartida(VentanaPrincipal vP) {
		
		setSize(1000, 800);
		setVisible(false);
		setLayout(new BorderLayout());
		setTitle(".: Nueva Partida :.");
		setLocationRelativeTo(null);
		
		this.vP =vP;
		
		JPanel tipoPartida = new JPanel();
		tipoPartida.setLayout(new GridLayout(2,2));
		add(tipoPartida,BorderLayout.NORTH);
	
		JLabel labNickName = new JLabel("NICK NAME: ");
		tipoPartida.add(labNickName);
		
		tfNickName = new JTextField();
		tipoPartida.add(tfNickName);
		
		cbTorneo = new JCheckBox("Torneo");
		cbTorneo.addActionListener(this);
		cbTorneo.setActionCommand(TORNEO);
		tipoPartida.add(cbTorneo);
		cbTorneo.setSelected(true);
		
		cbAmistoso = new JCheckBox("Amistoso");
		cbAmistoso.addActionListener(this);
		cbAmistoso.setActionCommand(AMISTOSO);
		tipoPartida.add(cbAmistoso);
		
		JPanel seleccionEquipo = new JPanel();
		seleccionEquipo.setLayout(new BorderLayout());
		add(seleccionEquipo,BorderLayout.CENTER);
		
		// Panel auxiliar para los CheckBox
		
		JPanel auxiliar = new JPanel();
		auxiliar.setLayout(new GridLayout(1,  2));
		
		cbSeleccion = new JCheckBox("Seleccion");
		cbSeleccion.addActionListener(this);
		cbSeleccion.setActionCommand(SELECCION);
		auxiliar.add(cbSeleccion);
		
		cbClub = new JCheckBox("Club");
		cbClub.addActionListener(this);
		cbClub.setActionCommand(CLUB);
		cbClub.setSelected(true);
		auxiliar.add(cbClub);
		
		seleccionEquipo.add(auxiliar, BorderLayout.NORTH);
		
		siguiente = new JButton("Siguiente");
		siguiente.addActionListener(this);
		siguiente.setActionCommand(SIGUIENTE);
		seleccionEquipo.add(siguiente, BorderLayout.EAST);
		
		anterior = new JButton("Anterior");
		anterior.addActionListener(this);
		anterior.setActionCommand(ANTERIOR);
		seleccionEquipo.add(anterior, BorderLayout.WEST);
		
		eleccion = new PanelEleccion(this, vP.getTorneo().getPrimero());
		seleccionEquipo.add(eleccion, BorderLayout.CENTER);
		eleccion.repaint();

		//Botones con nombres de equipos
		
		JPanel opciones = new JPanel();
		opciones.setLayout(new GridLayout(1,2));
		add(opciones,BorderLayout.SOUTH);
		
		ImageIcon atras = new ImageIcon("data/atras.png");
		btnAtras = new JButton(atras);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBorderPainted(false);
		btnAtras.setActionCommand(ATRAS);
		btnAtras.addActionListener(this);
		opciones.add(btnAtras);
		
		ImageIcon continuar = new ImageIcon("data/continuar.png");
		btnContinuar = new JButton(continuar);
		btnContinuar.setBackground(Color.WHITE);
		btnContinuar.setBorderPainted(false);
		btnContinuar.setActionCommand(CONTINUAR);
		btnContinuar.addActionListener(this);
		opciones.add(btnContinuar);
		
		
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * a la VentanaPrincipal
	 * 
	 * @return vP es un objeto de tipo VentanaPrincipal.
	 */
	public VentanaPrincipal getV(){
		return vP;
	}
	
	/**Este metodo se encarga de procesar los eventos realizados por el usuario a traves de 
	 * los componentes disponibles en el panel para interactuar  
	 * 
	 * @pre no se ha realizado ningun evento sobre ningun componente por el usuario
	 * @post se obtiene la informacion del componente con el cual interactuo el usuario
	 */
	@Override
	public void actionPerformed(ActionEvent e){
		
		String comando = e.getActionCommand();
		
		if(comando.equals(TORNEO)&&cbTorneo.isSelected()) {
			cbAmistoso.setSelected(false);
			
		}
		if(comando.equals(AMISTOSO)&&cbAmistoso.isSelected()) {
			cbTorneo.setSelected(false);
			
		}
		if(comando.equals(ATRAS)) {
			this.setVisible(false);
			vP.setVisible(true);
		}
		if(comando.equals(CONTINUAR)) {
			try {
				if(tfNickName.getText().equals("")){
					throw new NombreNoValidoException();
				}
				if(vP.getJuego().estaRepetido(tfNickName.getText()))
				{
					throw new NombreRepetidoException();
				}
				if(vP.getJuego().getJugador()==null)
				{	
					vP.getJuego().setJugador(new Jugador(vP.getTorneo(), tfNickName.getText()));;
				}
				else
				{
					vP.getJuego().getJugador().setTorneo(new Torneo(vP.getJuego()));
					vP.setTorneo(vP.getJuego().getJugador().getTorneo());
				}
				if(cbTorneo.isSelected())
				{
					this.setVisible(false);
					vP.getJuego().getJugador().getTorneo().setJugador(eleccion.getActual().getIndex());
					if(cbClub.isSelected()){
						vP.getJuego().getJugador().getTorneo().iniciarArbol(0);
					}
					else{
						vP.getJuego().getJugador().getTorneo().iniciarArbol(1);
					}
					vP.getJuego().guardarJuego();
					vP.getJuego().getJugador().getTorneo().jugarPartido();
					vP.start();
				}
				else
				{
					vP.getJuego().getJugador().setAmistoso(new Partido(vP.getTorneo().buscar(eleccion.getActual().getIndex()), vP.getTorneo().buscar((int)(Math.random()*7)+1), vP.getTorneo(), Partido.LOCAL));
					vP.amistoso();
				}
				
				} catch (NombreNoValidoException e1) {
					vP.mostrarMensaje(e1.getMessage());
				} catch (NombreRepetidoException e1) {
				vP.mostrarMensaje(e1.getMessage());
				}
			}
		
		if(comando.equals(SIGUIENTE))
		{
			eleccion.next();
			eleccion.repaint();
			repaint();
		}
		if(comando.equals(ANTERIOR))
		{
			eleccion.back();
			eleccion.repaint();
			repaint();
		}
		if(comando.equals(SELECCION) && cbSeleccion.isSelected()) {
			cbClub.setSelected(false);
			eleccion.setActual(vP.getTorneo().getPrimera());
			eleccion.repaint();
			repaint();
		}
		else if(comando.equals(CLUB) && cbClub.isSelected()) {
			cbSeleccion.setSelected(false);
			eleccion.setActual(vP.getTorneo().getPrimero());
			eleccion.repaint();
			repaint();
		}
	}
	
}