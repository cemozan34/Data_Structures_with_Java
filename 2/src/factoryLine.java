import java.util.Arrays;
import java.util.NoSuchElementException;

public class factoryLine<T> {
	private T[] line;
	private int frontIndex;
	private int backIndex;
	private int numberOfEntries;

	private int initialCapacity = 10;

	
	@SuppressWarnings("unchecked")
	public factoryLine() {//constructor
		T[] tempLine = (T[])new Object[initialCapacity+1];
		line = tempLine;
		frontIndex = 0;
		backIndex = initialCapacity;

	}
	
	 public void enqueue(T newEntry) {
		 if(isQueueFull()) {
			 doubleCapacity();
		 }
		 backIndex = (backIndex + 1) % line.length;
		 line[backIndex] = newEntry;
		 numberOfEntries++;
	 }
	
	 public T dequeue() {//It removes element from the queue
		 try {
			 if(isEmpty()) {
				 System.out.println("Cannot dequeue element, line is empty");
				 throw new NoSuchElementException();
			 }
			 else {
				 T front = line[frontIndex];
				 line[frontIndex] = null;
				 frontIndex = (frontIndex + 1) % line.length;
				 numberOfEntries--;
				 return front;
			 }
		 }catch(NoSuchElementException e) {
			 System.out.println("Cannot deque an this element, line is empty");
			 return null;
		 }
		 
	 }
	 
	 public boolean isEmpty() {
		 return (frontIndex == ((backIndex+1)%line.length));

	 }
	 

	public int getNumberOf(T entry) {//It returns the count of the element in the line
		 int counter = 0;
		 for(int index = 0 ; index < initialCapacity ; index++) {
			 if(line[index] == null) {
				 continue;
			 }
			 else if(entry.equals((line[index].getClass().getSimpleName()))) {
				counter++; 
			 }
		}
		 return counter;
	 }
	 
	 public T getFront(){//It returns the front element in the queue
		 try {
			 if(isEmpty()) {
				 throw new NoSuchElementException();
			 }
			 else {
				 return line[frontIndex];
			 }
		 }catch(NoSuchElementException e) {
			 System.out.print("Fail there is no such element in factory line. Marketing Analyst did not request yet.");
			 return null;
		 }
		 
	 }
	 
	 
	public String getFrontProductName() {
		 if(line[frontIndex] != null) {
			 if((line[frontIndex].getClass().getSimpleName()).equals("Bed")) {
				 return "bed";
			 }
			 else if((line[frontIndex].getClass().getSimpleName()).equals("Sofa")) {
				 return "sofa";
			 }
			 else if((line[frontIndex].getClass().getSimpleName()).equals("Dresser")) {
				 return "dresser" ;
			 }
			 else if((line[frontIndex].getClass().getSimpleName()).equals("Bookcase")) {
				 return "bookcase";
			 }
			 else if((line[frontIndex].getClass().getSimpleName()).equals("Table")) {
				 return "table";
			 }
			 else if((line[frontIndex].getClass().getSimpleName()).equals("Chair")){
				 return "chair";
			 }
			 else {
				 return null;
			 }
		 }
		 else {
			 return "no item";
		 }
	 }
	
	public boolean contains(T item) { // Looking array to find wanted item.
        boolean isContain = false;
        int i = 0;
        while(!isContain && (i<numberOfEntries)) {
        	if(line[i] != null) {
        		if (item.equals(line[i].getClass().getSimpleName())) {
                    isContain = true;
                }
        	}
            i++;
        }
        return isContain;
    }
	
	private void doubleCapacity() {
		int newLength = 2 * line.length;
		line = Arrays.copyOf(line, newLength);
	}
	
	private boolean isQueueFull() {
		return (numberOfEntries >= line.length);
	}

}
