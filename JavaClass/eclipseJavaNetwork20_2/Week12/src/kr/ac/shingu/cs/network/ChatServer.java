package kr.ac.shingu.cs.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;	// ���� ���� ��ü
import java.nio.channels.SocketChannel;			// Ŭ���̾�Ʈ ������ ��� �뵵
import java.util.Scanner;

public class ChatServer {
	// ���� ���� -> ���ε� -> accept
	public ChatServer() {
		System.out.println("ä�� ���� ���� ! ");
		try {
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();	// ���� ����
			serverSocketChannel.socket().bind(new InetSocketAddress(5000));			// ���� ���ε�
			
			boolean running = true;
			while (running) {
				System.out.println("��û ����� ...");
				SocketChannel socketChannel = serverSocketChannel.accept();			// ���� accept
				
				System.out.println("Ŭ���̾�Ʈ�� �����");
				String message;
				Scanner scanner = new Scanner(System.in);
				while (true) {
					System.out.print("> ");
					message = scanner.nextLine();
					if (message.equalsIgnoreCase("quit")) {
						HelperMethods.sendMessage(socketChannel, "Server Terminating");
						running = false;	// ���� ����
						break;
					} else {
						HelperMethods.sendMessage(socketChannel, message);
						System.out.println("Ŭ���̾�Ʈ �޼���  �����");
						System.out.println("�޼��� : " + HelperMethods.receiveMessage(socketChannel));
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
