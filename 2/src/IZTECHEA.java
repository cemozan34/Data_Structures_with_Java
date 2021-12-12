import java.util.Scanner;
import java.util.Random;
public class IZTECHEA {
	@SuppressWarnings({ "rawtypes", "resource", "unchecked" })
	public static void main(String args[]) throws Exception {
		
		BedWarehouse bw = new BedWarehouse();
		SofaWarehouse sw = new SofaWarehouse();
		ChairWarehouse cw = new ChairWarehouse();
		DresserWarehouse dw = new DresserWarehouse();
		TableWarehouse tw = new TableWarehouse();
		BookcaseWarehouse bookw = new BookcaseWarehouse();
		factoryLine factoryLine = new factoryLine();
		

		int numberOfBedSold = 0;
		int numberOfSofaSold = 0;
		int numberOfChairSold = 0;
		int numberOfTableSold = 0;
		int numberOfBookcaseSold = 0;
		int numberOfDresserSold = 0;
		
		
		int cycleCounter=1;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of random sequence cycles: ");
		int input = scanner.nextInt();
		String productList[] = {"sofa","bed","chair","dresser","table","bookcase"};
		for(int i = 0 ; i < input ; i++) {
			Random random = new Random();
			int role = random.nextInt(3); // 0:Marketing Analyst, 1:Storage Chief, 2:Customer.
			int product = random.nextInt(6); // 0:sofa, 1:bed, 2:chair, 3:dresser, 4:table, 5:bookcase.
			if (role == 0) { // Marketing Analyst (Checked all the conditions and after ensured that the code is working correctly, we add Success lines in a hard code way.)
				if(productList[product]=="bed") {
					Bed product1 = new Bed("bed");
					System.out.println(cycleCounter+"."+"\tMarketing Analyst requesting " + productList[product] + ". SUCCESS " + productList[product]+ " manufactured!");
					factoryLine.enqueue(product1);
					cycleCounter++;
				}
				else if(productList[product]=="sofa") {
					Sofa product1 = new Sofa("sofa");
					System.out.println(cycleCounter+"."+"\tMarketing Analyst requesting " + productList[product] + ". SUCCESS " + productList[product]+ " manufactured!");
					factoryLine.enqueue(product1);
					cycleCounter++;
				}
				else if(productList[product]=="chair") {
					Chair product1 = new Chair("chair");
					System.out.println(cycleCounter+"."+"\tMarketing Analyst requesting " + productList[product] + ". SUCCESS " + productList[product]+ " manufactured!");
					factoryLine.enqueue(product1);
					cycleCounter++;
				}
				else if(productList[product]=="dresser") {
					Dresser product1 = new Dresser("dresser");
					System.out.println(cycleCounter+"."+"\tMarketing Analyst requesting " + productList[product] + ". SUCCESS " + productList[product]+ " manufactured!");
					factoryLine.enqueue(product1);
					cycleCounter++;
				}
				else if(productList[product]=="table") {
					Table product1 = new Table("table");
					System.out.println(cycleCounter+"."+"\tMarketing Analyst requesting " + productList[product] + ". SUCCESS " + productList[product]+ " manufactured!");
					factoryLine.enqueue(product1);
					cycleCounter++;
				}
				else if(productList[product]=="bookcase") {
					Bookcase product1 = new Bookcase("bookcase");
					System.out.println(cycleCounter+"."+"\tMarketing Analyst requesting " + productList[product] + ". SUCCESS " + productList[product]+ " manufactured!");
					factoryLine.enqueue(product1);
					cycleCounter++;
				}
				
			}
			else if (role == 1) { // Storage Chief (Checked all the conditions and after ensured the code is working correctly, we add Success lines in a hard code way.)
				
					if(factoryLine.getFrontProductName().equals("bed")) {
						System.out.println(cycleCounter+"."+"\tStoring Chief storing bed. SUCCESS. Bed stored in Bed Warehouse!");
						bw.push(factoryLine.getFront());
						factoryLine.dequeue();
						cycleCounter++;
					}
					
					
				
				
					
					else if(factoryLine.getFrontProductName().equals("sofa")) {
						System.out.println(cycleCounter+"."+"\tStoring Chief storing sofa. SUCCESS. sofa stored in Sofa Warehouse!");
						sw.push(factoryLine.getFront());
						factoryLine.dequeue();
						cycleCounter++;
						
					}
					
				
					
					else if(factoryLine.getFrontProductName().equals("chair")) {
						System.out.println(cycleCounter+"."+"\tStoring Chief storing chair. SUCCESS. Chair stored in Chair Warehouse!");
						cw.push(factoryLine.getFront());
						factoryLine.dequeue();
						cycleCounter++;
					}
					
					
				
				
					
					else if(factoryLine.getFrontProductName().equals("dresser")) {
						System.out.println(cycleCounter+"."+"\tStoring Chief storing dresser. SUCCESS. Dresser stored in Dresser Warehouse!");
						dw.push(factoryLine.getFront());
						factoryLine.dequeue();
						cycleCounter++;
					}
					
				
					
					else if(factoryLine.getFrontProductName().equals("table")) {
						System.out.println(cycleCounter+"."+"\tStoring Chief storing table. SUCCESS. Table stored in Table Warehouse!");
						tw.push(factoryLine.getFront());
						factoryLine.dequeue();
						cycleCounter++;
					}
				
	
					
					else if(factoryLine.getFrontProductName().equals("bookcase")) {
						System.out.println(cycleCounter+"."+"\tStoring Chief storing bookcase. SUCCESS. Bookcase stored in Bookcase Warehouse!");
						bookw.push(factoryLine.getFront());
						factoryLine.dequeue();
						cycleCounter++;
					}
					
					else {
						System.out.println(cycleCounter+"."+"\tStoring chief FAILED. There is no product in line");
						cycleCounter++;
					}
			
					
			}
			else if (role == 2) { // Customer (Checked all the conditions and after ensured the code is working correctly, we add Success lines in a hard code way.)
				System.out.print(cycleCounter+"."+"\tCustomer buying " + productList[product]);
				cycleCounter++;
				
				if (productList[product] == "bed") {
					if(bw.contains("Bed")) {
						System.out.println(" SUCCESS. Customer bought "+productList[product]);
						bw.pop();
						numberOfBedSold++;
					}
					else {
						System.out.println(" FAIL. "+productList[product]+" Warehouse is empty");
					}
				}
				
				
				else if (productList[product] == "sofa") {
					if(sw.contains("Sofa")) {
						System.out.println(" SUCCESS. Customer bought "+productList[product]);
						sw.pop();
						numberOfSofaSold++;
					}
					else {
						System.out.println(" FAIL. "+productList[product]+" Warehouse is empty");
					}
				}
				
				
				else if (productList[product] == "chair") {
					if(cw.contains("Chair")) {
						System.out.println(" SUCCESS. Customer bought "+productList[product]);
						cw.pop();
						numberOfChairSold++;
					}
					else {
						System.out.println(" FAIL. "+productList[product]+" Warehouse is empty");
					}
				}
				
				
				else if (productList[product] == "table") {
					if(tw.contains("Table")) {
						System.out.println(" SUCCESS. Customer bought "+productList[product]);
						tw.pop();
						numberOfTableSold++;
					}
					else {
						System.out.println(" FAIL. "+productList[product]+" Warehouse is empty");
					}
				}
				
				
				else if (productList[product] == "dresser") {
					if(dw.contains("Dresser")) {
						System.out.println(" SUCCESS. Customer bought "+productList[product]);
						dw.pop();
						numberOfDresserSold++;
					}
					else {
						System.out.println(" FAIL. "+productList[product]+" Warehouse is empty");
					}
				}
				
				
				else if (productList[product] == "bookcase") {
					if(bookw.contains("Bookcase")) {
						System.out.println(" SUCCESS. Customer bought "+productList[product]);
						bookw.pop();
						numberOfBookcaseSold++;
					}
					else {
						System.out.println(" FAIL. "+productList[product]+" Warehouse is empty");
					}
				}
			}
		}
		
		System.out.println("\n");
		
		System.out.println("REPORT");
		
		System.out.println("\n");
		
		System.out.println("Amount of Bed in Factory Line: "+factoryLine.getNumberOf("Bed"));
		System.out.println("Amount of Sofa in Factory Line: "+factoryLine.getNumberOf("Sofa"));
		System.out.println("Amount of Dresser in Factory Line: "+factoryLine.getNumberOf("Dresser"));
		System.out.println("Amount of Table in Factory Line: "+factoryLine.getNumberOf("Table"));
		System.out.println("Amount of Chair in Factory Line: "+factoryLine.getNumberOf("Chair"));
		System.out.println("Amount of Bookcase in Factory Line: "+factoryLine.getNumberOf("Bookcase"));
		
		System.out.println("\n");
		
		System.out.println("Amount of Bed in Bed Warehouse: "+bw.getNumberOf("Bed"));
		System.out.println("Amount of Sofa in Sofa Warehouse: "+sw.getNumberOf("Sofa"));
		System.out.println("Amount of Dresser in Dresser Warehouse: "+dw.getNumberOf("Dresser"));
		System.out.println("Amount of Table in Table Warehouse: "+tw.getNumberOf("Table"));
		System.out.println("Amount of Chair in Chair Warehouse: "+cw.getNumberOf("Chair"));
		System.out.println("Amount of Bookcase in Bookcase Warehouse: "+bookw.getNumberOf("Bookcase"));
		
		System.out.println("\n");
		
		System.out.println("Amount of Bed sold: "+numberOfBedSold);
		System.out.println("Amount of Sofa sold: "+numberOfSofaSold);
		System.out.println("Amount of Dresser sold: "+numberOfDresserSold);
		System.out.println("Amount of Table sold: "+numberOfTableSold);
		System.out.println("Amount of Chair sold: "+numberOfChairSold);
		System.out.println("Amount of Bookcase sold: "+numberOfBookcaseSold);
		

	}
}
