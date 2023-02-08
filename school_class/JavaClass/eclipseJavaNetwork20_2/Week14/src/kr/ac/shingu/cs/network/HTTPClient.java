package kr.ac.shingu.cs.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class HTTPClient {

	public HTTPClient() {
		System.out.println("HTTP 클라이언트 시작");
		
		try {
			InetAddress serverInetAddress = InetAddress.getByName("127.0.0.1");
			Socket connection = new Socket(serverInetAddress, 8088);
			
			try(
					OutputStream out = connection.getOutputStream();
					BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
					){
				sendGet(out);
				System.out.println(getResponse(in));
				
			} 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void sendGet(OutputStream out) {
		try {
			out.write("GET /default \r\n".getBytes());
			out.write("User-Agent : Mozilla/5.0\r\n".getBytes());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String getResponse(BufferedReader in) {
		try {
			String inputLine;
			StringBuilder response = new StringBuilder();
			while((inputLine = in.readLine()) != null) {
				response.append(inputLine).append("\r\n");
				
			}
			return response.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static void main(String[] args) {
		new HTTPClient();
	}
}
