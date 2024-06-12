package main.java;

import java.util.ArrayList;

public class Player {
    private double mp;
    private int[] portfolio;
    private String name;
    private ArrayList<Double> recordMP;
    public Player(String name) {
        this.mp = 300.0;
        this.portfolio = new int[3];
        this.name = name;
        this.recordMP = new ArrayList<Double>();

    }
    
    public void buy(Mountain mountain, int shares, Mountain[] mountainsArray) {
        double purchasePrice = mountain.getSharePrice() * shares; 
        if (mp >= purchasePrice) {
            mp -= purchasePrice;
            for (int mountainID = 0; mountainID < 3; mountainID++) {
                if (mountain == mountainsArray[mountainID]) {
                    portfolio[mountainID] += shares;
                }
            }
        }
    }
    public void displayInfo() {
        System.out.println("Player Account Info- \nPlayer Name: " + name + "\nPlayer Magic Points: " + mp + "\nPlayer Portfolio-\nMon Khaides Shares: " + portfolio[0] + "\nMount Vernon Shares: " + portfolio[1] + "\nDies Koschey Shares: " + portfolio[2] + "\n");             
    }
    public String getName() {
        return name;
    }
	public ArrayList<Double> getRecordMP() {
		return recordMP;
	}
	public void addRecordMP(Mountain[] mountainArray) {
		Double newMP = 0.0;
		int i = 0;
		for (Mountain mountain: mountainArray) {
			
			newMP += portfolio[i] * mountain.getSharePrice();
			i++;
		}
		this.recordMP.add(newMP);
	}
}



