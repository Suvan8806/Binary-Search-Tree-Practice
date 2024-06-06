package TreeLab;

import static java.lang.System.*;
import java.util.LinkedList;
import java.util.Queue;


public class BinarySearchTree {
	private TreeNode root;

	public BinarySearchTree() {
		root = null;
	}

	public void add(Comparable val) {
		root = add(val, root);
	}

	private TreeNode add(Comparable val, TreeNode tree) {
	   if(tree == null)
			tree = new TreeNode(val);
		
		Comparable treeValue = tree.getValue();
		int dirTest = val.compareTo(treeValue);
		
		if(dirTest < 0)
			tree.setLeft(add(val, tree.getLeft()));
		else if(dirTest > 0)
			tree.setRight(add(val, tree.getRight()));
		
		return tree;
	}
	
	

public void inOrder() {
		System.out.println("IN ORDER");
		inOrder(root);
		System.out.println("\n\n");
	}

	private void inOrder(TreeNode tree) {
		if (tree != null){
			inOrder(tree.getLeft());
			System.out.print(tree.getValue() + " ");
			inOrder(tree.getRight());
		}
	}

	//add preOrder, postOrder, and revOrder
	public void preOrder() {
		System.out.println("PRE ORDER");
		preOrder(root);
		System.out.println("\n");
	}

	private void preOrder(TreeNode tree) {
		if (tree != null){
			System.out.print(tree.getValue() + " ");
			preOrder(tree.getLeft());
			preOrder(tree.getRight());
		}
	}	
	
	public void postOrder() {
		System.out.println("POST ORDER");
		postOrder(root);
		System.out.println("\n");
	}

	private void postOrder(TreeNode tree) {
		if (tree != null){
			postOrder(tree.getLeft());
			postOrder(tree.getRight());
			System.out.print(tree.getValue() + " ");
		}
	}
	
	public void revOrder() {
		System.out.println("IN ORDER");
		revOrder(root);
		System.out.println("\n");
	}

	private void revOrder(TreeNode tree) {
		if (tree != null){
			revOrder(tree.getRight());
			System.out.print(tree.getValue() + " ");
			revOrder(tree.getLeft());
		}
	}



	public int getNumLevels() {
		return getNumLevels(root);
	}

	private int getNumLevels(TreeNode tree) {
		if(tree==null)
			return 0;
		else if(getNumLevels(tree.getLeft())>getNumLevels(tree.getRight()))
			return 1+getNumLevels(tree.getLeft());
		else
			return 1+getNumLevels(tree.getRight());
	}



	//add getNumLeaves, getDiameter, getHeight, getNumNodes, and isFull
	public int getNumLeaves() {
		return getNumLeaves(root);
	}
	private int getNumLeaves(TreeNode tree) {
		if (tree == null) {
			return 0;
		}
			
		if (tree.getLeft() == null && tree.getRight() == null) {
			return 1;
		}
			
		else {
			return getNumLeaves(tree.getLeft()) + getNumLeaves(tree.getRight());
		}
			
	}
	
	public int getHeight() {
		return getNumLevels() - 1;
	}

	private int getHeight(TreeNode tree) {
		if (tree == null)
			return 0; //if this is 0 height becomes 3 and diameter works properly and becomes 5 but if this is -1 the height is correct 2 and diameter becomes 3
		else
			return 1 + Math.max(getHeight(tree.getLeft()), getHeight(tree.getRight()));
	}
	
	
	public int getNumNodes() {
		return getNumNodes(root);
	}
	private int getNumNodes(TreeNode tree) {
		if (tree == null) {
			return 0;
		}
			
		return 1 + getNumNodes(tree.getLeft()) + getNumNodes(tree.getRight());
	}
	
	public int getMaxWidth() {
		int maxWidth = 0;
		int height = getHeight();
		for (int i = 1; i <= height; i++) {
			int width = getWidth(root, i);
			if (width > maxWidth) {
				maxWidth = width;
			}
				
		}
		return maxWidth;
	}
	
