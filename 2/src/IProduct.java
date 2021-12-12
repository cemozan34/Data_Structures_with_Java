
public interface IProduct<T> {
	
	// We implement all of the methods listed here but did not use them in IZTECHEA class.
	public boolean isManufactured(T factoryLine);
	public boolean isStored(T warehouse);
	public boolean isSold(T item,T[] soldItemList);
}
