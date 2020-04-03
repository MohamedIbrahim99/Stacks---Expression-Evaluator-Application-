package eg.edu.alexu.csd.datastructure.stack.cs;

/**
 * Implementation for stack data structure
 */
public class Stack implements IStack {

	private node top;		// Reference to the head node
	private int size;		// Number of elements in the stack
	
	public Stack(){		// Constructs an empty Stack
		top = null;
		size = 0;
	}
	
	/**
	* Removes the element at the top of stack and returns that element.
	* @return top of stack element, or through exception if empty
	*/
	@Override
	public Object pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty."); 
		}
		else {
			Object temp = top.getElement();
			top = top.getNext();
			size--;
			return temp;
		}	
	}
	
	/**
	* Get the element at the top of stack without removing it from stack.
	* @return top of stack element, or through exception if empty
	*/
	@Override
	public Object peek() {			
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty."); 
		}
		else {
			return top.getElement();
		}
	}

	/**
	* Pushes an item onto the top of this stack.
	* @param object to insert
	*/
	@Override
	public void push(Object element) {	
		node newTop = new node(element,top);
		top = newTop;
		size++;
	}

	/**
	* Tests if this stack is empty
	* @return true if stack empty
	*/
	@Override
	public boolean isEmpty() {		
		if ( top == null)
			return true;
		else
			return false;
	}

	/**
	* Returns the number of elements in the stack.
	* @return number of elements in the stack
	*/
	@Override
	public int size() {		
		return size;
	}
	
	/*
	 * To print the stack elements.
	 */
	public void printStack () {			
		if (!isEmpty()) {
			System.out.print("The contents of the stack : ");
			node q = top;
			while (q != null) {
				System.out.print(q.getElement());
				q=q.getNext();
				if ( q != null)
					System.out.print(" , ");
			}
		}
		else 
			System.out.println("Stack is Empty");
	}

	
}
