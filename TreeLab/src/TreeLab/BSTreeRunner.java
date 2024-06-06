package TreeLab;

public class BSTreeRunner  {
	   public static void main( String args[] ) {
	 		//add test cases here
		   BinarySearchTree Tree = new BinarySearchTree();
		   Tree.add(90);
		   Tree.add(80);
		   Tree.add(100);
		   Tree.add(70);
		   Tree.add(85);
		   Tree.add(98);
		   Tree.add(120);
		   
		   Tree.inOrder();
		   Tree.preOrder();
		   Tree.postOrder();
		   Tree.revOrder();
		   
		   System.out.println("Tree Display like Tree\n");
		   Tree.displayLikeTree();
		   
		   System.out.println("\nTree Height is " + Tree.getHeight());
		   System.out.println("Tree max width is " + Tree.getMaxWidth());
		   System.out.println("Number of leaves is " + Tree.getNumLeaves());
		   System.out.println("Number of nodes is " + Tree.getNumNodes());
		   System.out.println("Number of levels is " + Tree.getNumLevels());
		   System.out.println("Tree as a string " + Tree.toString());
		   if(Tree.isFull()) {
			   System.out.println("The Tree is full.");
		   } else {
			   System.out.println("The Tree is not full.");
		   }
		   System.out.println("Tree Diameter is " + Tree.getDiameter()); 
		   
		   
		   System.out.println("The tree contains 100: " + Tree.search(100));
		   System.out.println("The tree does not contain 114: " + Tree.search(114));
		   System.out.println("The smallest tree node: " + Tree.getMinNode());
		   System.out.println("The largest tree node: " + Tree.getMaxNode());
		   
		   
		   
		   
		   System.out.println("\nTree before removing any nodes - using level order traversal.");
		   Tree.levelOrder();

		   Tree.remove(90);
		   System.out.println("\nTree after removing 90.");
		   Tree.levelOrder();

		   Tree.remove(70);
		   System.out.println("\nTree after removing 70.");
		   Tree.levelOrder();

		   Tree.remove(85);
		   System.out.println("\nTree after removing 85.");
		   Tree.levelOrder();

		   Tree.remove(98);
		   System.out.println("\nTree after removing 98.");
		   Tree.levelOrder();

		   Tree.remove(80);
		   System.out.println("\nTree after removing 80.");
		   Tree.levelOrder();

		   Tree.remove(120);
		   System.out.println("\nTree after removing 120.");
		   Tree.levelOrder();

		   Tree.remove(100);
		   System.out.println("\nTree after removing 100.");
		   Tree.levelOrder();
		   
		   
	   }
	}
