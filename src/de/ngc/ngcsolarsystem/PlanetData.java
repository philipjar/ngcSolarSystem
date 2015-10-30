package de.ngc.ngcsolarsystem;

import java.awt.Color;

public class PlanetData {
	
	/* Used to check if all necessary attributes are set
	private Map<Object, Boolean> checkMap = new HashMap<>();
	*/
	
	private String name;
	private Color color;
	
	private double conversionFactor;
	
	private double ownRadius;
	private double ownMass;
	
	private double orbitalRadius;
	private double centralStarMass;
	
	private double startPointX;
	private double startPointY;
	private double startVeloX;
	private double startVeloY;
	
/*
	protected PlanetData() {
		checkMap.put(name, false);
		checkMap.put(color, false);
		checkMap.put(ownRadius, false);
		checkMap.put(ownMass, false);
		checkMap.put(orbitalRadius, false);
		checkMap.put(centralStarMass, false);
		checkMap.put(startPointX, false);
		checkMap.put(startPointY, false);
		checkMap.put(startVeloX, false);
		checkMap.put(startVeloY, false);
	}
*/

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected Color getColor() {
		return color;
	}

	protected void setColor(Color color) {
		this.color = color;	
	}

	public double getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	protected double getOwnRadius() {
		return ownRadius;
	}

	protected void setOwnRadius(double ownRadius) {
		this.ownRadius = ownRadius;	
	}

	protected double getOwnMass() {
		return ownMass;
	}

	protected void setOwnMass(double ownMass) {
		this.ownMass = ownMass;	
	}

	protected double getOrbitalRadius() {
		return orbitalRadius;
	}

	protected void setOrbitalRadius(double orbitalRadius) {
		this.orbitalRadius = orbitalRadius;
	}

	protected double getCentralStarMass() {
		return centralStarMass;
	}

	protected void setCentralStarMass(double centralStarMass) {
		this.centralStarMass = centralStarMass;
	}

	protected double getStartPointX() {
		return startPointX;
	}

	protected void setStartPointX(double startPointX) {
		this.startPointX = startPointX;
	}

	protected double getStartPointY() {
		return startPointY;
	}

	protected void setStartPointY(double startPointY) {
		this.startPointY = startPointY;
	}

	protected double getStartVeloX() {
		return startVeloX;
	}

	protected void setStartVeloX(double startVeloX) {
		this.startVeloX = startVeloX;
	}

	protected double getStartVeloY() {
		return startVeloY;
	}

	protected void setStartVeloY(double startVeloY) {
		this.startVeloY = startVeloY;
	}
}
