package modelo;

import java.io.Serializable;

/**Entidad del modelo del mundo que representa las Selecciones disponibles para jugar, hereda de la
 * clase Equipo
 * 
 * @author Alvaro Jose Escobar & Cristian Felipe Molina
 * @version 22/05/2018 Beta 1.0
 */
public class Seleccion extends Equipo {

	/**Constructor para los objetos de tipo Seleccion,inicializa los valores de las variables 
	 * 
	 * @param nom de tipo String,es el nombre de la Seleccion, variable que hereda de la super clase Equipo
	 * @param in de tipo int,es el indice de la Seleccion, variable que hereda de la super clase Equipo
	 */
	public Seleccion(String nom, int in) {
		super(nom, in);
	}
}
