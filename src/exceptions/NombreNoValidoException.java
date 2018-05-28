package exceptions;

/**Esta clase define objetos de tipo NombreNoValidoException y hereda de Exception
 * 
 * @author Alvaro Jose Escobar & Cristian Felipe Molina
 * @version 22/05/2018 Beta 1.0
 */
public class NombreNoValidoException extends Exception{

	/**Constructor para los objetos de tipo NombreNoValidoException.
	 * 
	 * @param String "Nombre no válido", mensaje de error al usuario
	 */
	
	public NombreNoValidoException() {
		super("Nombre no válido");
	}
}