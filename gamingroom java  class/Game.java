package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity {
	
	//default constructor inherit from Entity
	public Game(long id, String name) {
		super(id, name);
	}
	
	
	
	/**
	 * A list of the active games
	 */
	private static List<Team> teams = new ArrayList<Team>();
	
	/*
	 * Holds the next team identifier
	 */
	
	private static long nextTeamId =1;
	/**
	 * Construct a new team instance
	 * 
	 * @param name the unique name of the team
	 * @return the team instance (new or existing)
	 */
	
	public Team addTeam(String name) {

		// a local team instance
		Team team = null;

		// FIXME(fixed): Use iterator to look for existing game with same name
		// if found, simply return the existing instance
		
		// instantiate iterator
		Iterator<Team> myIterator = teams.iterator();
		
		// iterate through the list to find the next element
		// iteration keeps going as long as the list has next element
		while (myIterator.hasNext()) {
			// take out the next element of the list, 
			// compare the name of the element with the parameter name
			// if they are the same, assign game to that element. 
			Team teamInstance = myIterator.next();
			if (teamInstance.getName()== name) {// if found, simply return the existing instance
				return  teamInstance; 
			}
		
		}
	
		// if not found, make a new game instance and add to list of games
		if (team == null) {
			team = new Team(nextTeamId++, name);
			teams.add(team);
		}

		// return the new/existing game instance to the caller
		return team;
	}
	
	@Override
	public String toString() {
		return "Game [id=" + this.getId() + ", name=" + this.getName() + "]";
	}

}
