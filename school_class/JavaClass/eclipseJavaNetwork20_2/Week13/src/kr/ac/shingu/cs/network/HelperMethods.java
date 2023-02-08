package kr.ac.shingu.cs.network;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class HelperMethods {
	public static void sendFixedLengthMessage(SocketChannel socketChannel, String message) {
		// 고정크기 메세지 보낼 때
		try {
			ByteBuffer buffer = ByteBuffer.allocate(64); 	// position : 0, Limit : 64, Capacity : 64
			buffer.put(message.getBytes());	// 버퍼에매개변수로 전달된 메세지 Byte 형태로 삽입
			buffer.flip();	// p : 0, l : p만큼, c : 64
			
			while (buffer.hasRemaining()) {
				socketChannel.write(buffer);
				
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String receiveFixedLengthMessage(SocketChannel socketChannel) {
		// 고정크기 메세지 받을 때
		String message = "";
		try {
			ByteBuffer byteBuffer = ByteBuffer.allocate(64);
			socketChannel.read(byteBuffer);	// 소캣채널로부터 읽은 데이터를 버퍼에 담는다
			byteBuffer.flip();
			while(byteBuffer.hasRemaining()) {
				message += (char) byteBuffer.get();
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		return message;
	}
	
	public static void sendMessage(SocketChannel socketChannel, String message) {
		// 가변 크기 메세지 보낼 때
		try {
			ByteBuffer buffer = ByteBuffer.allocate(message.length() + 1);
			buffer.put(message.getBytes());
			buffer.put((byte) 0x00);
			buffer.flip();
			while(buffer.hasRemaining()) {
				socketChannel.write(buffer);
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String receiveMessage(SocketChannel socketChannel) {
		// 가변 크기 메세지 받을 때
		try {
			ByteBuffer byteBuffer = ByteBuffer.allocate(16);
			String message = "";
			while (socketChannel.read(byteBuffer) > 0){
				char byteRead = 0x00;
				byteBuffer.flip();
				while(byteBuffer.hasRemaining()) {
					byteRead = (char) byteBuffer.get();
					if (byteRead == 0x00) {
						break;
					}
					message += byteRead;
				}
				if (byteRead == 0x00) {
					break;
				}
				byteBuffer.clear();
			}
			return message;
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}
