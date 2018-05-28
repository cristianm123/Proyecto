package modelo;

import java.awt.Rectangle;

/**Entidad del modelo del mundo que representa el Balon
 * 
 * @author Alvaro Jose Escobar & Cristian Felipe Molina
 * @version 22/05/2018 Beta 1.0
 */
public class Balon {

	/**Variable de tipo double x, representa la posicion en el eje X del Balon
	 */
	private double x;
	
	/**Variable de tipo double y, representa la posicion en el eje Y del Balon
	 */
	private double y;
	
	/**Variable de tipo double altura, representa la altura del Balon
	 */
	private double altura;
	
	/**Variable de tipo double ancho, representa el ancho del Balon
	 */
	private double ancho;
	
	/**Variable de tipo boolean tiro, indica si se tiro o no el Balon
	 */
	private boolean tiro;
	
	/**Variable de tipo double movsx, representa el movimiento del Balon en el eje X
	 */
	private double movsx = 0;
	
	/**Variable de tipo double movsy, representa el movimiento del Balon en el eje Y
	 */
	private double movsy = 0;
	
	/**Variable de tipo Rectangle areaBalon, representa el area del Balon
	 */
	private Rectangle areaBalon;

	public Balon() {
		super();
		this.altura = 80;
		this.ancho = 80;
		this.x = 650;
		this.y = 550;
		tiro = false;
		areaBalon = new Rectangle((int)x, (int)y, (int)ancho, (int)altura);
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * al atributo altura de la clase Balon
	 * 
	 * @return altura es un atributo de tipo double.
	 */
	public double getAltura() {
		return altura;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * al atributo ancho de la clase Balon
	 * 
	 * @return ancho es un atributo de tipo double.
	 */
	public double getAncho() {
		return ancho;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * al atributo x de la clase Balon
	 * 
	 * @return x es un atributo de tipo double.
	 */
	public double getX() {
		return x;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * al atributo y de la clase Balon
	 * 
	 * @return y es un atributo de tipo double.
	 */
	public double getY() {
		return y;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases modificar 
	 * el atributo altura de la clase Balon
	 * 
	 * @pre el altura se encuentra por defecto con los valores establecidos en el constructor
	 * @post se cambia el altura anterior por el que se recibe por parametro
	 * 
	 * @param altura es un atributo de tipo double
	 */
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases modificar 
	 * el atributo ancho de la clase Balon
	 * 
	 * @pre el ancho se encuentra por defecto con los valores establecidos en el constructor
	 * @post se cambia el ancho anterior por el que se recibe por parametro
	 * 
	 * @param ancho es un atributo de tipo double
	 */
	public void setAncho(double ancho) {
		this.ancho = ancho;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases modificar 
	 * el atributo x de la clase Balon
	 * 
	 * @pre el x se encuentra por defecto con los valores establecidos en el constructor
	 * @post se cambia el x anterior por el que se recibe por parametro
	 * 
	 * @param x es un atributo de tipo double
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases modificar 
	 * el atributo y de la clase Balon
	 * 
	 * @pre el y se encuentra por defecto con los valores establecidos en el constructor
	 * @post se cambia el y anterior por el que se recibe por parametro
	 * 
	 * @param y es un atributo de tipo double
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * al atributo areaBalon de la clase Balon
	 * 
	 * @return areaBalon es un atributo de tipo Rectangle.
	 */
	public Rectangle getAreaBalon(){
		return areaBalon;
	}
	
	/**Metodo que se encarga de modelar la trayectoria del Balon al hacer un Tiro
	 * 
	 * @pre el Balon se encuentra en su posicion original x = 650; y = 550;
	 * @post el Balon se desplaza desde la coordenada de origen hasta la coordenada final
	 * determinada por el usuario
	 * 
	 * @param int finx, representa la coordenada final en el eje X a donde debe dirigirse el Balon
	 * @param int finy, representa la coordenada final en el eje Y a donde debe dirigirse el Balon 
	 */
	public void moverBalon(int finx, int finy){
		if(!tiro){
			
			movsx = Math.abs((double)finx - this.x)/40;
			movsy = Math.abs((double)finy - this.y)/40;
			tiro = true;
			if(finx>x){
				movsx = -movsx;
			}
		}
		if(altura>35){
			x -= movsx;
			y -= movsy;
			altura -= 1;
			ancho -=1;
			areaBalon.setBounds((int)x, (int)y, (int)ancho, (int)altura);
		}
		else{
			if(y<450){
				y+=5;
			}
		}
	}
	
	/**Metodo que se encarga de modelar la trayectoria del Balon al rebotar ya sea porque 
	 * se intersecto con el arquero o con los limites de la cancha
	 * 
	 * @pre el Balon se encuentra en las coordenadas finales que determino el usuario
	 * @post al intersectarse con el arquero o con los limites de la cancha realiza un 
	 * movimiento de simula el rebote 
	 */
	public void rebotar(){
		if(y<600){
			x -= movsx;
			y -= movsy;
			altura += 1;
			ancho +=1;
		}
	}
}