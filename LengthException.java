/**
 * @author Roux-Akel
 *
 */
public class LengthException extends Exception{
	public LengthException(){
		super();
	}

	/**
	 * @param message d'erreur
	 */
	public LengthException(String message){
		super(message);
	}
}