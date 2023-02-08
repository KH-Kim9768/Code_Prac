package kr.ac.shingu.cs.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadedEchoServer implements Runnable {
	
	private static Socket clientSocket;
	
	public ThreadedEchoServer(Socket clientSocket) { // 생성자
		this.clientSocket = clientSocket;
		
	}
	
	public static void main(String[] args) {
		System.out.println("멀티 에코 서버 시작~");
		
		try(ServerSocket serverSocket = new ServerSocket(10000)){
			while(true) {
				System.out.println("연결대기....");
				
				clientSocket = serverSocket.accept();
				
				// 클라이언트가 접속할 때마다 서버 객체 생성, 쓰레드 생성
				ThreadedEchoServer tes = new ThreadedEchoServer(clientSocket);
				
				new Thread(tes).start();
			}
		}catch (IOException ex) {
			
		}
		System.out.println("멀티 에코 서버를 종료합니다!");
	}

	@Override
	public void run() { // 각각의 쓰레드는 run() 안의 함수를 실행함
		System.out.println("연결된 클라이언트의 쓰레드 : " + Thread.currentThread());
		// 현재 처리 중인 쓰레드 정보 출력
		
		try(	// 클라이언트 프로그램이 전송하는 텍스트를 담을 버퍼 준비
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				// 클라이언트 한테 전송 할 텍스트를 담을 버퍼 준비
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);){
			
			String inputLine;
			
			while((inputLine = in.readLine()) != null) {
				System.out.println("요청 클라이언트 [" + Thread.currentThread() + "] : " + inputLine); // 서버 콘솔에 클라이언트가 보낸 메세지를 줄단위 출력
				out.println(inputLine); // 출력용 객체 out을 이용하여 클라이언트한테 클라이언트가 보낸 메세지 재전송
				
			}
			System.out.println("요청 클라이언트 [" + Thread.currentThread() + "] 연결 종료됨 ");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
