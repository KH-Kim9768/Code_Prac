package kr.ac.shingu.cs.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;


public class NICTest {
	
	public static void main(String[] args) throws IOException {
		
		try {
			Enumeration<NetworkInterface> interfaceEnum = 
					NetworkInterface.getNetworkInterfaces();
			
			System.out.println("�̸� : ���÷��� �̸�");
			
			for ( NetworkInterface element : Collections.list(interfaceEnum) ) {
				System.out.printf("%-8s : %-32s\n", element.getName(), element.getDisplayName());
//				System.out.println(element.getSubInterfaces());
				
				Enumeration<InetAddress> addrs = element.getInetAddresses();
//				for ( InetAddress iA : Collections.list(addrs) ) {
//					System.out.printf("InetAddress : %s\n", iA);
//				}
				
				
				Collections
				.list(addrs)
				.stream()	// Collections �� Stream ��ü�� ����
				.forEach((iA) -> {
					System.out.printf("InetAddress : %s\n", iA);
				});
			}
			
			
		} catch ( SocketException e ) {
			
		}
	}
}
