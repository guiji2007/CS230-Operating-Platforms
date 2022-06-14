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
public class Team extends Entity {
	
	//default constructor inherit from Entity
	public Team(long id, String name) {
		super(id, name);
	}
	
	
	
	/**
	 * A list of the active players
	 */
	private static List<Player> players = new ArrayList<Player>();
	
	/*
	 * Holds the next player identifier
	 */
	
	private static long nextPlayerId =1;
	/**
	 * Construct a new player instance
	 * 
	 * @param name the unique name of the player
	 * @return the player instance (new or existing)
	 */
	
	public Player addPlayer(String name) {

		// a local player instance
		Player player = null;

		// Use iterator to look for existing player with same name
		// if found, simply return the existing instance
		
		// instantiate iterator
		Iterator<Player> myIterator = players.iterator();
		
		// iterate through the list to find the next element
		// iteration keeps going as long as the list has next element
		while (myIterator.hasNext()) {
			// take out the next element of the list, 
			// compare the name of the element with the parameter name
			// if they are the same, assign game to that element. 
			Player playerInstance = myIterator.next();
			if (playerInstance.getName()== name) {// if found, simply return the existing instance
				return  playerInstance; 
			}
		
		}
	
		// if not found, make a new game instance and add to list of games
		if (player == null) {
			player  = new Player(nextPlayerId++, name);
			players.add(player );
		}

		// return the new/existing game instance to the caller
		return player;
	}
	
	@Override
	public String toString() {
		return "Team [id=" + this.getId() + ", name=" + this.getName() + "]";
	}

}
