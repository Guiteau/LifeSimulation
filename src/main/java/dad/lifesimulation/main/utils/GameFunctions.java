package dad.lifesimulation.main.utils;

import java.util.concurrent.atomic.AtomicBoolean;

public abstract class GameFunctions implements Runnable{
	protected AtomicBoolean exit;
	protected AtomicBoolean pause;
	protected final Object pauseLock = new Object();

	public GameFunctions() {
		this.exit = new AtomicBoolean(false);
		this.pause = new AtomicBoolean(false);
		System.out.println("llamaste a super");
	}
	
	public boolean isPaused()
	{
		return this.pause.get();
	}
	
	public void toPause(boolean pause) {
		this.pause.set(pause);

		if (this.pause.get() == false)
			resume();
	}

	private void resume() {
		synchronized (pauseLock) {
			pauseLock.notifyAll();
		}
	}

	public void toExit(boolean exit) {
		this.exit.set(exit);
	}
}
