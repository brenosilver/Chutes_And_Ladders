//****************************************************************************************
//	Author: Breno Silva		Last Modified: 02/28/14
//
//	CSC*E224				Programming Assignment II
//****************************************************************************************

/*
 * Each player begins at square 0.
 * Each player spin the arrow once, highest numbers will play first.
 * If spin takes player past square #100, don't move, end turn.
 * 
 * TODO Change the way movePlayer returns, so it returns different integers for different situations.
 * TODO Improve how the displayGame method works so it can be smarter and more user friendly.
 */


package edu.housatonic.www.assignment2.chutesandladders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Game {
	public final String TITLE = "Chutes and Ladders";
	private int turn;
	private int turnIndex;
	private Spinner newSpin;
	private ArrayList<Player> players;
	private Board board;
	
	// Constructor
	public Game(){
		this.players = new ArrayList<Player>();
		this.newSpin = new Spinner();
		this.turnIndex = 0;
		this.board = new Board();
	}
	
	// Add a player to the game
	public void addPlayer(String name){
		int id = players.size()+1;
		this.players.add(new Player(name, id));
	}

	// Find the order of players to play by sorting
	// the array by the FirstSpinResult property,
	public void firstTurn(){
		this.turnIndex = players.size() -1;
		
		// Spin once for every player
		for(Player player: this.players){
			player.setFirstSpinResult(newSpin.spin());
		}
		
		// Sort array of players	
		Collections.sort(this.players, new Comparator<Player>() {
			@Override
		    public int compare(Player  p1, Player  p2){
				Integer p1Value = p1.getFirstSpinResult();
				Integer p2Value = p2.getFirstSpinResult();
		        return  p1Value.compareTo(p2Value);
		    }
		});
		
			this.turn = players.get(players.size()-1).getId();
	}
	
	//--------------------------------------------------------//
	
	
	// Get player with a given ID
	public Player getPlayer(int id){
		for(Player pl: players){
			if(pl.getId() == id)
				return pl;
		}
		return null;
	}
	
	
	// Change turns by going backyards
	// through the array of players
	public void changeTurn(){
		this.turnIndex--;
		
		// If the index is less than 0
		// index reset to the last player
		if(this.turnIndex < 0)
			this.turnIndex = players.size() -1;
		this.turn = players.get(this.turnIndex).getId();
		
	}
	
	
	// Spin and move Player through the board
	// Return false for continue, true for Stop (Win)
	public boolean movePlayer(){
		
		String outPut = "";
		int newCurrentSquare;
		
		// Get current player, spin and save spin to player
		Player currentPlayer = getPlayer(this.turn);
		currentPlayer.setSpinResult(newSpin.spin());
		int playerSpin = currentPlayer.getSpinResult();
		
		// Get the current square of a player and later test it
		// to be updated with the new spin result
		int currentSquare = currentPlayer.getCurrentSquare();
		int previousSquare = currentSquare;
		
		// if player lands on a square pass 100
		if(currentSquare + playerSpin > 100){
			outPut = " Over 100";
			displayGame(currentPlayer,previousSquare, outPut);
			return false;
		}
		
		// if player lands on square 100
		else if(board.checkWinningPosition(currentSquare + playerSpin)){
			currentPlayer.setCurrentSquare(currentSquare + playerSpin);
			
			displayGame(currentPlayer,100 ,previousSquare, outPut);
			displayGame(currentPlayer);
			return true;
		}
		
		else{
			currentPlayer.setCurrentSquare(currentSquare + playerSpin);
			newCurrentSquare = currentPlayer.getCurrentSquare();
			currentSquare = newCurrentSquare;
			
			// If player lands on any square that is
			// top of chute or bottom of ladder
			if(board.getSquare(currentSquare) != 0){
				currentSquare = board.getSquare(currentSquare);
				currentPlayer.setCurrentSquare(currentSquare);
				
				// Was it a Chute or a Ladder?
				if(previousSquare > currentSquare)
					outPut = " --CHUTE--> " + currentSquare;
				
				// Don't need to check if == since it
				// was already checked by if square > 100 line 113
				else
					outPut = " --LADDER--> " + currentSquare;
				
				// If that square was 80
				if(board.checkWinningPosition(currentPlayer.getCurrentSquare())){
					outPut = " --LADDER--> " + currentSquare;
					displayGame(currentPlayer,newCurrentSquare,previousSquare, outPut);
					displayGame(currentPlayer); 
					return true;
				}
			}

			displayGame(currentPlayer,newCurrentSquare,previousSquare, outPut);
			return false;
		}

	}
	
	// Display each players turn in the game
	public void displayGame(Player currentPlayer,int newCurrentSquare, int previousSquare, String str2){
		String str = currentPlayer.getName()+ ": " + previousSquare + " --> " + newCurrentSquare;
		System.out.println(str + str2);
	}
	
	// 2 argument displayGame for showing when player went over 100 
	public void displayGame(Player currentPlayer, int previousSquare, String str2){
		String str = currentPlayer.getName()+ ": " + previousSquare + " --> " + previousSquare;
		System.out.println(str + str2);
	}
	
	// 1 argument displayGame for showing when player Wins the game
	public void displayGame(Player currentPlayer){
		String str = "The Winner is " + currentPlayer.getName();
		System.out.println(str);
	}


	// Getter And Setter methods
	public ArrayList<Player> getPlayers() {
		return players;
	}
	


}