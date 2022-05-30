/**
 * @author Roux-Akel
 */
public class WeightException extends Exception{
	public WeightException(){
		super();
	}

	/**
	 * Genere une WeightException avec un message personalisé
	 */
	public WeightException(String message){
		super(message);
	}
}