
public class ShoppingBasket<T> implements IBag <T>{
	private T[] bag;
	private int gramsOfEntries;
	private static final int max_basket_size = 2000; // To make sure max_basket_size cannot be changeable.
	private int numberOfEntries;
	
	public ShoppingBasket() { // Constructor which set initial values of an object when I create one from this class.
		T[] tempBag = (T[])new Object[max_basket_size];
		bag = tempBag;
		gramsOfEntries = 0;
		numberOfEntries = 0;
	}
	
	public boolean isEmpty() {
		return gramsOfEntries == 0;
	}
	
	public boolean isFull() {
		return gramsOfEntries >= max_basket_size;
	}
	
	public boolean add(T newItem) {
		boolean isItemAdded = true;
		if(isFull()) { // Checking if the bag is full or not. If bag is full, print an error message to the user.
			isItemAdded = false;
			System.out.println("You exceeded the max basket size");
		}
		else {
			System.out.println("Added!");
			bag[numberOfEntries] = newItem; // Placing newItem to the bag with using numberOfEntries as an index.
			gramsOfEntries += ((Item) newItem).getWeight(); // Getting added item's weight to calculate gramsOfEntries to make sure user cannot exceed max_basket_size.
			numberOfEntries++; // Increasing numberOfEntries with 1 because we add an item.
		}
		return isItemAdded;
	}
	
	public T removeByIndex(int givenIndex) { //removing an item from bag with using index number.
		T result = null;
		if (!isEmpty() && (givenIndex >=0) && numberOfEntries > 0) { // Checking numberOfEntries > 0 because I don't there will be an error occurrence which is about bag[-1] when numberOfEntries = 0.
			result = bag[givenIndex];
			bag[givenIndex] = bag[numberOfEntries - 1]; // Replacing givenIndex place with bag[numberOfEntries-1].
			bag[numberOfEntries - 1] = null; // Making array's place null.
			numberOfEntries--; // Decreasing numberOfEntries with 1.
		}
		return result;
		
	}
	

	
	public T remove(T item) { // Removing item from array with using object as a parameter.
		int index = getIndexOf(item); // Calling getIndexOf method to determine index of the item.
		int grams = ((Item) item).getWeight(); // Getting item's weight to subtract weight value from gramsOfEntries for making our system works correctly.
		T result = removeByIndex(index); // Calling removeByIndex to remove item from array.
		gramsOfEntries -= grams;
		return result;
	}
	
	public int getIndexOf(T item) {
		int where = -1; // We cannot say false because its data type is int and we cannot say 0 because it can be our answer.
		boolean found = false;
		int index = 0;
		while(!found && (index<numberOfEntries)) {
			if (item.equals(bag[index])) {
				found = true;
				where = index;
			}
			index++;
		}
		return where;
	}
	
	public boolean contains(T item) { // Looking array to find wanted item.
		boolean isContain = false;
		int i = 0;
		while(!isContain && (i<numberOfEntries)) {
			if (item.equals(bag[i])) {
				isContain = true;	
			}
			i++;
		}
		return isContain;
	}

	public void displayItems() { // Display all the item that in the array.
		for (int i = 0 ; i < numberOfEntries ; i++) {
			Item item = (Item) bag[i];
			System.out.println(item.getName());
		}
		
	}
	

	public int getItemCount() { // Returns how many items in the array.
		return numberOfEntries;
	}

	
	
	
	
	
	
	
	
	
}
