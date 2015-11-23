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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

public class GUI implements RepaintCallListener {
	
	private JFrame frame;

	public GUI(){
		SolarSystem.addRepaintCallListener(this);
		
		//mainFrame
		frame = new JFrame("Solar System"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(750, 700);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout(0, 0));
		
		GUIDrawArea drawArea = new GUIDrawArea(); 
		drawArea.setBackground(Color.BLACK);
		drawArea.setPreferredSize(new Dimension(700, 700));
		frame.add(drawArea, BorderLayout.LINE_START);
		
		GUIButtons sideButtons = new GUIButtons();
		sideButtons.setPreferredSize(new Dimension(50, 700));
		frame.add(sideButtons, BorderLayout.LINE_END);
		
		frame.pack();
		
	
	}
	/*
	public void repaintFrame() {
		
		frame.repaint();
		
	} */

	@Override
	public void onRepaint() {
		frame.repaint();	
	}

}
