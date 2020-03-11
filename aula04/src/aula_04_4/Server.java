package aula_04_4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {

	public static void main(String[] args) throws IOException {
		int porta = 9876;
		int numConn = 1;

		DatagramSocket serverSocket = new DatagramSocket(porta);

		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];

		while (true) {

			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			System.out.println("Esperando por datagrama UDP na porta " + porta);
			serverSocket.receive(receivePacket);
			System.out.print("Datagrama UDP [" + numConn + "] recebido...");

			String sentence = new String(receivePacket.getData());
			System.out.println(sentence);

			InetAddress IPAddress = receivePacket.getAddress();

			int port = receivePacket.getPort();

			String capitalizedSentence = sentence.toUpperCase();

			sendData = capitalizedSentence.getBytes();

			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);

			System.out.print("Enviando " + capitalizedSentence + "...");

			serverSocket.send(sendPacket);
			System.out.println("OK\n");
		}

	}
}
