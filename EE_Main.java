package eg.edu.alexu.csd.datastructure.stack.cs;

import java.util.Scanner;

/**
 * Program that takes a symbolic infix expression as input and converts it to postfix notation
 * enter the values of each symbol, evaluates the postfix expression 
 * and outputs the resulting expression and its value.
 */

public class EE_Main {

	public static void main(String[] args) {

		ExpressionEvaluator e = new ExpressionEvaluator();
		Scanner scan = new Scanner(System.in);
		String expression ;
				
		try {
			System.out.print("Enter infix Expression : ");
			expression = scan.nextLine();				// Scan the infix Expression
			String newExpression = e.infixToPostfix(expression);		// Convert the expression from infix To Postfix
			int res = e.evaluate(newExpression);			// Evaluate
			
			System.out.print("The Postfix Expression is : ");
			for (int i = 0; i < newExpression.length() ; i++)
				System.out.print(newExpression.charAt(i));
			System.out.println();
			System.out.print("The Result is :");
			System.out.println(res);
		}
		catch ( Exception x ) {
			System.out.println("Invalid Expression");
		}
		
	}
}
