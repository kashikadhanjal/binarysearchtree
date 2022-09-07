



import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTreeTest {
	BinarySearchTree<Integer, String> newTree = new BinarySearchTree<Integer, String>();
	@Test
	public void insertTest() {
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
        Assert.assertEquals("[rohan, kashika, kate, emil, rohith, will, ben, zoe, shraf, anjali, alden]", newTree.inOrderRec());
        Assert.assertNotEquals("[rohan, kashika, kate, rohith, will, ben, zoe, shraf, anjali, alden]", newTree.inOrderRec());
	}
	public void removeTest() {
		newTree.delete(4);
		newTree.insert(2, "kashika");
        newTree.insert(1, "rohan");
        newTree.insert(4, "emil");
        newTree.insert(5, "rohith");
        newTree.insert(9, "zoe");
        newTree.insert(3, "kate");
        newTree.delete(12);
        newTree.delete(2);
        newTree.delete(9);
		
	}
	public void searchTEst() {
		newTree.insert(2, "kashika");
        newTree.insert(1, "rohan");
        newTree.insert(4, "emil");
        newTree.insert(5, "rohith");
        newTree.insert(9, "zoe");
        newTree.insert(3, "kate");
        String val1 = newTree.search(2);
        String val2 = newTree.search(9);
        String val3 = newTree.search(14);
	}
	public void inOrderRecTest() {
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
	}
	public void kthSmallestTest() {
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
		String val3 = newTree.kthSmallest(2);
		String val2 = newTree.kthSmallest(0);
	}

}
