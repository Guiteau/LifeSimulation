package dad.lifesimulation.main.utils;

import java.util.concurrent.atomic.AtomicBoolean;

public abstract class GameFunctions implements Runnable{
	protected AtomicBoolean exit;
	protected AtomicBoolean pause;
	protected final Object pauseLock = new Object();
	
	/**
	 * Constructor.
	 */

	public GameFunctions() {
		this.exit = new AtomicBoolean(false);
		this.pause = new AtomicBoolean(false);
		System.out.println("llamaste a super");
	}
	
	/**
	 * 
	 * @return if pause is true, false if not
	 */
	
	public boolean isPaused()
	{
		return this.pause.get();
	}
	
	/**
	 * If true the game stops if false continues
	 * 
	 * @param pause set the pause (true or false)
	 */
	
	public void toPause(boolean pause) {
		this.pause.set(pause);

		if (this.pause.get() == false)
			resume();
	}

	/**
	 * Recovers the game process
	 */
	
	private void resume() {
		synchronized (pauseLock) {
			pauseLock.notifyAll();
		}
	}
	
	/**
	 * If true the game ends
	 * 
	 * @param exit exit to set (boolean value)
	 */

	public void toExit(boolean exit) {
		this.exit.set(exit);
	}
}
