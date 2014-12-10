/**
* Khiem Trinh
* Professor Durendal
* CS112 Section 88195
* Tuesday 7 PM
* Final Exam
*/

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class mainCode 
{
	public static void main (String[] args) throws InterruptedException, ExecutionException
	{
		int rollCount = 0;
		int dNum = 0;
		int playerMove = 0;
	    String computer = null;
	    String user = null;
		String play;
		String output;
		Scanner scan = new Scanner(System.in);
		Dice tuString = new Dice();
		
		// A class that is derived from another class is called a subclass (also a derived class, extended class, or child class). 
		// 	The class from which the subclass is derived is called a superclass (also a base class or a parent class).
		DetermineWinner winner = new DetermineWinner();
		
		System.out.println("Welcome to the Hi-Lo Dice Game!");
		
    	do
    	{
    			do 
    			{
    				System.out.print("\nHow many Dice should be in game play?" +
										"\n1 = One Dice | 2 = Two Dice | 3 = Three Dice ");
    						dNum = scan.nextInt();
    						System.out.println("\nPlayer selected " + dNum + " Dices to play with: ");
    						
    						// If player enters 0 or 4+, generate error message
    		    			if (dNum < 1 || dNum > 3)
    		    			{
    		    		    	System.out.println("This is an Invalid Selection. Please Try Again.");
    		    			} // end dNum is 0 or 4+	
		
    		    			// If player enters 1
    						if (dNum == 1)
    						{
    							OneDice oneD = new OneDice(dNum);
    							oneD.Throw();
    							System.out.println("DEBUG CODE: The mainCode Throw call is " +
    												oneD.getThrow(dNum));
    	    					System.out.print("\nMake a move by guessing: 6 = HI or 1 = LO ");
    							playerMove = scan.nextInt();
    							System.out.println("Player move of " + playerMove + " is made.");

    							computer = Dice.computerChoice();
    							
    								// If playerMove is 0 or 7+ or between 1 and 6, not inclusive, then invalid move
    			    				if (playerMove < 1 || playerMove > 6 || playerMove > 1 && playerMove < 6)
    			    				{
    			    					System.out.println("This is an Invalid Selection. Please Try Again.");
    			    				}
    			    				// If playerMove is 6, then assign string value of HI to user variable
    			    				if (playerMove == 6)
    			    				{
    			    					user = "HI";
    			    					output = winner.determineWinner(computer, user);
    			    					System.out.println(output);
    			    				}
    									else if (playerMove == 1)
    									{
    										user = "LO";
    										output = winner.determineWinner(computer, user);
    										System.out.println(output);
    									}
    			    			rollCount++;
    						} // end If dNum is 1
    						
    							// If player enters 2
    							else if (dNum == 2)
    							{
    								TwoDice twoD = new TwoDice(dNum);
        							twoD.Throw();
        							System.out.println("DEBUG CODE: The mainCode Throw call is " +
        												twoD.getThrow(dNum));
        	    					System.out.print("\nMake a move by guessing: 6 = HI or 1 = LO ");
        							playerMove = scan.nextInt();
        							System.out.println("Player move of " + playerMove + " is made.");
        							computer = TwoDice.computerChoice();
        							user = Integer.toString(playerMove);
        							
        			    				if (playerMove < 1 || playerMove > 6 || playerMove > 1 && playerMove < 6)
        			    				{
        			    					System.out.println("This is an Invalid Selection. Please Try Again.");
        			    				}	
        			    				if (playerMove == 6)
        			    				{
        			    					user = "HI";
        			    					output = winner.determineWinner(computer, user);
        			    					System.out.println(output);
        			    				}
        									else if (playerMove == 1)
        									{
        										user = "LO";
        										output = winner.determineWinner(computer, user);
        										System.out.println(output);
        									}
        							rollCount++;
    							} // end If dNum is 2
    						
    								// If player enters 3
    								else if (dNum == 3)
    								{
    									ThreeDice threeD = new ThreeDice(dNum);
    									threeD.Throw();
    									System.out.println("DEBUG CODE: The mainCode Throw call is " +
        													threeD.getThrow(dNum));
    									System.out.print("\nMake a move by guessing: 6 = HI or 1 = LO ");
    									playerMove = scan.nextInt();
    									System.out.println("Player move of " + playerMove + " is made.");
    									computer = ThreeDice.computerChoice();
    									user = Integer.toString(playerMove);
        							
    										if (playerMove < 1 || playerMove > 6 || playerMove > 1 && playerMove < 6)
    										{
    											System.out.println("This is an Invalid Selection. Please Try Again.");
    										}	
    										if (playerMove == 6)
    										{
    											user = "HI";
    											output = winner.determineWinner(computer, user);
    											System.out.println(output);
    										}
    											else if (playerMove == 1)
    											{
    												user = "LO";
    												output = winner.determineWinner(computer, user);
    												System.out.println(output);
    											}
    										rollCount++;
    								} // end If dNum is 3
    			}
    			while (dNum >=1 & dNum <=3 && user.equalsIgnoreCase(computer));
    			// Exit inside Do-While Loop

    			System.out.print("\nDo you want to play again? Yes or No ");
    			play = scan.next();
    	}
    	while(play.equalsIgnoreCase("YES"));
    	// Exit outside Do-While Loop
    	
    	// Call from Shapes Interface
		Circle cir = new Circle(10.9);
		System.out.println("\nRadius of Circle Dice: " + cir.getRadius());
		System.out.println("Area of Circle Dice: " + cir.getArea());
		Square sqr = new Square(5,5);
		System.out.println("Area of Square Dice: " + sqr.getArea() + "\n");
		
		// Call from RunnableInterface class to implement runnable interface
		RunnableInterface.main(args);
		// Call from Executor class to implement Executor Service
		Executor.main(args);
		
		// TOSTRING METHOD CALL
		// Call from Dice SuperClass ToString method	
		tuString.toString(dNum);
		
		// Call from DoubleDice subclass to implement runnable interface
		// Polymorphism is the ability of an object to take on many forms. 
		// 	The most common use of polymorphism in OOP occurs when a parent class reference is used to refer to a child class object.
		DoubleDice.main(args);
		
		// Call from Dice superclass to demonstrate Encapsulation
		// Encapsulation is the technique of making the fields in a class private and providing access to the fields via public methods. 
		//	If a field is declared private, it cannot be accessed by anyone outside the class, thereby hiding the fields within the class. 
		// 	For this reason, encapsulation is also referred to as data hiding.
		Dice encapsulation = new Dice();
		System.out.println("Dice SuperClass Encapsulation is " + encapsulation.getDiceEncapsulation("DICE SUPERCLASS"));
		
    	System.out.println( "\n+++ | Total Score | +++ " + "\n-----------------------" +
				"\n  Correct Guesses = " + winner.winCount +
				"\n   Wrong Guesses = " + winner.loseCount +
				"\n      Timeouts = " + winner.drawCount );
    	if (winner.winCount > winner.loseCount)
    	{
    		System.out.println("\nCongratulations! Player Wins!");
    	}
    		else if (winner.winCount < winner.loseCount)
    		{
    			System.out.println("\nTough Luck! CPU Wins!");
    		}
    			else
    			{
    				System.out.println("\nNeck and Neck! It's a Draw!");
    			}
    	System.out.println("\nDice was Thrown a Total of " + rollCount + " times." + 
    						"\nGame Over. Thank you for playing!" +
    						"\nPlay Again Later. Good-Bye!");
    	
    	// Close scan method to prevent memory leaks
		scan.close();

	} // end static void main
} // end class mainCode