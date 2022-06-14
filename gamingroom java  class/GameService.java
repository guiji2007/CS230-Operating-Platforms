package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

	// FIXME(fixed): Add missing pieces to turn this class a singleton 
	/**
	 * Discussion for the use of singleton pattern. 
	 * The purpose of singleton pattern restricts the number of class instance to be one. 
	 * In this GameService case, the singleton pattern enables the GameService class to initiate only one instance
	 * so that all other games can be are associate with only one GameService instance singleService.
	 */
	
	private static GameService singleService = null;
	
	// A private Constructor prevents any other class from instantiating. 
	private GameService() {
		
	}
	// Static 'instance' method
	public static GameService getInstance() {
		if (singleService == null) {
			singleService = new GameService();
		} else {
			System.out.println("Game Service already instantiated.");
		}
		return singleService;
	}


	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		// FIXME(fixed): Use iterator to look for existing game with same name
		// if found, simply return the existing instance
		
		// instantiate iterator
		Iterator<Game> myIterator = games.iterator();
		
		// iterate through the list to find the next element
		// iteration keeps going as long as the list has next element
		while (myIterator.hasNext()) {
			// take out the next element of the list, 
			// compare the name of the element with the parameter name
			// if they are the same, assign game to that element. 
			Game gameInstance = myIterator.next();
			if (gameInstance.getName()== name) {// if found, simply return the existing instance
				return  gameInstance; 
			}
		
		}
	
		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		// FIXME(fixed): Use iterator to look for existing game with same id
		// if found, simply assign that instance to the local variable
		
		
		/**Discussion of the use of iterator design pattern
		 * The use of iterator design pattern allows the programmer to iterate through a collection of elements
		 * without compromising the data structure of the collection. 
		 */
		// instantiate iterator
		Iterator<Game> myIterator = games.iterator();
		// iterate through the list to find the next element
		// iteration keeps going as long as the list has next element
		while (myIterator.hasNext()) {
			// take out the next element of the list, 
			// compare the id of the element with the parameter id
			// if they are the same, assign game to that element. 
			Game gameInstance = myIterator.next();
			if (gameInstance.getId()== id) {
				game = gameInstance;
				break;
			}
		
		}

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// FIXME(fixed): Use iterator to look for existing game with same name
		// if found, simply assign that instance to the local variable
		
		// instantiate iterator
		Iterator<Game> myIterator = games.iterator();
		// iterate through the list to find the next element
		// iteration keeps going as long as the list has next element
		while (myIterator.hasNext()) {
			// take out the next element of the list, 
			// compare the name of the element with the parameter name
			// if they are the same, assign game to that element. 
			Game gameInstance = myIterator.next(); 
			if (gameInstance.getName() == name) {
				game = gameInstance;
				break;
			}	
		}

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
}
