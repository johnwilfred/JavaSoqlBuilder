package org.h2s.jw.soql;

/**
 * Soql condition takes lef hand side (lhs), operator and right hand side(rhs) <BR>
 * <BR>
 * Example<BR>
 * condition.lhs("id");<BR>
 * condition.operator(SoqlOperator.Comparison.EQ_T);<BR>
 * condition.rhs("00O40000003Q9cR");<BR>
 * @author johnwilfred
 *
 */
public class SoqlCondition {
	
	private String lhs;
	private SoqlOperator.Comparison comparisonOperator;
	private String rhs;
	private boolean rhboolean;
	
	
	/**
	 * The constructor takes in left hand side, Comparsion operator, right hand side
	 * @param lhs
	 * @param operator
	 * @param rhs
	 */
	public SoqlCondition(String lhs, SoqlOperator.Comparison comparisonOperator, String rhs) {
		super();
		this.lhs = lhs;
		this.rhs = rhs;
		this.comparisonOperator = comparisonOperator;
	}
	
	/**
	 * The constructor takes in left hand side, Comparsion operator, right hand side boolean
	 * @param lhs
	 * @param operator
	 * @param rhboolean
	 */
	public SoqlCondition(String lhs, SoqlOperator.Comparison comparisonOperator, boolean rhboolean) {
		super();
		this.lhs = lhs;
		this.rhboolean = rhboolean;
		this.comparisonOperator = comparisonOperator;
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
		this.comparisonOperator= operator;
		return this;
	}
	
	@Override
	public String toString(){
		if (null != comparisonOperator){
			String soql  = comparisonOperator.getValue();
			soql= soql.replace("lhs", this.lhs).replace("rhs", this.rhs);
			return soql;
		} else {
			System.out.println("Comparison operator cannot be null");
			return "";
		}
	}
	

}
