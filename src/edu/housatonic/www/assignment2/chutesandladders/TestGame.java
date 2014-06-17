//****************************************************************************************
//	Author: Breno Silva		Last Modified: 02/28/14
//
//	CSC*E224				Programming Assignment II
//****************************************************************************************

/*
 * Chutes and Ladders Game
 * Ability to add as many players as needed
 * Auto ordering of players turn
 */

package edu.housatonic.www.assignment2.chutesandladders;

public class TestGame {

	public static void main(String[] args) {
		
		Game game = new Game();
		
		game.addPlayer("John");
		game.addPlayer("Patrick");
		//game.addPlayer("Marc");
		
		System.out.println(game.TITLE);
		
		//First Spin to decide who is to go first
		game.firstTurn();
		
		// Display the players and their spin to see the order of turns
		for(Player player: game.getPlayers())
			System.out.println(player.getName() + " id: " + player.getId() + " spin: " + player.getFirstSpinResult());
		System.out.println("--------------------");
		
		// WhileMovePlayer returns false keep playing
		while(!game.movePlayer()){
			game.changeTurn();
		}
		

	}

}
