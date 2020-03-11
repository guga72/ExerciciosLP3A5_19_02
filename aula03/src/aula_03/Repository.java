package aula_03;

import java.util.ArrayList;

public class Repository {

	public static ArrayList<Double> numeros = new ArrayList<Double>();

	public synchronized static ArrayList<Double> getNumeros() {
		return numeros;
	}

	public synchronized static void setNumeros(ArrayList<Double> numeros) {
		Repository.numeros = numeros;
	}
	
	public static void print() {
		try {
			
			for(double number: numeros) {
				System.out.println(number);
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {}
		numeros.clear();
	}
}
