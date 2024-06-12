package main.java;

import java.util.ArrayList;

public class Mountain {
   private String name;
   private double magicalPower;
   private double landOwnership;
   private double sharePrice;
   private double dividends;
   private int investors;
   private int wizards;
   private int soldiers;
   private double debt;
   private double demand;
   private double debtMultiplier;
   private String direction;
   private ArrayList<Double> recordMP;
   public Mountain(String name) {
       this.name = name;
       this.magicalPower = -1000;
       this.landOwnership = 5;
       this.sharePrice = 100.0; // Initial share price
       this.dividends = 0.0; // Initial dividends
       this.investors = 100; // Initial investors count
       this.wizards = 30; // Initial wizards count
       this.soldiers = 3000; // Initial soldiers count
       this.debt = 0.0; // Initial debt
       this.demand = 1; // Initial demand
       this.debtMultiplier = 1.0; // Initial debt multiplier
       this.direction = "";
       this.recordMP = new ArrayList<Double>();

   }//most setter and getter methods from ChatGPT
   public void setName(String name) {
       this.name = name;
   }
  
   public void setDirection(String direction) {
       this.direction = direction;
   }
  
   public String getDirection() {
   	return direction;
   }
   public double getMagicalPower() {
       return magicalPower;
   }
   public double getLandOwnership() {
       return landOwnership;
   }
   public double getSharePrice() {
       return sharePrice;
   }
   public double getDividends() {
       return dividends;
   }
   public int getInvestors() {
       return investors;
   }
   public int getWizards() {
       return wizards;
   }
   public int getSoldiers() {
       return soldiers;
   }
   public double getDebt() {
       return debt;
   }
   public double getDemand() {
       return demand;
   }
   public double getDebtMultiplier() {
       return debtMultiplier;
   }
   public void setMagicalPower(double magicalPower) {
       this.magicalPower = magicalPower;
   }
   public void setLandOwnership(double landOwnership) {
       this.landOwnership = landOwnership;
   }
   public void setSharePrice(double sharePrice) {
       this.sharePrice = sharePrice;
   }
   public void setDividends(double dividends) {
       this.dividends = dividends;
   }
   public void setInvestors(int investors) {
       this.investors = investors;
   }
   public void setWizards(int wizards) {
       this.wizards = wizards;
   }
   public void setSoldiers(int soldiers) {
       this.soldiers = soldiers;
   }
  
   public void setDemand(double demand) {
   	this.demand = demand;
   }
   public void setDebtMultiplier(double debtMultiplier) {
   	this.debtMultiplier = debtMultiplier;
   }
   public ArrayList<Double> getRecordMP() {
	return recordMP;
   }
   public void addRecordMP() {
	   this.recordMP.add(sharePrice);
   }
   public double calculateTotalDebt() {
	       // Calculate debt based on a multiplier
	   double totalDebt = 0.0;
	   if (magicalPower < 0) {
		   totalDebt = debtMultiplier * (landOwnership * 400) + (Math.abs(magicalPower));
		   return totalDebt;
	   }
	   totalDebt = debtMultiplier * (landOwnership * 400);
	   return totalDebt;
   }
   public void calculateSharePrice() {
       this.sharePrice = ((landOwnership * 0.45) + (dividends * 0.10) + (investors * 0.10) + (demand * 35) - debt * 0.05);
   }
  
   public void engageInBattle(Mountain enemy) {
       double land = 0;
       double tempSoldiers = soldiers;
       double tempEnemySoldiers = enemy.getSoldiers();
       while (true) {
    	   tempSoldiers -= enemy.getWizards();
    	   magicalPower -= enemy.getWizards();
    	   tempEnemySoldiers -= wizards;
    	   enemy.setMagicalPower(enemy.getMagicalPower() - wizards);
            if (tempSoldiers <= 0) {
                break;
            }
            if (tempEnemySoldiers <= 0) {
                land = wizards / 100;
                break;
            }
       }
       landOwnership += land;
   }
  
   public double getProfit() {
   	double profit = 0;
   	profit = ((landOwnership * 1000) + (demand * 1000)) - ((wizards * 100) + (debt * 0.01));
   	return profit;
   }
   // Method to display info about the Mountain
   public void displayInfo() {
       System.out.println("Mountain Name: " + name);
       System.out.println("Mountain Disposition: " + direction);       
       System.out.println("Magical Power: " + magicalPower);
       System.out.println("Land Ownership: " + landOwnership);
       System.out.println("Share Price: $" + sharePrice);
       System.out.println("Dividends: $" + dividends);
       System.out.println("Investors: " + investors);
       System.out.println("Wizards: " + wizards);
       System.out.println("Soldiers: " + soldiers);
       System.out.println("Debt: $" + debt);
       System.out.println();
   }
	public String getName() {
		return name;
	}
}


