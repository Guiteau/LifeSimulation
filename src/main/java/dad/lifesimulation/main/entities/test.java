package dad.lifesimulation.main.entities;

import java.util.ArrayList;
import java.util.List;

import dad.lifesimulation.main.utils.Coordinates;

public class test {

	public static void main(String[] args) {
		int coordX =3; 
		int coordY =4;
		int range=2; //cambiar para comprobar distintos rangos
		int formula=2*range+1;
		int H=coordY+formula; // formula 2*n+1
		int W=coordX+formula; // formula 2*n+1
		List<Coordinates> aux = new ArrayList<Coordinates>();
		
		//funciona bien con un rango de 2 dimensiones o mas pero si el rango es de una dimension se deja por fuera
		//los ultimos valores
		System.out.println("generador de cordenadas");
		
			for (int x = coordX-range; x <=(W-coordX)+1; x++) {
				for (int y = coordY-range; y <= (H-coordY)+1; y++) {
						aux.add(new Coordinates(x, y));
				}
			}
			for (Coordinates a : aux) {
				System.out.println(a.toString());
			}
		
			
		

			
		}

	}


