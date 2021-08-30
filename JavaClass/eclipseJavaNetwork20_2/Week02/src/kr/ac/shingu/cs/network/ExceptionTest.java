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
			
			// 분모가 0일때
			// 정수값이 아닌 값이 입력 됐을때(실수, 문자열 등)
		} catch (InputMismatchException e) {
			System.out.println("정수가 아닌 값이 입력되었습니다.");
		}
		catch (ArithmeticException e) {
			System.out.println("분모에 0이 올 수 없습니다.");
		}
		catch (Exception e) { // 모든 예외를 받을 수 있음 마지막에 와야함
			System.out.println("예외가 발생 했습니다!");
		}
		finally { // 예외 상관 없이 무조건 실행됨
			System.out.println("프로그램 종료");
			scv.close();
		}

	}

}
