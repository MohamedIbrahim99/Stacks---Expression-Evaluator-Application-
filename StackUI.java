package eg.edu.alexu.csd.datastructure.stack.cs;

import java.util.Scanner;

/**
 * user interface (UI) for testing the implementation of the Stack.
 * asks for input and process it properly.
 */

public class StackUI {

	public static void main(String[] args)  {
		
		Stack s = new Stack();
	while (true) {
		
		int input = 0;
		try {
			Scanner scan = new Scanner(System.in);

			System.out.println("Enter the operation : ");
			System.out.println("1- Push");
			System.out.println("2- Pop");
			System.out.println("3- Peek");
			System.out.println("4- Get Size");
			System.out.println("5- Check if empty");
			
			input = scan.nextInt();
			switch (input) {
			case 1 :
				System.out.println("Enter the element : ");
				int element = 0;
				try {
					element = scan.nextInt();
					s.push(element);
					s.printStack();
				}
				catch (Exception e) {
					System.out.println("Wrong Input !!");
				}
				break;
				
			case 2 :
				Object data = s.pop();
				System.out.println("The Top was : " + data);
				s.printStack();
				break;

			case 3 :
				data = s.peek();
				System.out.println("The Top is : " + data);
				s.printStack();
				break;

			case 4 :
				int size = s.size();
				System.out.println("The size is : " + size);
				break;
				
			case 5 :
				if (s.isEmpty())
					System.out.println("The Stack Is Empty");
				else
					System.out.println("The Stack Is Not Empty");
				break;
				
			default :
				throw new RuntimeException("Invalid Input");

		}
		}
		catch (Exception e) {
			System.out.println("Wrong Input !!");
		}

		System.out.println();
		System.out.println("==========================================");
	}
	
   }
}
