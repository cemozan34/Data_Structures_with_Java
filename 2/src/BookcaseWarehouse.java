import java.util.Arrays;
import java.util.EmptyStackException;

public class BookcaseWarehouse<T> {
	private T[] stack;
	private int topIndex;
	private int numberOfEntries;

	private int initialCapacity= 10;
	
	public BookcaseWarehouse() {//constructor
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[])new Object[initialCapacity];
		stack = tempStack;
		topIndex = -1;

	}
	
	
	public void push(T newEntry) { // Adds new element to the stack
		 if(isStackFull()) {
			 doubleCapacity();
		 }
		 stack[topIndex + 1 ] = newEntry;
		 topIndex++;
		 numberOfEntries++;
	 }
   private void doubleCapacity() {
		int newLength = 2 * stack.length;
		stack = Arrays.copyOf(stack, newLength);
	}
	
	private boolean isStackFull() {
		return (numberOfEntries >= stack.length);
	}
	public T pop() {//It deletes element from the stack
		if(isEmpty()) {
			System.out.println("Cannot pop an element, Warehouse is empty");
			throw new EmptyStackException();
		}
		else {
			T top = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
			numberOfEntries--;
			return top;
		}
	}
	
	public boolean isEmpty() {
		return (topIndex == -1);
	}
	public boolean contains(T item) { // Looking array to find wanted item.
        boolean isContain = false;
        int i = 0;
        while(!isContain && (i<numberOfEntries)) {
        	if(stack[i] != null) {
        		if (item.equals(stack[i].getClass().getSimpleName())) {
                    isContain = true;
                }
        	}
            i++;
        }
        return isContain;
    }
	public int getNumberOf(T entry) {//It returns the count of the product that we are looking for
		 int counter = 0;
		 for(int index = 0 ; index < numberOfEntries;index++) {
			 if(stack[index] != null) {
				 if(entry.equals(stack[index].getClass().getSimpleName())) {
					 counter++;
				 } 
			 }
		 }
		 return counter;
	 }
}
