
public class BinarySearchTree<T> implements Orderable {

	private Node root;
	private T[] foodBag;
	private T[] restaurantBag;
	private int numberOfEntriesFood = 0;
	private int numberOfEntriesRestaurant = 0;
	
	class Node // Node class to implement each node
	 {
	     T key;
	     Node left, right;
	
	     public Node(T item)
	     {
	         key = item;
	         left = right = null;
	     }

		public T getKey() {
			return key;
		}

		public void setKey(T key) {
			this.key = key;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}
	     
	 }
	
	 // Constructor
	 @SuppressWarnings("unchecked")
	public BinarySearchTree()
	 {
		 T[] tempBag = (T[])new Object[50];
		foodBag = tempBag;	
		restaurantBag = tempBag;
	      root = null;
	 }
	
	public void updatePrice() {//updates price
		for(int i = 0 ; i < foodBag.length ; i++) {
			if(foodBag[i] != null) {
				((Food) foodBag[i]).setPrice(((Food) foodBag[i]).getPrice() + (((Food) foodBag[i]).getPrice() / 5));
			}
			
		}
		System.out.println("Prices in FoodBSTs are updated.");
	}
	public void updateStock() {//updates stock
		for(int i = 0 ; i < foodBag.length ; i++) {
			if(foodBag[i] != null) {
				((Food) foodBag[i]).setStock(((Food) foodBag[i]).getStock()/2);
			}
		}
		System.out.println("Stocks in FoodBSTs are updated.");
	}
	 // Public method to call private method for insertion
	 public void insertFood(T key)
	 {
		 foodBag[numberOfEntriesFood] = key;
		 numberOfEntriesFood++;
	      root = privateInsertFood(root, key);
	 }
	// Public method to call private method for insertion
	 public void insertRestaurant(T key)
	 {
		 restaurantBag[numberOfEntriesRestaurant] = key;
		 numberOfEntriesRestaurant++;
	      root = privateInsertRestaurant(root, key);
	 }
	
	 //A recursive function to insert a new key in BST
	private Node privateInsertRestaurant(Node root, T key)
	{
	
	   //If the tree is empty, return a new node
	  if (root == null)
	  {
	      root = new Node(key);
	      return root;
	  }
	
	  // Else, inserting nodes
	  if (((Restaurant) key).getRating() < ((Restaurant) root.key).getRating())
	      root.left = privateInsertRestaurant(root.left, key);
	  else if (((Restaurant) key).getRating() > ((Restaurant) root.key).getRating())
	      root.right = privateInsertRestaurant(root.right, key);
	
	  return root;
	}
	
	 // A recursive function to insert a new key in BST
	 private Node privateInsertFood(Node root, T key)
	 {
	
  // If the tree is empty,return a new node
	 if (root == null)
	 {
	     root = new Node(key);
	     return root;
	 }
	
	 // Else, inserting nodes
	 if (((Food) key).getPrice() < ((Food) root.key).getPrice())
	     root.left = privateInsertFood(root.left, key);
	 else if (((Food) key).getPrice() > ((Food) root.key).getPrice())
	     root.right = privateInsertFood(root.right, key);
	
	     return root;
	 }
	
	 // This method  calls privateDescendingOrderFood
	 public void descendingorderFood()
	 {
	      privateDescendingOrderFood(root);
	 }
	// This method  calls privateAscendingOrderRestaurant
	 public void ascendingorderRestaurant()
	 {
	      privateAscendingOrderRestaurant(root);
	 }
	
	 // A function to do Descending order traversal of BST by looking price
	 private void privateDescendingOrderFood(Node root) 
	 {
	    if (root == null) {
	    	 return;
	    }
		privateDescendingOrderFood(root.left);
		
		System.out.println(((Food) root.key).getName() +"   " + String.format("%.2f",((Food) root.key).getPrice())+ "   " +((Food) root.key).getStock());
		privateDescendingOrderFood(root.right);
	}
	 
	// A function to do ascending order traversal of BST by looking rating
	 private void privateAscendingOrderRestaurant(Node root) 
	 {
	     if (root == null) {
	         return;
	     }
	     privateAscendingOrderRestaurant(root.right);
	     System.out.println(((Restaurant) root.key).getName() +"   "+ ((Restaurant) root.key).getRating());
	     privateAscendingOrderRestaurant(root.left);
	
	}
	 
	 
	 // A function that deletes food or restaurant object, before deletion it detects if key is Food or Restaurant
	 public void deleteKey(T key) { 
		 
		 if(key.getClass().getSimpleName() == "Food") {
			 root = deleteRecFood(root, key); 
		 }
		 else {
			 root = deleteRecRestaurant(root, key); 
		 } 
	}
	
