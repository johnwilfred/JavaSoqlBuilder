package com.h2s.jw.main;

import org.h2s.jw.soql.SoqlCondition;
import org.h2s.jw.soql.SoqlConditions;
import org.h2s.jw.soql.SoqlOperator;
import org.h2s.jw.soql.SoqlSelect;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException {
		SoqlSelect soql = new SoqlSelect();
		soql.from("Account");
		soql.columns("id");
		
		SoqlCondition condition = new SoqlCondition();
		condition.lhs("id");
		condition.operator(SoqlOperator.Comparison.EQ_T);
		condition.rhs("00O40000003Q9cR");
		soql.where(condition);
		
		System.out.println(soql);
		
		Company company = new Company();
		soql = new SoqlSelect(company);
		
		
		SoqlCondition condition1 = new SoqlCondition();
		SoqlCondition condition2 = new SoqlCondition();
		
		condition1.lhs("billingCity");
		condition1.operator(SoqlOperator.Comparison.EQ_T);
		condition1.rhs("Sydney");
		
		condition2.lhs("billingCountry");
		condition2.operator(SoqlOperator.Comparison.EQ_T);
		condition2.rhs("Australia");
		
		
		SoqlConditions conditions = new SoqlConditions();
		conditions.and(condition1,condition2);
		soql.where(conditions);
		
		
		System.out.println(soql);
		
		
		//select id from Account where id = '00O40000003Q9cR'
	}

}
