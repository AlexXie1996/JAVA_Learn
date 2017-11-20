import java.io.*;
import java.net.*;

public class TCPServerExc implements Runnable
{
	private Socket connectionSocket = null;
	private static String url = "http://www.tuling123.com/openapi/api";
	private static String key = "";

	public TCPServerExc(Socket socket){
		this.connectionSocket = socket;
	}

	public void run()
	{
		try{
			String clientSentence;
			String respond;

			BufferedReader inFromClient = new BufferedReader(
					new InputStreamReader(connectionSocket.getInputStream(), "UTF-8"));
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

			while(true){
				clientSentence = inFromClient.readLine();
				respond = new String(sendPost(clientSentence) + '\n');

				outToClient.writeUTF(respond);
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.out.println("该用户已断开链接");
		}
	}

	public static String sendPost(String info){
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";

		String params = String.format("key=%s&info=%s", key, info);

		try{
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();

			conn.setDoOutput(true);
			conn.setDoInput(true);
		
			out = new PrintWriter(conn.getOutputStream());
			out.print(params);
			out.flush();

			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while((line = in.readLine()) != null){
				result += line;
			}

			
		}catch(Exception e){
			System.out.println("网络有异常哦! " + e);
			e.printStackTrace();
		}finally{
			try{
				if(out != null)
					out.close();
				if(in != null)
					in.close();
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}

		int begin = result.indexOf("text")+7;
		int end = result.length()-2;
		result = result.substring(begin,end);
		return result;
	}
}
