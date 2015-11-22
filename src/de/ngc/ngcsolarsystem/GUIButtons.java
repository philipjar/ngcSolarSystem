package de.ngc.ngcsolarsystem;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GUIButtons extends JPanel {
	
	private static final long serialVersionUID = -2773637082067263110L;
	
	JButton button;
	
	public GUIButtons() {
		setBackground(Color.DARK_GRAY);
		button = new JButton("+");
		button.setPreferredSize(new Dimension(40, 40));
		add(button);
	}

}
