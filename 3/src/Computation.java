import java.util.NoSuchElementException;

public class Computation<T> {
	private int id;
	private IProcess<T> process;
	private int frontIndex;
	private int backIndex;
	private int numberOfEntries;
	private int initialCapacity = 15;
	private T[] line;
	
	public Computation() {//constructor
		@SuppressWarnings("unchecked")
		T[] tempLine = (T[])new Object[initialCapacity+1];
		line = tempLine;
		frontIndex = 0;
		backIndex = initialCapacity;
	}
	
	
	 
	 @SuppressWarnings("unchecked")
	public void enqueue(T newEntry) {//It adds new element to queue 
		 int i;
		 if(numberOfEntries == 0) {
			 line[frontIndex] = newEntry;
			 numberOfEntries++;
		 }
		 for(i = numberOfEntries-1;i>=0;i--) {
			 if(((IProcess<T>) newEntry).getPriority() <= ((IProcess<T>) line[i]).getPriority()) {
				 line[i+1] = line[i];
			 }
			 else {
				 break;
			 }
		 }
		 line[i+1] = newEntry;
		 numberOfEntries++;
	 }
	
	 
	 public boolean isEmpty() {//It checks the queue empty or not 
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
	
	
	public int getId() {//It returns the elements id
		return id;
	}
	public void setId(int id) {//It gives the id to element
		this.id = id;
	}
	public IProcess<T> getProcess() {//returns the Process
		return process;
	}
	public void setProcess(IProcess<T> process) {//Sets process new data
		this.process = process;
	}
	public int getFrontIndex() {//It returns the front index element
		return frontIndex;
	}
	public void setFrontIndex(int frontIndex) {//It sets the front index element
		this.frontIndex = frontIndex;
	}
	public int getBackIndex() {//It returns back index element
		return backIndex;
	}
	public void setBackIndex(int backIndex) {//It sets the back index element
		this.backIndex = backIndex;
	}
	public int getNumberOfEntries() {//It returns the count of entries, size
		return numberOfEntries;
	}
	public void setNumberOfEntries(int numberOfEntries) {//It sets the size 
		this.numberOfEntries = numberOfEntries;
	}
	public int getInitialCapacity() {//It returns the capacity
		return initialCapacity;
	}
	public void setInitialCapacity(int initialCapacity) {//It sets the capacity
		this.initialCapacity = initialCapacity;
	}
	public T[] getLine() {//It returns the line
		return line;
	}
	public void setLine(T[] line) {//It sets the line
		this.line = line;
	}
	
}
