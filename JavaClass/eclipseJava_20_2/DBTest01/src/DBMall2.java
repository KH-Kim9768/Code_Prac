
public class DBMall2 {
	/* 다음 주 미션
	 * PreparedStatement() 알아오기 -> 다음 주 시행
	 * 
	 * Statement 클래스
	 *   SQL 구문을 실행하는 역할
	 *   스스로는 SQL 구문 이해 못함(구문해석 X) -> 전달역할
	 *   SQL 관리 O + 연결 정보 X
	 *   
	 * PreparedStatement 클래스
	 *   Statement 클래스의 기능 향상
	 *   인자와 관련된 작업이 특화(매개변수)
	 *   코드 안정성 높음, 가독성 높음
	 *   코드량이 증가 -> 매개변수를 set 해줘야하기 때문에
	 *   텍스트 SQL 호출
	 *  
	 * 
	 * 
	 * 
	 */

	public static void main(String[] args) {
		DBSelect dbs = new DBSelect();
//		dbs.select();
		
		
		if (args.length != 4) {
			System.out.println("사용 확인 : 상품코드 상품명 가격 제조사");
			return;
		}
		
		dbs.insert(args);
		dbs.select();
	}

}
