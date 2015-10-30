/*	Solar System Simulation.
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
	
	private static final double gamma = 6.67E-11;
	
	private String name;
	private Color color;
	
	private double centralMass;
	private double orbitalRadius;
	
	private double cF;
	
	private double mass;
	private double x;
	private double y;
	private double velocity_x;
	private double velocity_y;
	private double radius;
	
	public Planet(PlanetData data) {
		cF = data.getConversionFactor();
		name = data.getName();
		color = data.getColor();
		centralMass = data.getCentralStarMass();
		mass = data.getOwnMass();
		radius = data.getOwnRadius();
		x = data.getStartPointX();
		y = data.getStartPointY();
		velocity_x = data.getStartVeloX();
		velocity_y = data.getStartVeloY();
		orbitalRadius = data.getOrbitalRadius();
	}
	
	protected double X() {
		return x;
	}
	
	protected double Y() {
		return y;
	}
	
	protected double veloX() {
		return velocity_x;
	}
	
	protected double veloY() {
		return velocity_y;
	}
	
	protected double getRadius() {
		return cF * radius;
	}
	
	protected String getName() {
		return name;
	}
	
	protected Color getColor() {
		return color;
	}
	
	protected void setConcersionFactor(double factor) {
		cF = factor;
	}
	
	protected void next() {
		double accelX = Calc.nextAccelX(centralMass, orbitalRadius, x);
		double accelY = Calc.nextAccelY(centralMass, orbitalRadius, y);
		velocity_x = Calc.nextVeloX(velocity_x, accelX, 1);
		velocity_y = Calc.nextVeloY(velocity_y, accelY, 1);
		x = Calc.nextX(x, velocity_x, 1);
		y = Calc.nextY(y, velocity_y, 1);
		orbitalRadius = Calc.nextOrbitalRadius(x, y);
		
		System.out.println("----------------------------");
		System.out.println(String.valueOf(x));
		System.out.println(String.valueOf(y));
		System.out.println("----------------------------");
		System.out.println("\n\n");
		
		
	}
	
	protected static class Calc {
		
		protected static double nextAccelX(double M, double r, double x) {
			return ((-gamma * M) / Math.pow(r, 3.0)) * x;
		}
		
		protected static double nextAccelY(double M, double r, double y) {
			return ((-gamma * M) / Math.pow(r, 3.0)) * y;
		}
		
		protected static double nextVeloX(double veloX, double accelX, double deltaT) {
			return veloX + (accelX * deltaT);
		}
		
		protected static double nextVeloY(double veloY, double accelY, double deltaT) {
			return veloY + (accelY * deltaT);
		}
		
		protected static double nextX(double x, double veloX, double deltaT) {
			return x + (veloX * deltaT);
		}
		
		protected static double nextY(double y, double veloY, double deltaT) {
			return y + (veloY * deltaT);
		}
		
		protected static double nextOrbitalRadius(double x, double y) {
			return Math.sqrt(Math.pow(x, 2.0) * Math.pow(y, 2.0));
		}
	}

}
