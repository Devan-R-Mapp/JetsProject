package com.skilldistillery.jets.entities;

public class Fighter extends Craft {

	
	
	public Fighter(String model, int speed, int range, double price) {
		super(model, speed, range, price);
	}
	
	public void beginAttack() {
		
		System.out.println(this.model + " sets s-foils in attack postition");
	}

}
