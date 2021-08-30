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
		DatagramSocket serverSocket = null; // UDP ��������
		try {
			serverSocket = new DatagramSocket(); // �޸� �Ҵ�
			while(true) {
				String dateText = new Date().toString(); // �ý��� ��¥�ð� ���� ����
				byte[] buffer = new byte[256];
				buffer = dateText.getBytes();
				
				InetAddress group = InetAddress.getByName("224.0.0.0"); // ��Ƽĳ��Ʈ UDP �ּ�����
				DatagramPacket packet;
				packet = new DatagramPacket(buffer, buffer.length, group, 8888); // ������ ������
				
				serverSocket.send(packet);
				System.out.println(" ���۵� �ð� : " + dateText);
				
				try {
					Thread.sleep(1000); // 1�ʸ��� ��¥ �ð����� ��������
				} catch(InterruptedException e) {
					
				}
			}
		}catch(SocketException e) {
			// ����ó��
		} catch(IOException e) {
			// ����ó��
		}
		
	}

}
