package kr.ac.shingu.cs.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;


public class MulticastClient {

	public static void main(String[] args) {
		System.out.println("Multicast Time Clinet");
		try(MulticastSocket socket = new MulticastSocket(8888)){
			InetAddress group = InetAddress.getByName("224.0.0.0");
			socket.joinGroup(group); // 실제 멀티캐스트 그룹에 합류
			System.out.println("멀티캐스트 그룹에 입장");
			
			byte[] buffer = new byte[256];
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length); // 생성자 오버로딩
										// 받는 생성자
			
			for ( int i = 0; i < 5 ; i++ ) {
				socket.receive(packet);
				String received = new String(packet.getData());
				System.out.println(received.trim());
				
			}
		} catch(IOException e) {
			
		}
		System.out.println("멀티캐스트 타임 클라이언트가 종료되었습니다.");

	}

}
