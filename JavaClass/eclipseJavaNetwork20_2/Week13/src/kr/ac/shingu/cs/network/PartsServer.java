package kr.ac.shingu.cs.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;

public class PartsServer {
	private static final HashMap<String, Float> parts = new HashMap<>();
	

	public PartsServer() {
		System.out.println("부품 서버 시작...");
		initializeParts();
		
		try {
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.socket().bind(new InetSocketAddress(5000));
			
			while(true) {
				System.out.println("클라이언트 대기중...");
				SocketChannel socketChannel = serverSocketChannel.accept();
				new Thread(new ClientHandler(socketChannel)).start();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void initializeParts() {
		parts.put("Hammer", 12.55f);
		parts.put("Nail", 1.35f);
		parts.put("Pliers", 4.65f);
		parts.put("Saw", 8.45f);
		parts.put("Driver", 2.45f);
		
	}

	public static Float getPrice(String partName) {
		return parts.get(partName);
	}


	public static void main(String[] args) {
		new PartsServer();
		
	}
}
