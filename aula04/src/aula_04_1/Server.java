package aula_04_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.Map;

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

		}
	}
}
