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
	
	private double conversionFactor;
	
	private double ownRadius;
	private double ownMass;
	
	private double orbitalRadius;
	private double centralStarMass;
	
	private double x;
	private double y;
	private double veloX;
	private double veloY;
	private double accelX;
	private double accelY;
	
	public Planet() {
		return;
	}
	
	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected Color getColor() {
		return color;
	}

	protected void setColor(Color color) {
		this.color = color;	
	}

	public double getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	protected double getOwnRadius() {
		return conversionFactor * ownRadius;
	}

	protected void setOwnRadius(double ownRadius) {
		this.ownRadius = ownRadius;	
	}

	protected double getOwnMass() {
		return ownMass;
	}

	protected void setOwnMass(double ownMass) {
		this.ownMass = ownMass;	
	}

	protected double getOrbitalRadius() {
		return orbitalRadius;
	}

	protected void setOrbitalRadius(double orbitalRadius) {
		this.orbitalRadius = orbitalRadius;
	}

	protected double getCentralStarMass() {
		return centralStarMass;
	}

	protected void setCentralStarMass(double centralStarMass) {
		this.centralStarMass = centralStarMass;
	}

	protected double X() {
		return conversionFactor * x;
	}

	protected void setX(double startPointX) {
		this.x = startPointX;
	}

	protected double Y() {
		return conversionFactor * y;
	}

	protected void setY(double startPointY) {
		this.y = startPointY;
	}

	protected double veloX() {
		return veloX;
	}

	protected void setVeloX(double startVeloX) {
		this.veloX = startVeloX;
	}
	
	protected double veloY() {
		return veloY;
	}

	protected void setVeloY(double startVeloY) {
		this.veloY = startVeloY;
	}
	
	protected double getAccelX() {
		return accelX;
	}
	
	protected double getAccelY() {
		return accelY;
	}
	
	protected void next() {
		accelX = Calc.nextAccelX(centralStarMass, orbitalRadius, x);
		accelY = Calc.nextAccelY(centralStarMass, orbitalRadius, y);
		veloX = Calc.nextVeloX(veloX, accelX, 1);
		veloY = Calc.nextVeloY(veloY, accelY, 1);
		x = Calc.nextX(x, veloX, 1);
		y = Calc.nextY(y, veloY, 1);
		orbitalRadius = Calc.nextOrbitalRadius(x, y);
		
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
			return Math.sqrt(Math.pow(x, 2.0) + Math.pow(y, 2.0));
		}
	}

}
