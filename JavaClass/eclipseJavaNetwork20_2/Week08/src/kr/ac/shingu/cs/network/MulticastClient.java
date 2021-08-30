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
			socket.joinGroup(group); // ���� ��Ƽĳ��Ʈ �׷쿡 �շ�
			System.out.println("��Ƽĳ��Ʈ �׷쿡 ����");
			
			byte[] buffer = new byte[256];
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length); // ������ �����ε�
										// �޴� ������
			
			for ( int i = 0; i < 5 ; i++ ) {
				socket.receive(packet);
				String received = new String(packet.getData());
				System.out.println(received.trim());
				
			}
		} catch(IOException e) {
			
		}
		System.out.println("��Ƽĳ��Ʈ Ÿ�� Ŭ���̾�Ʈ�� ����Ǿ����ϴ�.");

	}

}
