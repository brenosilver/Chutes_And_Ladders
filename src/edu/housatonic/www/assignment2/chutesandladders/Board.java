	/** 
	 *
	 * 
	 * @author Farshad Ravanshad
	 * @since 1.0
	 * @version Board.java 05/09/2010 
	 */

	/** This class defines a Gameboard.
	   
	*/

package edu.housatonic.www.assignment2.chutesandladders;

public class Board {
	
		// create an int array of 101 elements. Each element corresponds to one board square, 
		// the zeroth element is the start square off the board near square #1 . 
		// The value of squares[i] is zero if square i 
		// is neither the top of a chute nor the bottom of a ladder.  If squares[i] is nonzero, 
		// it means that either a chute or a ladder originates on that square and the value indicates 
		// the next square a player goes to.  

	   private int[] squares = { 0,38, 0, 0,14, 0, 0, 0, 0,31, 0,	//10
	                           0, 0, 0, 0, 0, 6, 0, 0, 0, 0,		//20
	                           42, 0, 0, 0, 0, 0, 0,84, 0, 0,		//30
	                           0, 0, 0, 0, 0,44, 0, 0, 0, 0,		//40
	                           0, 0, 0, 0, 0, 0,26, 0,11, 0,		//50
	                           67, 0, 0, 0, 0,53, 0, 0, 0, 0,		//60
	                           0,19, 0,60, 0, 0, 0, 0, 0, 0,		//70
	                           91, 0, 0, 0, 0, 0, 0, 0, 0,100,		//80
	                           0, 0, 0, 0, 0, 0,24, 0, 0, 0,		//90
	                           0, 0,73, 0,75, 0, 0,78, 0, 0 };		//100

	    // create an int array of 101 elements. Each element corresponds to one board square, 
		// the zeroth element is the start square off the board near square #1 . 
		// The value of squares[i] is zero if square i is one of those special squares 
		// that ends a player's turn. 
		// If squares[i] is -1, it means that it is a special square, 
		// if squares[i] is 0, it means that it is a regular square. 
		// Note: This array is NOT complete yet. 
		//TODO Complete this array. This array is to be used to implement the extra assumptions 
		//     as to when a player's turn is over. The extra assumptions are:
		//     * a square with no picture
		//     * a square with no picture and just an arrow
		//     * a square that a ladder or chute just passes through
		//     * a picture square at the top of a ladder
		//     * a picture square at the bottom of a chute
		

	   private int[] special_squares = { 0,-1, -1, -1,-1, -1, -1, -1, -1,-1, -1,
	                                  0, 0, -1, 0, 0, 0, 0, 0, 0, 0,
	                                  0, 0, 0, 0, 0, 0, 0,0, 0, 0,
	                                  0, 0, 0, 0, 0,0, 0, 0, 0, 0,
	                                  0, 0, 0, 0, 0, 0,0, 0,0, 0,
	                                  0, 0, 0, 0, 0,0, 0, 0, 0, 0,
	                                  0,0, 0,0, 0, 0, 0, 0, 0, 0,
	                                  0, 0, 0, 0, 0, 0, 0, 0, 0,0,
	                                  0, 0, 0, 0, 0, 0,0, 0, 0, 0,
	                                  0, 0,0, 0,0, 0, 0,0, 0, 0 };

	  
	   public int getSquare(int square) {
	      if ((square < 1) || (square > 100) ) 
			  return -1;
	      return squares[square];
	   }

	   public boolean checkWinningPosition(int square) {
		   if ( square == 100)
			   return true;	 
		   else
		       return false;
	      
	   }

	    public int lastSquare() { 
	        return squares.length - 1;
	  }


}
