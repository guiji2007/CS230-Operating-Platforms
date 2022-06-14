package com.gamingroom;

public class Entity {
	private static long id;
	private static String name;
	
	// private constructor
	private Entity() {
		
	}
	
	// constructor
	public Entity(long id, String name) {
		Entity.id = id;
		Entity.name = name;			
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return"Entity [id=" + id + ", name=" + name + "]";
		
	}
}
