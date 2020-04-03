package eg.edu.alexu.csd.datastructure.stack.cs;

	/**
	 * Class to convert a symbolic infix expression to postfix notation,
	 * and evaluates the postfix expression and returns its value.
	 */
public class ExpressionEvaluator implements IExpressionEvaluator {

	/**
	* Takes a symbolic/numeric infix expression as input and converts it to
	* postfix notation. There is no assumption on spaces between terms or the
	* length of the term (e.g., two digits symbolic or numeric term)
	*
	* @param expression
	* infix expression
	* @return postfix expression
	*/
	public String infixToPostfix(String expression) {
		Stack s = new Stack();
		String newExpression = new String();
		int i;
		boolean negative = false ;			// For the Unary negative
		boolean negativeOrPositive = false; 		// To check if it is a negative or positive
		
		for (i = 0 ; i < expression.length() ; i++) {
			char c = expression.charAt(i);
			if ( c == '+' || c == '-' ) {
				
				if ( c == '-' && negativeOrPositive && ( (char)s.peek() == '*' || (char)s.peek() == '/' ) ) {	// Unary Negative Case
					newExpression += '0';		// Dummy Zero
					s.push('(');
					negative = true;
				}
				
				while ( !s.isEmpty() && (char) s.peek() != '(' ) {
					newExpression += (char) s.pop();
				}
				s.push(c);
			}
			else if ( c == '*' || c == '/' ) {
				if ( !s.isEmpty() && ( (char) s.peek() == '*' || (char) s.peek() == '/' ) ) {
					newExpression += (char) s.pop();
				}
			s.push(c);	
			negativeOrPositive = true;			// To know the next is positive num or negative
			}
			else if ( c == '(') {
				s.push(c);	
			}
			else if ( c == ')') {
				while ( !s.isEmpty() && (char) s.peek() != '(' ) {
					newExpression += (char) s.pop();
				}
				if (s.isEmpty()) 					// Exception of Right parenthesis without Left parenthesis
					throw new RuntimeException("Invalid Input (Right parenthesis without Left parenthesis)");
				else
					s.pop();
			}
			else {						// Operands case
				newExpression += c;
				negativeOrPositive = false;
				if ( negative )	{		// Negative Case
					expression = expression.substring( 0 , i+1 ) + ')' + expression.substring( i+1 ,expression.length());
					negative = false;
				}
			}
			
		}
		
		while ( !s.isEmpty()) {
			if ( (char) s.peek() != '(' ) 			
				newExpression += (char) s.pop();
			else 											// Exception of Left parenthesis without right parenthesis
				throw new RuntimeException("Invalid Input (Left parenthesis without Right parenthesis)");
				
		}
		
		return newExpression;
	}

	/**
	* Evaluate a postfix numeric expression, with a single space separator
	*
	* @param expression
	* postfix expression
	* @return the expression evaluated value
	*/
	
	@Override
	public int evaluate(String expression) {
		Stack operandsStack = new Stack();
		int i,result;
		
		for (i = 0 ; i < expression.length() ; i++) {
			char c = expression.charAt(i);
			if ( Character.isDigit(c) ) {
				operandsStack.push(Integer.parseInt(String.valueOf(c)));
			}
			else if ( c == '+') {
				result = (int) operandsStack.pop() + (int) operandsStack.pop();
				operandsStack.push(result);
			}
			else if ( c == '-') {
				int a = (int) operandsStack.pop();
				int b =(int) operandsStack.pop();
				result = b - a;
				operandsStack.push(result);
			}	
			else if ( c == '*') {
				result = (int) operandsStack.pop() * (int) operandsStack.pop();
				operandsStack.push(result);
			}	
			else if ( c == '/') {
				int a = (int) operandsStack.pop();
				int b =(int) operandsStack.pop();
				if ( a == 0 )
					throw new RuntimeException("Error : Divide by zero");
				else
					result = b / a;
				operandsStack.push(result);
			}
			else if ( c != ' ' ) {
				throw new RuntimeException("Invalid Input.");
			}
		}
		if ( operandsStack.size() > 1)			// Wrong Expression
			throw new RuntimeException("Invalid Expression");
		else	
			return (int) operandsStack.pop();
		
	}

}
