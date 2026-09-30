package com.va.week4.lab2_SJ;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Interest {

	private BigDecimal principal;
	private BigDecimal rate;
	private int time;

	public Interest(BigDecimal principal, BigDecimal rate, int time) {

		if (principal.compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException("Principal must be greater than 0.");
		}

		if (principal.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0) {
			throw new IllegalArgumentException("Principal cannot be an integer.");
		}

		if (rate.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Rate cannot be negative.");
		}

		if (rate.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0) {
			throw new IllegalArgumentException("Rate cannot be an integer.");
		}

		if (time <= 0) {
			throw new IllegalArgumentException("Time must be greater than 0.");
		}

		this.principal = principal;
		this.rate = rate;
		this.time = time;
	}

	// Simple Interest using BigDecimal
	public BigDecimal calculateSimpleInterest(BigDecimal p, BigDecimal r, int t) {

		return p.multiply(r).multiply(BigDecimal.valueOf(t)).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
	}

	public double calculateSimpleInterest(double p, double r, int t) {

		return (p * r * t) / 100;
	}

	public BigDecimal calculateCompoundInterest(BigDecimal p, BigDecimal r, int t) {

		// Compound Interest using BigDecimal

		BigDecimal rateDecimal = r.divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP);

		BigDecimal onePlusRate = BigDecimal.ONE.add(rateDecimal);

		BigDecimal amount = p.multiply(onePlusRate.pow(t));

		BigDecimal compoundInterest = amount.subtract(p);

		return compoundInterest.setScale(2, RoundingMode.HALF_UP);
	}

	public double calculateCompoundInterest(double p, double r, int t) {

		return p * Math.pow(1 + r / 100, t) - p;
	}
}
