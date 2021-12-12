
public class Item {
	private String name;
	private String item_compartment;
	private int weight;
	
	
	public Item(String name, String item_compartment, int weight) { // Constructor
		
		this.item_compartment = item_compartment;
		this.name = name;
		this.weight = weight;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getItem_compartment() {
		return item_compartment;
	}
	public void setItem_compartment(String item_compartment) {
		this.item_compartment = item_compartment;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}
