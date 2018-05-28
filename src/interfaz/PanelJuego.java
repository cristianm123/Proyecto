package interfaz;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import exceptions.YaDisparoException;
import modelo.Tiro;

/**Esta clase define objetos de tipo PanelJuego, hereda de JPanel e implementa 
 * la interface MouseListener
 * 
 * @author Alvaro Jose Escobar & Cristian Felipe Molina
 * @version 22/05/2018 Beta 1.0
 */
public class PanelJuego extends JPanel implements MouseListener{
	
	/** Relacion con un objeto de tipo VentanaPrincipal
	 */
	private VentanaPrincipal v;
	
	/**Constructor para los objetos de tipo PanelJuego
	 * 
	 * @param v es un objeto de tipo VentanaPrincipal
	 */
	public PanelJuego(VentanaPrincipal v){
		setPreferredSize(new Dimension(1400, 675));
		
		this.v = v;
		repaint();
		addMouseListener(this);
	}
	
	/**Este metodo se encarga de pintar las graficas que se desean mostrar al usuario en
	 * el PanelJuego
	 * 
	 * @pre el PanelJuego se encuentra por defecto con los componentes inicializados en el constructor
	 * @post se pintan las grafias del fondo del PanelJuego
	 * 
	 * @param g es un objeto de tipo Graphics
	 */
	@Override
	public void paint(Graphics g){ 
		
		Tiro p = v.getJuego().getJugador().getTorneo().getPartida().getTiro();
		ImageIcon fondo = new ImageIcon("data/FondoPro5.jpg" );
		fondo = new ImageIcon(fondo.getImage().getScaledInstance(1400, 675, Image.SCALE_AREA_AVERAGING));
		g.drawImage(fondo.getImage(), 0, 0, null);
		ImageIcon balon = new ImageIcon("data/balon.png" );
		balon = new ImageIcon(balon.getImage().getScaledInstance((int)p.getBalon().getAltura(), (int)p.getBalon().getAncho(), Image.SCALE_AREA_AVERAGING));
		g.drawImage(balon.getImage(), (int)p.getBalon().getX(), (int)p.getBalon().getY(), null);
		ImageIcon arquero = new ImageIcon("data/arquero.png");
		arquero = new ImageIcon(arquero.getImage().getScaledInstance(250, 250, Image.SCALE_AREA_AVERAGING));
		ImageIcon local = new ImageIcon("data/"+v.getJuego().getJugador().getTorneo().getPartida().getLocal().getNombre()+".png");
		local = new ImageIcon(local.getImage().getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING));
		g.drawImage(local.getImage(), 30, 30, null);
		ImageIcon visitante = new ImageIcon("data/"+v.getJuego().getJugador().getTorneo().getPartida().getVisitante().getNombre()+".png");
		visitante = new ImageIcon(visitante.getImage().getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING));
		g.drawImage(visitante.getImage(), 1200, 30, null);
		
		Graphics2D g2 = (Graphics2D)g;
		g2.rotate(Math.toRadians(p.getArquero().getAngulo()), p.getArquero().getFinx(), p.getArquero().getFiny());
		g2.drawImage(arquero.getImage(), 575, 275, null);
		
	}
	
	/**Este metodo se encarga de seleccionar las graficas del marcador que se desean 
	 * mostrar al usuario en el PanelJuego 
	 * 
	 * @pre el marcador se encuentra por defecto o sin actualizar
	 * @post actualiza el marcador despues de que se realiza un tiro 
	 * 
	 * @param favor,es un arreglo de boolean que contiene los goles hechos a favor 
	 * @param contra,es un arreglo de boolean que contiene los goles hechos en contra 
	 */
	public void marcador(Boolean[] favor, Boolean[] contra){
		Graphics g = getGraphics();
		int c = 400;
		for (int i = 0; i < favor.length; i++) {
			if(favor[i]){
				g.drawImage(new ImageIcon("data/scored.png").getImage(), c, 40, null);
			}
			else{
				g.drawImage(new ImageIcon("data/missed.png").getImage(), c, 40, null);
			}
			c+=60;
		}
		c = 400;
		for (int j = 0; j < contra.length; j++) {
			if(contra[j]){
				g.drawImage(new ImageIcon("data/scored.png").getImage(), c, 100, null);
			}
			else{
				g.drawImage(new ImageIcon("data/missed.png").getImage(), c, 100, null);
			}
			c+=60;
		}
	}
	
	public void pintarVictoria(){
		Graphics g = getGraphics();
		g.drawImage(new ImageIcon("data/win.png").getImage(), 300, 300, null);
	}
	
	public void pintarDerrota(){
		Graphics g = getGraphics();
		g.drawImage(new ImageIcon("data/lose.png").getImage(), 300, 200, null);
	}

	/**Este metodo se encarga de procesar los eventos realizados por el usuario a traves del 
	 * mouse 
	 * 
	 * @pre no se ha realizado ningun evento de tipo Click por el usuario
	 * @post se obtienen las coordenadas del Click realizado por el usuario para realizar el tiro
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if(!v.getJuego().getJugador().getTorneo().getPartida().getShoot()){
			v.getJuego().getJugador().getTorneo().getPartida().getTiro().lanzo(e.getX(), e.getY());
			v.getJuego().getJugador().getTorneo().getPartida().setShoot(true);
		}
		else
		{
			try {
				throw new YaDisparoException();
			} catch (YaDisparoException e1) {
				// TODO Auto-generated catch block
				v.mostrarMensaje(e1.getMessage());
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
