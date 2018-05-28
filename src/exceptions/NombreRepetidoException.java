package exceptions;

public class NombreRepetidoException extends Exception{
	
	public NombreRepetidoException()
	{
		super("El nombre ya está en uso.");
	}

}
