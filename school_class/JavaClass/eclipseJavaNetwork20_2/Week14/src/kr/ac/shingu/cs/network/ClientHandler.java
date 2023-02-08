package kr.ac.shingu.cs.network;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.StringTokenizer;

public class ClientHandler implements Runnable{
	
	private final Socket socket;
	
	public ClientHandler(Socket socket) {
		this.socket = socket;
		
	}
	
	public void handleRequest(Socket socket) {
		try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));){
			String headerLine = in.readLine();
			StringTokenizer tokenizer = new StringTokenizer(headerLine);
			String httpMethod = tokenizer.nextToken();
			
			if (httpMethod.equals("GET")) {
				// html�� form �±��� method �Ӽ��� ������ get�̳� post�� �� �� �ִ�.
				// get ����� �ּ�â�� �Է������� �״�� ��Ÿ���� ���� �����Ǿ ���� ���� ª�� Ű���� �˻� � ���ȴ�.
				// post��  ������ ���߱� ���ؼ� ���ȴ�. get�� ª�� ����, post�� �� ���ڵ� ó�� �����ϴ�.
				
				System.out.println("GET �޼ҵ� ó����");
				// StringTokenizer, StringBuilder�� ���ڿ� ó�� �����ִ� Ŭ����
				String httpQueryString = tokenizer.nextToken();
				StringBuilder responseBuffer = new StringBuilder();
				responseBuffer
				.append("<html><h1>WebServer Home Page... </h1><br>")
				.append("<b>Welcome to my web server!</b><br>")
				.append("</html>");
				
				sendResponse(socket, 200, responseBuffer.toString());
			} else {
				System.out.println("HTTP �޼ҵ� �ν� �Ұ�");
				sendResponse(socket, 405, "�޼ҵ� ��� �Ұ�");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendResponse(Socket socket, int statusCode, String responseString) {
		String statusLine;
		String serverHeader = "Server : WebServer \r\n";
		String contentTypeHeader = "Content-Type : text/html\r\n";
		
		try(DataOutputStream out = new DataOutputStream(socket.getOutputStream());){
			if(statusCode == 200) {
				statusLine = "HTTP/1.0 200 OK" + "\r\n";
				String contentLengthHeader = "Content-Length: " + responseString.length() + "\r\n";
				
				out.writeBytes(statusLine);
				out.writeBytes(serverHeader);
				out.writeBytes(contentTypeHeader);
				out.writeBytes(contentLengthHeader);
				out.writeBytes("\r\n");
				out.writeBytes(responseString);
				
			} else if (statusCode == 405) { 
				statusLine = "HTTP/1.0 405 �޼ҵ� ��� �Ұ�" + "\r\n";
				out.writeBytes(statusLine);
				out.writeBytes("\r\n");
			} else {
				statusLine = "HTTP/1.0 404 Not Found" + "\r\n";
				out.writeBytes(statusLine);
				out.writeBytes("\r\n");
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		System.out.println(this.socket + " Ŭ���̾�Ʈ �ڵ鷯 ����!");
		handleRequest(this.socket);
		System.out.println(this.socket + " Ŭ���̾�Ʈ �ڵ鷯 ����!");
	}
	
	

}
