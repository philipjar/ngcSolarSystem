/*		Solar System Simulation.
    Copyright (C) 2015 Philip Lindner and Tim Rademacher

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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
