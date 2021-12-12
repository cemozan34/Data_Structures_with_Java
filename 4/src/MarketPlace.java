import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MarketPlace {
	public static void main(String args[]) {
		int i = 0;
		BinarySearchTree<Food> foodBST = new BinarySearchTree<>();
		BinarySearchTree<Restaurant> restaurantBST = new BinarySearchTree<>();
		Food foodArray[] = new Food[50];
		Restaurant restaurantArray[] = new Restaurant[50];
		String line = "";  
		String splitBy = ",";  
		try   
		{
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader("CENG112_HW4.csv"));  
			while ((line = br.readLine()) != null)   //returns a Boolean value  
			{  
			if(i == 0) {
				line = br.readLine();
			}
			String[] tokens = line.split(splitBy);    // use comma as separator  
			// Deletion of spaces of words
			tokens[1]= tokens[1].strip();
			tokens[2]= tokens[2].strip();
			tokens[4]= tokens[4].strip();
			tokens[6]= tokens[6].strip();
			tokens[0]= tokens[0].strip();
			tokens[3]= tokens[3].strip();
			tokens[5]= tokens[5].strip();
			String fname = tokens[0];
			double fprice = Double.parseDouble(tokens[1]);
			int fstock = Integer.parseInt(tokens[2]);
			String rname = tokens[3];
			double rrating = Double.parseDouble(tokens[4]);
			String rcuisine = tokens[5];
			int rdelivery = Integer.parseInt(tokens[6]);
			
				Restaurant restaurant = new Restaurant(rname,rrating,rcuisine,rdelivery);
		        Food food = new Food(fname,fprice,fstock,restaurant);
		        foodArray[i] = food;
	        	 foodBST.insertFood(food);
		        restaurantArray[i] = restaurant;
		        //Inserted only one instance of restaurant in BST, if there are multiple restaurants with the same name in the csv file.
		        if(!restaurantBST.contain(restaurant)) {
		        	restaurantBST.insertRestaurant(restaurant);
		        }
		        if(!foodBST.contain(food)) {
		        	foodBST.insertFood(food);
		        }
		        i++;
			}  
		}   
		catch (IOException e)   
		{  
			e.printStackTrace();  
		}  
		System.out.println("------------- 1 -------------");
		restaurantBST.ascendingorderRestaurant();
		System.out.println("------------- 2 -------------");
		foodBST.descendingorderFood();
		System.out.println("------------- 3 -------------");
		shortestDeliveryTime(restaurantArray);
		System.out.println("------------- 4 -------------");
		highestStockCoffee(foodArray);
		System.out.println("------------- 5 -------------");
		listAndRemove(foodArray,restaurantArray,foodBST,restaurantBST);
		System.out.println("------------- 7 -------------");
		foodBST.updatePrice();
		System.out.println("------------- 8 ------------");
		foodBST.updateStock();
		System.out.println("------------- 9 -------------");
		restaurantBST.ascendingorderRestaurant();
		System.out.println("------------- 10 -------------");
		foodBST.descendingorderFood();
			
	}
	
	public static void shortestDeliveryTime(Restaurant array[]) {//This function  finds the fastest restaurant and prints it
		Restaurant shortestRestaurant = null;
		for(int i = 1; i < array.length ; i++) {
			if(array[i] != null) {
				if(array[i].getDeliveryTime() < array[i-1].getDeliveryTime()) {
					if(array[i].getCuisine().equals("Pizza")) {
						shortestRestaurant = array[i];
					}
				}
			}
			
		}
		System.out.println(shortestRestaurant.getName() + ", "+shortestRestaurant.getDeliveryTime());
		
	}
	public static void highestStockCoffee(Food array[]) {//This function finds the highest stock and prints it
		Food highestStockCoffee = null;
		for(int i = 1 ; i < array.length ; i++) {
			if(array[i] != null) {
				if(array[i].getStock() > array[i-1].getStock()) {
					if(array[i].getRestaurant().getCuisine().equals("Coffee")) {
						highestStockCoffee = array[i];
					}
				}
			}
		}
		System.out.println(highestStockCoffee.getName() + ", " +highestStockCoffee.getStock() );
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void listAndRemove(Food array[],Restaurant array2[],BinarySearchTree bst,BinarySearchTree bst2) {// this function list and removes them(restaurant name, rate; foods and price). Also it prints them
		Restaurant array3[] = new Restaurant[50];
		int k = 0;
		for(int i  = 0 ; i < array.length ; i++) {
			if(array[i] != null) {
				if(array[i].getPrice() > 80) {
					System.out.println(array[i].getName() + "   " + array[i].getPrice() + " Removed");
					bst.deleteKey(array[i]);
				}
			}
		}
		for(int i  = 0 ; i < array2.length ; i++) {
			if(array2[i] != null) {
				if(array2[i].getRating() < 8.0) {
					
					array3[k] = array2[i];
					k++;
					bst2.deleteKey(array2[i]);
				}
			}
		}
		System.out.println("------------- 6 -------------");
		for(int i = 0 ; i < array3.length ; i++) {
			try {
				if(array3[2*i] != null) {
					System.out.println(array3[2*i].getName() + "   " + array3[2*i].getRating() + " Removed");
				}
			}catch(ArrayIndexOutOfBoundsException e) {
				
			}
		}
	}
}
