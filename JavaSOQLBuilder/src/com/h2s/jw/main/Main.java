package com.h2s.jw.main;

import org.h2s.jw.soql.SoqlCondition;
import org.h2s.jw.soql.SoqlConditions;
import org.h2s.jw.soql.SoqlOperator;
import org.h2s.jw.soql.SoqlSelect;

/**
 * The Main class demonstrates the use of SoqlSelect.
 * 
 * @author johnwilfred
 * @since version 0.1
 * 
 */
public class Main {

	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("Simple SOQL example");
		Main.printSimpleSOQLExample();

		System.out.println("Complex SOQL example");
		Main.printComplexSOQLExample();
	}

	private static void printSimpleSOQLExample() {
		SoqlSelect soql = new SoqlSelect();
		soql.from("Account");
		soql.columns("id");

		SoqlCondition condition = new SoqlCondition();
		condition.lhs("id");
		condition.operator(SoqlOperator.Comparison.IN);
		condition.rhs("00O40000003Q9cR");
		soql.where(condition);

		System.out.println(soql);
	}

	private static void printComplexSOQLExample() throws ClassNotFoundException {

		Company company = new Company();
		SoqlSelect soql = new SoqlSelect(company);

		SoqlCondition billingCountryIsNz = new SoqlCondition();
		SoqlCondition billingCountryIsAu = new SoqlCondition();
		SoqlCondition revenueCheck = new SoqlCondition();
		SoqlCondition profitCheck = new SoqlCondition();
		

		billingCountryIsNz.lhs("billingCountry");
		billingCountryIsNz.operator(SoqlOperator.Comparison.EQ_T);
		billingCountryIsNz.rhs("New Zeland");

		billingCountryIsAu.lhs("billingCountry");
		billingCountryIsAu.operator(SoqlOperator.Comparison.EQ_T);
		billingCountryIsAu.rhs("Australia");
		
		revenueCheck.lhs("revenue");
		revenueCheck.operator(SoqlOperator.Comparison.LE);
		revenueCheck.rhs("200000");
		
		profitCheck.lhs("profit");
		profitCheck.operator(SoqlOperator.Comparison.GT);
		profitCheck.rhs("100000");
		
		SoqlConditions conditions1 = new SoqlConditions();
		conditions1.and(billingCountryIsNz,billingCountryIsAu);
		
		SoqlConditions conditions2 = new SoqlConditions();
		conditions2.or(billingCountryIsAu,profitCheck);
		
		
		SoqlConditions conditions3 = new SoqlConditions();
		conditions3.and(conditions1,conditions2);
		
		soql.where(conditions3);
		System.out.println(soql);
	}

}
