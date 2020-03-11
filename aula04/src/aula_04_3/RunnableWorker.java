package aula_04_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class RunnableWorker implements Runnable{

	private Socket client;
	private ServerSocket server;
	public RunnableWorker(Socket client, ServerSocket server) {
	this.client = client;
	this.server = server;
	}
	
	@Override 
	public void run() {
	try (BufferedReader in =
	new BufferedReader(new InputStreamReader(client.getInputStream()));
	PrintWriter out =
	new PrintWriter(new OutputStreamWriter(client.getOutputStream()))) {
	// processamento da comunica��o com o cliente
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Client thread for socket "+client.getLocalAddress()+" is DONE!");
	}

}
