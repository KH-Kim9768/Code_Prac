package kr.ac.shingu.cs.network;

import java.nio.channels.SocketChannel;

public class ClientHandler implements Runnable {
	private final SocketChannel socketChannel;
	
	
	public ClientHandler(SocketChannel socketChannel) {
		this.socketChannel = socketChannel;
	}
	
	@Override
	public void run(){
		System.out.println(socketChannel + " 클라이언트 핸들러 시작");
		String partName;
		while(true) {
			partName = HelperMethods.receiveMessage(socketChannel);
			
			if (partName.equalsIgnoreCase("quit")) {
				break;
			} else {
				Float price = PartsServer.getPrice(partName);
				HelperMethods.sendMessage(socketChannel, "" + price);	// String Casting
				
			}
		}
		System.out.println(socketChannel + " 클라이언트 핸들러 종료");
	}
}
