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
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI {
	
	private JFrame frame;
	private JFrame infoFrame;
	private JLabel htmlLabel = new JLabel();
	
	public GUI(){
		
		//mainFrame
		frame = new JFrame("Solar System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 700);
		frame.setVisible(true);
		frame.setResizable(false);
		
		GUIDrawArea drawArea = new GUIDrawArea(); 
		drawArea.setBackground(Color.BLACK);
		
		frame.getContentPane().add(drawArea);
		frame.repaint();
		
		//frame-move listener to update the location of the second infoFrame
		frame.addComponentListener(new ComponentAdapter() {
			public void componentMoved(ComponentEvent e){
				infoFrame.setLocation(new Point(frame.getLocation().x + 708, frame.getLocation().y+25));
			}
		});
		
		//infoFrame
		infoFrame = new JFrame("Bahndaten");
		infoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		infoFrame.setSize(300, 200);
		infoFrame.setUndecorated(true);
		infoFrame.setResizable(false);
		infoFrame.setVisible(true);
		infoFrame.add(htmlLabel);
	
	}
	
	public void repaintFrames() {
		frame.repaint();
		htmlLabel.setText("<html><body>Bahngeschwindigkeit(x): " + SolarSystem.planets.get(0).veloX()				
						+ "<br>Bahngeschwindigkeit(y): " + SolarSystem.planets.get(0).veloY() 
						+ "<br>"
						+ "<br>Bahnbeschleunigung(x): " + SolarSystem.planets.get(0).getAccelX()
						+ "<br>Bahnbeschleunigung(y): " + SolarSystem.planets.get(0).getAccelY()
						+ "<br>"
						+ "<br>x-Wert: " + SolarSystem.planets.get(0).X()
						+ "<br>y-Wert: " + SolarSystem.planets.get(0).Y()
						+ "<br>" 
						+ "<br>Bahnradius: " + SolarSystem.planets.get(0).getOrbitalRadius()
						+ "</body></html>");
		
	}

}
