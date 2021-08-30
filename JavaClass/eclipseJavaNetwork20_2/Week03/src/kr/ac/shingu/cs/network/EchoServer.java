package kr.ac.shingu.cs.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter; // 클라이언트한테 보낼 메세지를 담아둘 버퍼
import java.net.ServerSocket; // 서버용 소켓
import java.net.Socket; // 클라이언트 용

// 서버에서는 포트번호도 열어줘야 한다.
// 서버는 IP주소와 포트번호 조합에 의해 식별된다.
		

public class EchoServer {
	
	public static void main(String[] args) {
		System.out.println("에코 서버");
		
		// 소켓 생성, 포트 번호 지정
		// try - with - resource
		try(ServerSocket sSocket = new ServerSocket(6000)){
			System.out.println("접속 대기중...");
			Socket cSocket = sSocket.accept(); // 연결 승인
			System.out.println("클라이언트와 연결됨!");
			
			try(	// 클라이언트 프로그램이 전송하는 텍스트를 담을 버퍼 준비
					BufferedReader in = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
					// 클라이언트 한테 전송 할 텍스트를 담을 버퍼 준비
					PrintWriter out = new PrintWriter(cSocket.getOutputStream(), true);){
				
				String inputLine;
				while((inputLine = in.readLine()) != null) {
					System.out.println("Server : " + inputLine); // 서버 콘솔에 클라이언트가 보낸 메세지를 줄단위 출력
					out.println(inputLine); // 출력용 객체 out을 이용하여 클라이언트한테 클라이언트가 보낸 메세지 재전송
					
				}
			}catch(IOException e) {
				
			}
			
		}catch(IOException e) {
			
		}
		System.out.println("서버 종료됨!");		
	}

}
