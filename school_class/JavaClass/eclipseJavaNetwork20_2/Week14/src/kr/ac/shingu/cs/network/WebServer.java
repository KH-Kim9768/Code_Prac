package kr.ac.shingu.cs.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

	public WebServer() {
		System.out.println("������ ����");
		
		try(ServerSocket serverSocket = new ServerSocket(8088)){
			while(true) {
				System.out.println("Ŭ���̾�Ʈ ��û ����� ...");
				Socket remote = serverSocket.accept();
				System.out.println("�����");
				new Thread(new ClientHandler(remote)).start();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
		new WebServer();

	}

}
