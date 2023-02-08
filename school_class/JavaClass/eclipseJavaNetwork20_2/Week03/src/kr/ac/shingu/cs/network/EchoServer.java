package kr.ac.shingu.cs.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter; // Ŭ���̾�Ʈ���� ���� �޼����� ��Ƶ� ����
import java.net.ServerSocket; // ������ ����
import java.net.Socket; // Ŭ���̾�Ʈ ��

// ���������� ��Ʈ��ȣ�� ������� �Ѵ�.
// ������ IP�ּҿ� ��Ʈ��ȣ ���տ� ���� �ĺ��ȴ�.
		

public class EchoServer {
	
	public static void main(String[] args) {
		System.out.println("���� ����");
		
		// ���� ����, ��Ʈ ��ȣ ����
		// try - with - resource
		try(ServerSocket sSocket = new ServerSocket(6000)){
			System.out.println("���� �����...");
			Socket cSocket = sSocket.accept(); // ���� ����
			System.out.println("Ŭ���̾�Ʈ�� �����!");
			
			try(	// Ŭ���̾�Ʈ ���α׷��� �����ϴ� �ؽ�Ʈ�� ���� ���� �غ�
					BufferedReader in = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
					// Ŭ���̾�Ʈ ���� ���� �� �ؽ�Ʈ�� ���� ���� �غ�
					PrintWriter out = new PrintWriter(cSocket.getOutputStream(), true);){
				
				String inputLine;
				while((inputLine = in.readLine()) != null) {
					System.out.println("Server : " + inputLine); // ���� �ֿܼ� Ŭ���̾�Ʈ�� ���� �޼����� �ٴ��� ���
					out.println(inputLine); // ��¿� ��ü out�� �̿��Ͽ� Ŭ���̾�Ʈ���� Ŭ���̾�Ʈ�� ���� �޼��� ������
					
				}
			}catch(IOException e) {
				
			}
			
		}catch(IOException e) {
			
		}
		System.out.println("���� �����!");		
	}

}
