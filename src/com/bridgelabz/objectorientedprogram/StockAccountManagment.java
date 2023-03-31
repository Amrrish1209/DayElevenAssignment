package com.bridgelabz.objectorientedprogram;

import java.util.Scanner;

class Stock {

	private String name;
	private int numOfShares;
	private double pricePerShare;

	// constructor
	public Stock(String name, int numOfShares, double pricePerShare) {
		this.name = name;
		this.numOfShares = numOfShares;
		this.pricePerShare = pricePerShare;
	}

	public double getValue() {
		return numOfShares * pricePerShare;
	}

	@Override
	public String toString() {
		return "Stock [name=" + name + ", numOfShares=" + numOfShares + ", pricePerShare=" + pricePerShare + "]";
	}
}

class StockPortfolio {
	private Stock stocks[];

	// constructor
	public StockPortfolio(int numOfStocks) {
		stocks = new Stock[numOfStocks];
	}

	public void addStock(Stock stock, int index) {
		stocks[index] = stock;
	}

	public double getTotalValue() {
		double totalValue = 0;
		for (int i = 0; i < stocks.length; i++) {
			if (stocks[i] != null) {
				totalValue += stocks[i].getValue();
			}
		}
		return totalValue;
	}

	@Override
	public String toString() {
		String portfolio = "";
		for (int i = 0; i < stocks.length; i++) {
			if (stocks[i] != null) {
				portfolio += stocks[i].toString() + "\n";

			}
		}
		portfolio += "Total Portfolio Value: " + getTotalValue();
		return portfolio;
	}

}

public class StockAccountManagment {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of stocks: ");
		int numOfStocks = scanner.nextInt();
		scanner.nextLine(); // consume the newline character
		StockPortfolio portfolio = new StockPortfolio(numOfStocks);
		for (int i = 0; i < numOfStocks; i++) {
			System.out.println("Enter stock #" + (i + 1) + " details:");
			System.out.print("Name: ");
			String name = scanner.nextLine();
			System.out.print("Number of shares: ");
			int numOfShares = scanner.nextInt();
			System.out.print("Price per share: ");
			double pricePerShare = scanner.nextDouble();
			scanner.nextLine(); // consume the newline character
			Stock stock = new Stock(name, numOfShares, pricePerShare);
			portfolio.addStock(stock, i);
		}
		System.out.println(portfolio.toString());
		scanner.close();
	}
}
