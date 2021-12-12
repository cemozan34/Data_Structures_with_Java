
public interface IBag <T> {
	public boolean add(T newItem);
	public boolean isEmpty();
	public boolean isFull();
	public T remove(T item);
	public int getItemCount();
	public int getIndexOf(T item);
	public boolean contains(T item);
	public void displayItems();



}
