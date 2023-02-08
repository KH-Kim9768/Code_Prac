package kr.ac.shingu.cs.network;

// lambda 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ThreadedEchoServer implements Runnable {
	
	private static Socket clientSocket;
	
	public ThreadedEchoServer(Socket clientSocket) { // ������
		this.clientSocket = clientSocket;
	}
	
	public static void main(String[] args) {
		System.out.println("��Ƽ ���� ���� ����~");
		
		try(ServerSocket serverSocket = new ServerSocket(9000)){
			while(true) {
				System.out.println("������....");
				
				clientSocket = serverSocket.accept();
				
				// Ŭ���̾�Ʈ�� ������ ������ ���� ��ü ����, ������ ����
				ThreadedEchoServer tes = new ThreadedEchoServer(clientSocket);
				
				new Thread(tes).start();
			}
		}catch (IOException ex) {
			ex.printStackTrace();
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
			
			
			
			
			// Old School Code
			
//			String inputLine;
//			while((inputLine = in.readLine()) != null) {
//				System.out.println("��û Ŭ���̾�Ʈ [" + Thread.currentThread() + "] : " + inputLine); // ���� �ֿܼ� Ŭ���̾�Ʈ�� ���� �޼����� �ٴ��� ���
//				out.println(inputLine); // ��¿� ��ü out�� �̿��Ͽ� Ŭ���̾�Ʈ���� Ŭ���̾�Ʈ�� ���� �޼��� ������
//				
//			}
//			System.out.println("��û Ŭ���̾�Ʈ [" + Thread.currentThread() + "] ���� ����� ");
			
			
			// Modern Style (jdk 8+)
			// Lambda�� ���� + ǥ�� �Լ��� �������̽�(�ֿ� 4���� Supplier(�Է�X ����O), Consumer(�Է�O, ����X), Function(�Է�O, ����O), Predicate(�Է�O, ���� Boolean))
			
			Supplier<String> socketInput = () -> { // Supplier �� ������ return�� �־�� ��
				try {							   // try, catch �Ѵ� return �־�� ��
					return in.readLine();
				} catch (IOException e) {
					return null;
				}
			};
			
			Stream<String> stream = Stream.generate(socketInput); 
			// generate�� Stream Ŭ������ �����޼ҵ� �̸� �Ű������� Supplier�� �޴´� 
			stream
			.map( s -> {
				System.out.println("��ûŬ���̾�Ʈ [" + Thread.currentThread() + "] : " + s);
				out.println(s);
				return s;
			} )
			.allMatch( s -> s != null ); // (s) -> { return s != null; } 
			// map�� Stream Ŭ������ �ν��Ͻ� �޼ҵ��̸� �Ű������� Function�� �޴´�.
			// allMatch�� Stream Ŭ������ �ν��Ͻ� �޼ҵ��̸� �Ű������� Predicate�� �޴´�.
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
