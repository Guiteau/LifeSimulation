package dad.lifesimulation.main.utils;

public class Die {
	
	/**
	 * 
	 * @param start initial value
	 * @param end highest value
	 * @return a discret value (int value)
	 */

	public static int getDiscretValue(int start, int end) {
		
		int resultado = 0;
		
		resultado = start + (int)(Math.random() * ((end - start) + 1));		
		
		return resultado;
		
	}

}
