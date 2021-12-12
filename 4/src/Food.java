
public class Food implements Orderable{
	private String name;
	private double price;
	private int stock;
	private Restaurant restaurant;
	
	public Food(String fname, double fprice, int fstock, Restaurant restaurant2) { // Constructor
		name = fname;
		price = fprice;
		stock = fstock;
		restaurant = restaurant2;
	}
	public void updatePrice() {
		// Implemented in BinarySearchTree Class
	}
	public void updateStock() {
		// Implemented in BinarySearchTree Class
	}
	
	public String getName() {//returns the name
		return name;
	}
	public void setName(String name) {//sets the name
		this.name = name;
	}
	public double getPrice() {//returns the price
		return price;
	}
	public void setPrice(double price) {//sets the price
		this.price = price;
	}
	public int getStock() {// returns the stock
		return stock;
	}
	public void setStock(int stock) {//sets the stock 
		this.stock = stock;
	}
	public Restaurant getRestaurant() {//returns the restaurant
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {//sets the restaurant 
		this.restaurant = restaurant;
	}
	
}
