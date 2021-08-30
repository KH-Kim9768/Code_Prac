package kr.ac.shingu.cs.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class ChatClient {

	public ChatClient() {
		SocketAddress address = new InetSocketAddress("127.0.0.1", 5000);
		try(
				SocketChannel socketChannel = SocketChannel.open(address)
				){
			System.out.println("채팅 서버 연결!");
			String message;
			Scanner scanner = new Scanner(System.in);
			while (true) {
				System.out.println("서버 메세지 대기중");
				System.out.println("메세지 : " + HelperMethods.receiveMessage(socketChannel));
				System.out.println("> ");
				message = scanner.nextLine();
				if(message.equalsIgnoreCase("quit")) {
					HelperMethods.sendMessage(socketChannel, "Client Terminating");
					break;
				}
				HelperMethods.sendMessage(socketChannel, message);
				
			}
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ChatClient();
		
	}
}
