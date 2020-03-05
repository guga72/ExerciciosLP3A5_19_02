package aula_03_2;

public class Executor {

	public static void main(String[] args) {
		Pilha pilha = new Pilha();
		
		Runnable runnableConsumidor = new Consumer(pilha);
		Thread threadConsumidor = new Thread(runnableConsumidor);
		Runnable runnableProdutor = new Producer(pilha);
		Thread threadProdutor = new Thread(runnableProdutor);
		threadConsumidor.start();
		threadProdutor.start();
	}
}
