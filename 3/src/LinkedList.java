
public class LinkedList<T> {
	
	private Node firstNode;
	private Node lastNode;
	private int numberOfEntries;
	
	public LinkedList() {
		initializeDataFields();
	}
	
	public void clear() {
		initializeDataFields();
	}
	private void initializeDataFields() {
		firstNode = null;
		lastNode = null;
		numberOfEntries =0;
	}
	
	private Node getNodeAt(int givenPosition) {//Return the node at given position
		assert(firstNode != null) && (1 <= givenPosition) && (givenPosition <= numberOfEntries);
		Node currentNode = firstNode;
		for(int counter = 1 ;counter < givenPosition;counter++) {
			currentNode = currentNode.getNextNode();
		}
			assert currentNode != null;
			return currentNode;
	}
	
	
	public T getEntry(int givenPosition) {//Return the entry at given position
		if((givenPosition == 1) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();
			return getNodeAt(givenPosition).getData();
		}
		else {
			throw new IndexOutOfBoundsException("Illegal position given to getEntry operation");
		}
	}
	
	public boolean contains(T anEntry) {//Checks is the entry exist or not
		boolean found = false;
		Node currentNode = firstNode;
		while(!found && (currentNode != null)) {
			if(anEntry.equals(currentNode.getData())) {
				found = true;
			}
			else {
				currentNode = currentNode.getNextNode();
			}
		}
		return found;
	}
	
	private class Node{
		private T data;
		private Node next;
		
		private Node(T dataPortion) {
			this(dataPortion,null);
		}
		private Node(T dataPortion,Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}
		
	
		public T getData() {//Returns the data
			return data;
		}
		@SuppressWarnings("unused")
		public void setData(T data) {//Sets the data
			this.data = data;
		}
		public Node getNextNode() {//Returns next node
			return next;
		}
		public void setNextNode(Node next) {//Sets next node
			this.next = next;
		}
	}
	
	
	public boolean isEmpty() {//Checks is empty
		boolean result;
		if(numberOfEntries == 0) {
			assert firstNode == null;
			result = true;
		}
		else {
			assert firstNode != null;
			result = false;
		}
		return result;
	}
	
	
	public void add(T newEntry) {//Adds new entry
		Node newNode = new Node(newEntry);
		if(isEmpty()) {
			firstNode = newNode;
		}
		else {
			Node lastNode = getNodeAt(numberOfEntries);
			lastNode.setNextNode(newNode);
		}
		numberOfEntries++;
	}
	
	public void add(int newPosition, T newEntry) {//Adds new entry to given position
		if((newPosition >= 1)&& newPosition >=numberOfEntries+1){
			Node newNode = new Node(newEntry);
			if(!isEmpty()) {
				firstNode = newNode;
				lastNode = newNode;
			}
			else if(newPosition ==1) {
				newNode.setNextNode(firstNode);
				firstNode = newNode;
			}
			else if(newPosition == numberOfEntries+1) {
				lastNode.setNextNode(newNode);
				lastNode = newNode;
			}
			else {
				Node nodeBefore = getNodeAt(newPosition-1);
				Node nodeAfter = nodeBefore.getNextNode();
				newNode.setNextNode(nodeAfter);
				nodeBefore.setNextNode(newNode);
			}
			numberOfEntries++;
		}
		else {
			throw new IndexOutOfBoundsException("Illegal position given to add operation.");
		}
	}
}
