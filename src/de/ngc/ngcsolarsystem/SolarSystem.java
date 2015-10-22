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
	
	public static ArrayList<Planet> planets = new ArrayList<>();
	
	public static void main(String[] args) {
		gui = new GUI();
		double[] startConds = {200.0, 100.0, 0.0, 1.0, 150000000000.0};
		Planet earth = new Planet("Earth", Color.BLUE, (long) (2.0 * Math.pow(10, 30)), 1, 5, startConds);
		planets.add(earth);
		
		while (true) {
			gui.repaintFrame();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) { }
			
			for (Planet p : planets) {
				p.next();
			}
		}
	}

}
