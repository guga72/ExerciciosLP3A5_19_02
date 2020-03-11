package aula_04_1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String args[]) {
		try (ServerSocket server = new ServerSocket(18981)) {
			while (true) {
			System.out.println("Server waiting for client.");
			Socket client = server.accept(); // blocks
			System.out.println("Client from " + client.getLocalAddress() + " connected.");
			new Thread(new RunnableWorker(client, server)).start();
		}
			} catch (IOException e) {

			// em caso de erro
			System.out.println("Ocorreu um erro na conexão");
			e.printStackTrace();
		}
	}
}
