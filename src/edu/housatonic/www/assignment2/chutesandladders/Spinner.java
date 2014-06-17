//****************************************************************************************
//	Author: Breno Silva		Last Modified: 02/28/14
//
//	CSC*E224				Programming Assignment II
//****************************************************************************************

package edu.housatonic.www.assignment2.chutesandladders;

import java.util.Random;

public class Spinner {
	private int value;
	
	// Constructor
	public Spinner(){
		this.value = 0;
	}
	
	// Spin Method
	public int spin(){
		Random rand = new Random();
		int value = rand.nextInt(6)+1;
		this.value = value;
		
		return value;
	}

	// Getter method
	public int getValue() {
		return value;
	}


}
