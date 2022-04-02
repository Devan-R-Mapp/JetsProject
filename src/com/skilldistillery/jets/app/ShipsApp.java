package com.skilldistillery.jets.app;

import java.util.ArrayList;

import com.skilldistillery.jets.entities.Craft;
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
	ArrayList<Craft> tester = new ArrayList<Craft>();
	Fleet Negotiator = new Fleet();
	Negotiator = Negotiator.importlist("RepublicShips.txt");
	Negotiator.menu(Negotiator);
	
	}// launch

	
	}//class