	 private Node deleteRecRestaurant(Node root, T key)
	 {
		     //If the tree is empty
		 if (root == null)
		     return root;
		
		 // Else, recursively down the tree 
		 if (((Restaurant) key).getRating() < ((Restaurant) root.key).getRating())
		     root.left = deleteRecRestaurant(root.left, key);
		 else if (((Restaurant) key).getRating() > ((Restaurant) root.key).getRating())
		     root.right = deleteRecRestaurant(root.right, key);
		
		 // if key is same as root's key then this is the node that will be deleted.
		 else {
			     // node with only one child or no child
			 if (root.left == null)
			     return root.right;
			 else if (root.right == null)
			     return root.left;
			
			 // node with two children
			 root.key = minValueRestaurant(root.right);
			
			 // Delete the inorder 
			 root.right = deleteRecRestaurant(root.right, root.key);
		 }
		     return root;
	}
	
	 @SuppressWarnings("unused")
	private T minValueRestaurant(Node root)
	 {
	     T minv = root.key;
	     int k = (int) ((Restaurant) minv).getRating();
	     while (root.left != null)
	     {
	         k = (int) ((Restaurant) root.left.key).getRating();
	         root = root.left;
	     }
	     return minv;
	 }
	 
	 private Node deleteRecFood(Node root, T key)
	 {
	     //If the tree is empty 
	 if (root == null)
	     return root;
	
	 // Else, recursively down the tree
	 if (((Food) key).getPrice() < ((Food) root.key).getPrice())
	     root.left = deleteRecFood(root.left, key);
	 else if (((Food) key).getPrice() > ((Food) root.key).getPrice())
	     root.right = deleteRecFood(root.right, key);
	
	 //  if key is same as root's key then this is the node that will be deleted.
	 else {
	     // node with only one child or no child
	 if (root.left == null)
	     return root.right;
	 else if (root.right == null)
	     return root.left;
	
	 // node with two children
	 root.key = minValueFood(root.right);
	
	 // Delete the inorder 
	         root.right = deleteRecFood(root.right, root.key);
	     }
	
	     return root;
	 }
	
	 @SuppressWarnings("unused")
	private T minValueFood(Node root)
	 {
	     T minv = root.key;
	     int k = (int) ((Food) minv).getPrice();
	     while (root.left != null)
	     {
	         k = (int) ((Food) root.left.key).getPrice();
	         root = root.left;
	     }
	     return minv;
	 }


		public Node getRoot() {
			return root;
		}

		public void setRoot(Node root) {
			this.root = root;
		}
	 
	 public String getEntry(T entry) {
		 if(entry.getClass().getName().equals("Food")) {
			 return findFoodEntry(getRoot(),entry);
		 }
		 else {
			 return findRestaurantEntry(getRoot(),entry);
		 }
		 
		 
	 }

	private String findFoodEntry(Node rootNode, T entry) {
		 String result = null;
		 if(rootNode != null) {
			 String rootEntry =  ((Food) rootNode.getKey()).getName();
			 if(((Food) entry).getName().equals(rootEntry)) {
				 result = rootEntry;
			 }
			 else if(((Food) entry).getName().compareTo(rootEntry) < 0) {
				 result = findFoodEntry(rootNode.getLeft(),entry);
			 }
			 else {
				 result = findFoodEntry(rootNode.getRight(),entry);
			 }
		 }
		 return result;
	 }
	
	
	private String findRestaurantEntry(Node rootNode, T entry) {
		 String result = null;
		 if(rootNode != null) {
			 String rootEntry =  ((Restaurant) rootNode.getKey()).getName();
			 if(((Restaurant) entry).getName().equals(rootEntry)) {
				 result = rootEntry;
			 }
			 else if(((Restaurant) entry).getName().compareTo(rootEntry) < 0) {
				 result = findRestaurantEntry(rootNode.getLeft(),entry);
			 }
			 else {
				 result = findRestaurantEntry(rootNode.getRight(),entry);
			 }
		 }
		 return result;
	 }
	 public boolean contain(T entry) {
		 return getEntry(entry) != null;
	 }
	 
	 
	 
	 //Preorder and Postorder implementations are done in here!. But it is not used for our homework, the detailed implementations are not made.
	 
	 public void preOrder() {
		 preOrder(root); 
	} 
	 /* traverse the binary tree in PreOrder */
	
	 private void preOrder(Node node) {
		 if (node == null) { 
			 return; 
		} 
		 System.out.println(node.key); 
		 preOrder(node.left);
		 preOrder(node.right); 
	}
	 
	 public void postOrder() {
		 postOrder(root); 
	} 
	 /**  traverse the binary tree in PreOrder  */ 
	 private void postOrder(Node node) {
		 if (node == null) { 
			 return; 
		} 
		 preOrder(node.left);
		 preOrder(node.right); 
		 System.out.println(node.key); 
	}


}