package kr.ac.shingu.cs.network;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest {

	public static void main(String[] args) {
		Scanner scv = new Scanner(System.in);
		
		try {
			int a = scv.nextInt();
			int b = scv.nextInt();
			
			System.out.println(a/b);
			
			// �и� 0�϶�
			// �������� �ƴ� ���� �Է� ������(�Ǽ�, ���ڿ� ��)
		} catch (InputMismatchException e) {
			System.out.println("������ �ƴ� ���� �ԷµǾ����ϴ�.");
		}
		catch (ArithmeticException e) {
			System.out.println("�и� 0�� �� �� �����ϴ�.");
		}
		catch (Exception e) { // ��� ���ܸ� ���� �� ���� �������� �;���
			System.out.println("���ܰ� �߻� �߽��ϴ�!");
		}
		finally { // ���� ��� ���� ������ �����
			System.out.println("���α׷� ����");
			scv.close();
		}

	}

}
