package aula_03;

import java.util.ArrayList;

public class raizQuadrada {

	public static ArrayList<Double> quadrada = new ArrayList<Double>();
	
	public static void raizQuadrada01() {
		for(int cont = 1; cont<= 1000; cont++) {
			if(cont >= 1 && cont < 100) {
				if(cont%2 == 0) {
					quadrada.add(Math.cbrt(cont));
				}
			}
		}
		Repository.setNumeros(quadrada);
		Repository.print();
	}
	
}
