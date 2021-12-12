
public class Restaurant {
	private String name;
	private double rating;
	private String cuisine;
	private int deliveryTime; // in minutes
	
	
	public Restaurant(String rname, double rrating, String rcuisine, int rdelivery) {//constructor
		name = rname;
		rating = rrating;
		cuisine = rcuisine;
		deliveryTime = rdelivery;
	}
	public void updateCuisine(String category) {//updates cuisine
		
	}
	public void updateRating(double score) {//updates rating scores
		
	}
	public void updateDeliveryTime(int deliveryTime) {//updates delivery time
		
	}
	public String getName() {//returns name
		return name;
	}
	public void setName(String name) {//sets name
		this.name = name;
	}
	public double getRating() {//returns the rating
		return rating;
	}
	public void setRating(double rating) {//sets the ratings
		this.rating = rating;
	}
	public String getCuisine() {//return the cuisine
		return cuisine;
	}
	public void setCuisine(String cuisine) {//sets the cuisine
		this.cuisine = cuisine;
	}
	public int getDeliveryTime() {//returns the delivery time
		return deliveryTime;
	}
	public void setDeliveryTime(int deliveryTime) {//sets the delivery time
		this.deliveryTime = deliveryTime;
	}
	
}
