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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;

import de.ngc.ngcsolarsystem.Planet;
import de.ngc.ngcsolarsystem.SolarSystem;

public class GUIDrawArea extends JPanel {

	private static final long serialVersionUID = 3314874896779099613L;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		paint2D((Graphics2D) g);
	}

	protected void paint2D(Graphics2D g2) {
		g2.translate(0 + 350, 0 + 350);

		g2.setColor(Color.YELLOW);
		double sunSize = SolarSystem.getSunSize();
		g2.fill(new Ellipse2D.Double(0 - sunSize / 2, 0 - sunSize / 2, sunSize, sunSize));

		for (Planet p : SolarSystem.getPlanetsList()) {
			g2.setColor(p.getColor());
			g2.fill(new Ellipse2D.Double(p.X() - p.getOwnRadius(), p.Y() - p.getOwnRadius(), p.getOwnRadius() * 2, p.getOwnRadius() * 2));
			g2.drawString(p.getName(), (int) p.X(), (int) p.Y() -10);
			for (double[] array : p.getLastPoints()) {
				g2.fill(new Ellipse2D.Double(array[0], array[1], 1, 1));
			}
		}
	}
}
