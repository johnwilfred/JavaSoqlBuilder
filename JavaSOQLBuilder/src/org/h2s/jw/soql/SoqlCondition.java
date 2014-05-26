package org.h2s.jw.soql;

public class SoqlCondition {
	
	private String lhs;
	private SoqlOperator.Comparison operator;
	private String rhs;
	private boolean rhboolean;
	
	
	public SoqlCondition(String lhs, SoqlOperator.Comparison operator, String rhs) {
		super();
		this.lhs = lhs;
		this.rhs = rhs;
		this.operator = operator;
	}
	
	public SoqlCondition() {
		
	}
	
	public SoqlCondition lhs(String lhs) {
		this.lhs = lhs;
		return this;
	}
	
	public SoqlCondition rhs(String rhs) {
		this.rhs = rhs;
		return this;
	}
	
	public SoqlCondition rhboolean(boolean rhboolean) {
		this.rhboolean = rhboolean;
		return this;
	}
	
	public SoqlCondition operator(SoqlOperator.Comparison operator) {
		this.operator= operator;
		return this;
	}
	
	@Override
	public String toString() {
		String soql  = ""; 
		
		switch (operator) {
			case NEQ_N:
				soql = lhs + " != " + rhs;
				break;
			case NEQ_T:
				soql = lhs + " != '" + rhs + "'";
				break;
			case EQ_N:
				soql = lhs + " = " + rhs;
				break;
			case EQ_T:
				soql = lhs + " = '" + rhs + "'";
				break;
			case LT:
				soql = lhs + " < " + rhs;
				break;
			case GT :
				soql = lhs + " > " + rhs;
				break;
			case LE:
				soql = lhs + " <= " + rhs;
				break;
			case GE :
				soql = lhs + " >= " + rhs;
				break;
			case LK :
				soql = lhs + " Like " + rhs;
				break;
			case NLK :
				soql = lhs + " Not Like " + rhs;
				break;
			case IN :
				soql = lhs + " In (" + rhs + ")";
				break;
			case NIN :
				soql = lhs + " Not In (" + rhs + ")";
				break;
			case EQ_B :
				soql = lhs + " = " + rhboolean;
				break;
			case NEQ_B :
				soql = lhs + " != " + rhboolean;
				break;
		}
		return soql;
	}
	

}
