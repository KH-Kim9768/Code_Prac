package NetworkMidterm;
//Around Us Game
//제작자 : 김광희
//학번 : 2015132076

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Game_2015132076 implements Runnable{	// Around Us 게임 클래스
	static List<PrintWriter> playerList = null;	// playerList
	static List<BufferedReader> playerBrList = null;	//playerBrList
	static List<String> playerNicknameList = null;	// nicknameList
	
	// aliveList
	static List<PrintWriter> alivePlayerList = new ArrayList<PrintWriter>();	// 현재 생존한 교수, 학생 PrintWriter
	static List<BufferedReader> aliveBrList = new ArrayList<BufferedReader>();		// 현재 생존한 교수, 학생 BufferedReader
	static List<String> aliveNicknameList = new ArrayList<String>();		// 현재 생존한 교수, 학생 Nickname
	
	// professorList
	static List<PrintWriter> professorList = new ArrayList<PrintWriter>();	// professorList 교수
	static List<BufferedReader> professorBrList = new ArrayList<BufferedReader>();	// 교수의 BufferedReader List
	static List<String> professorNicknameList = new ArrayList<String>();
	
	// studentList
	static List<PrintWriter> studentList = new ArrayList<PrintWriter>();	// studentList 학생
	static List<BufferedReader> studentBrList = new ArrayList<BufferedReader>();
	static List<String> studentNicknameList = new ArrayList<String>();
	
	static List<BufferedReader> voteBrList = new ArrayList<BufferedReader>();
	static List<Integer> voteResult = new ArrayList<Integer>();
	int[] countVote = null;
	int gameType = 1;	// profeessor 1명 or 2명
	Timer timer = new Timer();
	static boolean conversationBl = true;
	static boolean voteBl = false;
	static boolean gameBl = true;
	
	BufferedReader receiveBr = null;
	String receiveNickname = null;
	String receiveInputLine = null;
	List<String> receiveInputList = new ArrayList<String>();
	List<String> receiveNicknameList = new ArrayList<String>();
	List<BufferedReader> receiveBrList = new ArrayList<BufferedReader>();
	
	public Game_2015132076 () {	// AroundUsGame 생성자
		
	}
	
	// 게임 시작 셋팅
	public void setPBNL(List<PrintWriter> playerList, List<BufferedReader> playerBrList, List<String> nicknameList) {	// playerList 동기화
		this.playerList = playerList;
		this.playerBrList = playerBrList;
		this.playerNicknameList = nicknameList;
		
		setAliveList();
	}
	
	public void setAliveList() {	// alive 리스트 셋팅
		for(PrintWriter pw : playerList) {
			alivePlayerList.add(pw);
		}
		
		for(BufferedReader br : playerBrList) {
			aliveBrList.add(br);
		}
		
		for(String s : playerNicknameList) {
			aliveNicknameList.add(s);
		}
	}
	
	public void selectProfessor() {	// Professor 선택, 리스트 추가
		int members = playerList.size();
		
		if (members < 6) {
			gameType = 1;
			int proIndex = (int) (Math.random()*members +1);	// 멤버 수 중 1명 추출
		
			professorList.add(playerList.get(proIndex-1));
			professorBrList.add(playerBrList.get(proIndex-1));
			professorNicknameList.add(playerNicknameList.get(proIndex-1));
		} else if (members >= 6) {
			gameType = 2;
			int[] proIndex = new int[2];
			
			for ( int i = 0; i < proIndex.length; i++) {	// 중복 되지 않는 교수 index 2명 추출
				while(true) {
					boolean bl = true;
					proIndex[i] = (int) (Math.random()*proIndex.length + 1);
					for( int j = 0; j < i ; j++) {
						if ( proIndex[j] == proIndex[i] ) {
							bl = false;
							break;
						}
					}
					if (bl) {
						break;
					}
				}
			}
			
			for ( int i = 0; i < proIndex.length; i++) {
				professorList.add(playerList.get(proIndex[i]-1));
				professorBrList.add(playerBrList.get(proIndex[i]-1));
				professorNicknameList.add(playerNicknameList.get(proIndex[i]-1));
			}
		}
		
		setStudentList();
	}
	
	public void setStudentList() {	// player 중 professor 리스트 인원 제외 studentList 추가
		for(PrintWriter out : playerList) { 	// studentList 설정 for문
			if (gameType == 1 ) {
				if (out == professorList.get(0)) {
					continue;
				}
			} else if (gameType == 2) {
				if (out == professorList.get(0) || out == professorList.get(1)) {
					continue;
				}
			}
			
			studentList.add(out);
		}
		
		for(BufferedReader in : playerBrList) {	// studentBrList 설정 for문
			if (gameType == 1) {
				if (in == professorBrList.get(0)) {
					continue;
				}
			} else if (gameType == 2) {
				if (in == professorBrList.get(0) || in == professorBrList.get(1)) {
					continue;
				}
			}
			
			studentBrList.add(in);
		}
		
		for(String s : playerNicknameList) {	// studentNicknameList 설정 for문
			if (gameType == 1) {
				if (s.equals(professorNicknameList.get(0))) {
					continue;
				}
			} else if (gameType == 2) {
				if (s.equals(professorNicknameList.get(0)) || s.equals(professorNicknameList.get(1))) {
					continue;
				}
			}
			
			studentNicknameList.add(s);
		}
	}
	
	public void noticeRole() {	// 역할 고지
		
		for(PrintWriter out : professorList) {	// Professor
			out.println("당신은 교수입니다. 학생들에게 들키지 않고 F를 주세요");
			out.flush();
		}
		
		
		for(PrintWriter out : studentList) {	// Student
			
			out.println("당신은 학생입니다. 학생들 사이에 숨어있는 교수를 찾아 승리하세요");
			out.flush();
		}
	}
	
	public void noticeRule() {	// 게임 룰 고지

		for(PrintWriter out : alivePlayerList) {
			
			out.println("Around Us Game 룰");
			out.println("");
			out.println("1. 낮에는 대화를 통해 교수를 찾아 투표합니다.");
			out.println("2. 밤에는 교수가 학생 한 명에게 F를 줄 수  있습니다.");
			out.println("3. 교수의 수와 학생의 수가 같으면 교수의 승리로 게임은 종료됩니다.");
			out.println("4. 학생들이 교수를 모두 찾으면 학생들의 승리로 게임은 종료됩니다.");
			out.println("5. 투표 시간에 지정된 숫자 이외의 문자를 입력하면 skip표로 간주됩니다.");
			out.println("");
			out.println("## 모든 player는 Enter키를 한 번 눌러 주세요 ##");
		}
	}

	
	// 게임 진행 관련 메소드
	public void voteStart() {	// 투표 메소드, alive player 에게만 전송
		
		for (PrintWriter out : alivePlayerList) {	// 투표 전송
			out.println("## 누가 교수님일까? ##");
			out.println("0. 투표 스킵(무효표)");
			for (int i = 1 ; i <= alivePlayerList.size() ; i ++ ) {
				out.println(i + ". " + aliveNicknameList.get(i-1));
			}
		}
		
		for(BufferedReader br : aliveBrList) {	// voteBrList 생성
			voteBrList.add(br);
		}
		
		voteBl = true;	// 투표 시작
	}
		
		
	public void vote(BufferedReader br, String inputLine) {	// 투표 받음
			
		if (voteBrList.contains(br)) {
			voteResult(inputLine);
			voteBrList.remove(voteBrList.indexOf(br));
		}
		
		if (voteBrList.size() == 0) {
			voteBl = false;
			
		}
			
			
		
		
	}
	
	
	public void professorVoteStart() {	// 교수 전용 투표 메소드
		
		for (PrintWriter out : professorList) {	// 투표 전송
			out.println("## 누구에게 F 학점을 줄까? ##");
			out.println("0. 투표 스킵(무효표)");
			for (int i = 1 ; i <= studentList.size() ; i ++ ) {
				out.println(i + ". " + studentNicknameList.get(i-1));
			}
		}
		
		for(BufferedReader br : professorBrList) {	// voteBrList 생성
			voteBrList.add(br);
		}
		
		voteBl = true;	// 투표 시작
		
		
	}
	
	public void voteResult(String s) {	// 투표 결과 수집 메소드
		synchronized ( voteResult ) {
			try {
				if (Integer.parseInt(s) > alivePlayerList.size())	// 플레이어 숫자보다 큰 수가 들어오면 0에 추가
					voteResult.add(0);
				
				voteResult.add(Integer.parseInt(s));	// 투표 결과를 Integer 형태로 담음
			} catch (NumberFormatException e) {
				voteResult.add(0);						// 지정된 숫자 이외의 값을 입력했을 경우 0(Skip)을 넣음
			}	
		}
	}
	
	public void countVote() {	// 투표 집계 메소드 ( alivePlayer 학생 + 교수 모두 투표 )
		countVote = new int[alivePlayerList.size()+1];	// 남은 플레이어 수 만큼 배열 생성
		for (int i = 0; i < voteResult.size(); i ++) {
			for (int j = 1; j <= alivePlayerList.size(); j ++) {
				if (j == voteResult.get(i)) {	// voteResult[0]의 값이 j와 같은 값이면 해당 인덱스에 카운팅 +1
					countVote[j] ++ ;
					break;	// 해당 값 찾으면 j for문 break;
				} else if (voteResult.get(i) > alivePlayerList.size() || voteResult.get(i) == 0 ) {
					countVote[0] ++ ;
					break;	// j for문 break;
				}	
			}
		}
		
		voteResult.clear(); 	// voteResult 값 모두 삭제
	}
	
	public void countProfessorVote() {	// ( studentPlayer 교수의 투표 집계
		countVote = new int[studentList.size()+1];	// 학생 플레이어 수 만큼 배열 생성
		for (int i = 0; i < voteResult.size(); i ++) {
			for (int j = 1; j <= studentList.size(); j ++) {
				if (j == voteResult.get(i)) {	// voteResult[0]의 값이 j와 같은 값이면 해당 인덱스에 카운팅 +1
					countVote[j] ++ ;
					break;	// 해당 값 찾으면 j for문 break;
				} else if (voteResult.get(i) > studentList.size() || voteResult.get(i) == 0 ) {
					countVote[0] ++ ;
					break;	// j for문 break;
				}	
			}
		}
		
		voteResult.clear(); 	// voteResult 값 모두 삭제
	}
	
	public void noticeVoteResult() {	// 투표 결과 playerList 모두에게 전송 (죽은 사람 포함) 
		for (PrintWriter out : playerList) {	// 모든 player에게 결과 전송
			out.println("## 투표 결과");
			for (int i = 0 ; i < countVote.length; i ++) {
				if ( i == 0 ) {
					out.println(i + ". 투표스킵 - " + countVote[i] + "표");
				}
				else {
					out.println(i + ". " + aliveNicknameList.get(i-1) + " - " + countVote[i] + "표");
				}	
			}
		}
		
		scoreFPlayer(0);	// 투표 결과에 따라 플레이어 조정
		
		
		countVote = null; // countVote 변수 초기화
	}
	
	public void noticeProfessorVoteResult() {	// 교수 투표 결과 전송
		for (PrintWriter out : playerList) {	// 모든 player에게 결과 전송
			out.println("## 투표 결과");
			for (int i = 0 ; i < countVote.length; i ++) {
				if ( i == 0 ) {
					out.println(i + ". 투표스킵 - " + countVote[i] + "표");
				}
				else {
					out.println(i + ". " + studentNicknameList.get(i-1) + " - " + countVote[i] + "표");
				}	
			}
		}
		
		scoreFPlayer(1);	// 투표 결과에 따라 플레이어 조정
		
		
		countVote = null; // countVote 변수 초기화
	}
	
		
	public void scoreFPlayer(int type) {	// 투표 많이 받은 플레이어, 교수가 선택한 플레이어 죽임
		int scoreF = 0;
		int index = 0;
		for (int i = 0; i < countVote.length; i ++) { // 가장 높은 득표수, index 가져옴
			if(scoreF < countVote[i]) {
				scoreF = countVote[i];
				index = i;
			}
		}
		
		for (int i = 0; i < countVote.length; i ++) {
			if(scoreF == countVote[i] && i != index) {
				String notice = "투표수가 같은 플레이어가 있습니다. 아무도 퇴출되지 않았습니다.";
				sendTo(0, notice, 0);
				return;	// 득표수가 같은 플레이어가 있으면 함수 종료
			}
		}
		
		if (type == 0) {	// type == 0 ( 모든 플레이어 투표 )
			String noticeFPlayer = aliveNicknameList.get(index-1) + " 플레이어가 퇴출되었습니다.";
			sendTo(0, noticeFPlayer, 0);
			if (studentNicknameList.contains(aliveNicknameList.get(index-1))) {
				int getIndex = studentNicknameList.indexOf(aliveNicknameList.get(index-1));
				noticeFPlayer = aliveNicknameList.get(index-1) + " 플레이어는 학생이었습니다.";
				sendTo(0, noticeFPlayer, 0);
				studentList.remove(getIndex);
				studentBrList.remove(getIndex);
				studentNicknameList.remove(getIndex);
			} else if (professorNicknameList.contains(aliveNicknameList.get(index-1))) {
				int getIndex = professorNicknameList.indexOf(aliveNicknameList.get(index-1));
				noticeFPlayer = aliveNicknameList.get(index-1) + " 플레이어는 교수님이었습니다.";
				sendTo(0, noticeFPlayer, 0);
				professorList.remove(getIndex);
				professorBrList.remove(getIndex);
				professorNicknameList.remove(getIndex);
			}
			alivePlayerList.remove(index-1);
			aliveBrList.remove(index-1);
			aliveNicknameList.remove(index-1);
			
		} else if (type == 1) {	// type == 1 ( 교수 플레이어 투표 )
			String noticeFPlayer = studentNicknameList.get(index-1) + " 플레이어가 퇴출되었습니다.";
			sendTo(0, noticeFPlayer, 0);
			int getIndex = aliveNicknameList.indexOf(studentNicknameList.get(index-1));
			alivePlayerList.remove(getIndex);
			aliveBrList.remove(getIndex);
			aliveNicknameList.remove(getIndex);
			studentList.remove(index-1);
			studentBrList.remove(index-1);
			studentNicknameList.remove(index-1);
		}
		
		
	}
	
	public void conversationTimer(long t) {	// 지정된 시간이 지나면 대화 무한루프 false로 닫음
		TimerTask c_task = new TimerTask() {
			
			public void run() {
				conversationBl = false;
				String notice = "20초가 지났습니다. 투표를 시작합니다.";
				sendTo(0, notice, 0);
			}
			
		};
		conversationBl = true;	// 대화 다시 열어줌
		String notice = "20초 동안 대화하세요";
		sendTo(0, notice, 0);
		timer.schedule(c_task, t);
	}
	
	public void voteTimer(long t) {
		TimerTask v_task = new TimerTask() {
			
			public void run() {
				voteBl = false;
				voteBrList.clear();
				countVote();
				noticeVoteResult();
			}
		};
		String notice = "투표 10초 남았습니다";
		sendTo(0, notice, 0);
		timer.schedule(v_task, t);
	}
	
	public void professorVoteTimer(long t) {
		TimerTask v_task = new TimerTask() {
			
			public void run() {
				voteBl = false;
				voteBrList.clear();
				countProfessorVote();		// 투표 끝나면 투표 집계
				noticeProfessorVoteResult();	// 투표 결과 공지
			}
		};
		String notice = "투표 10초 남았습니다";
		sendTo(0, notice, 1);
		timer.schedule(v_task, t);
	}
	
	public boolean gameOver() {	// 게임 종료 조건 메소드 게임 종료조건이 되면 true return;
		if (professorList.size() == studentList.size()) {
			String notice = "교수팀이 승리했습니다.";
			sendTo(0, notice, 0);
			return true;
		}
		else if (studentList.size() == 0) {
			String notice = "교수팀이 승리했습니다.";
			sendTo(0, notice, 0);
			return true;
		}
		else if (professorList.size() == 0 ) {
			String notice = "학생팀이 승리했습니다.";
			sendTo(0, notice, 0);
			return true;
		}
		else if (alivePlayerList.size() == 0) {
			String notice = "플레이어가 없습니다.";
			sendTo(0, notice, 0);
			return true;
		}
		else return false;
	}
	
	public static void sendTo(int cat, String s, int type) { // type == 1 -> sendToProfessor
		synchronized (playerList){							 // type == 0 -> sendAll
			String c;
			
			if ( cat == 0 ) {
				c = "[Server]  ";
			} else if ( cat == 1 ) {
				c = "[Player]  ";
			} else {
				c = "[ETC]  ";
			}
			
			if ( type == 0 ) {	// 모두에게 메세지 전송
				for(PrintWriter out : playerList) {
					out.println(c + s);
					out.flush();
				}
			} else if ( type == 1) {	// 교수에게 메세지 전송
				for(PrintWriter out : professorList) {
					out.println(c + s);
					out.flush();
				}
			}
			
			
		}
	}
	
	// 서버 쓰레드로부터 메세지 정보 받아옴
	public void receiveMessage(BufferedReader receiveBr, String receiveNickname, String receiveInputLine) {
		
		if (voteBl) {
			vote(receiveBr, receiveInputLine);
		}
		else {
			
			if(aliveBrList.contains(receiveBr) && conversationBl) {
				sendTo(1, receiveNickname + " : " + receiveInputLine, 0);
			}
			
		}
		
	}
	
	public void threadSleep(long t) {
		try {
			Thread.sleep(t);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
	
	public void run() {
		sendTo(0, "게임시작합니다!", 0);	// sendAll
		selectProfessor();	// 교수 선발, studentList 작성
		threadSleep(1000);
		noticeRule();	// 게임 룰 고지
		
		threadSleep(2000);
		
		noticeRole();	// 게임 역할 고지
		threadSleep(2000);
		
		// 게임 시작
		
		while (true) {
			conversationTimer(20000);
			threadSleep(22000);
			
			voteStart();
			voteTimer(10000);
			threadSleep(12000);
			
			if (gameOver()) {
				break;
			}
			
			professorVoteStart();
			professorVoteTimer(10000);
			threadSleep(12000);
			
			if (gameOver()) {
				break;
			}
		}
		

		
		sendTo(0, "게임을 종료합니다. " ,0);
		

	}
	
}
