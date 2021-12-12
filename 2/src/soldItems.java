
public class soldItems {
	private String [] soldItemList; // Dynamically growing array that stores solded item.
	
	public soldItems(String[] liste) {
		this.soldItemList=liste;
	}
	private int listeUzunluk=soldItemList.length;
	public void add(String esya) { // Method that doubles array size if there will be no space for new solded items.
		boolean enoughPlace=false;
		int sayac=0;
		for(int i =0 ; i<listeUzunluk;i++) {
			
			if(soldItemList[i].equals(null)) {
			enoughPlace=true;
			sayac=i;
			break;}
		}
	if(enoughPlace) {
		this.soldItemList[sayac]=esya;	
	}
	else {

		String[] newListe=new String[listeUzunluk*2];
		for(int i =0;i<listeUzunluk;i++) {
			newListe[i]=soldItemList[i];
		}
		newListe[listeUzunluk]=esya;
		this.soldItemList=newListe;
		
	}}
	public String[] getListe() {
		return soldItemList;
	}
}
