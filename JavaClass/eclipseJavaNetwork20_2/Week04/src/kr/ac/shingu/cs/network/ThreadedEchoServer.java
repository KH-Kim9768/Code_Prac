package kr.ac.shingu.cs.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadedEchoServer implements Runnable {
	
	private static Socket clientSocket;
	
	public ThreadedEchoServer(Socket clientSocket) { // ������
		this.clientSocket = clientSocket;
		
	}
	
	public static void main(String[] args) {
		System.out.println("��Ƽ ���� ���� ����~");
		
		try(ServerSocket serverSocket = new ServerSocket(10000)){
			while(true) {
				System.out.println("������....");
				
				clientSocket = serverSocket.accept();
				
				// Ŭ���̾�Ʈ�� ������ ������ ���� ��ü ����, ������ ����
				ThreadedEchoServer tes = new ThreadedEchoServer(clientSocket);
				
				new Thread(tes).start();
			}
		}catch (IOException ex) {
			
		}
		System.out.println("��Ƽ ���� ������ �����մϴ�!");
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
			
			while((inputLine = in.readLine()) != null) {
				System.out.println("��û Ŭ���̾�Ʈ [" + Thread.currentThread() + "] : " + inputLine); // ���� �ֿܼ� Ŭ���̾�Ʈ�� ���� �޼����� �ٴ��� ���
				out.println(inputLine); // ��¿� ��ü out�� �̿��Ͽ� Ŭ���̾�Ʈ���� Ŭ���̾�Ʈ�� ���� �޼��� ������
				
			}
			System.out.println("��û Ŭ���̾�Ʈ [" + Thread.currentThread() + "] ���� ����� ");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
