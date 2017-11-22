import java.io.*;
import java.net.*;

class UDPServer
{
	private static int port = 9876;

	public static void main(String[] arg)
	{
		System.out.println("服务器启动");
		try{
			DatagramSocket serverSocket = new DatagramSocket(port);
			byte[] receiveData = new byte[1024];
			byte[] sendData = new byte[1024];

			while(true){
				DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
				serverSocket.receive(receivePacket);

				String sentence = new String(receivePacket.getData());
				InetAddress IPAddress = receivePacket.getAddress();
				int p = receivePacket.getPort();

				String capitalizedSentence = sentence.toUpperCase();
				sendData = capitalizedSentence.getBytes();

				DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length, IPAddress, port);
				serverSocket.send(sendPacket);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("服务器端关闭");
	}
}
