package dad.lifesimulation.main.utils;


import dad.lifesimulation.main.draw.DrawableFactory;

public class GUIGame extends GameFunctions {

	DrawableFactory levelGUI_creator;

	public GUIGame(DrawableFactory levelGUI_creator) {
		this.levelGUI_creator = levelGUI_creator;
		
	}

	@Override
	public void run() {
		System.out.println("...Estoy imprimiendo por pantalla");
		synchronized (pauseLock) {
			while (!exit.get()) {
				
				levelGUI_creator.render();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					if (pause.get()) {
						synchronized (pauseLock) {
							System.out.println("Pausé el reenderizado");
							pauseLock.wait();
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("...Terminé de imprimir por pantalla");
	}

	

}
