
public class OSPMS {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String args[]) {
		
		Computation computation1 = new Computation();//Creating computation classes
		Computation computation2 = new Computation();
		Computation computation3 = new Computation();
		Computation computation4 = new Computation();
		Computation computation5 = new Computation();
		Computation computation6 = new Computation();
		Computation computation7 = new Computation();
		Computation computation8 = new Computation();
		Computation computation9 = new Computation();
		LinkedList linkedSimulations = new LinkedList();//Creating linkedlist class
		int totalNumberOfHighs = 0;//Creating default values
		int totalNumberOfNormals = 0;
		int totalNumberOfLows = 0;
		int totalWaitingTime = 0;
		int waitingTimeForHigh = 0;
		int waitingTimeForNormal = 0;
		int waitingTimeForLow = 0;
		for(int i = 0 ; i < 3 ; i++) {// Simulation Number
			if(i == 0) {
				System.out.println("Simulation number: 1");
				
				for(int j = 0 ; j < 3 ; j++) {// Three processes
					Process process = new Process(j);
					computation1.enqueue(process);	
				}
				prints(computation1,totalWaitingTime, totalNumberOfHighs, totalNumberOfNormals, totalNumberOfLows, waitingTimeForHigh, waitingTimeForNormal, waitingTimeForLow);
				
				for(int j = 0 ; j < 5 ; j++) {// Five processes
					Process process = new Process(j);
					computation2.enqueue(process);	
				}
				prints(computation2,totalWaitingTime, totalNumberOfHighs, totalNumberOfNormals, totalNumberOfLows, waitingTimeForHigh, waitingTimeForNormal, waitingTimeForLow);
				
				for(int j = 0 ; j < 10 ; j++) {// Ten processes
					Process process = new Process(j);
					computation3.enqueue(process);	
				}
				prints(computation3,totalWaitingTime, totalNumberOfHighs, totalNumberOfNormals, totalNumberOfLows, waitingTimeForHigh, waitingTimeForNormal, waitingTimeForLow);
			}
			else if(i == 1) {
				System.out.println("Simulation number: 2");
				for(int j = 0 ; j < 3 ; j++) { // Three processes
					Process process = new Process(j);
					computation4.enqueue(process);	
				}
				prints(computation4,totalWaitingTime, totalNumberOfHighs, totalNumberOfNormals, totalNumberOfLows, waitingTimeForHigh, waitingTimeForNormal, waitingTimeForLow);
				for(int j = 0 ; j < 5 ; j++) { // Five processes
					Process process = new Process(j);
					computation5.enqueue(process);	
				}
				prints(computation5,totalWaitingTime, totalNumberOfHighs, totalNumberOfNormals, totalNumberOfLows, waitingTimeForHigh, waitingTimeForNormal, waitingTimeForLow);
				for(int j = 0 ; j < 10 ; j++) { // Ten processes
					Process process = new Process(j);
					computation6.enqueue(process);	
				}
				prints(computation6,totalWaitingTime, totalNumberOfHighs, totalNumberOfNormals, totalNumberOfLows, waitingTimeForHigh, waitingTimeForNormal, waitingTimeForLow);
			}
			else {
				System.out.println("Simulation number: 3");
				for(int j = 0 ; j < 3 ; j++) { // Three processes
					Process process = new Process(j);
					computation7.enqueue(process);	
				}
				prints(computation7,totalWaitingTime, totalNumberOfHighs, totalNumberOfNormals, totalNumberOfLows, waitingTimeForHigh, waitingTimeForNormal, waitingTimeForLow);
				for(int j = 0 ; j < 5 ; j++) { // Five processes
					Process process = new Process(j);
					computation8.enqueue(process);	
				}
				prints(computation8,totalWaitingTime, totalNumberOfHighs, totalNumberOfNormals, totalNumberOfLows, waitingTimeForHigh, waitingTimeForNormal, waitingTimeForLow);
				for(int j = 0 ; j < 10 ; j++) { // Ten processes
					Process process = new Process(j);
					computation9.enqueue(process);	
				}
				prints(computation9,totalWaitingTime, totalNumberOfHighs, totalNumberOfNormals, totalNumberOfLows, waitingTimeForHigh, waitingTimeForNormal, waitingTimeForLow);
			}
			
		}
		
