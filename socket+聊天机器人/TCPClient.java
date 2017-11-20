import java.io.*;
import java.net.*;

class TCPClient{

	private static String host = "127.0.0.1";
	private static int port = 6789;

	public static void main(String[] argv)
	{
		try{
			String sentence;
			String respond;

			BufferedReader inFromUser = new BufferedReader(
							new InputStreamReader(System.in,"UTF-8"));
		
			Socket clientSocket = new Socket(host, port);
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());


			BufferedReader inFromServer = new BufferedReader(
							new InputStreamReader(clientSocket.getInputStream(), "UTF-8"));

			while(true){
				sentence = inFromUser.readLine();
				outToServer.writeUTF(sentence + '\n');

				if (sentence.equals("QUIT"))
					break;
				respond = inFromServer.readLine();
				try{
					System.out.println("S:" + respond.substring(2,respond.length()));
				}catch(Exception e){
					System.out.println("S: 讨厌网络断开了啦");
				}
			}

			clientSocket.close();

		}catch(IOException e){
			e.printStackTrace();
		}
			
	}
}
