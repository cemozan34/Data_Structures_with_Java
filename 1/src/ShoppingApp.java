import java.io.BufferedReader; // For reading file.
import java.io.FileNotFoundException; // For throwing an exception.
import java.io.FileReader; // For reading file.
import java.io.IOException; // For throwing an exception.
import java.util.Scanner; // For taking user inputs.

public class ShoppingApp {

	public static void main(String[] args) throws FileNotFoundException {
		
		Item itemArray[] = new Item[50]; // Readed items will be placed this array.
		int i = 0;
		try(BufferedReader in = new BufferedReader(new FileReader("inventory.txt"))) {
		    String str;
		    while ((str = in.readLine()) != null) {
		    	String[] tokens = str.split(","); // splitting line with ',' delimeter.
		        String name = tokens[0];
		        String compartment = tokens[1];
		        int weight = Integer.parseInt(tokens[2]);
		        Item item = new Item(name,compartment,weight);
		        itemArray[i] = item;
		        i++;
		    }
		}
		catch (IOException e) {
		    System.out.println("File Read Error");
		}
		
		
		Item itemArrayRefined[] = new Item[i]; 
		for(int l = 0 ; l < i ; l++) { // To minimize itemArray's length(50) to total readed elements. 
			itemArrayRefined[l] = itemArray[l];
		}	
		
		// Creating compartments and shopping basket.
		
		ShoppingBasket<Item> shoppingBasket = new ShoppingBasket<Item>();
		BevaragesCompartment<Item> bevaragesCompartment = new BevaragesCompartment<Item>();
		MeatsCompartment<Item> meatsCompartment = new MeatsCompartment<Item>();
		VegetablesFruitsCompartment<Item> vegetableFruitsCompartment = new VegetablesFruitsCompartment<Item>();
		SnacksCompartment<Item> snacksCompartment = new SnacksCompartment<Item>();
		
		System.out.println("Welcome to the ShoppingApp");
		while(true) {
			System.out.println("Please select an option\n 1-Go to shopping\n 2-See the status of the fridge\n 3-Exit");
			Scanner scanner = new Scanner(System.in);
			int input = scanner.nextInt(); // Taking user input.
			if(input == 1) {
				
					while(true) {
						System.out.println("Please select an option\n 1- Add an item to the basket\n 2- See the basket\n 3-Finish shopping");
						Scanner scanner1 = new Scanner(System.in);
						int input1 = scanner.nextInt(); // Taking user input.
						if (input1 == 1) {
							
							
							for(int k = 0 ; k < itemArrayRefined.length ; k++) {
								System.out.println((k+1)+"- "+itemArrayRefined[k].getName());
							}
							
							System.out.println("Please select an item:");
							Scanner scanner2 = new Scanner(System.in);
							int input2 = scanner2.nextInt(); // Taking user input.
							
							
							if (input2 <= itemArrayRefined.length && input2 != 0 && input2 > 0) { // To make sure that user enters valid number.
								shoppingBasket.add(itemArrayRefined[input2-1]); // Products are listed to the user with their index number + 1 in console. So I have to subtract 1 from user input.
									
								if(shoppingBasket.isFull()) { // If weight exceed 2000gr, break.
									System.out.println("Shopping basket is full shopping is finished!");
									System.out.println("Filling the fridge!");
									
									for(int c = 0 ; c < itemArrayRefined.length ; c++) {
										
										if(shoppingBasket.contains(itemArrayRefined[c])) {
											
											String compartment1 = itemArrayRefined[c].getItem_compartment();
											if (compartment1.contentEquals("beverages")) {
												bevaragesCompartment.transferTo(shoppingBasket, itemArrayRefined[c]);
												shoppingBasket.remove(itemArrayRefined[c]);
											}
											else if (compartment1.contentEquals("snacks")) {
												snacksCompartment.transferTo(shoppingBasket, itemArrayRefined[c]);
												shoppingBasket.remove(itemArrayRefined[c]);
											}
											else if (compartment1.contentEquals("meats")) {
												meatsCompartment.transferTo(shoppingBasket, itemArrayRefined[c]);
												shoppingBasket.remove(itemArrayRefined[c]);
											}
											else if (compartment1.contentEquals("vegetables and fruits")) {
												vegetableFruitsCompartment.transferTo(shoppingBasket, itemArrayRefined[c]);
												shoppingBasket.remove(itemArrayRefined[c]);
											}	
										}
									}
									System.out.println("Fridge is filled");
									break;
								}
							}
							else {
								System.out.println("Enter valid number!");
							}
						}
						else if(input1 == 2) { // Showing shopping basket.
							System.out.println("Your basket contains:");
							shoppingBasket.displayItems();
						}
						else if(input1==3) { // Finishin shopping and filling fridge with respect to related compartments.
							
							System.out.println("Shopping is finished.");
							System.out.println("Filling the fridge");
							for(int m = 0 ; m < itemArrayRefined.length ; m++) {
								
								if(shoppingBasket.contains(itemArrayRefined[m])) {
									
									String compartment1 = itemArrayRefined[m].getItem_compartment();
									if (compartment1.contentEquals("beverages")) {
										bevaragesCompartment.transferTo(shoppingBasket, itemArrayRefined[m]);
										shoppingBasket.remove(itemArrayRefined[m]);
									}
									else if (compartment1.contentEquals("snacks")) {
										snacksCompartment.transferTo(shoppingBasket, itemArrayRefined[m]);
										shoppingBasket.remove(itemArrayRefined[m]);
									}
									else if (compartment1.contentEquals("meats")) {
										meatsCompartment.transferTo(shoppingBasket, itemArrayRefined[m]);
										shoppingBasket.remove(itemArrayRefined[m]);
									}
									else if (compartment1.contentEquals("vegetables and fruits")) {
										vegetableFruitsCompartment.transferTo(shoppingBasket, itemArrayRefined[m]);
										shoppingBasket.remove(itemArrayRefined[m]);
									}
								}
							}
							System.out.println("Fridge is filled");
							break;
						}
				}
			}
			
			else if (input == 2) { // Showing each compartment's remaining space.
				System.out.println("Remaining capacities of each compartment");
				System.out.println("Bevarages: " + bevaragesCompartment.remainigSpace());
				System.out.println("Vegetables And Fruits: " + vegetableFruitsCompartment.remainigSpace());
				System.out.println("Meats: " + meatsCompartment.remainigSpace());
				System.out.println("Snacks: " + snacksCompartment.remainigSpace());
			}
			
			else if(input == 3) { // Quitting program.
				break;
			}
		}
	}
}
