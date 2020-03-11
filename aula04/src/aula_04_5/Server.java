package aula_04_5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Server {
	
	public static void main(String[] args) throws IOException {
		int porta = 9876;
		int numConn = 1;

		DatagramSocket serverSocket = new DatagramSocket(porta);
		
		LinkedHashMap<Integer, InetAddress> informacoes = new LinkedHashMap<Integer, InetAddress>();

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
			
			informacoes.put(port, IPAddress);
			
			for(Map.Entry<Integer, InetAddress> tst : informacoes.entrySet()) {

			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, tst.getValue(), tst.getKey());

			System.out.print("Enviando " + capitalizedSentence + "...");

			serverSocket.send(sendPacket);
			}
			System.out.println("OK\n");
		}

	}
}
