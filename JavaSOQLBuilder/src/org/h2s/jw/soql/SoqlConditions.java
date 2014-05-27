package org.h2s.jw.soql;


import java.util.ArrayList;
import java.util.List;

/**
 * SoqlConditions takes condition and conditions
 * @author johnwilfred
 *
 */
public class SoqlConditions {
	private SoqlOperator.Logical logicalOperator;
	private List<SoqlCondition> conditionList;
	private List<SoqlConditions> conditionsList;
	
	public SoqlConditions() {
		conditionList = new ArrayList<SoqlCondition>();
		conditionsList= new ArrayList<SoqlConditions>();
	}
	
	/**
	 * AND operator
	 * @param condition
	 */
	public void and(SoqlCondition... condition) {
		this.logicalOperator = SoqlOperator.Logical.AND;
		setConditionList(condition);
	}
	
	/**
	 * AND operator
	 * @param conditions
	 */
	public void and(SoqlConditions... conditions) {
		this.logicalOperator = SoqlOperator.Logical.AND;
		setConditionsList(conditions);
	}
	
	/**
	 * AND operator
	 * @param condition
	 * @param conditions
	 */
	public void and(SoqlCondition condition,SoqlConditions conditions) {
		this.logicalOperator = SoqlOperator.Logical.AND;
		setConditionsList(conditions);
		setConditionList(condition);
	}
	
	/**
	 * AND operator
	 * @param conditions
	 * @param condition
	 */
	public void and(SoqlConditions conditions,SoqlCondition condition) {
		this.logicalOperator = SoqlOperator.Logical.AND;
		setConditionsList(conditions);
		setConditionList(condition);
	}
	
	/**
	 * OR operator
	 * @param condition
	 */
	public void or(SoqlCondition... condition) {
		this.logicalOperator = SoqlOperator.Logical.OR;
		setConditionList(condition);
	}
	
	/**
	 * OR operator
	 * @param conditions
	 */
	public void or(SoqlConditions... conditions) {
		this.logicalOperator = SoqlOperator.Logical.OR;
		setConditionsList(conditions);
	}
	
	/**
	 * OR operator
	 * @param condition
	 * @param conditions
	 */
	public void or(SoqlCondition condition,SoqlConditions conditions) {
		this.logicalOperator = SoqlOperator.Logical.AND;
		setConditionsList(conditions);
		setConditionList(condition);
	}
	
	/**
	 * OR operator
	 * @param conditions
	 * @param condition
	 */
	public void or(SoqlConditions conditions,SoqlCondition condition) {
		this.logicalOperator = SoqlOperator.Logical.AND;
		setConditionsList(conditions);
		setConditionList(condition);
	}
	
	private void setConditionList(SoqlCondition... conditions){
		for (SoqlCondition condition : conditions) {
			conditionList.add(condition);
		}
	}
	
	private void setConditionsList(SoqlConditions... conditions){
		for (SoqlConditions condition : conditions) {
			conditionsList.add(condition);
		}
	}
	
	@Override
	public String toString() {
		String soql  = "";
			int idx=0;
			if (conditionList.size()>0) {
				soql  = soql + "(";
				for (SoqlCondition condition : conditionList) {
					if (idx++ == conditionList.size()-1) {
						soql = soql + condition ;
					} else {
						soql = soql + condition + " " + logicalOperator.toString() + " ";	
					}	
				}
				soql = soql + ")";
			}
			
			if (conditionsList.size()>0) {
				if (soql != "")
					soql = soql + " " + logicalOperator.toString() + " ";
				idx=0;
				soql  = soql + "(";
				for (SoqlConditions conditions : conditionsList) {
					if (idx++ == conditionsList.size()-1) {
						soql = soql + conditions.toString() ;
					} else {
						soql = soql + conditions.toString() + " " + logicalOperator.toString() + " ";	
					}	
				}
				soql = soql + ")";
			}
			return soql;
	}
	
}
