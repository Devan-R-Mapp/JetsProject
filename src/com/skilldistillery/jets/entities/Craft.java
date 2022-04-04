package com.skilldistillery.jets.entities;

public abstract class Craft { //this is the overarching Jets class
	protected String model;
	private int speed;
	private int range;
	private double price;
	private Pilot pilot;
	
	public Craft(String model, int speed, int range, double price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}
	public Craft(String model, int speed, int range, double price, Pilot pilot) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}
	
	public void fly() {
		System.out.println(this.model + " * begins take of procedure *");
		System.out.println(this.model + " \"Sir, all lights are green and we're ready to go!\"");
		System.out.println(this.model + " * takes off *" );
		System.out.println("|This " + this.model + " can fly " + (this.speed*this.range) + " miles before refueling|" );
		System.out.println();
	}
	
	public String getModel() {
		return model;
	}
	public String toStringnameonly() {
		StringBuilder builder = new StringBuilder();

		builder.append(model);
		return builder.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n");
		builder.append("Craft Model: \t");
		builder.append(model);
		builder.append("\t --- Speed: ");
		builder.append(speed);
		builder.append(" --- Range: ");
		builder.append(range);
		builder.append(" --- Price: ");
		builder.append(price);
		return builder.toString();
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}//Craft class
