package aula_03;

import java.util.ArrayList;

public class raizCubica {
   
public static ArrayList<Double> impares = new ArrayList<Double>();
	
	public static void raizCubica01() {
		for(int cont = 1; cont<= 1000; cont++) {
			if(cont >= 1 && cont < 100) {
				if(cont%2 != 0) {
					impares.add(Math.sqrt(cont));
				}
			}
		}
		Repository.setNumeros(impares);
		Repository.print();
	}
	
}
