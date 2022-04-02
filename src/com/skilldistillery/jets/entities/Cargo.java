package com.skilldistillery.jets.entities;

public class Cargo extends Craft implements CargoImpl {

	public Cargo(String model, int speed, int range, double price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	public void loadCargo() {
		
		System.out.println(this.model + " begins loading troops for ground assault");
	}
}
