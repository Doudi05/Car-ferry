/**
 * @author Roux-Akel
 *
 */
public class LengthException extends Exception{
	public LengthException(){
		super();
	}

	/**
	 * genere une exception avec un message personalisé
	 */
	public LengthException(String message){
		super(message);
	}
}