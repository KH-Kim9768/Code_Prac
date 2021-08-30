package kr.ac.shingu.cs.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class PartsClient {
	
	public PartsClient() {
		System.out.println("부품 클라이언트 시작...");
		SocketAddress address = new InetSocketAddress("127.0.0.1", 5000);
		
		try(
				SocketChannel socketChannel = SocketChannel.open(address);
				Scanner scan = new Scanner(System.in);
				){
			System.out.println("파츠서버 연결");
			
			while(true) {
				System.out.println("부품 이름 입력 : ");
				String partName = scan.nextLine();
				if(partName.equalsIgnoreCase("quit")) {
					HelperMethods.sendMessage(socketChannel, "quit");
					break;
				} else {
					HelperMethods.sendMessage(socketChannel, partName);
					System.out.println("가격은 " + HelperMethods.receiveMessage(socketChannel));
				}
			}
			System.out.println("부품 클라이언트 종료");
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new PartsClient();
	}
}
