//****************************************************************************************
//	Author: Breno Silva		Last Modified: 02/28/14
//
//	CSC*E224				Programming Assignment II
//****************************************************************************************

package edu.housatonic.www.assignment2.chutesandladders;

public class Player {
	private int currentSquare;
	private String name;
	private int id;
	private int spinResult;
	private int firstSpinResult;
	
	// Constructor
	public Player(String name, int id){
		this.currentSquare = 0;
		this.name = name;
		this.id = id;
	}
	

	// Getter and Setter Methods
	public void setCurrentSquare(int currentSquare) {
		this.currentSquare = currentSquare;
	}


	public int getCurrentSquare() {
		return currentSquare;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getFirstSpinResult() {
		return firstSpinResult;
	}


	public void setFirstSpinResult(int spinResult) {
		this.firstSpinResult = spinResult;
	}


	public int getSpinResult() {
		return spinResult;
	}

	public void setSpinResult(int spinResult) {
		this.spinResult = spinResult;
	}


	// toString method
	@Override
	public String toString() {
		return "Player [currentSquare=" + currentSquare + ", name=" + name
				+ ", id=" + id + ", spinResult=" + spinResult
				+ ", firstSpinResult=" + firstSpinResult + "]";
	}
		

}
