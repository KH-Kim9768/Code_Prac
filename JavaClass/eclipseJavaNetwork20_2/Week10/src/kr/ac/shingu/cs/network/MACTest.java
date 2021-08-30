package kr.ac.shingu.cs.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

public class MACTest {
	// MAC : Media Access Control 
	// ������ ��ũ ���̾�� ����ϴ� �ϵ���� �ּ�
	// �� 3�ڸ� -> A8:2B:B9 -> ����  , ������ ����
	
	public static String getMACIdentifier(NetworkInterface network) {
		StringBuilder identifier = new StringBuilder();
		try {
			byte[] macBuffer = network.getHardwareAddress();
			if(macBuffer != null) {
				for (int i= 0; i < macBuffer.length; i++) {
					identifier.append(
							String.format("%02X%s", macBuffer[i], (i < macBuffer.length - 1)? "-" : ""));
							// 02X -> 2�ڸ� 16������ ��ڴ�., 3�� �����ڴ� ' - ' �־��ִ� ����
				}
			} else {
				return "---";
			}
		} catch (SocketException ex) {
			ex.printStackTrace();
		}
		return identifier.toString();
	}
	
	public static void main(String[] args) {
		
		try {
			InetAddress address;
			address = InetAddress.getLocalHost();
			System.out.println("Ip address : " + address.getHostAddress());
			NetworkInterface network = NetworkInterface.getByInetAddress(address);
			System.out.println("MAC address : " + getMACIdentifier(network));
			
			Enumeration<NetworkInterface> interfaceEnum = NetworkInterface.getNetworkInterfaces();
			System.out.println("Name      MAC Address");
			
			Collections
				.list(interfaceEnum)
				.stream()
				.forEach((inetAddress) -> {
					System.out.printf("%-6s  %s\n", inetAddress.getName(), getMACIdentifier(inetAddress));
				});
						
//			for (NetworkInterface element : Collections.list(interfaceEnum)) {
//				System.out.printf("%-6s  %s\n", 
//						element.getName(), getMACIdentifier(element));
//				
//			}
			
		} catch(IOException e) {
			
		}
	}
}
