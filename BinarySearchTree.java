





import java.util.*;

public class BinarySearchTree <T extends Comparable<T>, V>{
	private Node <T,V> head;
	private class Node <T extends Comparable<T>, V>{
		private T key;
        private V value;
        private Node<T,V> leftChild;
        private Node<T,V> rightChild;   
        public Node(T key, V value) {
        	this.key = key; //assign the key 
        	this.value = value; //assign the value
        	leftChild = null; //assign children as null
        	rightChild = null;
        }
		public int compareTo(T o) {
			// TODO Auto-generated method stub
			return this.key.compareTo(o); //establish the compare value 
		}
		
    }
	public <V, T extends Comparable<T>> BinarySearchTree(){
		head = null; //assign head as null
	}
	
	private Node<T,V> inserthelper(Node<T,V> inserted, Node<T,V> head1) {
		if( head1 == null) {
			return inserted; //if head equals null then return new node
			}
		int compareResult = head1.compareTo( inserted.key ); //compare values
		if( compareResult > 0 ) { //if greater then one 
			head1.leftChild = inserthelper( inserted, head1.leftChild ); //go to left
			}
		else if( compareResult < 0 ) { //if less than one 
			head1.rightChild = inserthelper( inserted, head1.rightChild ); //go to right
			
			}
		else {
			head1.rightChild = inserthelper( inserted, head1.rightChild); //if same then add to right
			
			}
		
		return head1;// once your done keep returning 
	}
	public void insert(T key, V value) {
		Node<T,V> newNode = new Node<T, V>(key, value); //make new Node to pass through 
		Node<T,V> inserted = inserthelper(newNode, head); //return inserted newNode to check
		if(head == null) { //check that head is null
			head = inserted; //assign head as inserted 
		}
	}
	private Node<T,V> remove(T key, Node<T,V> head1) {
		if(head1 == null) { //if head1 is null return null
			return head1;
		}
		int compareResult = head1.compareTo( key ); //compare head1 key to key passed through
		if(compareResult > 0){ //go to left 
			head1.leftChild = remove(key, head1.leftChild);
		}
		else if(compareResult < 0) { //go to right 
			head1.rightChild = remove(key, head1.rightChild);
		}
		else { //head has key value to be removed
			if (head1.leftChild == null) //if head1 left is null j replace with right child
				return head1.rightChild;
	        else if (head1.rightChild == null) //if head1 right is null j replace with left child
	            return head1.leftChild;
			Node<T,V> replacement = findMin(head1.rightChild); //if two children exist then find min on right side
			head1.key = replacement.key; //replace node with minimum value and key
			head1.value = replacement.value;
	        head1.rightChild = remove((T) head1.key, head1.rightChild); //call remove on right side now searching for new key 
	        }
	    return head1; //returns head 
			
	}
	public void delete(T key) {
		remove(key, head); //call helper remove
	}
	private Node<T,V> searchhelper(T key, Node<T,V> head1) {
		if(head1 == null || head1.compareTo(key) == 0) { //if head is equal to null or its equal
			return head1; //return head
		}
		int compareResult = head1.compareTo(key); //call compare to 
		if(compareResult > 0) { //if less than go to left 
			return searchhelper(key, head1.leftChild);
		}
		return searchhelper(key, head1.rightChild); //if greater than go to right 
	
	}
	public V search(T key) {
		Node<T, V> value = searchhelper(key, head); //call helper method
		if(value == null) { //if node is null return null
			return null;
		}
		return value.value; //return value of node 
		
	}
	private List<V> inOrderRecHelper(List<V> order, Node<T,V> root){
		if(root == null) //if root is null return null
		{
			return null; 
		}
		if(root.leftChild != null) { //go left 
			inOrderRecHelper(order, root.leftChild);
		}
		order.add(root.value); //adds value if left is null  
		if(root.rightChild != null) { //go right 
			inOrderRecHelper(order, root.rightChild);
		}
		return order; //returns list back
	}
	
	public List<V> inorderRec(){
		List<V> newList = new ArrayList<V>();
		return inOrderRecHelper(newList, head); //passes through an empty list 
	}
	public V kthSmallest(int k) { 
		List<V> searchList = inorderRec(); //call inorder method
		if(searchList == null) { //if list is null return null
			return null;
		}
		if(k <= 0) { //if k is 0 or less than 0 throw an exception
			throw new NoSuchElementException();
		}
		return searchList.get(k-1); //calls kthSmallest
	}
	private Node<T, V> findMin(Node<T, V> head1) {
		Node<T, V> newNode = head1;
		if(newNode == null) { //if null return null
			return newNode;
		}
		while(newNode.leftChild != null) { //keep going left 
			newNode = newNode.leftChild;
		}
		return newNode; //returns new node 
	}
	public static void main(String[] args)
    {
		
        BinarySearchTree<Integer, String> newTree = new BinarySearchTree<Integer, String>();
        newTree.insert(2, "kashika");
        newTree.insert(1, "rohan");
        newTree.insert(4, "emil");
        newTree.insert(5, "rohith");
        newTree.insert(9, "zoe");
        newTree.insert(3, "kate");
        newTree.insert(6, "will");
        newTree.insert(7, "ben");
        newTree.insert(10, "shraf");
        newTree.insert(12, "alden");
        newTree.insert(11, "anjali");
        System.out.println(newTree.inorderRec());
        newTree.delete(4);
        System.out.println(newTree.inorderRec());
        newTree.delete(9);
        System.out.println(newTree.inorderRec());
        String val = newTree.search(12);
        System.out.println(val);
        String val2 = newTree.search(4);
        System.out.println(val2);
        String val3 = newTree.kthSmallest(2);
        System.out.println(val3);
        BinarySearchTree<Foo, String> newTree1 = new BinarySearchTree<Foo, String>();
        newTree1.insert(new Foo(2),"kiss of venus");
        newTree1.insert(new Foo(1), "beauty and essex");
        newTree1.insert(new Foo(4), "normal girl");
        newTree1.insert(new Foo(5), "drown");
        newTree1.insert(new Foo(9), "zoe");
        newTree1.insert(new Foo(3), "kate");
        newTree1.insert(new Foo(6), "will");
        newTree1.insert(new Foo(7), "ben");
        newTree1.insert(new Foo(10), "shraf");
        newTree1.insert(new Foo(12), "alden");
        newTree1.insert(new Foo(11), "anjali");
        System.out.println(newTree1.inorderRec());
        newTree1.delete(new Foo(4));
        System.out.println(newTree1.inorderRec());
        newTree1.delete(new Foo(9));
        System.out.println(newTree1.inorderRec());
        String val4 = newTree1.search(new Foo(12));
        System.out.println(val4);
        String va15 = newTree1.search(new Foo(4));
        System.out.println(va15);
        String val6 = newTree1.kthSmallest(2);
        System.out.println(val6);
    }
}

class Foo implements Comparable<Foo>{
	Integer val;
	Foo(int val){
		this.val = val;
	}
	public int compareTo(Foo o) {
		return this.val.compareTo(o.val);
	}
}


