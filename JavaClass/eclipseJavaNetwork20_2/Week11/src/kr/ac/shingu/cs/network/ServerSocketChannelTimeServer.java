package kr.ac.shingu.cs.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;

public class ServerSocketChannelTimeServer {

	public static void main(String[] args) {
		System.out.println("Ÿ�� ���� ����!");
		try {
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			
			serverSocketChannel.socket().bind(new InetSocketAddress(5000));
			
			while(true) {
				System.out.println("Ŭ���̾�Ʈ ��û ����� ...");
				SocketChannel socketChannel = serverSocketChannel.accept();
				if (socketChannel != null) {
					String dateAndTimeMessage = "Date : " + new Date(System.currentTimeMillis());
					ByteBuffer buf = ByteBuffer.allocate(64);
					buf.put(dateAndTimeMessage.getBytes());
					
					buf.flip();
					while(buf.hasRemaining()) {
						socketChannel.write(buf);
					}
					System.out.println(dateAndTimeMessage + " ����");
					
				}
			}
		} catch(IOException e) {
			
		}
	}
}
