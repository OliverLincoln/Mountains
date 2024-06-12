package main.java;

import java.util.Scanner;

import java.awt.Dimension;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class Main {
	
	public static void main(String[] args) {
		int randomNumber = 0;
		double currentMP = 0.0;
		String input = "";
		int numInput = 0;
		boolean check = true;
		boolean check2 = true;
		Scanner scanner = new Scanner(System.in);
		
		//initializes mountains and puts them in an array
		Mountain MK = new Mountain("Mon Khaides");
		Mountain MV = new Mountain("Mount Vernon");
		Mountain DK = new Mountain("Dies Koschey");
		
		Player p1 = new Player("Oliver");
		Player p2 = new Player("Paxton");
		
		Mountain[] mountainsArray = {MK, MV, DK};
		
		Player[] playersArray = {p1, p2};
		
		for (Mountain mountain : mountainsArray)
		{
			randomNumber = (int) (Math.random() * 3);
			if (randomNumber == 0) {
				mountain.setDirection("Aggressive");
			}
			else if (randomNumber == 1) {
				mountain.setDirection("Defensive");
			}
			else if (randomNumber == 2) {
				mountain.setDirection("Monetary");
			}
		}
		//String[] directions = {"Aggressive", "Defensive", "Monetary"};
		//Events are war, increase wizard budget, increase soldier budget, lower wizard budget, lower dividends, increase dividends, take on debt, pay off debt, stock buy back, issue new shares, invest in product, change direction, change mode
		int[][] dearth = {{3, 1, 2, 3, 5, 2, 2, 1, 1}, {1, 5, 1, 4, 1, 1, 5, 1, 1}, {2, 3, 3, 1, 1, 5, 3, 1, 1}}; // If they need more MP: war, lower wizard budget, lower soldier budget, lower dividends, take on debt, issue new shares, invest in product, change direction, change mode
		int[][] surplus = {{2, 5, 3, 5, 1, 1, 1, 1, 1}, {0, 1, 4, 1, 4, 4, 4, 1, 1}, {1, 3, 3, 5, 1, 2, 3, 1, 1}}; // If they have excess money: war, increase wizard budget, increase soldier budget, increase dividends, pay off debt, stock buy back, invest in product, change direction, change mode
		
		//mountains generate profit and liabilities
		//check direction, roll random integer 1-20, mountain does action
		while (true) {
		    check = true;
		    //iterates through each mountain to check if they're a surplus or dearth and what disposition they have
			for (Mountain mountain : mountainsArray)
			{                 //current magic points plus new magic points 
				currentMP = mountain.getMagicalPower() + mountain.getProfit();
				mountain.setMagicalPower(currentMP);
				//checks disposition
				if (mountain.getDirection() == "Aggressive") {
				    //checks if in surplus
					if (mountain.getMagicalPower() <= 0) {
					    //assign random event
						getDearthRandomEvent(mountain, dearth[0], mountainsArray);
					}
				}
				
				mountain.displayInfo();
			}
			check = true;
			while (check) {
				check2 = true;
			    System.out.println("Input: ");
    			input = scanner.nextLine();
    			for (Player player: playersArray) {
    				player.addRecordMP(mountainsArray);
    			    if (input.equals(player.getName())) {
    			        player.displayInfo();
    			        while (check2) {
        			        input = scanner.nextLine();
        			        if (input.length() >= 6) {
	        			        for (Mountain mountain: mountainsArray) {
	        			        	if (input.substring(0, 3).equals("buy") && input.substring(4).equals(mountain.getName())) {
	        			        		System.out.println(mountain.getName() + " Shares: ");
	        			        		numInput = scanner.nextInt();
	        			        		player.buy(mountain, numInput, mountainsArray);
	        			        	}
	        			        	else if (input.substring(0,  5).equals("graph") && input.substring(6).equals(mountain.getName())) {
	        			        		createAndShowGraph(mountain.getRecordMP());
	        			        	}
	        			        }
        			        }
        			        
	        			        if (input.equals("graph")) {
	        			        	createAndShowGraph(player.getRecordMP());
	        			        }
	        			        else if (input.equals("continue")) {
	        			            check2 = false;
	        			        }
	    			        }
    			        }
    			    
	    			if (input.equals("close")) {
	    			    scanner.close();
	    			}
	    			else if (input.equals("continue")) {
	    			    check = false;
	    			}
    			}
			}
			
		}
		
	}
	//from ChatGPT
	private static void createAndShowGraph(List<Double> array) {
        // Create a list of scores (data points)
        // Create a GraphPanel with the custom scores
        GraphPanel mainPanel = new GraphPanel(array);
        mainPanel.setPreferredSize(new Dimension(800, 600));
        // Create a JFrame to display the graph
        JFrame frame = new JFrame("Custom Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
	//Assigns random event when mountain is at a loss
	public static void getDearthRandomEvent(Mountain mountain, int[] probabilities, Mountain[] mountainsArray) {
	    //generates a random int 1-20
		int randomNumber = (int) (Math.random() * 20) + 1;
		int index = 0;
		for (int nums: probabilities) {
		    randomNumber -= nums;
		    if (randomNumber <= 0) {
		        break;
		    }
		    index++;
		}

		System.out.println("Index: " + index);
		
		if (index == 0) { //declare war with random nation
			randomNumber = (int) (Math.random() * 3);
			while (mountainsArray[randomNumber].getName() == mountain.getName()) {
				randomNumber = (int) (Math.random() * 3);
			}
			System.out.println("War breaks out: " + mountain.getName() + "Attacks " + mountainsArray[randomNumber].getName());
			mountain.engageInBattle(mountainsArray[randomNumber]);
		}
		else if (index == 1) {
			mountain.setWizards(mountain.getWizards());
		}
	}
}




