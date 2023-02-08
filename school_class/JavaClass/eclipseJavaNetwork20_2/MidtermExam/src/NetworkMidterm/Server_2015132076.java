package NetworkMidterm;
// Around Us Server
// 제작자 : 김광희
// 학번 : 2015132076

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;



public class Server_2015132076 implements Runnable{	// Around Us Server 클래스
	private static Socket clientSocket;
	static List<PrintWriter> playerList = null;		// player의 Printwriter 정보
	static List<BufferedReader> playerBrList = null;	// player의 BufferedReader 정보
	static List<String> nicknameList = null;		// player의 닉네임 정보
	String Nickname;
	static boolean blWhile1 = true;
	static boolean blWhile2 = true;
	boolean blName = true;
	Game_2015132076 aug = null;
	
	
	
	public Server_2015132076(Socket clientSocket, List<PrintWriter> playerList, 
			List<String> NicknameList, List<BufferedReader> brList, Game_2015132076 aug) { // 생성자
		this.clientSocket = clientSocket;
		this.playerList = playerList;
		this.nicknameList = NicknameList;
		this.playerBrList = brList;
		this.aug = aug;
	}
	
	
	public static void main(String[] args) {
		System.out.println(" Around Us 서버 On ");
		
		List<PrintWriter> playerList = new ArrayList<PrintWriter>();
		List<String> nicknameList = new ArrayList<String>();
		List<BufferedReader> playerBrList = new ArrayList<BufferedReader>();
		Game_2015132076 aug = new Game_2015132076();
		
		try(ServerSocket serverSocket = new ServerSocket(10000)){
			while(true) {
				System.out.println("연결대기....");
				
				clientSocket = serverSocket.accept();
				
				// 클라이언트가 접속할 때마다 서버 객체 생성, 쓰레드 생성
				Server_2015132076 aus = new Server_2015132076(clientSocket, playerList, nicknameList, playerBrList, aug);
				new Thread(aus).start();
				
			
			}
		}catch (IOException ex) {
			ex.printStackTrace();
		}
		System.out.println("Around Us 서버를 종료합니다!");
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
			while((inputLine = in.readLine()) != null && blWhile1) {	// 게임 대기실 루프
				
				String[] str = inputLine.split(":");
				if ("Nickname".equals(str[0]) && blName) { // 닉네임 입력 조건문
					Nickname = str[1];
					addPlayer(out, in, str[1]);
					sendAll(0, Nickname + "님이 연결되었습니다.");

					blName = false;
					continue;
				}
					
				if ("start".equalsIgnoreCase(inputLine)) { // 게임 시작 조건문, start 입력 시 게임 시작
					if (playerList.size() >= 4 && playerList.size() <= 8) {
						
						blWhile1 = false;
						aug.setPBNL(playerList, playerBrList, nicknameList);
						
						new Thread(aug).start();

						
						break;
						// 4인 이상일 때 게임 시작
					} else { // 인원 부족 시 start 입력한 클라리언트에게 메세지 전송
						
						System.out.println("요청 클라이언트 [" + Thread.currentThread() + "] : " + inputLine);
						out.println("4인 이상의 플레이어가 필요합니다.");
						out.println("현재 인원 : " + playerList.size());
						continue;
					}
						
					
				}
					
				System.out.println("요청 클라이언트 [" + Thread.currentThread() + "] : " + inputLine); // 서버 콘솔에 클라이언트가 보낸 메세지를 줄단위 출력
				sendAll(1, Nickname + " : " + inputLine); 
			}
				
			
			
			
			while((inputLine = in.readLine()) != null){
				aug.receiveMessage(in, Nickname, inputLine);
			}
			

				
			
			
			
			System.out.println("요청 클라이언트 [" + Thread.currentThread() + "] 연결 종료됨 ");
			removeFromList(out, in, Nickname);	// 게임 종료시 목록에서 제거
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private void addPlayer(PrintWriter player, BufferedReader in, String s) {// 서버에 사용자 추가
		synchronized (playerList) {
			synchronized (nicknameList) {
				synchronized (playerBrList) {
					playerList.add(player);
					playerBrList.add(in);
					nicknameList.add(s);
				}
			}
		}
	}
	
	private void removeFromList(PrintWriter player, BufferedReader in, String s) {
		synchronized (playerList){
			synchronized (nicknameList) {
				synchronized (playerBrList) {
					try {
						nicknameList.remove(nicknameList.indexOf(s));
						playerBrList.remove(playerBrList.indexOf(in));
						playerList.remove(playerList.indexOf(player));
					} catch(UnsupportedOperationException e) {
						System.out.println("removeList에서 Error 발생 - " + e);
					} catch(IndexOutOfBoundsException e) {
						System.out.println("removeList에서 Error 발생 - " + e);
					}
				}
			}
		}
	}
	
	
	
	public static void sendAll(int cat, String s) { // 모든 사용자에게 채팅전송
		synchronized (playerList){
			String c;
			
			if ( cat == 0 ) {
				c = "[Server]  ";
			} else if ( cat == 1 ) {
				c = "[Player]  ";
			} else {
				c = "[ETC]  ";
			}
			
			for(PrintWriter out : playerList) {
				out.println(c + s);
				out.flush();
			}
		}
	}
	
	

	
	
}
