import java.io.*;
import java.net.*;

class UDPClient
{
	private static String hostName = "hostname";
	private static int port = 9876;

	public static void main(String []args)
	{
		try{
			BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
			DatagramSocket clientSocket = new DatagramSocket();

			InetAddress IPAddress = InetAddress.getByName(hostName);

			byte[] sendData = new byte[1024];
			byte[] receiveData = new byte[1024];

			String sentence = inFromUser.readLine();
			sendData = sentence.getBytes();
		
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
			clientSocket.send(sendPacket);

			DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
			clientSocket.receive(receivePacket);

			String modifiedSentence = new String(receivePacket.getData());
			System.out.println("S: " + modifiedSentence);

			clientSocket.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
