package kr.ac.shingu.cs.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;	// 서버 소켓 객체
import java.nio.channels.SocketChannel;			// 클라이언트 정보를 담는 용도
import java.util.Scanner;

public class ChatServer {
	// 소켓 생성 -> 바인드 -> accept
	public ChatServer() {
		System.out.println("채팅 서버 시작 ! ");
		try {
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();	// 소켓 생성
			serverSocketChannel.socket().bind(new InetSocketAddress(5000));			// 소켓 바인드
			
			boolean running = true;
			while (running) {
				System.out.println("요청 대기중 ...");
				SocketChannel socketChannel = serverSocketChannel.accept();			// 소켓 accept
				
				System.out.println("클라이언트가 연결됨");
				String message;
				Scanner scanner = new Scanner(System.in);
				while (true) {
					System.out.print("> ");
					message = scanner.nextLine();
					if (message.equalsIgnoreCase("quit")) {
						HelperMethods.sendMessage(socketChannel, "Server Terminating");
						running = false;	// 서버 종료
						break;
					} else {
						HelperMethods.sendMessage(socketChannel, message);
						System.out.println("클라이언트 메세지  대기중");
						System.out.println("메세지 : " + HelperMethods.receiveMessage(socketChannel));
					}
				}
				scanner.close();
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ChatServer();

	}

}
