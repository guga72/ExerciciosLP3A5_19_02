package aula_04_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		try {
			ServerSocket servidor = new ServerSocket(18981);
			System.out.println("Porta 18981 aberta!!!");
			while(true) {
				System.out.println("waiting for a client");
				Socket client = servidor.accept();
				System.out.println("Client from " + client.getLocalAddress()+ " connected");
				new Thread(new RunnableWorker(client, servidor)).start();
				BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				}

		}catch(Exception e) {
			System.out.println("Ocorreu um erro na conexão");
			e.printStackTrace();

		}
	}
}
