package ourExceptions;

public class NotInitializer extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2219901520754718346L;

	public NotInitializer(String message)
	{
		System.err.println(message);
	}

}
