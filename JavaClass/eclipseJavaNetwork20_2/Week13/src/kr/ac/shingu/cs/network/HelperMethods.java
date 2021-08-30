package kr.ac.shingu.cs.network;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class HelperMethods {
	public static void sendFixedLengthMessage(SocketChannel socketChannel, String message) {
		// ����ũ�� �޼��� ���� ��
		try {
			ByteBuffer buffer = ByteBuffer.allocate(64); 	// position : 0, Limit : 64, Capacity : 64
			buffer.put(message.getBytes());	// ���ۿ��Ű������� ���޵� �޼��� Byte ���·� ����
			buffer.flip();	// p : 0, l : p��ŭ, c : 64
			
			while (buffer.hasRemaining()) {
				socketChannel.write(buffer);
				
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String receiveFixedLengthMessage(SocketChannel socketChannel) {
		// ����ũ�� �޼��� ���� ��
		String message = "";
		try {
			ByteBuffer byteBuffer = ByteBuffer.allocate(64);
			socketChannel.read(byteBuffer);	// ��Ĺä�ηκ��� ���� �����͸� ���ۿ� ��´�
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
		// ���� ũ�� �޼��� ���� ��
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
		// ���� ũ�� �޼��� ���� ��
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
