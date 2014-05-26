package org.h2s.jw.soql;


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
		LT,  	// LESS THAN
		GT,  	// GREATER THAN
		LE,  	// LESS THAN
		GE,  	// GREATER THAN
		EQ_T,  	// EQUAL TO TEXT
		EQ_N, 	// EQUAL TO NUMBER
		NEQ_N, 	// NOT EQUAL TO NUMBER
		NEQ_T, 	// NOT EQUAL TO TEXT
		LK, 	// LIKE
		IN, 	// IN
		NLK, 	// NOT LIKE
		NIN, 	// NOT IN
		EQ_B,   // EQUAL TO BOOLEAN
		NEQ_B;  // NOT EQUAL TO BOOLEAN
	}

}
