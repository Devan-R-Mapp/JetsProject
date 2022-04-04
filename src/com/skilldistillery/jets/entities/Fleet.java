package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Fleet {
	private String name;
	private ArrayList<Craft> hangar;
	private int totalCraft = 0;

	public Fleet() {
		hangar = new ArrayList<>();
	}

//	public ArrayList<Craft> getFleet() {
//		return fleet;
//	}
//
//	public void setFleet(ArrayList<Craft> fleet) {
//		this.fleet = (ArrayList<Craft>) fleet;
//	}

	public ArrayList<Craft> getFleet() {
		return hangar;
	}

	public void setFleet(ArrayList<Craft> fleet) {
		this.hangar = fleet;
	}

	public void add(int index, Craft runner) {

		hangar.add(index, runner);
		totalCraft++;

	}

	public void add(Craft runner) {

		hangar.add(runner);
		totalCraft++;

	}

	public Fleet importlist(String txt) {

		Fleet capitalShip = new Fleet();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(txt));
			String line;
//			while ((line = reader.readLine()) != "---") {
//				setname(line);
////			}
//			if(txt.equalsIgnoreCase("RepublicShips")) {
//				capitalShip.setname("Negotiator");
//			} else if(txt.contains("Sepratists")){
//				setName("Malevolence");
//			}
			while ((line = reader.readLine()) != null) {
				String[] row = line.split(",");
				int ships = 0;
				int speed = Integer.parseInt(row[2]);
				int range = Integer.parseInt(row[3]);
				double price = Double.parseDouble(row[4]);
//				Craft runner = null;
				if (row[0].equals("CARGO")) {
					Cargo runnerC = new Cargo(row[1], speed, range, price);
					capitalShip.add(ships, runnerC);
				} else if (row[0].equals("FIGHTER")) {
					Fighter runnerF = new Fighter(row[1], speed, range, price);
					capitalShip.add(ships, runnerF);
				}
//					System.out.println(runner);
//					System.out.println(capitalShip);
				ships++;
//				System.out.println(line + " this is out");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		return capitalShip;

	}// importlist

	private String setname(String line) {
		return this.name = line;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void menu(Fleet input) {
		boolean isRunning = true;
		Fleet runner = new Fleet();
		runner = input;
		Scanner sc = new Scanner(System.in);
		System.out.println("--------------------------------------------------");
		System.out.println("Attention on deck! Welcome aboard! Commander what are your orders?");
		System.out.println("--------------------------------------------------");
		System.out.println();
		while (isRunning) {
			int userInput = 0;
			menuPrint();
			try {
				userInput = sc.nextInt();
				switch (userInput) {
				case 1:
					System.out.println(runner);
					break;
				case 2:
					runner.flyAll();
					break;
				case 3:
					runner.fastestShipCall();
					break;
				case 4:
					runner.longestRangeShipCall();
					break;
				case 5:
					runner.cargoloadscargo();
					break;
				case 6:
					runner.preparesForCombat();
					break;
				case 7:
					runner.addship(runner, sc);
					break;
				case 8:
					runner.removeShip(runner, sc);
					break;
				case 9:
					System.out.println();
					System.out.println("-------------------");
					System.out.println("Commander off deck!");
					System.out.println("-------------------");
					isRunning = false;
					break;

				default:
					sc.close();
					break;

				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter the number that corresponds with the menu option.");
				sc.nextLine();

			} // catch (InputMismatchException e)

		} // while loop

	} // public void menu()

	private void preparesForCombat() {
		for (Craft craft : hangar) {
			if (craft instanceof Fighter) {
				((Fighter) craft).combatReady();
			}
		}
	}

	private void cargoloadscargo() {
		for (Craft craft : hangar) {
			if (craft instanceof Cargo) {
				((Cargo) craft).loadCargo();
			}
		}
	}

	private void longestRangeShipCall() {
		int topRange = 0;
		int craftRange = 0;
		Craft ndPlace = null;
		for (Craft craft : hangar) {
			craftRange = craft.getRange();
			if (craftRange > topRange) {
				topRange = craftRange;
				ndPlace = craft;
			}
		}
		System.out.println();
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("Sir, the ship that can travel the furthest is the " + ndPlace.getModel()
				+ " with a top range of " + ndPlace.getRange() + " parsec");
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println();
	}

	private void fastestShipCall() {
		int topSpeed = 0;
		int craftSpeed = 0;
		Craft fstPlace = null;
		for (Craft craft : hangar) {
			craftSpeed = craft.getSpeed();
			if (craftSpeed > topSpeed) {
				topSpeed = craftSpeed;
				fstPlace = craft;
			}
		}
		System.out.println();
		System.out.println("----------------------------------------------------------------------");
		System.out.println("Sir, the fastest ship we have is the " + fstPlace.getModel() + " with a top speed of "
				+ fstPlace.getSpeed() + "kph");
		System.out.println("----------------------------------------------------------------------");
		System.out.println();
	}

	private Fleet removeShip(Fleet runner, Scanner sc) {
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("Commander, a ship will be removed from the fleet, Which ship would you like to remove?.");
		System.out.println("-----------------------------------------------------------------------------------------");
		runner.numberedList();
		System.out.println("Which craft would delete?");
		int choice = sc.nextInt();
		choice--;
		runner.remove(choice);
		return runner;
	}

	private void remove(int choice) {
		System.out.println();
		System.out.println("---------------------------------");
		System.out.println("The ship " + (hangar.get(choice)).toStringnameonly() + " has been removed.");
		System.out.println("---------------------------------");
		System.out.println();
		hangar.remove(choice);
		totalCraft--;

	}

	public Fleet addship(Fleet runner, Scanner sc) {
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("Commander, another ship will be added to the fleet, but we need some details on it first.");
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("What is the model of the ship?");
		sc.nextLine();
		String modelr = sc.nextLine();
		System.out.println("What is the speed of the ship?");
		int speedr = sc.nextInt();
		System.out.println("What is the range of the ship?");
		int ranger = sc.nextInt();
		System.out.println("What is the price of the ship?");
		double pricer = sc.nextDouble();
		System.out.println("What kind of ship is this?");
//		System.out.println("-Fighter or Cargo-");
		String type = "";
		boolean incorrectAnswer = true;
		while (incorrectAnswer) {
			type = sc.nextLine();
			if (type.equalsIgnoreCase("fighter")) {
				Fighter craftr = new Fighter(modelr, speedr, ranger, pricer);
				runner.add(craftr);
				incorrectAnswer = false;
			} else if (type.equalsIgnoreCase("cargo")) {
				Cargo craftr = new Cargo(modelr, speedr, ranger, pricer);
				runner.add(craftr);
				incorrectAnswer = false;
			} else {
				System.out.println("-Fighter or Cargo-");
			}

		}
		return runner;
	}// public Fleet addship

	public void menuPrint() {

		System.out.println("1. List Fleet");
		System.out.println("2. Fly all Ships");
		System.out.println("3. View fastest ship");
		System.out.println("4. View longest range ship");
		System.out.println("5. Load all cargo ships");
		System.out.println("6. Scramble all fighters!");
		System.out.println("7. Add a ship to the fleet");
		System.out.println("8. Remove a ship from the fleet");
		System.out.println("9. Quit");

	}

	public void flyAll() {
		for (Craft craft : hangar) {
			craft.fly();
		}
	}

	public void numberedList() {
		int totalCraft = 1;
		for (Craft craft : hangar) {
			System.out.println(totalCraft + ": " + craft.toStringnameonly());
			totalCraft++;
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("The ships on standby are:");
		builder.append(hangar);
		builder.append("\n");
//		builder.append("");
//		builder.append(totalCraft);
//		builder.append("]");
		return builder.toString();
	}
}
