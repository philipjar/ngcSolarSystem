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
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;

import java.text.Format;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUIWindows implements RepaintCallListener {
	
	JFrame infoFrame;
	JLabel htmlLabel;
	DecimalFormat dF;
	boolean infoFrameIsVisable = false;
	
	JFrame newPlanetFrame;
	JTextField planetName;
	JTextField planetColor;
	JTextField planetRadius;
	JTextField planetVeloX;
	JTextField planetVeloY;
	JButton planetCancelButton;
	JButton planetOkButton;
	boolean newPlanetFrameVisible = false;
	
	JFrame errorFrame;
	JLabel errorLabel;
	JButton errorOkButton;
	
	public GUIWindows(){
		SolarSystem.addRepaintCallListener(this);
		
		infoFrame = new JFrame("Bahndaten");
		infoFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		infoFrame.setSize(300, 130);
		infoFrame.setResizable(false);
		
		htmlLabel = new JLabel();
		dF = new DecimalFormat("00.0000E0");
		
		infoFrame.add(htmlLabel);
		infoFrame.setVisible(false);
		
		newPlanetFrame = new JFrame("new Planet");
		newPlanetFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		newPlanetFrame.setSize(300, 150);
		newPlanetFrame.setLayout(new GridLayout(0, 2, 5, 5));
		
		newPlanetFrame.add(new JLabel("Name:"));
		newPlanetFrame.add(planetName = new JTextField("Unknown"));
		newPlanetFrame.add(new JLabel("Color"));
		newPlanetFrame.add(planetColor = new JTextField("#0000FF"));
		newPlanetFrame.add(new JLabel("Radius/startPosX"));
		newPlanetFrame.add(planetRadius = new JTextField());
		newPlanetFrame.add(new JLabel("Velocity X"));
		newPlanetFrame.add(planetVeloX = new JTextField("0.0E0"));
		newPlanetFrame.add(new JLabel("Velocity Y"));
		newPlanetFrame.add(planetVeloY = new JTextField("0.0E0"));
		newPlanetFrame.add(planetCancelButton = new JButton("Cancel"));
		newPlanetFrame.add(planetOkButton = new JButton("OK"));
		
		newPlanetFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				toggleNewPlanetFrame();
			}
		});
		
		planetCancelButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				toggleNewPlanetFrame();
			}
		});
		
		planetOkButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				submitPlanet();
				toggleNewPlanetFrame();
			}
		});
		
		newPlanetFrame.setVisible(false);
		
		errorFrame = new JFrame("Error <3");
		errorFrame.setSize(400, 80);
		errorFrame.setLayout(new FlowLayout());
		errorLabel = new JLabel();
		errorFrame.add(errorLabel);
		errorFrame.add(errorOkButton = new JButton("Ok"));
		errorOkButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				errorFrame.setVisible(false);
			}
		});
		errorFrame.setVisible(false);
	}
	
	protected void toggleInfoFrame(){
		infoFrame.setVisible(infoFrameIsVisable = !infoFrameIsVisable);
	}
	
	protected void toggleNewPlanetFrame() {
		newPlanetFrame.setVisible(newPlanetFrameVisible = !newPlanetFrameVisible);
	}
	
	protected void error(String msg) {
		errorLabel.setText(msg);
		errorFrame.setVisible(true);
	}
	
	private void submitPlanet() {
		try {
			Planet planet = new Planet();
			planet.setName(planetName.getText());
			planet.setColor(Color.decode(planetColor.getText()));
			planet.setOwnRadius(6378E6); /* Standard size (Earth radius) */
			planet.setOwnMass(0.0); /* Not used */
			planet.setOrbitalRadius(Double.parseDouble(planetRadius.getText()));
			planet.setX(Double.parseDouble(planetRadius.getText()));
			planet.setY(0.0);
			planet.setVeloX(Double.parseDouble(planetVeloX.getText()));
			planet.setVeloY(Double.parseDouble(planetVeloY.getText()));
			SolarSystem.addPlanet(planet);
		} catch (Exception e) {
			error(e.toString());
		}
	}
	
	@Override
	public void onRepaint() {
		repaintFrame();
	}
	
	private void repaintFrame(){
		try {
			infoFrame.setSize(300, SolarSystem.planets.size() *130);
			String allData = "<html><body>";
			for(Planet p : SolarSystem.planets){
				allData = allData + p.getName() + ": "
						+ "<br>Orbital velocity(x): " + dF.format(p.veloX())
						+ "<br>Orbital velocity(y): " + dF.format(p.veloY())
						+ "<br>"
						+ "<br>Orbital radius: " + dF.format(p.getOrbitalRadius())
						+ "<br><br>"
						;
			}
			htmlLabel.setText(allData + "</body></html>");
		} catch (NullPointerException e) {
			/* This try-catch block is a temporary workaround.
			 * A NullPointerException sometimes shows up and we don*t know why yet.
			 * Until this is fixed this workaround will prevent the JVM from aborting execution.
			 */
			System.err.println("The NullPointer came back to say Hi...");
			e.printStackTrace();
			return;
		}
	}

}
