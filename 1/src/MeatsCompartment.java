
public class MeatsCompartment<T> {
	private T[] bag;
	private int gramsOfEntries;
	private static final int max_basket_size = 5000;
	private int numberOfEntries;
	
	
	public MeatsCompartment() { // Constructor
		T[] tempBag = (T[])new Object[max_basket_size];
		bag = tempBag;
		gramsOfEntries = 0;
		numberOfEntries = 0;
	}
	
	
	public boolean isFull() {
		return gramsOfEntries >= max_basket_size;
	}
	
	
	
	public int remainigSpace() {
		return max_basket_size - gramsOfEntries;
	}
	public boolean transferTo(IBag<T> targetBag, T item) {
		boolean isItemTransfered = true;
		if(isFull()) {
			isItemTransfered = false;
			System.out.println(((Item) item).getName() + "cannot be added");
		}
		else {
			bag[numberOfEntries] = item;
			gramsOfEntries += ((Item) item).getWeight();
			numberOfEntries++;
		}
		return isItemTransfered;
	}

}
