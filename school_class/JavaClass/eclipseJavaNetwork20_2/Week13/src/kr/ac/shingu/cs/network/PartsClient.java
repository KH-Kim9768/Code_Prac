package kr.ac.shingu.cs.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class PartsClient {
	
	public PartsClient() {
		System.out.println("��ǰ Ŭ���̾�Ʈ ����...");
		SocketAddress address = new InetSocketAddress("127.0.0.1", 5000);
		
		try(
				SocketChannel socketChannel = SocketChannel.open(address);
				Scanner scan = new Scanner(System.in);
				){
			System.out.println("�������� ����");
			
			while(true) {
				System.out.println("��ǰ �̸� �Է� : ");
				String partName = scan.nextLine();
				if(partName.equalsIgnoreCase("quit")) {
					HelperMethods.sendMessage(socketChannel, "quit");
					break;
				} else {
					HelperMethods.sendMessage(socketChannel, partName);
					System.out.println("������ " + HelperMethods.receiveMessage(socketChannel));
				}
			}
			System.out.println("��ǰ Ŭ���̾�Ʈ ����");
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new PartsClient();
	}
}
