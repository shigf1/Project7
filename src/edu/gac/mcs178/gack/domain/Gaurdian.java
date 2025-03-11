package edu.gac.mcs178.gack.domain;

import java.util.ArrayList;
import java.util.List;

import edu.gac.mcs178.gack.Utility;

public class Gaurdian extends AutoPerson {
	
	private Place destination;
	
	public Gaurdian(String name, Place place, int threshold, Place destination) {
		super(name, place, threshold);
		this.destination = destination;
	}

	@Override
	public void act() {
		List<Person> others = otherPeopleAtSamePlace();
		if (!others.isEmpty()) {
			Person winner = others.get(Utility.randInt(others.size()));
			crown(winner);
		} else {
			super.act();
		}
	}

	public void crown(Person person) {
		crownPlayer(person);
	}
	
	public void crownPlayer(Person person) {
		// need to copy person.getPossessions() in order to avoid a ConcurrentModificationException
		List<Thing> personsPossessions = new ArrayList<Thing>(person.getPossessions());
		for (Thing thing : personsPossessions) {
			if (thing.toString()=="Karl's glasses") {
				person.moveTo(destination);
				say("Congrats " + person + ", you win!");
			}
		}
	}
}