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
package de.ngc.ngcsolarsystem.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

import de.ngc.ngcsolarsystem.SolarSystem;

public class GUIButtons extends JPanel {
	
	private static final long serialVersionUID = -2773637082067263110L;
	
	GUIWindows windows;
	
	JButton buttonZoomIn;
	JButton buttonZoomOut;
	JButton buttonInfo;
	JButton buttonNewPlanet;
	JButton buttonDeletePlanet;
	
	public GUIButtons() {
		setBackground(Color.DARK_GRAY);
		setLayout(new FlowLayout());
		
		windows = new GUIWindows();
		
		Font font = new Font("Arial", Font.PLAIN, 20);
		
		buttonZoomIn = new JButton();
		buttonZoomIn.setText("+");
		buttonZoomIn.setFont(font);
		buttonZoomIn.setPreferredSize(new Dimension(40, 40));
		buttonZoomIn.setMargin(new Insets(0, 0, 0, 0));
		buttonZoomIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SolarSystem.zoomIn();	
			}
		});
		add(buttonZoomIn);
		
		buttonZoomOut = new JButton();
		buttonZoomOut.setText("-");
		buttonZoomOut.setFont(font);
		buttonZoomOut.setPreferredSize(new Dimension(40, 40));
		buttonZoomOut.setMargin(new Insets(0, 0, 0, 0));
		buttonZoomOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SolarSystem.zoomOut();	
			}
		});
		add(buttonZoomOut);
		
		buttonInfo = new JButton();
		buttonInfo.setText("i");
		buttonInfo.setFont(font);
		buttonInfo.setPreferredSize(new Dimension(40, 40));
		buttonInfo.setMargin(new Insets(0, 0, 0, 0));
		buttonInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
					windows.toggleInfoFrame();
			}
		});
		add(buttonInfo);
		
		buttonNewPlanet = new JButton();
		buttonNewPlanet.setText("nP");
		buttonNewPlanet.setFont(font);
		buttonNewPlanet.setPreferredSize(new Dimension(40, 40));
		buttonNewPlanet.setMargin(new Insets(0, 0, 0, 0));
		buttonNewPlanet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				windows.toggleNewPlanetFrame();	
			}
		});
		add(buttonNewPlanet);
		
		buttonDeletePlanet = new JButton();
		buttonDeletePlanet.setText("rP");
		buttonDeletePlanet.setFont(font);
		buttonDeletePlanet.setPreferredSize(new Dimension(40, 40));
		buttonDeletePlanet.setMargin(new Insets(0, 0, 0, 0));
		buttonDeletePlanet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				windows.toggleDeleteFrame();
			}
		});
		add(buttonDeletePlanet);
	}

}
