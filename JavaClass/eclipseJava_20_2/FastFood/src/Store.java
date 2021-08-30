
public class Store {
	
	private String menuStr;
	private int choice;
	private String item;
	private int num;
	
	public Store(String menuStr, int choice, String item, int num) {
		this.menuStr = menuStr;
		this.choice = choice;
		this.item = item;
		this.num = num;
	}
	
	public String getmenuStr() {
		return menuStr;
	}
	
	public int getchoice() {
		return choice;
	}
	
	public String getitem() {
		return item;
	}
	
	public int getnum() {
		return num;
	}

}
