package eg.edu.alexu.csd.datastructure.stack.cs;

/**
 * Implementation for Single LinkedList Node data structure
 */
public class node {
	
		private Object data;
		private node next;
		
		public node() {
			data = null;
			next = null;
		}
		
		/** Creates a node with the given element and next node. */
		public node(Object element , node n) {
			data = element;
			next = n;
		}
		
		/** Returns the next node of this node. */
		public node getNext() {
			return next;
		}
		
		/** Returns the element of this node. */
		public Object getElement(){
			return data;
		}
		
		/** Sets the next node of this node. */
		public void setNext(node newNext) {
			next = newNext;
		}
		
		/** Sets the element of this node. */
		public void setElement (Object newElement) {
			data = newElement;
		}
		
}
