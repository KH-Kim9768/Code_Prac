package NetworkMidterm;
// Around Us Server
// ������ : �豤��
// �й� : 2015132076

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;



public class Server_2015132076 implements Runnable{	// Around Us Server Ŭ����
	private static Socket clientSocket;
	static List<PrintWriter> playerList = null;		// player�� Printwriter ����
	static List<BufferedReader> playerBrList = null;	// player�� BufferedReader ����
	static List<String> nicknameList = null;		// player�� �г��� ����
	String Nickname;
	static boolean blWhile1 = true;
	static boolean blWhile2 = true;
	boolean blName = true;
	Game_2015132076 aug = null;
	
	
	
	public Server_2015132076(Socket clientSocket, List<PrintWriter> playerList, 
			List<String> NicknameList, List<BufferedReader> brList, Game_2015132076 aug) { // ������
		this.clientSocket = clientSocket;
		this.playerList = playerList;
		this.nicknameList = NicknameList;
		this.playerBrList = brList;
		this.aug = aug;
	}
	
	
	public static void main(String[] args) {
		System.out.println(" Around Us ���� On ");
		
		List<PrintWriter> playerList = new ArrayList<PrintWriter>();
		List<String> nicknameList = new ArrayList<String>();
		List<BufferedReader> playerBrList = new ArrayList<BufferedReader>();
		Game_2015132076 aug = new Game_2015132076();
		
		try(ServerSocket serverSocket = new ServerSocket(10000)){
			while(true) {
				System.out.println("������....");
				
				clientSocket = serverSocket.accept();
				
				// Ŭ���̾�Ʈ�� ������ ������ ���� ��ü ����, ������ ����
				Server_2015132076 aus = new Server_2015132076(clientSocket, playerList, nicknameList, playerBrList, aug);
				new Thread(aus).start();
				
			
			}
		}catch (IOException ex) {
			ex.printStackTrace();
		}
		System.out.println("Around Us ������ �����մϴ�!");
	}
	

	@Override
	public void run() { // ������ ������� run() ���� �Լ��� ������
		System.out.println("����� Ŭ���̾�Ʈ�� ������ : " + Thread.currentThread());
		
		
		// ���� ó�� ���� ������ ���� ���
		

		try(	// Ŭ���̾�Ʈ ���α׷��� �����ϴ� �ؽ�Ʈ�� ���� ���� �غ�
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				// Ŭ���̾�Ʈ ���� ���� �� �ؽ�Ʈ�� ���� ���� �غ�
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);){
			


			String inputLine;
			while((inputLine = in.readLine()) != null && blWhile1) {	// ���� ���� ����
				
				String[] str = inputLine.split(":");
				if ("Nickname".equals(str[0]) && blName) { // �г��� �Է� ���ǹ�
					Nickname = str[1];
					addPlayer(out, in, str[1]);
					sendAll(0, Nickname + "���� ����Ǿ����ϴ�.");

					blName = false;
					continue;
				}
					
				if ("start".equalsIgnoreCase(inputLine)) { // ���� ���� ���ǹ�, start �Է� �� ���� ����
					if (playerList.size() >= 4 && playerList.size() <= 8) {
						
						blWhile1 = false;
						aug.setPBNL(playerList, playerBrList, nicknameList);
						
						new Thread(aug).start();

						
						break;
						// 4�� �̻��� �� ���� ����
					} else { // �ο� ���� �� start �Է��� Ŭ�󸮾�Ʈ���� �޼��� ����
						
						System.out.println("��û Ŭ���̾�Ʈ [" + Thread.currentThread() + "] : " + inputLine);
						out.println("4�� �̻��� �÷��̾ �ʿ��մϴ�.");
						out.println("���� �ο� : " + playerList.size());
						continue;
					}
						
					
				}
					
				System.out.println("��û Ŭ���̾�Ʈ [" + Thread.currentThread() + "] : " + inputLine); // ���� �ֿܼ� Ŭ���̾�Ʈ�� ���� �޼����� �ٴ��� ���
				sendAll(1, Nickname + " : " + inputLine); 
			}
				
			
			
			
			while((inputLine = in.readLine()) != null){
				aug.receiveMessage(in, Nickname, inputLine);
			}
			

				
			
			
			
			System.out.println("��û Ŭ���̾�Ʈ [" + Thread.currentThread() + "] ���� ����� ");
			removeFromList(out, in, Nickname);	// ���� ����� ��Ͽ��� ����
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private void addPlayer(PrintWriter player, BufferedReader in, String s) {// ������ ����� �߰�
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
						System.out.println("removeList���� Error �߻� - " + e);
					} catch(IndexOutOfBoundsException e) {
						System.out.println("removeList���� Error �߻� - " + e);
					}
				}
			}
		}
	}
	
	
	
	public static void sendAll(int cat, String s) { // ��� ����ڿ��� ä������
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
