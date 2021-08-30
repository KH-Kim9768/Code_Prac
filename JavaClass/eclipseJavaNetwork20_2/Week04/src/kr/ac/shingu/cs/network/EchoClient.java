package kr.ac.shingu.cs.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient {

	public static void main(String[] args) {
		// Port Number : 포트번호 2byte = 16비트
		// 0 ~ +2^16 -1
		// 0 ~ 65535 
		
		System.out.println("에코 클라이언트!!");
		
		InetAddress localAddress;
		try {
			localAddress = InetAddress.getLocalHost(); // 내 컴퓨터의 IP 획득
			
			// try - with - resource
			try(	// 서버 호스트 정보, 포트번호
					Socket cSocket = new Socket(localAddress, 10000);
					// 서버에 보낼 메세지 담을 출력 버퍼 객체 생성
					PrintWriter out = new PrintWriter(cSocket.getOutputStream(), true);
					// 서버가 보내준 메세지 담을 입력 버퍼 객체 생성
					BufferedReader in = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
					) {
				System.out.println("서버에 연결됨!");
				Scanner scan = new Scanner(System.in);
				
				while(true) {                    
					System.out.print("Enter text : ");
					String inputLine = scan.nextLine(); // 클라이언트 키보드 입력
					if("quit".equalsIgnoreCase(inputLine)) // IgnoreCase = 대소문자 구분x
						break;
					
					out.println(inputLine); // 서버에 전송
					String response = in.readLine();
					System.out.println("서버가 보내준 메세지 : " + response);
					
				}
				
			} catch(IOException e) {
				
			}
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		

	}

}
