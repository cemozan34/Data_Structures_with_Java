
public class Chair<T> implements IProduct<T> {
	private String productName;
	public Chair(String productName) {//constructor
		this.productName = productName;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean isStored(T warehouse) {//It checks the element if it is stored in warehouse 
		
		return (((ChairWarehouse) warehouse).contains("Chair"));
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean isManufactured(T factoryLine) {
	    
	    if(((factoryLine) factoryLine).contains("Chair")) {
	        return true;
	    }
	    else {
	    	return false;
	    }      
	}
	public boolean isSold(T item, T[] soldItemList) {//It checks the element if it is sold from warehouse 
		int sayac=0;
		for(int i =0;i<soldItemList.length;i++) {
			if(soldItemList[i].equals(item)) {
				sayac++;
			}
		}
		if(sayac!=0) {return true;}
		return false;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
}
