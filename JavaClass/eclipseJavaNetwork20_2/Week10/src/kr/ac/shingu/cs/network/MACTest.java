package kr.ac.shingu.cs.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

public class MACTest {
	// MAC : Media Access Control 
	// 데이터 링크 레이어에서 사용하는 하드웨어 주소
	// 앞 3자리 -> A8:2B:B9 -> 벤더  , 제조사 정보
	
	public static String getMACIdentifier(NetworkInterface network) {
		StringBuilder identifier = new StringBuilder();
		try {
			byte[] macBuffer = network.getHardwareAddress();
			if(macBuffer != null) {
				for (int i= 0; i < macBuffer.length; i++) {
					identifier.append(
							String.format("%02X%s", macBuffer[i], (i < macBuffer.length - 1)? "-" : ""));
							// 02X -> 2자리 16진수로 찍겠다., 3항 연산자는 ' - ' 넣어주는 역할
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
