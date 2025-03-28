package edu.gac.mcs178.gack;

import edu.gac.mcs178.gack.domain.AutoPerson;
import edu.gac.mcs178.gack.domain.Person;
import edu.gac.mcs178.gack.domain.Place;
import edu.gac.mcs178.gack.domain.Scroll;
import edu.gac.mcs178.gack.domain.Thing;
import edu.gac.mcs178.gack.domain.Witch;
import edu.gac.mcs178.gack.domain.Wizard;
import edu.gac.mcs178.gack.domain.Food;
import edu.gac.mcs178.gack.domain.Gaurdian;

public class GackWorld extends World {
	
	public GackWorld() {
		super();
		Place foodService = new Place("Food Service");
		Place po = new Place("Post Office");
		Place alumniHall = new Place("Alumni Hall");
		Place chamberOfWizards = new Place("Chamber of Wizards");
		Place library = new Place("Library");
		Place goodShipOlin = new Place("Good Ship Olin");
		Place lounge = new Place("Lounge");
		Place computerLab = new Place("Computer Lab");
		Place offices = new Place("Offices");
		Place dormitory = new Place("Dormitory");
		Place pond = new Place("Pond");
		Place lund = new Place("Lund");
		Place destination = new Place("Destination");
		
		//add Lund and Destination to places
		
		foodService.addNewNeighbor("down", po);
		po.addNewNeighbor("south", alumniHall);
		lund.addNewNeighbor("southeast", dormitory);
		//add Dormitory as neighbor to Lund
		alumniHall.addNewNeighbor("north", foodService);
		alumniHall.addNewNeighbor("east", chamberOfWizards);
		alumniHall.addNewNeighbor("west", library);
		chamberOfWizards.addNewNeighbor("west", alumniHall);
		chamberOfWizards.addNewNeighbor("south", dormitory);
		dormitory.addNewNeighbor("north", chamberOfWizards);
		dormitory.addNewNeighbor("west", goodShipOlin);
		//add Lund as neighbor to dormitory
		dormitory.addNewNeighbor("northwest", lund);
		library.addNewNeighbor("east", library);
		
		library.addNewNeighbor("south", goodShipOlin);
		goodShipOlin.addNewNeighbor("north", library);
		goodShipOlin.addNewNeighbor("east", dormitory);
		goodShipOlin.addNewNeighbor("up", lounge);
		lounge.addNewNeighbor("west", computerLab);
		lounge.addNewNeighbor("south", offices);
		lounge.addNewNeighbor("down", goodShipOlin);
		computerLab.addNewNeighbor("east", lounge);
		offices.addNewNeighbor("north", lounge);
		
		new AutoPerson("Max", offices, 2);
		new AutoPerson("Karl", computerLab, 4);
		//new Witch("Jacob", lund, 2, pond);
		new Witch("Barbara", offices, 3, pond);
		new Gaurdian("Gaurdian", goodShipOlin, 1, destination);
		//Add witch Jacob
		new Wizard("Elvee", offices, 1, chamberOfWizards);
		
	
		lounge.gain(new Thing("Karl's glasses"));
		dormitory.gain(new Scroll("Louis Don't Barf Magical Enchantment"));
		//add Louis Don't Barf Scroll
		dormitory.gain(new Scroll("Late lab report"));
		library.gain(new Scroll("Scroll of Enlightenment"));
		String[] someTitles = {"War and Peace", "Iliad", "Collected Works of Rilke"};
		for (String title : someTitles) {
			library.gain(new Scroll(title));
		}
		dormitory.gain(new Food("Chocolate"));
		//add Chocolate to Dormitory
		computerLab.gain(new Scroll("Unix Programmers Manual"));
		computerLab.gain(new Scroll("NeXT User's Reference"));
		
		setPlayer(new Person("player", dormitory));
	}
}
