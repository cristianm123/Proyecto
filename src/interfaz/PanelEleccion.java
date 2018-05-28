package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import modelo.Equipo;

/**Esta clase define objetos de tipo PanelEleccion, hereda de JPanel 
 * 
 * @author Alvaro Jose Escobar & Cristian Felipe Molina
 * @version 22/05/2018 Beta 1.0
 */
public class PanelEleccion extends JPanel {

	private DialogNuevaPartida menu;
	private Equipo actual;
	
	/**Constructor para los objetos de tipo PanelEleccion
	 * 
	 */
	public PanelEleccion(DialogNuevaPartida m, Equipo a) {
		menu = m;
		actual = a;
	}
	
	/**Este metodo se encarga de pintar las graficas que se desean mostrar al usuario en
	 * el PanelEleccion
	 * 
	 * @pre el PanelEleccion se encuentra por defecto con los componentes inicializados en el constructor
	 * @post se pintan las grafias del fondo del PanelEleccion
	 * 
	 * @param g es un objeto de tipo Graphics
	 */
	public void paint(Graphics g)
	{
		ImageIcon i = new ImageIcon("data/"+actual.getNombre()+".png");
		i = new ImageIcon(i.getImage().getScaledInstance(400, 400, Image.SCALE_AREA_AVERAGING));
		g.drawImage(i.getImage(), 200, 100, null);
	}
	
	public void next()
	{
		actual = actual.getNext();
	}
	
	public void back()
	{
		actual = actual.getBack();
	}
	
	public void setActual(Equipo a)
	{
		actual = a;
	}

	public Equipo getActual()
	{
		return actual;
	}
	

}
