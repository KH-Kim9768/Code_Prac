package kr.ac.shingu.cs.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelTimeClient {
	
	public static void main(String[] args) {
		SocketAddress address = new InetSocketAddress("127.0.0.1", 5000);
		
		try(
				SocketChannel socketChannel = SocketChannel.open(address)
				){
			
			ByteBuffer byteBuffer = ByteBuffer.allocate(64);	// 수신 버퍼 할당
			int bytesRead = socketChannel.read(byteBuffer);
			
			while(bytesRead > 0) {
				byteBuffer.flip();	// limit를 현재 position으로, position은 0으로, flip은 버퍼를 읽기 위한 용도
				while(byteBuffer.hasRemaining()) {
					System.out.print((char) byteBuffer.get());
				}
				System.out.println();
				bytesRead = socketChannel.read(byteBuffer);			}
			
		} catch(IOException e) {
			
		}
	}
}
