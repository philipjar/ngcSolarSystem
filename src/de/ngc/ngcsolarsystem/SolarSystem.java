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
import java.util.ArrayList;

public class SolarSystem {
	
	private static GUI gui;
	
	protected static ArrayList<Planet> planets = new ArrayList<>();
	
	/* Calculating the realLife to pixelLife conversion factor here */
	private static double realLifeDistance = 147.1E9;
	private static double pixelLifeDistance = 200.0;
	private static double conversionFactor = pixelLifeDistance / realLifeDistance;
	
	public static void main(String[] args) {
		Planet earth = new Planet();
		earth.setName("Earth");
		earth.setColor(Color.BLUE);
		earth.setConversionFactor(conversionFactor);
		earth.setOwnRadius(6378.0E6);
		earth.setOwnMass(0.0);
		earth.setOrbitalRadius(147.1E9);
		earth.setCentralStarMass(1.99E30);
		earth.setX(147.1E9);
		earth.setY(0);
		earth.setVeloX(0.0);
		earth.setVeloY(29.29E3);
		planets.add(earth);
		
		gui = new GUI();
		
		while (true) { 
			gui.repaintFrames();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) { }
			
			for (Planet p : planets) {
				p.next();
			}
		}
	}

}
