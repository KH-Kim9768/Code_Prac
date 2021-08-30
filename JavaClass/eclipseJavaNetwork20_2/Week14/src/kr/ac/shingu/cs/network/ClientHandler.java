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
				// html의 form 태그의 method 속성의 값으로 get이나 post가 올 수 있다.
				// get 방식은 주소창에 입력정보가 그대로 나타나며 보통 공개되어도 문제 없는 짧은 키워드 검색 등에 사용된다.
				// post는  정보를 감추기 위해서 사용된다. get은 짧은 글자, post는 긴 글자도 처리 가능하다.
				
				System.out.println("GET 메소드 처리됨");
				// StringTokenizer, StringBuilder는 문자열 처리 도와주는 클래스
				String httpQueryString = tokenizer.nextToken();
				StringBuilder responseBuffer = new StringBuilder();
				responseBuffer
				.append("<html><h1>WebServer Home Page... </h1><br>")
				.append("<b>Welcome to my web server!</b><br>")
				.append("</html>");
				
				sendResponse(socket, 200, responseBuffer.toString());
			} else {
				System.out.println("HTTP 메소드 인식 불가");
				sendResponse(socket, 405, "메소드 사용 불가");
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
				statusLine = "HTTP/1.0 405 메소드 사용 불가" + "\r\n";
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
		System.out.println(this.socket + " 클라이언트 핸들러 시작!");
		handleRequest(this.socket);
		System.out.println(this.socket + " 클라이언트 핸들러 종료!");
	}
	
	

}
