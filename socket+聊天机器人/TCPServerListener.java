import java.io.*;
import java.net.*;

class TCPServerListener
{
	private static int port = 6789;
 
	public static void main(String[] arg)
	{
		System.out.println("服务器端启动");
		try{
			ServerSocket welcomeSocket = new ServerSocket(port);
			while(true){
				Socket connectionSocket = welcomeSocket.accept();
				new Thread(new TCPServerExc(connectionSocket)).start();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("服务器端关闭");
	}
}
