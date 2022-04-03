package com.skilldistillery.jets.entities;

public class Fighter extends Craft implements CombatReady{

	
	
	public Fighter(String model, int speed, int range, double price) {
		super(model, speed, range, price);
	}
	
	public void beginAttack() {
		
		System.out.println(this.model + " intercepts other incoming fighters.");
	}

	public void combatReady() {
		System.out.println();
		System.out.println("---------------------------------------------");
		System.out.println(this.model + " sets it's s-foils in attack position");
		System.out.println("---------------------------------------------");
	}
	
}
