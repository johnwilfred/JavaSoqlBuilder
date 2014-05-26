package org.h2s.jw.soql;


import java.util.ArrayList;
import java.util.List;

public class SoqlConditions {
	private SoqlOperator.Logical operator;
	private List<SoqlCondition> conditionList;
	private List<SoqlConditions> conditionsList;
	
	public SoqlConditions() {
		conditionList = new ArrayList<SoqlCondition>();
		conditionsList = new ArrayList<SoqlConditions>();
	}
	
	public SoqlConditions and(SoqlConditions... conditions) {
		this.operator = SoqlOperator.Logical.AND;
		for (SoqlConditions condition : conditions) {
			conditionsList.add(condition);
		}
		return this;
	}
	
	public SoqlConditions or(SoqlConditions... conditions) {
		this.operator = SoqlOperator.Logical.OR;
		for (SoqlConditions condition : conditions) {
			conditionsList.add(condition);
		}
		return this;
	}
	
	public SoqlConditions and(SoqlCondition... conditions) {
		this.operator = SoqlOperator.Logical.AND;
		for (SoqlCondition condition : conditions) {
			conditionList.add(condition);
		}
		return this;
	}
	
	public SoqlConditions or(SoqlCondition... conditions) {
		this.operator = SoqlOperator.Logical.OR;
		for (SoqlCondition condition : conditions) {
			conditionList.add(condition);
		}
		return this;
	}
	
	
	
	@Override
	public String toString() {
		int idx = 0;
		String soql  = ""; 
		switch (operator) {
			case AND:
				idx=0;
				if (conditionList.size()>0) {
					soql  = soql + "(";
					for (SoqlCondition condition : conditionList) {
						if (idx++ == conditionList.size()-1) {
							soql = soql + condition ;
						} else {
							soql = soql + condition + " AND ";	
						}	
					}
					soql = soql + ")";
				}
				idx=0;
				if (conditionsList.size()>0) {
					soql  = soql + "(";
					for (SoqlConditions conditions : conditionsList) {
						if (idx++ == conditionsList.size()-1) {
							soql = soql + conditions ;
						} else {
							soql = soql + conditions + " AND ";	
						}	
					}
					soql = soql + ")";
				}
				break;
			case OR:
				idx=0;
				if (conditionList.size()>0) {
					soql  = soql + "(";
					for (SoqlCondition condition : conditionList) {
						if (idx++ == conditionList.size()-1) {
							soql = soql + condition ;
						} else {
							soql = soql + condition + " OR ";	
						}	
					}
					soql = soql + ")";
				}
				idx=0;
				if (conditionsList.size()>0) {
					soql  = soql + "(";
					for (SoqlConditions conditions : conditionsList) {
						if (idx++ == conditionsList.size()-1) {
							soql = soql + conditions ;
						} else {
							soql = soql + conditions + " OR ";	
						}	
					}
					soql = soql + ")";
				}
				break;
		}
		return soql;
	}
	
	
}
