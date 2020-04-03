package eg.edu.alexu.csd.datastructure.stack.cs;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExpressionEvaluatorTest {

	@Test
	void convertTest1() {
		ExpressionEvaluator e = new ExpressionEvaluator();
		
		String expression = "2+3*4";
		String newExpression = e.infixToPostfix(expression);
		String result = "234*+";
		
		assertEquals(result, newExpression);
	}
	
	@Test
	void convertTest2() {
		ExpressionEvaluator e = new ExpressionEvaluator();
		
		String expression = "a*b+5";
		String newExpression = e.infixToPostfix(expression);
		String result = "ab*5+";
		
		assertEquals(result, newExpression);
	}
	
	@Test
	void convertTest3() {
		ExpressionEvaluator e = new ExpressionEvaluator();
		
		String expression = "(1 + 2) * 7";
		String newExpression = e.infixToPostfix(expression);
		String result = "1  2+  7*";
		
		assertEquals(result, newExpression);
	}
	
	@Test
	void convertTest4() {
		ExpressionEvaluator e = new ExpressionEvaluator();
		
		String expression = "a*b/c";
		String newExpression = e.infixToPostfix(expression);
		String result = "ab*c/";
		
		assertEquals(result, newExpression);
	}
	
	@Test
	void convertTest5() {
		ExpressionEvaluator e = new ExpressionEvaluator();
		
		String expression = "(a/(b-c+d))*(e-a)*c";
		String newExpression = e.infixToPostfix(expression);
		String result = "abc-d+/ea-*c*";
		
		assertEquals(result, newExpression);
	}
	
	@Test
	void convertTest6() {
		ExpressionEvaluator e = new ExpressionEvaluator();
		
		String expression = "a/b-c+d*e-a*c";
		String newExpression = e.infixToPostfix(expression);
		String result = "ab/c-de*+ac*-";

		assertEquals(result, newExpression);
	}
	
	@Test
	void convertTest7() {			// Negative number Test
		ExpressionEvaluator e = new ExpressionEvaluator();
		
		String expression = "5*-2+6";
		String newExpression = e.infixToPostfix(expression);
		String result = "502-*6+";

		assertEquals(result, newExpression);
	}
	
	@Test
	void evaluateTest1() {
		ExpressionEvaluator e = new ExpressionEvaluator();
		
		String expression = "6 2 / 3 - 4 2 * +";
		int result = e.evaluate(expression);
		
		assertEquals(8 , result);
	}
	
	@Test
	void evaluateTest2() {
		ExpressionEvaluator e = new ExpressionEvaluator();
		
		String expression = "2 3 4 * +";
		int result = e.evaluate(expression);
		
		assertEquals(14 , result);
	}
	
	@Test
	void evaluateTest3() {
		ExpressionEvaluator e = new ExpressionEvaluator();
		
		String expression = "1 2 + 7 *";
		int result = e.evaluate(expression);
		
		assertEquals(21 , result);
	}
	
	@Test
	void evaluateTest4() {			// Wrong Expression
		ExpressionEvaluator e = new ExpressionEvaluator();
		
		String expression = "1 2 + 7";
		
		RuntimeException b = assertThrows (RuntimeException.class,() -> e.evaluate(expression));
		assertEquals("Invalid Expression" ,b.getMessage() );
	}
	
	@Test
	void evaluateTest5() {			// Wrong Expression "null case" 
		ExpressionEvaluator e = new ExpressionEvaluator();
		
		String expression = " ";
		
		RuntimeException b = assertThrows (RuntimeException.class,() -> e.evaluate(expression));
		assertEquals("Stack is empty." ,b.getMessage() );
	}

}
