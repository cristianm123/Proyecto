package modelo;

import java.io.Serializable;

/**Entidad del modelo del mundo que representa los Clubes disponibles para jugar, hereda de la
 * clase Equipo
 * 
 * @author Alvaro Jose Escobar & Cristian Felipe Molina
 * @version 22/05/2018 Beta 1.0
 */
public class Club extends Equipo {

	/**Constructor para los objetos de tipo Club,inicializa los valores de las variables 
	 * 
	 * @param b de tipo String,es el nombre del Club, variable que hereda de la super clase Equipo
	 * @param ind de tipo int,es el indice del Club, variable que hereda de la super clase Equipo
	 */
	public Club(String b, int ind){
		super(b, ind);
	}
}
