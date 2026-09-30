package com.va.week4.lab2_SJ;

import java.util.Scanner;
import java.math.BigDecimal;

public class MainDriver {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Interest[] investments = new Interest[5];

		for (int i = 0; i < investments.length; i++) {

			try {
				System.out.println("\nInvestment " + (i + 1));

				System.out.print("Enter Principal: ");
				BigDecimal principal = scanner.nextBigDecimal();

				System.out.print("Enter Rate (%): ");
				BigDecimal rate = scanner.nextBigDecimal();

				System.out.print("Enter Time (Years): ");
				int time = scanner.nextInt();

				investments[i] = new Interest(principal, rate, time);

				BigDecimal simpleInterest = investments[i].calculateSimpleInterest(principal, rate, time);

				System.out.println("Simple Interest: " + simpleInterest);

				double simpleInterestDouble = investments[i].calculateSimpleInterest(principal.doubleValue(),
						rate.doubleValue(), time);

				System.out.printf("Simple Interest (Double): %.2f%n", simpleInterestDouble);

				BigDecimal compoundInterest = investments[i].calculateCompoundInterest(principal, rate, time);

				System.out.println("Compound Interest: " + compoundInterest);

				double compoundInterestDouble = investments[i].calculateCompoundInterest(principal.doubleValue(),
						rate.doubleValue(), time);

				System.out.printf("Compound Interest (Double): %.2f%n", compoundInterestDouble);

			} catch (IllegalArgumentException e) {

				System.out.println(e.getMessage());

			}
		}

		scanner.close();
	}
}