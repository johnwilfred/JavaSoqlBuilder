package org.h2s.jw.soql;


/**
 * Logic and Compario operator
 * @author johnwilfred
 *
 */
public class SoqlOperator {

	/**
	*	AND  
	*	OR  
	*/
	public enum Logical {
		AND, // AND 
		OR,  // OR
	}
	
	/**
	 *  LT ----> LESS THAN<BR>
	 *	GT ----> GREATER THAN<BR>
	 *	LE ----> LESS THAN<BR>
	 *	GE ----> GREATER THAN<BR>
	 *	EQ_T --> EQUAL TO TEXT<BR>
	 *	EQ_N --> EQUAL TO NUMBER<BR>
	 *	NEQ_N -> NOT EQUAL TO NUMBER<BR>
	 *	NEQ_T -> NOT EQUAL TO TEXT<BR>
	 *	LK ----> LIKE<BR>
	 *	IN ----> IN<BR>
	 *	NLK ---> NOT LIKE<BR>
	 *	NIN ---> NOT IN<BR>
	 *	EQ_B --> EQUAL TO BOOLEAN<BR>
	 *	NEQ_B -> NOT EQUAL TO BOOLEAN<BR>
	 */
	public enum Comparison {
		LT("lhs < rhs"),  	// LESS THAN
		GT("lhs > rhs"),  	// GREATER THAN
		LE("lhs <= rhs"),  	// LESS THAN
		GE("lhs >= rhs"),  	// GREATER THAN
		EQ_T("lhs = 'rhs'"),  	// EQUAL TO TEXT
		EQ_N("lhs = rhs"), 	// EQUAL TO NUMBER
		NEQ_N("lhs != rhs"), 	// NOT EQUAL TO NUMBER
		NEQ_T("lhs != 'rhs'"), 	// NOT EQUAL TO TEXT
		LK("lhs like rhs"), 	// LIKE
		IN("lhs in (rhs)"), 	// IN
		NLK("lhs not like (rhs)"), 	// NOT LIKE
		NIN("lhs not in (rhs)"), 	// NOT IN
		EQ_B("lhs = rhs"),   // EQUAL TO BOOLEAN
		NEQ_B("lhs != rhs");  // NOT EQUAL TO BOOLEAN
		
		Comparison(String value) {
			this.value = value;
		}
		
		private final String value;
		
		public String getValue() {
			return this.value;
		}
		
		
	}

}
