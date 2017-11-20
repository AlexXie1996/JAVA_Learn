import java.io.*;
import java.net.*;

class TCPClientTest{

	public static void main(String[] argv)
	{
		try{
			Socket clientSocket = new Socket("127.0.0.1", 6789); 
			System.out.println(clientSocket.isBound());  
			System.out.println(clientSocket.isClosed());  
			System.out.println(clientSocket.isConnected());		

			clientSocket.close();

		}catch(IOException e){
			e.printStackTrace();
		}
			
	}
}
