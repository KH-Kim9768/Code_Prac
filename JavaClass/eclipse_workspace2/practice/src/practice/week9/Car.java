package practice.week9;

public class Car {
	
	
	String model;
	String company="Çö´ë";
	String color;
	int maxSpeed;
	
	Car(){
		
	}
	
	
	Car(String model){
//		this.model=model;
//		this.color="silver";
//		this.maxSpeed=250;
		
		this(model, "silver", 250);
		
	}
	
	Car(String model, String color){
//		this.model=model;
//		this.color=color;
//		this.maxSpeed=250;
		
		this(model, color, 250);
		
	}
	
	Car(String model, String color, int maxSpeed){
		this.model=model;
		this.color=color;
		this.maxSpeed=maxSpeed;
		
	}

}
