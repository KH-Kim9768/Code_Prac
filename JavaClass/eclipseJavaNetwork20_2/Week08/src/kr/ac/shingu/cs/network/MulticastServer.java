package kr.ac.shingu.cs.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;

public class MulticastServer {

	public static void main(String[] args) {
		System.out.println("Multicast Time Server");
		DatagramSocket serverSocket = null; // UDP 프로토콜
		try {
			serverSocket = new DatagramSocket(); // 메모리 할당
			while(true) {
				String dateText = new Date().toString(); // 시스템 날짜시간 정보 저장
				byte[] buffer = new byte[256];
				buffer = dateText.getBytes();
				
				InetAddress group = InetAddress.getByName("224.0.0.0"); // 멀티캐스트 UDP 주소지정
				DatagramPacket packet;
				packet = new DatagramPacket(buffer, buffer.length, group, 8888); // 보내는 생성자
				
				serverSocket.send(packet);
				System.out.println(" 전송된 시간 : " + dateText);
				
				try {
					Thread.sleep(1000); // 1초마다 날짜 시간정보 리프레시
				} catch(InterruptedException e) {
					
				}
			}
		}catch(SocketException e) {
			// 예외처리
		} catch(IOException e) {
			// 예외처리
		}
		
	}

}
