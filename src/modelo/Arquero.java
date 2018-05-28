package modelo;

/**Entidad del modelo del mundo que representa al Arquero
 * 
 * @author Alvaro Jose Escobar & Cristian Felipe Molina
 * @version 22/05/2018 Beta 1.0
 */
public class Arquero {
	
	/**Variable de tipo double x, representa la posicion en el eje X del Arquero
	 */
	private double x;
	
	/**Variable de tipo double y, representa la posicion en el eje Y del Arquero
	 */
	private double y;
	
	/**Variable de tipo double altura, representa la altura del Arquero
	 */
	private double altura;
	
	/**Variable de tipo double ancho, representa el ancho del Arquero
	 */
	private double ancho;
	
	/**Variable de tipo int angulo, representa el angulo de rotacion del Arquero
	 */
	private int angulo;
	
	/**Variable de tipo int finx, representa la posicion final en el eje X del Arquero 
	 * al atajar un Tiro
	 */
	private int finx;
	
	/**Variable de tipo int finy, representa la posicion final en el eje Y del Arquero 
	 * al atajar un Tiro
	 */
	private int finy;

	/**Constructor para los objetos de tipo Arquero,inicializa los valores de las variables 
	 */
	public Arquero() {
		angulo = 0;
		x = 605;
		y = 275;
		altura = 230;
		ancho = 180;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * al atributo angulo de la clase Arquero
	 * 
	 * @return angulo es un atributo de tipo int.
	 */
	public int getAngulo() {
		return angulo;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases modificar 
	 * el atributo angulo de la clase Arquero
	 * 
	 * @pre el angulo se encuentra por defecto con los valores establecidos en el constructor
	 * @post se cambia el angulo anterior por el que se recibe por parametro
	 * 
	 * @param angulo es un atributo de tipo int
	 */
	public void setAngulo(int angulo) {
		this.angulo = angulo;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * al atributo finx de la clase Arquero
	 * 
	 * @return finx es un atributo de tipo int.
	 */
	public int getFinx() {
		return finx;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * al atributo finy de la clase Arquero
	 * 
	 * @return finy es un atributo de tipo int.
	 */
	public int getFiny() {
		return finy;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases modificar 
	 * el atributo finx angulo de la clase Arquero
	 * 
	 * @pre el finx se encuentra por defecto con los valores establecidos en el constructor
	 * @post se cambia el finx anterior por el que se recibe por parametro
	 * 
	 * @param finx es un atributo de tipo int
	 */
	public void setFinx(int finx) {
		this.finx = finx;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases modificar 
	 * el atributo finy angulo de la clase Arquero
	 * 
	 * @pre el finy se encuentra por defecto con los valores establecidos en el constructor
	 * @post se cambia el finy anterior por el que se recibe por parametro
	 * 
	 * @param finy es un atributo de tipo int
	 */
	public void setFiny(int finy) {
		this.finy = finy;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * al atributo x de la clase Arquero
	 * 
	 * @return x es un atributo de tipo double.
	 */
	public double getX() {
		return x;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * al atributo y de la clase Arquero
	 * 
	 * @return y es un atributo de tipo double.
	 */
	public double getY() {
		return y;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * al atributo altura de la clase Arquero
	 * 
	 * @return altura es un atributo de tipo double.
	 */
	public double getAltura() {
		return altura;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * al atributo ancho de la clase Arquero
	 * 
	 * @return ancho es un atributo de tipo double.
	 */
	public double getAncho() {
		return ancho;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases modificar 
	 * el atributo x de la clase Arquero
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
	 * el atributo y de la clase Arquero
	 * 
	 * @pre el y se encuentra por defecto con los valores establecidos en el constructor
	 * @post se cambia el y anterior por el que se recibe por parametro
	 * 
	 * @param y es un atributo de tipo double
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases modificar 
	 * el atributo altura de la clase Arquero
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
	 * el atributo ancho de la clase Arquero
	 * 
	 * @pre el ancho se encuentra por defecto con los valores establecidos en el constructor
	 * @post se cambia el ancho anterior por el que se recibe por parametro
	 * 
	 * @param ancho es un atributo de tipo double
	 */
	public void setAncho(double ancho) {
		this.ancho = ancho;
	}
	
	/**Metodo que se encarga de modelar la trayectoria del Arquero al atajar un Tiro
	 * 
	 * @post dependiendo del lado que ingrese por parametro el arquero realizara un 
	 * desplazamiento en forma de parabola que permitira modelar su trayectoria
	 * 
	 * @param int lado, representa loa zona en la que el arquero atajara el Balon
	 */
	public void tirarArquero(int lado){
		
		if(angulo<90&&angulo>-90&&lado==0){
			angulo-=3;
			x-=10;
			y-= (angulo/3)*Math.sin(Math.toRadians(4*angulo));
			finx = 600;
			finy = 600;
			altura-=1.67;
			ancho+=1.67;
		}
		else if(angulo<90&&angulo>-90&&lado==1){
			angulo+=3;
			x+=10;
			y-= (angulo/3)*Math.sin(Math.toRadians(4*angulo));
			
			finx = 800;
			finy = 600;
			altura-=1.67;
			ancho+=1.67;
		}
	}
	
	/**Metodo que se encarga de decidir si el Arquero puede o no atajar el Balon
	 * 
	 * @pre el Balon y el Arquero terminan sus respectivos desplazamientos 
	 * @post se comparan las coordenas finales de ambos objetos para decidir si el arquero tapo
	 * o no el balon 
	 * 
	 * @param Balon b, es un objeto de tipo Balon
	 * 
	 * @return boolean ret, variable que indica si el Arquero tapo o no el Balon 
	 */
	public boolean taparBalon(Balon b){
		boolean ret = false;
		if(b.getX()>=x&&b.getX()<=(x+ancho)&&b.getY()>=y&&b.getY()<=(y+altura)&&b.getAltura()>=45&&b.getAltura()<=55){
			ret = true;
		}
		return ret;
	}
}
