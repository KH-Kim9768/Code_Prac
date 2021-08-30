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
		// Port Number : ��Ʈ��ȣ 2byte = 16��Ʈ
		// 0 ~ +2^16 -1
		// 0 ~ 65535 
		
		System.out.println("���� Ŭ���̾�Ʈ!!");
		
		InetAddress localAddress;
		try {
			localAddress = InetAddress.getLocalHost(); // �� ��ǻ���� IP ȹ��
			
			// try - with - resource
			try(	// ���� ȣ��Ʈ ����, ��Ʈ��ȣ
					Socket cSocket = new Socket(localAddress, 10000);
					// ������ ���� �޼��� ���� ��� ���� ��ü ����
					PrintWriter out = new PrintWriter(cSocket.getOutputStream(), true);
					// ������ ������ �޼��� ���� �Է� ���� ��ü ����
					BufferedReader in = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
					) {
				System.out.println("������ �����!");
				Scanner scan = new Scanner(System.in);
				
				while(true) {                    
					System.out.print("Enter text : ");
					String inputLine = scan.nextLine(); // Ŭ���̾�Ʈ Ű���� �Է�
					if("quit".equalsIgnoreCase(inputLine)) // IgnoreCase = ��ҹ��� ����x
						break;
					
					out.println(inputLine); // ������ ����
					String response = in.readLine();
					System.out.println("������ ������ �޼��� : " + response);
					
				}
				
			} catch(IOException e) {
				
			}
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		

	}

}
