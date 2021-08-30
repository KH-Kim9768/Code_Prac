package kr.ac.shingu.cs.network;

import java.nio.channels.SocketChannel;

public class HelperMethods {
	public static void sendFixedLengthMessage(SocketChannel socketChannel, String message) {
		// 고정크기 메세지 보낼 때
	}
	
	public static void receiveFixedLengthMessage(SocketChannel socketChannel) {
		// 고정크기 메세지 받을 때
	}
	
	public static void sendMessage(SocketChannel socketChannel, String message) {
		// 가변 크기 메세지 보낼 때
	}
	
	public static void receiveMessage(SocketChannel socketChannel) {
		// 가변 크기 메세지 받을 때
	}
}
