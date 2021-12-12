import java.util.Random;
public class Process<T> implements IProcess<T>{
	private int priority;
	private String priorityInString;
	private int occupation;
	private int nameNumber;
	
	public Process(int name) {//Constructor
		this.setNameNumber(name);
		Random random = new Random();
		int occupationValue = random.nextInt(10) + 1;
		setOccupation(occupationValue);
		int priorityValue = random.nextInt(3) + 1;
		setPriority(priorityValue);
		if(priorityValue == 1) {
			setPriorityInString("High");
		}
		else if(priorityValue == 2) {
			setPriorityInString("Normal");
		}
		else {
			setPriorityInString("Low");
		}
		
	}
	
	public String getType() {//Returns the priority of item
		return getPriorityInString();
	}
	
	

	public int getOccupation() {//Returns the occupation
		return occupation;
	}


	public void setOccupation(int occupation) {//Sets the ocupation 
		this.occupation = occupation;
	}


	public String getPriorityInString() {//Returns the priority in string 
		return priorityInString;
	}


	public void setPriorityInString(String priorityInString) {//sets the priority in string
		this.priorityInString = priorityInString;
	}


	public int getPriority() {//returns the priority
		return priority;
	}
	

	public void setPriority(int priority) {//sets the priority
		this.priority = priority;
	}

	public int getNameNumber() {//returns the name number
		return nameNumber;
	}

	public void setNameNumber(int nameNumber) {//sets the name number
		this.nameNumber = nameNumber;
	}
	
}
