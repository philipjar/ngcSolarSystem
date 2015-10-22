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

import java.awt.Graphics;

import javax.swing.JPanel;

public class GUIDrawArea extends JPanel{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		for(Planet p : SolarSystem.planets){
		
			g.setColor(p.getColor());
			g.drawOval(((int) (p.X()-p.getRadius())), ((int)(p.Y()-p.getRadius())), (int)p.getRadius()*2, (int)p.getRadius()*2);
			
		}
	
	}

}