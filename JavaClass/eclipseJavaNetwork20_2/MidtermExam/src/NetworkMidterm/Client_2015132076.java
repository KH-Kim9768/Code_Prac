package NetworkMidterm;
//Around Us Client
//������ : �豤��
//�й� : 2015132076
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client_2015132076 implements Runnable{	// Around Us Client Ŭ����
	
	private static Socket clientSocket;
	
	public Client_2015132076(Socket clientSocket) { // ������
		this.clientSocket = clientSocket;
		
	}

	public static void main(String[] args) {	// main ������
			
		System.out.println("Around Us Ŭ���̾�Ʈ!!");
			
		InetAddress localAddress;
		try {
			localAddress = InetAddress.getLocalHost(); // �� ��ǻ���� IP ȹ��
			
			
			try(	// ���� ȣ��Ʈ ����, ��Ʈ��ȣ   // ������ ����
					Socket cSocket = new Socket(localAddress, 10000);
					// ������ ���� �޼��� ���� ��� ���� ��ü ����
					PrintWriter out = new PrintWriter(cSocket.getOutputStream(), true);
					
					) {
				
				System.out.println("Around Us ������ �����!");  // ���� ���� ������ ���
				Scanner scan = new Scanner(System.in);
				String Nickname;
				while(true) {
					System.out.print("�г��� �Է� : ");
					Nickname = scan.nextLine();
					if ( Nickname.isEmpty() == false) {
						out.println("Nickname:" + Nickname);
						break;
					}
					System.out.println("�߸��� �г����Դϴ�. �ٽ� �Է����ּ���.");
				}
				
				Client_2015132076 auc = new Client_2015132076(cSocket);
				new Thread(auc).start(); // �������� ���� �޼��� �޴� ������ ���� 
				
				
				
				while(true) {

					String inputLine = scan.nextLine(); // Ŭ���̾�Ʈ Ű���� �Է�
					if("quit".equalsIgnoreCase(inputLine)) // IgnoreCase = ��ҹ��� ����x
						break;
					
					out.println(inputLine); // ������ ����

					
				}
				
		
			} catch(IOException e) {
				
			}
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void run() {	// �޼��� �޴� ������
		
		try {
			// ������ ������ �޼��� ���� �Է� ���� ��ü ����
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