	private int getWidth(TreeNode tree, int level) {
		if (tree == null) {
			return 0;
		}
			
		if (level == 1) {
			return 1;
		}
			
		else if (level > 1) {
			return getWidth(tree.getLeft(), level -1) + getWidth(tree.getRight(), level -1);
		}
			
		return 0;
	}
	
	
	public boolean isFull() {
		return isFull(root);
	}

	private boolean isFull(TreeNode tree) {
		if (tree == null) {
			return true;
		}
			

		if (tree.getLeft() == null && tree.getRight() == null) {
			return true;
		}
			

		if ((tree.getLeft() != null) && (tree.getRight() != null)) {
			return (isFull(tree.getLeft()) && isFull(tree.getRight()));
		}
			

		return false;
	}
	
	public int getDiameter() {
		return getDiameter(root);
	}

	private int getDiameter(TreeNode tree) {
		if (tree == null)
			return 0;

		int lHeight = getHeight(tree.getLeft());
		int rHeight = getHeight(tree.getRight());

		int lDiameter = getDiameter(tree.getLeft());
		int rDiameter = getDiameter(tree.getRight());

		return Math.max(lHeight + rHeight + 1, Math.max(lDiameter, rDiameter));
	}
	
	//add extra credit options here - 10 points each
	
	//search
	public String search(Comparable test) {
		boolean ok = search(test, root);
		
		if (ok)
			return "The tree contains " + test;
		else {
			return "The tree does'nt contain " + test;
		}
	}

	private boolean search(Comparable t, TreeNode tree) {
		if (tree == null) {
			return false;
		}
			
		int ok = t.compareTo(tree.getValue());
		if (ok == 0) {
			return true;
		}
			
		else if (ok < 0) {
			return search(t, tree.getLeft());
		}
			
		else
			return search(t, tree.getRight());
	}
	
	//maxNode
	public Comparable getMaxNode() {
		return getMaxNode(root);
	}

	private Comparable getMaxNode(TreeNode tree) {
		if (tree == null) {
			return null;
		}	
		else if (tree.getRight() == null) {
			return tree.getValue();
		}
		else {
			return getMaxNode(tree.getRight());
		}
	}
	
	//minNode
	public Comparable getMinNode() {
		return getMinNode(root);
	}

	private Comparable getMinNode(TreeNode tree) {
		if (tree == null) {
			return null;
		}
		else if (tree.getLeft() == null) {
			return tree.getValue();
		}
		else {
			return getMinNode(tree.getLeft());
		}	
	}
	
	//level order
	public void levelOrder() {
		if (root == null)
			return;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			System.out.print(current.getValue() + " ");

			if (current.getLeft() != null)
				queue.add(current.getLeft());

			if (current.getRight() != null)
				queue.add(current.getRight());
		}
		System.out.println();
	}
	
	//display like a tree
	public void displayLikeTree() {
		int height = getHeight();
		for (int a = 0; a <= height + 1; a++) {
			displayLikeTree(root, a);
			System.out.println();
		}
	}
	
	private void displayLikeTree(TreeNode tree, int level) {
		if (tree == null)
			return;
		if (level == 1)
			System.out.print(tree.getValue() + " ");
		else if (level > 1) {
			displayLikeTree(tree.getLeft(), level - 1);
			displayLikeTree(tree.getRight(), level - 1);
		}
	}
	
	//remove
	public void remove(Comparable hoi) {
		root = remove(hoi, root);
	}

	private TreeNode remove(Comparable hi, TreeNode tree) {
		if (tree == null)
			return tree;

		int test = hi.compareTo(tree.getValue());
		if (test < 0)
			tree.setLeft(remove(hi, tree.getLeft()));
		else if (test > 0)
			tree.setRight(remove(hi, tree.getRight()));
		else {
			if (tree.getLeft() == null)
				return tree.getRight();
			else if (tree.getRight() == null)
				return tree.getLeft();

			tree.setValue(getMinNode(tree.getRight()));
			tree.setRight(remove(tree.getValue(), tree.getRight()));
		}

		return tree;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		toString(root, sb);
		return sb.toString();
	}

	private void toString(TreeNode tree, StringBuilder sb) {
		if (tree != null) {
			toString(tree.getLeft(), sb);
			sb.append(tree.getValue()).append(" ");
			toString(tree.getRight(), sb);
		}
	}
	
}

