package aula_04_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {

	public static void main(String args[]) throws Exception {

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

		DatagramSocket clientSocket = new DatagramSocket();

		String servidor = "localhost";
		int porta = 9876;

		InetAddress IPAddress = InetAddress.getByName(servidor);

		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];
		while (true) {
			System.out.println("Digite o texto a ser enviado ao servidor: ");
			String sentence = inFromUser.readLine();
			sendData = sentence.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, porta);

			System.out.println("Enviando pacote UDP para " + servidor + ":" + porta);
			clientSocket.send(sendPacket);

			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

			clientSocket.receive(receivePacket);
			System.out.println("Pacote UDP recebido...");

			String modifiedSentence = new String(receivePacket.getData());

			System.out.println("Texto recebido do servidor:" + modifiedSentence);
		}
	}
}
