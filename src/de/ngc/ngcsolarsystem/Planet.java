package de.ngc.ngcsolarsystem;

import java.awt.Color;

public class Planet {
	
	private String name;
	private Color color;
	
	private long mass;
	private int x;
	private int y;
	private int velocity_x;
	private int velocity_y;
	
	public Planet(String name, Color color, long mass, int[] startConditions) {
		this.name = name;
		this.color = color;
		this.mass = mass;
		
		x = startConditions[0];
		y = startConditions[1];
		velocity_x = startConditions[2];
		velocity_y = startConditions[3];
	}
	
	protected int getX() {
		return x;
	}
	
	protected int getY() {
		return y;
	}
	
	protected int getVelocityX() {
		return velocity_x;
	}
	
	protected int getVelocityY() {
		return velocity_y;
	}

}
