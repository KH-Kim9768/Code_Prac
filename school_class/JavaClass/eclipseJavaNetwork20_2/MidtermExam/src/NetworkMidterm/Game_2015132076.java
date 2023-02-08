package NetworkMidterm;
//Around Us Game
//������ : �豤��
//�й� : 2015132076

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Game_2015132076 implements Runnable{	// Around Us ���� Ŭ����
	static List<PrintWriter> playerList = null;	// playerList
	static List<BufferedReader> playerBrList = null;	//playerBrList
	static List<String> playerNicknameList = null;	// nicknameList
	
	// aliveList
	static List<PrintWriter> alivePlayerList = new ArrayList<PrintWriter>();	// ���� ������ ����, �л� PrintWriter
	static List<BufferedReader> aliveBrList = new ArrayList<BufferedReader>();		// ���� ������ ����, �л� BufferedReader
	static List<String> aliveNicknameList = new ArrayList<String>();		// ���� ������ ����, �л� Nickname
	
	// professorList
	static List<PrintWriter> professorList = new ArrayList<PrintWriter>();	// professorList ����
	static List<BufferedReader> professorBrList = new ArrayList<BufferedReader>();	// ������ BufferedReader List
	static List<String> professorNicknameList = new ArrayList<String>();
	
	// studentList
	static List<PrintWriter> studentList = new ArrayList<PrintWriter>();	// studentList �л�
	static List<BufferedReader> studentBrList = new ArrayList<BufferedReader>();
	static List<String> studentNicknameList = new ArrayList<String>();
	
	static List<BufferedReader> voteBrList = new ArrayList<BufferedReader>();
	static List<Integer> voteResult = new ArrayList<Integer>();
	int[] countVote = null;
	int gameType = 1;	// profeessor 1�� or 2��
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
	
	public Game_2015132076 () {	// AroundUsGame ������
		
	}
	
	// ���� ���� ����
	public void setPBNL(List<PrintWriter> playerList, List<BufferedReader> playerBrList, List<String> nicknameList) {	// playerList ����ȭ
		this.playerList = playerList;
		this.playerBrList = playerBrList;
		this.playerNicknameList = nicknameList;
		
		setAliveList();
	}
	
	public void setAliveList() {	// alive ����Ʈ ����
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
	
	public void selectProfessor() {	// Professor ����, ����Ʈ �߰�
		int members = playerList.size();
		
		if (members < 6) {
			gameType = 1;
			int proIndex = (int) (Math.random()*members +1);	// ��� �� �� 1�� ����
		
			professorList.add(playerList.get(proIndex-1));
			professorBrList.add(playerBrList.get(proIndex-1));
			professorNicknameList.add(playerNicknameList.get(proIndex-1));
		} else if (members >= 6) {
			gameType = 2;
			int[] proIndex = new int[2];
			
			for ( int i = 0; i < proIndex.length; i++) {	// �ߺ� ���� �ʴ� ���� index 2�� ����
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
	
	public void setStudentList() {	// player �� professor ����Ʈ �ο� ���� studentList �߰�
		for(PrintWriter out : playerList) { 	// studentList ���� for��
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
		
		for(BufferedReader in : playerBrList) {	// studentBrList ���� for��
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
		
		for(String s : playerNicknameList) {	// studentNicknameList ���� for��
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
	
	public void noticeRole() {	// ���� ����
		
		for(PrintWriter out : professorList) {	// Professor
			out.println("����� �����Դϴ�. �л��鿡�� ��Ű�� �ʰ� F�� �ּ���");
			out.flush();
		}
		
		
		for(PrintWriter out : studentList) {	// Student
			
			out.println("����� �л��Դϴ�. �л��� ���̿� �����ִ� ������ ã�� �¸��ϼ���");
			out.flush();
		}
	}
	
	public void noticeRule() {	// ���� �� ����

		for(PrintWriter out : alivePlayerList) {
			
			out.println("Around Us Game ��");
			out.println("");
			out.println("1. ������ ��ȭ�� ���� ������ ã�� ��ǥ�մϴ�.");
			out.println("2. �㿡�� ������ �л� �� ���� F�� �� ��  �ֽ��ϴ�.");
			out.println("3. ������ ���� �л��� ���� ������ ������ �¸��� ������ ����˴ϴ�.");
			out.println("4. �л����� ������ ��� ã���� �л����� �¸��� ������ ����˴ϴ�.");
			out.println("5. ��ǥ �ð��� ������ ���� �̿��� ���ڸ� �Է��ϸ� skipǥ�� ���ֵ˴ϴ�.");
			out.println("");
			out.println("## ��� player�� EnterŰ�� �� �� ���� �ּ��� ##");
		}
	}

	
	// ���� ���� ���� �޼ҵ�
	public void voteStart() {	// ��ǥ �޼ҵ�, alive player ���Ը� ����
		
		for (PrintWriter out : alivePlayerList) {	// ��ǥ ����
			out.println("## ���� �������ϱ�? ##");
			out.println("0. ��ǥ ��ŵ(��ȿǥ)");
			for (int i = 1 ; i <= alivePlayerList.size() ; i ++ ) {
				out.println(i + ". " + aliveNicknameList.get(i-1));
			}
		}
		
		for(BufferedReader br : aliveBrList) {	// voteBrList ����
			voteBrList.add(br);
		}
		
		voteBl = true;	// ��ǥ ����
	}
		
		
	public void vote(BufferedReader br, String inputLine) {	// ��ǥ ����
			
		if (voteBrList.contains(br)) {
			voteResult(inputLine);
			voteBrList.remove(voteBrList.indexOf(br));
		}
		
		if (voteBrList.size() == 0) {
			voteBl = false;
			
		}
			
			
		
		
	}
	
	
	public void professorVoteStart() {	// ���� ���� ��ǥ �޼ҵ�
		
		for (PrintWriter out : professorList) {	// ��ǥ ����
			out.println("## �������� F ������ �ٱ�? ##");
			out.println("0. ��ǥ ��ŵ(��ȿǥ)");
			for (int i = 1 ; i <= studentList.size() ; i ++ ) {
				out.println(i + ". " + studentNicknameList.get(i-1));
			}
		}
		
		for(BufferedReader br : professorBrList) {	// voteBrList ����
			voteBrList.add(br);
		}
		
		voteBl = true;	// ��ǥ ����
		
		
	}
	
	public void voteResult(String s) {	// ��ǥ ��� ���� �޼ҵ�
		synchronized ( voteResult ) {
			try {
				if (Integer.parseInt(s) > alivePlayerList.size())	// �÷��̾� ���ں��� ū ���� ������ 0�� �߰�
					voteResult.add(0);
				
				voteResult.add(Integer.parseInt(s));	// ��ǥ ����� Integer ���·� ����
			} catch (NumberFormatException e) {
				voteResult.add(0);						// ������ ���� �̿��� ���� �Է����� ��� 0(Skip)�� ����
			}	
		}
	}
	
	public void countVote() {	// ��ǥ ���� �޼ҵ� ( alivePlayer �л� + ���� ��� ��ǥ )
		countVote = new int[alivePlayerList.size()+1];	// ���� �÷��̾� �� ��ŭ �迭 ����
		for (int i = 0; i < voteResult.size(); i ++) {
			for (int j = 1; j <= alivePlayerList.size(); j ++) {
				if (j == voteResult.get(i)) {	// voteResult[0]�� ���� j�� ���� ���̸� �ش� �ε����� ī���� +1
					countVote[j] ++ ;
					break;	// �ش� �� ã���� j for�� break;
				} else if (voteResult.get(i) > alivePlayerList.size() || voteResult.get(i) == 0 ) {
					countVote[0] ++ ;
					break;	// j for�� break;
				}	
			}
		}
		
		voteResult.clear(); 	// voteResult �� ��� ����
	}
	
	public void countProfessorVote() {	// ( studentPlayer ������ ��ǥ ����
		countVote = new int[studentList.size()+1];	// �л� �÷��̾� �� ��ŭ �迭 ����
		for (int i = 0; i < voteResult.size(); i ++) {
			for (int j = 1; j <= studentList.size(); j ++) {
				if (j == voteResult.get(i)) {	// voteResult[0]�� ���� j�� ���� ���̸� �ش� �ε����� ī���� +1
					countVote[j] ++ ;
					break;	// �ش� �� ã���� j for�� break;
				} else if (voteResult.get(i) > studentList.size() || voteResult.get(i) == 0 ) {
					countVote[0] ++ ;
					break;	// j for�� break;
				}	
			}
		}
		
		voteResult.clear(); 	// voteResult �� ��� ����
	}
	
	public void noticeVoteResult() {	// ��ǥ ��� playerList ��ο��� ���� (���� ��� ����) 
		for (PrintWriter out : playerList) {	// ��� player���� ��� ����
			out.println("## ��ǥ ���");
			for (int i = 0 ; i < countVote.length; i ++) {
				if ( i == 0 ) {
					out.println(i + ". ��ǥ��ŵ - " + countVote[i] + "ǥ");
				}
				else {
					out.println(i + ". " + aliveNicknameList.get(i-1) + " - " + countVote[i] + "ǥ");
				}	
			}
		}
		
		scoreFPlayer(0);	// ��ǥ ����� ���� �÷��̾� ����
		
		
		countVote = null; // countVote ���� �ʱ�ȭ
	}
	
	public void noticeProfessorVoteResult() {	// ���� ��ǥ ��� ����
		for (PrintWriter out : playerList) {	// ��� player���� ��� ����
			out.println("## ��ǥ ���");
			for (int i = 0 ; i < countVote.length; i ++) {
				if ( i == 0 ) {
					out.println(i + ". ��ǥ��ŵ - " + countVote[i] + "ǥ");
				}
				else {
					out.println(i + ". " + studentNicknameList.get(i-1) + " - " + countVote[i] + "ǥ");
				}	
			}
		}
		
		scoreFPlayer(1);	// ��ǥ ����� ���� �÷��̾� ����
		
		
		countVote = null; // countVote ���� �ʱ�ȭ
	}
	
		
	public void scoreFPlayer(int type) {	// ��ǥ ���� ���� �÷��̾�, ������ ������ �÷��̾� ����
		int scoreF = 0;
		int index = 0;
		for (int i = 0; i < countVote.length; i ++) { // ���� ���� ��ǥ��, index ������
			if(scoreF < countVote[i]) {
				scoreF = countVote[i];
				index = i;
			}
		}
		
		for (int i = 0; i < countVote.length; i ++) {
			if(scoreF == countVote[i] && i != index) {
				String notice = "��ǥ���� ���� �÷��̾ �ֽ��ϴ�. �ƹ��� ������� �ʾҽ��ϴ�.";
				sendTo(0, notice, 0);
				return;	// ��ǥ���� ���� �÷��̾ ������ �Լ� ����
			}
		}
		
		if (type == 0) {	// type == 0 ( ��� �÷��̾� ��ǥ )
			String noticeFPlayer = aliveNicknameList.get(index-1) + " �÷��̾ ����Ǿ����ϴ�.";
			sendTo(0, noticeFPlayer, 0);
			if (studentNicknameList.contains(aliveNicknameList.get(index-1))) {
				int getIndex = studentNicknameList.indexOf(aliveNicknameList.get(index-1));
				noticeFPlayer = aliveNicknameList.get(index-1) + " �÷��̾�� �л��̾����ϴ�.";
				sendTo(0, noticeFPlayer, 0);
				studentList.remove(getIndex);
				studentBrList.remove(getIndex);
				studentNicknameList.remove(getIndex);
			} else if (professorNicknameList.contains(aliveNicknameList.get(index-1))) {
				int getIndex = professorNicknameList.indexOf(aliveNicknameList.get(index-1));
				noticeFPlayer = aliveNicknameList.get(index-1) + " �÷��̾�� �������̾����ϴ�.";
				sendTo(0, noticeFPlayer, 0);
				professorList.remove(getIndex);
				professorBrList.remove(getIndex);
				professorNicknameList.remove(getIndex);
			}
			alivePlayerList.remove(index-1);
			aliveBrList.remove(index-1);
			aliveNicknameList.remove(index-1);
			
		} else if (type == 1) {	// type == 1 ( ���� �÷��̾� ��ǥ )
			String noticeFPlayer = studentNicknameList.get(index-1) + " �÷��̾ ����Ǿ����ϴ�.";
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
	
	public void conversationTimer(long t) {	// ������ �ð��� ������ ��ȭ ���ѷ��� false�� ����
		TimerTask c_task = new TimerTask() {
			
			public void run() {
				conversationBl = false;
				String notice = "20�ʰ� �������ϴ�. ��ǥ�� �����մϴ�.";
				sendTo(0, notice, 0);
			}
			
		};
		conversationBl = true;	// ��ȭ �ٽ� ������
		String notice = "20�� ���� ��ȭ�ϼ���";
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
		String notice = "��ǥ 10�� ���ҽ��ϴ�";
		sendTo(0, notice, 0);
		timer.schedule(v_task, t);
	}
	
	public void professorVoteTimer(long t) {
		TimerTask v_task = new TimerTask() {
			
			public void run() {
				voteBl = false;
				voteBrList.clear();
				countProfessorVote();		// ��ǥ ������ ��ǥ ����
				noticeProfessorVoteResult();	// ��ǥ ��� ����
			}
		};
		String notice = "��ǥ 10�� ���ҽ��ϴ�";
		sendTo(0, notice, 1);
		timer.schedule(v_task, t);
	}
	
	public boolean gameOver() {	// ���� ���� ���� �޼ҵ� ���� ���������� �Ǹ� true return;
		if (professorList.size() == studentList.size()) {
			String notice = "�������� �¸��߽��ϴ�.";
			sendTo(0, notice, 0);
			return true;
		}
		else if (studentList.size() == 0) {
			String notice = "�������� �¸��߽��ϴ�.";
			sendTo(0, notice, 0);
			return true;
		}
		else if (professorList.size() == 0 ) {
			String notice = "�л����� �¸��߽��ϴ�.";
			sendTo(0, notice, 0);
			return true;
		}
		else if (alivePlayerList.size() == 0) {
			String notice = "�÷��̾ �����ϴ�.";
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
			
			if ( type == 0 ) {	// ��ο��� �޼��� ����
				for(PrintWriter out : playerList) {
					out.println(c + s);
					out.flush();
				}
			} else if ( type == 1) {	// �������� �޼��� ����
				for(PrintWriter out : professorList) {
					out.println(c + s);
					out.flush();
				}
			}
			
			
		}
	}
	
	// ���� ������κ��� �޼��� ���� �޾ƿ�
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
		sendTo(0, "���ӽ����մϴ�!", 0);	// sendAll
		selectProfessor();	// ���� ����, studentList �ۼ�
		threadSleep(1000);
		noticeRule();	// ���� �� ����
		
		threadSleep(2000);
		
		noticeRole();	// ���� ���� ����
		threadSleep(2000);
		
		// ���� ����
		
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
		

		
		sendTo(0, "������ �����մϴ�. " ,0);
		

	}
	
}
