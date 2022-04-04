package com.skilldistillery.jets.app;

import java.io.FileNotFoundException;
import java.util.Scanner;

//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.List;
//
//import com.skilldistillery.jets.entities.Craft;
//import com.skilldistillery.jets.entities.Fighter;
import com.skilldistillery.jets.entities.Fleet;
//import com.skilldistillery.jets.entities.Cargo;



public class ShipsApp {

	public static void main(String[] args) {
	
		ShipsApp a = new ShipsApp();
		a.launch();
	} //main
	
	public void launch() {
		Scanner sc = new Scanner(System.in);
	Fleet runnerFleet = new Fleet();
	boolean isNotCorrect = true;
		while (isNotCorrect) {
			try {
				System.out.println("Please enter the fleet file you want to look at: ");
				System.out.println("Current files: \"RepublicShips\" and \"SepratistShips\"");
				String txtFile = sc.nextLine();
				runnerFleet = runnerFleet.importlist(txtFile + ".txt");
				isNotCorrect =false;
			} catch (Exception e) {
				System.out.println("Try again");
			}
		} 
		runnerFleet.menu(runnerFleet);

	
	}// launch

	
	}//class