		link(computation1, linkedSimulations, computation3, computation2, computation4, computation5, computation6, computation7, computation8, computation9);
	}
	
	@SuppressWarnings("rawtypes")
	public static void prints(Computation computation1, int totalWaitingTime, int totalNumberOfHighs, int totalNumberOfNormals, int totalNumberOfLows, int waitingTimeForHigh, int waitingTimeForNormal, int waitingTimeForLow) {
		System.out.print("Computation Queue:");//Prints the information that we have to see
		
		for(int j = 0 ; j<computation1.getNumberOfEntries()-1;j++) {//It will loop until j become number of entries
			
			
			if(j <computation1.getNumberOfEntries()-2) {
				totalWaitingTime += ((Process) computation1.getLine()[j]).getOccupation();
			}
			System.out.print(" P" +((Process) computation1.getLine()[j]).getNameNumber()+", " + ((Process) computation1.getLine()[j]).getPriorityInString()+", " + ((Process) computation1.getLine()[j]).getOccupation()+"ns <-");
			
			
			if(((Process) computation1.getLine()[j]).getPriorityInString() == "High") {
				totalNumberOfHighs++;
				
			}
			
			
			if(((Process) computation1.getLine()[j]).getPriorityInString() == "Normal") {
				totalNumberOfNormals++;
				
			}
			
			
			if(((Process) computation1.getLine()[j]).getPriorityInString() == "Low") {
				totalNumberOfLows++;
				
			}
			
		}
		for(int k = computation1.getNumberOfEntries()-2 ; k > 0 ; k-- ) {//It loops until the k becomes 0
			if(((Process) computation1.getLine()[k]).getPriorityInString()=="High") {
				waitingTimeForHigh += ((Process) computation1.getLine()[k-1]).getOccupation();
			}
			if(((Process) computation1.getLine()[k]).getPriorityInString()=="Normal") {
				waitingTimeForNormal += ((Process) computation1.getLine()[k-1]).getOccupation();
			}
			if(((Process) computation1.getLine()[k]).getPriorityInString()=="Low") {
				waitingTimeForLow += ((Process) computation1.getLine()[k-1]).getOccupation();
			}
		}
		
		System.out.print("\n");
		System.out.println("Total numbers of computations: " + (computation1.getNumberOfEntries()-1));
		System.out.println("\n");
		
		System.out.println("Total Waiting Time: "+totalWaitingTime);
		System.out.println("Average Waiting Time: " + totalWaitingTime / (computation1.getNumberOfEntries()-1));
		System.out.println("\n");
		
		totalWaitingTime = 0;
		System.out.println("Total number of computations for High: " +totalNumberOfHighs );
		System.out.println("Total number of computations for Normal: " +totalNumberOfNormals);
		System.out.println("Total number of computations for Low: " + totalNumberOfLows);
		System.out.println("\n");
		
		System.out.println("Total waiting time for High: " +waitingTimeForHigh);
		if(totalNumberOfHighs == 0) {
			System.out.println("Average waiting time for High: 0");
			System.out.println("\n");
		}
		else {
			System.out.println("Average waiting time for High: "+ (waitingTimeForHigh / totalNumberOfHighs));
			System.out.println("\n");
		}
		waitingTimeForHigh = 0;
		totalNumberOfHighs = 0;
		System.out.println("Total waiting time for Normal: " +waitingTimeForNormal);
		if(totalNumberOfNormals == 0) {
			System.out.println("Average waiting time for Normal: 0");
			System.out.println("\n");
		}
		else {
			System.out.println("Average waiting time for Normal: "+ (waitingTimeForNormal / totalNumberOfNormals));
			System.out.println("\n");
		}
		waitingTimeForNormal = 0;
		totalNumberOfNormals = 0;
		System.out.println("Total waiting time for Low: "+waitingTimeForLow);
		if(totalNumberOfLows == 0) {
			System.out.println("Average waiting time for Low: 0");
			System.out.println("\n");
		}
		else {
			System.out.println("Average waiting time for Low: "+ (waitingTimeForLow / totalNumberOfLows));
			System.out.println("\n");
		}
		
		totalNumberOfLows = 0;
		waitingTimeForLow = 0;
		
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void link(Object computation1, LinkedList linkedSimulations, Object computation3, Object computation2, Object computation4, Object computation5, Object computation6, Object computation7, Object computation8, Object computation9) {
		//It adds computations to linked simulation
		linkedSimulations.add(computation1);
		linkedSimulations.add(computation2);
		linkedSimulations.add(computation3);
		linkedSimulations.add(computation4);
		linkedSimulations.add(computation5);
		linkedSimulations.add(computation6);
		linkedSimulations.add(computation7);
		linkedSimulations.add(computation8);
		linkedSimulations.add(computation9);
	}

}
