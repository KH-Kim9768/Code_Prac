package NetworkMidterm;
//Around Us Client
//제작자 : 김광희
//학번 : 2015132076
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client_2015132076 implements Runnable{	// Around Us Client 클래스
	
	private static Socket clientSocket;
	
	public Client_2015132076(Socket clientSocket) { // 생성자
		this.clientSocket = clientSocket;
		
	}

	public static void main(String[] args) {	// main 쓰레드
			
		System.out.println("Around Us 클라이언트!!");
			
		InetAddress localAddress;
		try {
			localAddress = InetAddress.getLocalHost(); // 내 컴퓨터의 IP 획득
			
			
			try(	// 서버 호스트 정보, 포트번호   // 서버에 연결
					Socket cSocket = new Socket(localAddress, 10000);
					// 서버에 보낼 메세지 담을 출력 버퍼 객체 생성
					PrintWriter out = new PrintWriter(cSocket.getOutputStream(), true);
					
					) {
				
				System.out.println("Around Us 서버에 연결됨!");  // 서버 연결 성공시 출력
				Scanner scan = new Scanner(System.in);
				String Nickname;
				while(true) {
					System.out.print("닉네임 입력 : ");
					Nickname = scan.nextLine();
					if ( Nickname.isEmpty() == false) {
						out.println("Nickname:" + Nickname);
						break;
					}
					System.out.println("잘못된 닉네임입니다. 다시 입력해주세요.");
				}
				
				Client_2015132076 auc = new Client_2015132076(cSocket);
				new Thread(auc).start(); // 서버에서 보낸 메세지 받는 쓰레드 실행 
				
				
				
				while(true) {

					String inputLine = scan.nextLine(); // 클라이언트 키보드 입력
					if("quit".equalsIgnoreCase(inputLine)) // IgnoreCase = 대소문자 구분x
						break;
					
					out.println(inputLine); // 서버에 전송

					
				}
				
		
			} catch(IOException e) {
				
			}
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void run() {	// 메세지 받는 쓰레드
		
		try {
			// 서버가 보내준 메세지 담을 입력 버퍼 객체 생성
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			while(true) {
				String response = in.readLine();
				if(response != null) {
					System.out.println(response);
				} else continue;
			}
		} catch (IOException e) {
			
		}
		
	}
}
