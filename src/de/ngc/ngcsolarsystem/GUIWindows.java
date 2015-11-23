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

import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUIWindows implements RepaintCallListener {
	
	JFrame infoFrame;
	JLabel htmlLabel;
	DecimalFormat dF;
	
	boolean infoFrameIsVisable = false;
	
	public GUIWindows(){
		SolarSystem.addRepaintCallListener(this);
		
		infoFrame = new JFrame("Bahndaten");
		infoFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		infoFrame.setSize(300, 200);
		infoFrame.setResizable(false);
		
		htmlLabel = new JLabel();
		dF = new DecimalFormat("00.0000E0");
		
		infoFrame.add(htmlLabel);
		infoFrame.setVisible(true);
	}
	
	public void toggleInfoFrame(){
		
		
		
	}
	
	@Override
	public void onRepaint() {
		repaintFrame();
	}
	
	private void repaintFrame(){
		try {
			Planet p = SolarSystem.planets.get(0);
			htmlLabel.setText("<html><body>Bahngeschwindigkeit(x): " + dF.format(p.veloX())				
							+ "<br>Bahngeschwindigkeit(y): " + dF.format(p.veloY())
							+ "<br>"
							+ "<br>Bahnbeschleunigung(x): " + dF.format(p.getAccelX())
							+ "<br>Bahnbeschleunigung(y): " + dF.format(p.getAccelY())
							+ "<br>"
							+ "<br>x-Wert: " + dF.format(p.X())
							+ "<br>y-Wert: " + dF.format(p.Y())
							+ "<br>" 
							+ "<br>Bahnradius: " + dF.format(p.getOrbitalRadius())
							+ "</body></html>");
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
