package ourExceptions;

public class NotColorOrImageChosen extends Exception{

	private static final long serialVersionUID = 2671037011145662673L;
	
	/**
	 * Constructor.
	 * @param message String to be printed via stdout
	 */
	
	public NotColorOrImageChosen(String message)
	{
		System.err.println(message);
	}

}
