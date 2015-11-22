package de.ngc.ngcsolarsystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GUIButtons extends JPanel {
	
	private static final long serialVersionUID = -2773637082067263110L;
	
	JButton buttonZoomIn;
	JButton buttonZoomOut;
	
	public GUIButtons() {
		setBackground(Color.DARK_GRAY);
		setLayout(new FlowLayout());
		
		buttonZoomIn = new JButton();
		buttonZoomIn.setText("+");
		buttonZoomIn.setPreferredSize(new Dimension(40, 40));
		buttonZoomIn.setMargin(new Insets(0, 0, 0, 0));
		add(buttonZoomIn);
		
		buttonZoomOut = new JButton();
		buttonZoomOut.setText("-");
		buttonZoomOut.setPreferredSize(new Dimension(40, 40));
		buttonZoomOut.setMargin(new Insets(0, 0, 0, 0));
		add(buttonZoomOut);
	}

}
