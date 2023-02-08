package kr.ac.shingu.cs.network;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class InetAddressTest {
	
	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getByName("www.shingu.ac.kr"); //ip 주소를 얻어옴
			System.out.println(address);
			System.out.println(address.getCanonicalHostName());
			System.out.println(address.getHostAddress());
			System.out.println(address.getHostName());
			
		} catch (UnknownHostException e) {
			System.out.println("호스트 주소 확인 필요");
			e.printStackTrace();
		}
		

	}
}
