
public class Store {

	private String menuStr;
	private int choice;
	private String item;
	private int suryang;
	public Store(String menuStr, int choice, String item, int suryang){
		this.menuStr = menuStr;
		
		if (menuStr.equals("1")) {
			this.choice = choice;
			this.item = item;
			this.suryang = suryang;
		}else if(menuStr.equals("2")) {
			this.choice = choice;
			this.item = item;
			this.suryang = suryang;
		}else if(menuStr.equals("3")) {
			this.choice = choice;
			this.item = item;
			this.suryang = suryang;
		}
	}
	public String getmenuStr(){
		return menuStr;
	}	
	public int getchoice(){
		return choice;
	}
	public String getitem(){
		return item;
	}
	public int getsuryang(){
		return suryang;
	}
}